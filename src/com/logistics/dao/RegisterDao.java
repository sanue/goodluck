package com.logistics.dao;

import com.logistics.bean.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Administrator on 2016/10/26.
 */
public class RegisterDao extends BaseDao{
    Connection con = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    /*信息注册*/
    public int register(Register register){
        int val = 0;

        try {
            con = super.getConnection();
            psmt = con.prepareStatement("INSERT INTO register(name , password , sex , telephoneNum , identityStatus , status) VALUES(? , ? , ? ,? , ?, ?)");
            psmt.setString(1,register.getName());
            psmt.setString(2,register.getPassword());
            psmt.setString(3,register.getSex());
            psmt.setString(4,register.getTelephoeNum());
            psmt.setInt(5,register.getIdentity());
            psmt.setInt(6,register.getStatus());
            val=psmt.executeUpdate();
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return val;
    }
    // 登录
    public Register login(String name ,String password){
        Register register = null;
        try{
            con = super.getConnection();
            psmt=con.prepareStatement("select * from register where name=? and password=?");
            psmt.setString(1, name);
            psmt.setString(2, password);
            rs=psmt.executeQuery();
            if(rs.next()){
                register=new Register(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));

            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            super.closeAll(rs, psmt, con);
        }
        return register;
    }
    // 修改密码
    public int modifyPassword(String name , String newPassword ,String password){
        int val = 0;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement("update register set password=? where name=? and password=?");
            psmt.setString(1, newPassword);
            psmt.setString(2, name);
            psmt.setString(3,password);
            val=psmt.executeUpdate();
        }catch (Exception e) {
            System.out.println("修改密码失败，原因："+e.getMessage());
        }finally{
            super.closeAll(rs, psmt, con);
        }
        return val;
    }
    //修改密码时检查输入的密码是否正确
    public  int checkUserPwd(String userName,String password){
        int val=0;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement("select * from register where name=? and password=?");
            psmt.setString(2,password);
            psmt.setString(1,userName);
            rs=psmt.executeQuery();
            if(rs.next()){
                val=1;
            }

        }catch (Exception e){
            System.out.print("检查失败，原因是："+e.getMessage());
        }finally {

        }
        return  val;

    }

    //检查用户名是否已经存在
    public int checkIfExisted(String inputUserName){
        int val=0;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement("select name from register where name=?");
            psmt.setString(1,inputUserName);
            rs=psmt.executeQuery();
            if(rs.next()){
                val=1;
            }

        }catch (Exception e){
            System.out.print("检查用户名失败，原因是："+e.getMessage());
        }finally{
            super.closeAll(rs,psmt,con);

        }

        return  val;
    }
    //检查是不是车主
    public int checkOwnerORShipper(String name){
        int val=0;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement("select * from register where identityStatus=0 and name=? ");
            psmt.setString(1,name);
            rs=psmt.executeQuery();
            if(rs.next()){
                val=1;
                //车主
            }

        }catch (Exception e){
            System.out.print("检查用户名失败，原因是："+e.getMessage());
        }finally{
            super.closeAll(rs,psmt,con);

        }

        return  val;
    }
    //修改验证状态
    public int setStatus(int statu,String name){
        int val = 0;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement("update register set status=? where name=?");
            psmt.setInt(1, statu);
            psmt.setString(2, name);
            val=psmt.executeUpdate();
        }catch (Exception e) {
            System.out.println("修改密码失败，原因："+e.getMessage());
        }finally{
            super.closeAll(rs, psmt, con);
        }
        return val;
    }
    //根据姓名获取身份
    public int getIdentityByName(String name){
        int val=0;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement("select identityStatus from register where name=?");
            psmt.setString(1,name);
            rs=psmt.executeQuery();
            if(rs.next()){
                val=rs.getInt(1);
            }

        }catch (Exception e){
            System.out.print("检查用户名失败，原因是："+e.getMessage());
        }finally{
            super.closeAll(rs,psmt,con);

        }
        return val;
    }

}
