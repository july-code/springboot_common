package com.example.demo.constant;

/**
 * 错误码
 *
 * @author Administor
 * @date 2019/02/19
 */
public enum ErrorCode {
    NoError("操作成功", 0),
    Error("系统异常", 1),
    UserNotExists("没有此用户!", 10),
    UserDisable("用户已被禁用!", 11),
    UserPwdExpire("用户密码已经过期,请联系管理员!", 12),
    UserHasLogin("该用户已经在别的地方登录，不能重复登录！", 13),
    UserPwdError("用户名或密码错误", 14),
    UserExists("用户已存在", 15),
    UserCreateFail("用户创建失败 请重试", 16),
    UserEditLimit("用户为部门负责人，不能修改所属组织", 17),
    UserDelFail("用户为部门负责人，无法删除", 18),
    UserEditFail("编辑用户描述信息失败  请重试", 19),
    UserInitPassFail("初始化密码失败", 20),
    UserOrgPassFail("原始密码不对，请重试...", 21),
    DeptCreateFail("部门创建失败  请重试", 22),
    DeptEditFail("部门编辑失败 请重试", 23),
    DeptAlreadyExists("部门编辑失败 部门已存在", 24),
    DeptIsEmpty("部门名称不能为空!", 25),
    DeptAddExists("部门已存在", 26),
    DeptNoUser("该部门下未创建用户!", 27),
    DeptExistsUser("部门下存在用户或部门", 28),
    DeptDelFail("部门删除失败", 29),
    DictCreateFail("字典创建失败", 30),
    DictEditFail("字典编辑失败", 31),
    DictDelFail("字典删除失败", 32),
    RelAlreadyExists("被关联用户已被关联到相同的关联系统和关联系统URL", 33),
    RelUserExists("关联用户已存在", 34),
    Forbiden("会话过期，请重新登录", 403),
    QueryError("查询失败", 500);

    private String msg;
    private int code;

    ErrorCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return String.format("msg:%s code:%d", msg, code);
    }

    public boolean equals(ErrorCode errorCode) {
        if (errorCode.getCode() == code && errorCode.getMsg().equals(msg)) {
            return true;
        }

        return false;
    }
}
