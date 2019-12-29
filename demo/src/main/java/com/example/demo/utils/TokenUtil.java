package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/2/18.
 */
@Component
public class TokenUtil {

    public static final String SECRET = "julyzy";

    @Autowired
    private TokenCache tokenCache;

    /**
     * 创建token
     *
     * @param username 用户名
     * @return
     * @throws UnsupportedEncodingException
     */
    public  String createToken(String username, String realname) throws UnsupportedEncodingException {
        String token = null;

        Date iatDate = new Date();
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 60);
        Date expireDate = nowTime.getTime();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        token = JWT.create().withHeader(map)
                .withClaim("username", username)
                .withClaim("realname", realname)
                .withExpiresAt(expireDate)
                .withIssuedAt(iatDate)
                .sign(Algorithm.HMAC256(SECRET));

        return token;
    }

    /**
     * 检验token值
     *
     * @param token 令牌值
     * @return
     * @throws UnsupportedEncodingException
     */
    public  Map<String, Claim> verify(String token) throws UnsupportedEncodingException {

        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();

        DecodedJWT jwt = null;
        try {
            jwt = verifier.verify(token);
        } catch (Exception e) {

        }

        Map<String, Claim> map = jwt.getClaims();
        return map;
    }

    /**
     * 根据token获取用户名
     *
     * @param token
     * @return
     */
    public  Map<String, String> getUserName(String token) {
        try {
            if (!tokenCache.isExists(token)) {
                return null;
            }

            Map<String, Claim> user = verify(token);
            if (user == null) {
                return null;
            }
            String username = user.get("username").asString();
            String realname = user.get("realname").asString();
            Map<String, String> result = new HashMap<>();
            result.put("username", username);
            result.put("realname", realname);
            return result;
        } catch (UnsupportedEncodingException e) {

        }

        return null;
    }

    public  void delete(String token) {
        tokenCache.clear(token);
    }

}
