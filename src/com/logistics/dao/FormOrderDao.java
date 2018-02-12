package com.logistics.dao;

import com.logistics.bean.FormOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/28.
 */
public class FormOrderDao extends BaseDao{
    /*订单
    String orderNum;
    String startProvince;
    String startCity;
    String toProvince;
    String toCity;
    String goodsName;
    String goodsWeight;
    String time;
    String carNum;
    int state;*/

    /*获取所有订单*/
    public ArrayList<FormOrder> getAllFormOrder(String shipper , String owner){
        ArrayList<FormOrder> orders = new ArrayList<FormOrder>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT f.orderNum , g.startProvince , g.startCity , g.toProvince , g.toCity , g.name , g.weight , g.shipmentTime , c.carNum ,c.owner , f.state  FROM formorders f INNER JOIN goods g ON f.goodsId = g.id INNER JOIN carinfo c ON f.goodsId = c.id WHERE  g.shipper= ? OR c.owner= ?");
            psmt.setString(1 , shipper);
            psmt.setString(2 , owner);
            rs = psmt.executeQuery();
            while (rs.next()){
                FormOrder f =new FormOrder(rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11));
                orders.add(f);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误原因："+e.getMessage());
        }finally {
            closeAll(rs ,psmt ,con);
        }
        return orders;

    }
    /*根据装货时间来获取订单*/
    public  ArrayList<FormOrder> getOrdersByTime(String shipper , String owner,String startTime , String endTime){
        ArrayList<FormOrder> orders = new ArrayList<FormOrder>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con .prepareStatement("SELECT f.orderNum , g.startProvince , g.startCity , g.toProvince , g.toCity , g.name , g.weight , g.shipmentTime , c.carNum ,c.owner , f.state  FROM formorders f INNER JOIN goods g ON f.goodsId = g.id INNER JOIN carinfo c ON f.goodsId = c.id WHERE  (g.shipper= ? OR c.owner= ?) AND g.shipmentTime BETWEEN ? and ?");
            psmt.setString(1 , shipper);
            psmt.setString(2 , owner);
            psmt.setString(3 , startTime);
            psmt.setString(4 , endTime);
            rs = psmt.executeQuery();
            while (rs.next()){
                FormOrder f =new FormOrder(rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11));
                orders.add(f);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误原因："+e.getMessage());
        }finally {
            closeAll(rs ,psmt ,con);
        }
        return  orders;
    }
    /*根据起始地来获取来获取订单*/
    public  ArrayList<FormOrder> getOrdersByAddress(String shipper , String owner,String startAddr , String endAddr){
        ArrayList<FormOrder> orders = new ArrayList<FormOrder>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con .prepareStatement("SELECT f.orderNum , g.startProvince , g.startCity , g.toProvince , g.toCity , g.name , g.weight , g.shipmentTime , c.carNum ,c.owner , f.state  FROM formorders f INNER JOIN goods g ON f.goodsId = g.id INNER JOIN carinfo c ON f.goodsId = c.id WHERE  (g.shipper= ? OR c.owner= ?) AND g.startCity=? AND toCity=?");
            psmt.setString(1 , shipper);
            psmt.setString(2 , owner);
            psmt.setString(3 , startAddr);
            psmt.setString(4 , endAddr);
            rs = psmt.executeQuery();
            while (rs.next()){
                FormOrder f =new FormOrder(rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11));
                orders.add(f);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误原因："+e.getMessage());
        }finally {
            closeAll(rs ,psmt ,con);
        }
        return  orders;
    }
    /*根据时间和其实地来获取订单*/
    public  ArrayList<FormOrder> getOrdersByTimeAndAddress(String shipper , String owner,String startTime , String endTime , String startAddr , String endAddr){
        ArrayList<FormOrder> orders = new ArrayList<FormOrder>();
        String sql = "SELECT f.orderNum , g.startProvince , g.startCity , g.toProvince , g.toCity , g.name , g.weight , g.shipmentTime , c.carNum ,c.owner , f.state  FROM formorders f INNER JOIN goods g ON f.goodsId = g.id INNER JOIN carinfo c ON f.goodsId = c.id WHERE 1=1";
        if(!"".equals(shipper)){
            sql+=" and g.shipper='"+shipper+"'";
        }else{
            sql+=" and c.owner='"+owner+"'";
        }
        if(!"".equals(startTime)){
            sql+=" and g.shipmentTime >'" +startTime+"'";
        }
        if(!"".equals(endTime)){
            sql+=" and g.shipmentTime <'"+endTime+"'";
        }
        if(!"".equals(startAddr)){
            sql+=" and g.startCity='"+startAddr+"'";
        }
        if(!"".equals(endAddr)){
            sql+=" and g.toCity='"+endAddr+"'";
        }
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con .prepareStatement(sql);

            rs = psmt.executeQuery();
            while (rs.next()){
                FormOrder f =new FormOrder(rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11));
                orders.add(f);
            }
        } catch (Exception e) {
            System.out.print("发生错误，错误原因："+e.getMessage());
        }finally {
            closeAll(rs ,psmt ,con);
        }
        return  orders;
    }
    //根据ID删除订单
    public int delete(int goodsId){
        int val=0;
        Connection con=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement("delete from formorders where orderNum=?");
            psmt.setInt(1,goodsId);
            val=psmt.executeUpdate();
        }catch (Exception e){
            System.out.print("删除订单信息失败，原因是"+e.getMessage());
        }finally {
            closeAll(rs,psmt,con);
        }
        return  val;
    }
}
