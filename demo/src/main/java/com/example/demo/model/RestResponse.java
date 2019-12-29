package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.example.demo.constant.ErrorCode;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize
public class RestResponse implements Serializable {
    private Integer code;
    private String msg;
    private Object data;

    @JsonIgnore
    private boolean success;

    public RestResponse() {
        this.code = ErrorCode.Error.getCode();
        this.msg = ErrorCode.Error.getMsg();
    }

    public RestResponse(ErrorCode code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public void setErrorCode(ErrorCode errorCode, String msg) {
        this.code = errorCode.getCode();
        this.msg = msg;
    }

    public void setResult(ErrorCode errorCode, Object data) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.data = data;
    }

    public String toJsonString() {
        ObjectMapper objectMapper = new ObjectMapper();
        String val = null;
        try {
            val = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return val;
    }

    public void setResult(Object obj) {

    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
