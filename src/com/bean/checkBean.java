package com.bean;

import java.util.HashMap;
import java.util.Map;

public class checkBean {
    private String name;
    private String password;
    private String password2;
    private String email;
    private Map<String, String> error = new HashMap();

    public checkBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean namevalidate() {
        boolean flag = true;
        if (name == null || name.trim().equals("")) {//不为空且不是空格
            error.put("name", "请输入用户名！");
            flag = false;
        }
        return flag;
    }

    public boolean passwordvalidate() {
        boolean flag = true;
        if (password == null || password.trim().equals("")) {
            error.put("password", "请输入密码！");
            flag = false;
        } else if (password.length() > 12 || password.length() < 6) {
            error.put("password", "请输入6-12位密码！");
            flag = false;
        }
        return flag;
    }

    public boolean password2validate() {
        boolean flag = true;
        if (password != null && !password.equals(password2)) {
            error.put("password2", "两次密码不匹配！");
            flag = false;
        }
        return flag;
    }

    public boolean emailvalidate() {
        boolean flag = true;
        if (email == null || email.trim().equals("")) {
            error.put("email", "请输入邮箱！");
            flag = false;
        } else if (!email.matches("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)")) {
            error.put("email", "email格式错误！");
            flag = false;
        }
        return flag;
    }

    public void setError(String err, String errMsg) {

        this.error.put(err, errMsg);

    }

    public Map<String, String> getError() {
        return error;
    }
}
