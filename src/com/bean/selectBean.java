package com.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class selectBean {
    private String name;
    private String password;
    private String email;
    private Map<String, String> error = new HashMap();
    public selectBean()
    {

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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setError(String err, String errMsg) {

        this.error.put(err, errMsg);

    }

    public Map<String, String> getError() {
        return error;
    }
    public int loginVerify()
    {
        Connection connection = new ConnectBean().getconnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String email = this.email;
        String password = this.password;
        int flag=0;
        String sql="select * from user.use_list where email=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                Object password1 = resultSet.getObject("password");
                if(password1.equals(password)){
                    flag=1;
                }else {
                    error.put("email","密码错误！");
                    flag=2;
                }
            }else{
                error.put("email","用户不存在！");
                flag=3;
            }
            return flag;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public int registerVerify()
    {
        Connection connection = new ConnectBean().getconnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String email = this.email;
        String password = this.password;
        int flag=0;
        String sql="select * from user.use_list where email=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                error.put("email","用户已存在！");
                flag = 1;
            }else{
                flag = 2;
            }
            return flag;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public void registerLoad()
    {
        Connection connection = new ConnectBean().getconnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String name = this.name;
        String email = this.email;
        String password = this.password;
        int flag=0;
        String sql="INSERT INTO user.use_list(username,password,email) values (?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,email);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public int resetVerify()
    {
        Connection connection = new ConnectBean().getconnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String email = this.email;
        String password = this.password;
        int flag=0;
        String sql="select * from user.use_list where email=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                flag = 1;
            }else{
                error.put("email","用户不存在！");
                flag = 2;
            }
            return flag;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public void resetLoad()
    {
        Connection connection = new ConnectBean().getconnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String email = this.email;
        String password = this.password;
        int flag=0;
        String sql="UPDATE user.use_list SET password=? WHERE email=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,password);
            preparedStatement.setString(2,email);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public void deleteLoad()
    {
        Connection connection = new ConnectBean().getconnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String email = this.email;
        String password = this.password;
        int flag=0;
        String sql="DELETE FROM user.use_list  WHERE email=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public String forgetLoad()
    {
        Connection connection = new ConnectBean().getconnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String email = this.email;
        String password = this.password;
        int flag=0;
        String sql="select password from user.use_list where email=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                flag = 1;
                return resultSet.getString("password");
            }else{
                flag = 2;
                return "no";
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public String sqlName()
    {
        Connection connection = new ConnectBean().getconnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String email = this.email;
        String password = this.password;
        int flag=0;
        String sql="select username from user.use_list where email=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                flag = 1;
                return resultSet.getString("username");
            }else{
                flag = 2;
                return "no";
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
