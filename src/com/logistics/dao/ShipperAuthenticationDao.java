package com.logistics.dao;

import com.logistics.bean.ShipperAuthentication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/26.
 */
public class ShipperAuthenticationDao extends BaseDao {
    /*获取所有认证信息*/
    public ArrayList<ShipperAuthentication> getAllShipperAnthenticationInfo(){
        ArrayList<ShipperAuthentication> shipperAuthentications = new ArrayList<ShipperAuthentication>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT s.shipperName , s.trueName , s.identityCard , s.pic , r.status FROM shipperAuthentication s INNER JOIN register r WHERE s.shipperName = r.name");
            rs = psmt.executeQuery();
            while (rs.next()){
                ShipperAuthentication s = new ShipperAuthentication(rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getInt(5));
                shipperAuthentications.add(s);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return  shipperAuthentications;
    }
    /*提交货主认证信息*/
    public int shipperAnthentication(ShipperAuthentication authentication){
        int val = 0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("INSERT INTO shipperAuthentication(shipperName , trueName ,identityCard , pic ) VALUES (?,?,?,?) ");
            psmt.setString(1 , authentication.getShipperName());
            psmt.setString(2 , authentication.getTrueName());
            psmt.setString(3, authentication.getIdentityCard());
            psmt.setString(4 , authentication.getPic());
            val = psmt.executeUpdate();
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return  val;
    }

    /*批准认证*/
    public int changeAnthenticationStatus(int status , String name){
        int val = 0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("UPDATE register SET status = ? WHERE name = ?");
            psmt.setInt(1 , status);
            psmt.setString(2 , name);
            val = psmt.executeUpdate();
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return val;
    }
    /*验证货主是否有审核信息*/
    public int checkExistShipperAnth(String name){
        int val = 0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("select shipperName from shipperAuthentication where shipperName=?");
            psmt.setString(1 , name);
            rs = psmt.executeQuery();
            if (rs.next()){
                val=1;
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return val;
    }
    /*获取当前货主验证信息*/
    public ShipperAuthentication getCurrentShipperAuth(String name) {
        ShipperAuthentication shipperAuthentication = new ShipperAuthentication();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con =super.getConnection();
            psmt = con.prepareStatement("SELECT * FROM shipperauthentication  where shipperName=?");
            psmt.setString(1,name);
            rs = psmt.executeQuery();
            while (rs.next()) {
                shipperAuthentication = new ShipperAuthentication(rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) ,1);
            }
        } catch (Exception e) {
            System.out.println("获取当前车主审核信息失败，原因："+e.getMessage());
        } finally {
            super.closeAll(rs, psmt, con);
        }
        return  shipperAuthentication;
    }
    //删除认证信息
    public int deleteShipperInfo(String name){
        int val = 0;
        Connection con =null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("DELETE FROM shipperauthentication WHERE shipperName=?");
            psmt.setString(1 , name);
            val = psmt.executeUpdate();
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt ,con);

        }
        return val;
    }

}
