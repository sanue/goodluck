package com.logistics.dao;

import com.logistics.bean.Goods;
import com.logistics.bean.GoodsAndPhone;
import com.logistics.bean.RecordSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/26.
 */
public class GoodsDao extends BaseDao {
    /*获取所有的货源信息*/
    public ArrayList<Goods> getAllGoods() {
        ArrayList<Goods> goodses = new ArrayList<Goods>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT g.id , g.shipper , g.name , g.weight , g.carTypeId , ct.type , g.coachTypeId , cht.type , g.carLongId , cl.carLong , g.startProvince ,g.startCity, g.toProvince,g.toCity , g.shipmentTime , g.pic  FROM goods g INNER JOIN cartype ct ON g.carTypeId = ct.id INNER JOIN coachtype cht ON g.coachTypeId= cht.id INNER JOIN carlong cl ON g.carLongId = cl.id");
            rs = psmt.executeQuery();
            while (rs.next()){
                Goods g = new Goods(rs.getInt(1) ,rs.getString(2), rs.getString(3) , rs.getString(4) , rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16) );
                goodses.add(g);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return goodses;
    }
    /*根据装货地点获取货源*/
    public ArrayList<Goods> getGoodsByCity(String city) {
        ArrayList<Goods> goodses = new ArrayList<Goods>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT g.id ,g.shipper , g.name , g.weight , g.carTypeId , ct.type , g.coachTypeId , cht.type , g.carLongId , cl.carLong , g.startProvince ,g.startCity, g.toProvince,g.toCity , g.shipmentTime , g.pic  FROM goods g INNER JOIN cartype ct ON g.carTypeId = ct.id INNER JOIN coachtype cht ON g.coachTypeId= cht.id INNER JOIN carlong cl ON g.carLongId = cl.id WHERE g.startCity = ?");
            psmt.setString(1 , city);
            rs = psmt.executeQuery();
            while (rs.next()){
                Goods g = new Goods(rs.getInt(1) ,rs.getString(2), rs.getString(3) , rs.getString(4) , rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16) );
                goodses.add(g);
            }

        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return goodses;
    }
    /*根据时间和装货地点获取货源*/
    public ArrayList<Goods> getGoodsByTimeAndloading(String loading , String time) {
        ArrayList<Goods> goodses = new ArrayList<Goods>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT g.id ,g.shipper, g.name , g.weight , g.carTypeId , ct.type , g.coachTypeId , cht.type , g.carLongId ,cl.carLong,  g.startProvince,g.startCity , g.toProvince,g.toCity , g.shipmentTime , g.pic   FROM goods g INNER JOIN cartype ct ON g.carTypeId = ct.id INNER JOIN coachtype cht ON g.coachTypeId= cht.id INNER JOIN carlong cl ON g.carLongId = cl.id WHERE g.startCity= ? AND g.shipmentTime = ?  ");
            psmt.setString(1 , loading);
            psmt.setString(2 , time);
            rs = psmt.executeQuery();
            while (rs.next()){
                Goods g = new Goods(rs.getInt(1) ,rs.getString(2), rs.getString(3) , rs.getString(4) , rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16) );
                goodses.add(g);
            }

        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return goodses;
    }
    /*根据时间和装货地点和送货点获取货源*/
    public ArrayList<Goods> getGoodsByTimeAndloadingAndUnloading(String loading , String unloading, String time) {
        ArrayList<Goods> goodses = new ArrayList<Goods>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT g.id ,g.shipper, g.name , g.weight , g.carTypeId , ct.type , g.coachTypeId , cht.type , g.carLongId , cl.carLong , g.startProvince,g.startCity , g.toProvince,g.toCity , g.shipmentTime , g.pic  FROM goods g INNER JOIN cartype ct ON g.carTypeId = ct.id INNER JOIN coachtype cht ON g.coachTypeId= cht.id INNER JOIN carlong cl ON g.carLongId = cl.id WHERE g.startCity = ? AND g.toCity= ? AND g.shipmentTime = ?");
            psmt.setString(1 , loading);
            psmt.setString(2 , unloading);
            psmt.setString(3 , time);
            rs = psmt.executeQuery();
            while (rs.next()){
                Goods g = new Goods(rs.getInt(1) ,rs.getString(2), rs.getString(3) , rs.getString(4) , rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16) );
                goodses.add(g);
            }

        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return goodses;
    }

    /***********获取前几个货源信息（推荐信息）****************/
    public ArrayList<Goods> getGoodsByLimit(int limit){
        ArrayList<Goods> goodses = new ArrayList<Goods>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("select * from goodses limit 0,?");
            psmt.setInt(1, limit);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Goods g = new Goods(rs.getInt(1) ,rs.getString(2), rs.getString(3) , rs.getString(4) , rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16) );
                goodses.add(g);
            }
        } catch (Exception e) {
            System.out.print("发生错误，错误信息：" + e.getMessage());
        } finally {
            closeAll(rs, psmt, con);
        }
        return goodses;


    }
    public ArrayList<Goods> getAllGoodsBylimit(int limit) {
        ArrayList<Goods> goodses = new ArrayList<Goods>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT g.id , g.shipper , g.name , g.weight , g.carTypeId , ct.type , g.coachTypeId , cht.type , g.carLongId , cl.carLong , g.startProvince ,g.startCity, g.toProvince,g.toCity , g.shipmentTime , g.pic  FROM goods g INNER JOIN cartype ct ON g.carTypeId = ct.id INNER JOIN coachtype cht ON g.coachTypeId= cht.id INNER JOIN carlong cl ON g.carLongId = cl.id limit ?");
            psmt.setInt(1,limit);
            rs = psmt.executeQuery();
            while (rs.next()){
                Goods g = new Goods(rs.getInt(1) ,rs.getString(2), rs.getString(3) , rs.getString(4) , rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16) );
                goodses.add(g);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return goodses;
    }
    /*根据城市 显示货物信息和手机号+分页功能*/
    public ArrayList<GoodsAndPhone> showGoodsAndPhone(String city) {
        ArrayList<GoodsAndPhone> goodses = new ArrayList<GoodsAndPhone>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT g.id ,g.shipper , g.name , g.weight , g.carTypeId , ct.type , g.coachTypeId , cht.type , g.carLongId , cl.carLong , g.startProvince ,g.startCity, g.toProvince,g.toCity , g.shipmentTime , g.pic , rg.telephoneNum  FROM goods g INNER JOIN cartype ct ON g.carTypeId = ct.id INNER JOIN coachtype cht ON g.coachTypeId= cht.id INNER JOIN carlong cl ON g.carLongId = cl.id INNER JOIN register as rg ON g.shipper=rg.name WHERE g.startCity = ?");
            psmt.setString(1 , city);
            rs = psmt.executeQuery();
            while (rs.next()){
                GoodsAndPhone g = new GoodsAndPhone(rs.getInt(1) ,rs.getString(2), rs.getString(3) , rs.getString(4) , rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16) , rs.getString(17));
                goodses.add(g);
            }

        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return goodses;
    }
    /*显示所有货物信息和手机号+分页功能*/
    public RecordSet<GoodsAndPhone> showGoodsAndPhone(int start , int pageSize , String time ,String startCity , String toCity) {
        String sql = "SELECT g.id ,g.shipper , g.name , g.weight , g.carTypeId , ct.type , g.coachTypeId , cht.type , g.carLongId , cl.carLong , g.startProvince ,g.startCity, g.toProvince,g.toCity , g.shipmentTime , g.pic , rg.telephoneNum  FROM goods g INNER JOIN cartype ct ON g.carTypeId = ct.id INNER JOIN coachtype cht ON g.coachTypeId= cht.id INNER JOIN carlong cl ON g.carLongId = cl.id INNER JOIN register as rg ON g.shipper=rg.name where 1 = 1";
        String sql1 = "SELECT count(1) FROM goods g INNER JOIN cartype ct ON g.carTypeId = ct.id INNER JOIN coachtype cht ON g.coachTypeId= cht.id INNER JOIN carlong cl ON g.carLongId = cl.id INNER JOIN register as rg ON g.shipper=rg.name where 1 = 1";
        if(!"".equals(time)){
            sql+=" and g.shipmentTime='"+time+"'";
            sql1+=" and g.shipmentTime='"+time+"'";
        }
        if(!"".equals(startCity)){
            sql+=" and g.startCity='"+startCity+"'";
            sql1+=" and g.startCity='"+startCity+"'";
        }
        if(!"".equals(toCity)){
            sql+=" and g.toCity='"+toCity+"'";
            sql1+=" and g.toCity='"+toCity+"'";
        }
        sql+=" limit ?,?";
        RecordSet<GoodsAndPhone> goodses = new RecordSet<GoodsAndPhone>();
        ArrayList<GoodsAndPhone> goods = new ArrayList<GoodsAndPhone>();
        goodses.setPageSize(pageSize);

        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement(sql);
            psmt.setInt(1 , start);
            psmt.setInt(2 , pageSize);
            rs = psmt.executeQuery();
            while (rs.next()){
                GoodsAndPhone g = new GoodsAndPhone(rs.getInt(1) ,rs.getString(2), rs.getString(3) , rs.getString(4) , rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16) , rs.getString(17));
                goods.add(g);
            }
            goodses.setRecordSet(goods);
            psmt = con.prepareStatement(sql1);
            rs = psmt.executeQuery();
            while (rs.next()){
                goodses.setRowCount(rs.getInt(1));
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return goodses;
    }
    /*根据装货地，卸货地，货主姓名，获取对应的发布信息*/
    public ArrayList<Goods> getGoodsByShipperStartCityToCity(String shipper,String fromCity,String toCity){
        ArrayList<Goods> goods=new ArrayList<Goods>();
        String sql="SELECT g.id , g.shipper , g.name , g.weight , g.carTypeId , ct.type , g.coachTypeId , cht.type , g.carLongId , cl.carLong , g.startProvince ,g.startCity, g.toProvince,g.toCity , g.shipmentTime , g.pic  FROM goods g INNER JOIN cartype ct ON g.carTypeId = ct.id INNER JOIN coachtype cht ON g.coachTypeId= cht.id INNER JOIN carlong cl ON g.carLongId = cl.id where shipper = '"+shipper+"'";
        if(!"".equals(fromCity)){
            sql+=" and g.startCity='"+fromCity+"'";
        }
        if(!"".equals(toCity)){
            sql+=" and g.toCity='"+toCity+"'";
        }
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try{
            con = super.getConnection();
            psmt = con .prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()){
                Goods g=new Goods(rs.getInt(1) ,rs.getString(2), rs.getString(3) , rs.getString(4) , rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16));
                goods.add(g);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误原因："+e.getMessage());
        }finally {
            closeAll(rs ,psmt ,con);
        }
        return  goods;
    }
    /*根据姓名获取货源信息*/
    public ArrayList<Goods> getGoodsByName(String shipper) {
        ArrayList<Goods> goodses = new ArrayList<Goods>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT g.id , g.shipper , g.name , g.weight , g.carTypeId , ct.type , g.coachTypeId , cht.type , g.carLongId , cl.carLong , g.startProvince ,g.startCity, g.toProvince,g.toCity , g.shipmentTime , g.pic  FROM goods g INNER JOIN cartype ct ON g.carTypeId = ct.id INNER JOIN coachtype cht ON g.coachTypeId= cht.id INNER JOIN carlong cl ON g.carLongId = cl.id where g.shipper=?");
            psmt.setString(1,shipper);
            rs = psmt.executeQuery();
            while (rs.next()){
                Goods g = new Goods(rs.getInt(1) ,rs.getString(2), rs.getString(3) , rs.getString(4) , rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16) );
                goodses.add(g);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return goodses;
    }
    //根据ID删除货单
    public int delete(int goodsId){
        int val=0;
        Connection con=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement("delete from goods where id=?");
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
