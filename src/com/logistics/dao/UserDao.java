package com.logistics.dao;

import com.logistics.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Administrator on 2016/10/28.
 */
public class UserDao extends BaseDao{
    Connection con = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    // 登录
    public User login(String name ,String password){
        User user = null;
        try{
            con = super.getConnection();
            psmt=con.prepareStatement("select userName,Password,nickName from user where userName=? and password=?");
            psmt.setString(1, name);
            psmt.setString(2, password);
            rs=psmt.executeQuery();
            if(rs.next()){
                user=new User();
                user.setUserName(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setNickName(rs.getString(3));
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            super.closeAll(rs, psmt, con);
        }
        return user;
    }

    // 修改密码
    public int modifyPassword(String name , String newPassword ,String password ){
        int val = 0;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement("update user set password=? where userName=? and password=?");
            psmt.setString(1, password);
            psmt.setString(2, name);
            psmt.setString(3, newPassword);
            val=psmt.executeUpdate();
        }catch (Exception e) {
            System.out.println("修改密码失败，原因："+e.getMessage());
        }finally{
            super.closeAll(rs, psmt, con);
        }
        return val;
    }
}
