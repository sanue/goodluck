package com.logistics.dao;
import java.sql.*;
/**
 * Created by Administrator on 2016/10/26.
 */
public class BaseDao {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.5.33/logistics?characterEncoding=utf-8&useUnicode=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "niit";

    /**
     *
     * @return
     */
    public Connection getConnection(){
        Connection con = null;
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL , USERNAME , PASSWORD);
        }
        catch(Exception ex){
            System.out.println("create connection failure,desc:" + ex.getMessage());
        }
        return con;
    }

    /**
     *
     * @param rs
     * @param psmt
     * @param con
     */
    public void closeAll(ResultSet rs , PreparedStatement psmt , Connection con){
        if(null != rs){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != psmt){
            try {
                psmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null != con){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
