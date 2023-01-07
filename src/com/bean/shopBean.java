package com.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class shopBean {
    private String email;
    private String name;
    private int id;
    private String book_name;
    private float price;
    public shopBean()
    {

    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void creatUser()
    {
        Connection connection = new ConnectBean().getconnection();
        PreparedStatement preparedStatement=null;
        String email = this.email;
        String name = this.name;
        int flag=0;
        String sql="CREATE TABLE " + email + " ( id INT, bookName VARCHAR(30), price FLOAT);";
        try {
            preparedStatement = connection.prepareStatement(sql);
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
    public ArrayList<Item> selectUser()
    {
        Connection connection = new ConnectBean().getconnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String email = this.email;
        String name = this.name;
        ArrayList<Item> list = new ArrayList<Item>();
        int flag=0;
        String sql="select * from user." + email;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                flag = 1;
                Item item = new Item();
                //处理读出的数据
                item.setId(resultSet.getInt("id"));
                item.setBook_name(resultSet.getString("bookName"));
                item.setPrice(resultSet.getFloat("price"));
                list.add(item);
            }
            return list;

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
    public void clearAll()
    {
        Connection connection = new ConnectBean().getconnection();
        PreparedStatement preparedStatement=null;
        String email = this.email;
        String name = this.name;
        String delete_sql = "DROP TABLE " + email + ";";
        String create_sql = "CREATE TABLE " + email + " ( id INT, bookName VARCHAR(30), price FLOAT);";
        try {
            preparedStatement = connection.prepareStatement(delete_sql);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(create_sql);
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
    public void addItem()
    {
        Connection connection = new ConnectBean().getconnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String email = this.email;
        int id = this.id;
        String book_name = this.book_name;
        float price = this.price;
        int flag=0;
        String sql="INSERT INTO user." + email + " (id,bookName,price) values (?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,book_name);
            preparedStatement.setFloat(3,price);
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
}
