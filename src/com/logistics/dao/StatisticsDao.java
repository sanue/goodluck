package com.logistics.dao;

import com.logistics.bean.Statistics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/27.
 */
public class StatisticsDao extends BaseDao {
    /*车主数量*/
    public int getCountOfOwner(){
        int val = 0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT COUNT(*) from register where identityStatus = 0");
            rs = psmt.executeQuery();
            while (rs.next()){
                val=rs.getInt(1);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return val;
    }
    /*车源数量*/
    public int getCountOfCarInfo(){
        int val = 0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT COUNT(*) from carInfo ");
            rs = psmt.executeQuery();
            while (rs.next()){
                val = rs.getInt(1);
            }

        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return val;
    }

    /*货主数量*/
    public int getCountOfShipper(){
        int val = 0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT COUNT(*) from register WHERE identityStatus = 1");
            rs = psmt.executeQuery();
            while (rs.next()){
                val = rs.getInt(1);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return val;
    }
    /*货源数量*/
    public int getCountOfGoods(){
        int val = 0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT COUNT(*) from goods");
            rs = psmt.executeQuery();
            while (rs.next()){
                val = rs.getInt(1);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return val;
    }
    /*不同地方的车源数量*/
    public ArrayList<Statistics> getCountOfCarInfoByRegion(){
        ArrayList<Statistics> ss = new ArrayList<Statistics>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT carinfo.startProvince ,  COUNT(*) AS counts from carinfo GROUP BY startProvince ORDER BY counts DESC");
            rs = psmt.executeQuery();
            while (rs.next()){
                Statistics s = new Statistics(rs.getString(1) , rs.getInt(2));
                ss.add(s);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return ss;
    }
    /*不同地方的货源数量*/
    public ArrayList<Statistics> getCountOfGoodsByRegion(){
        ArrayList<Statistics> ss = new ArrayList<Statistics>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT goods.startProvince ,  COUNT(*) AS counts from goods GROUP BY startProvince ORDER BY  counts DESC");
            rs = psmt.executeQuery();
            while (rs.next()){
                Statistics s = new Statistics(rs.getString(1) , rs.getInt(2));
                ss.add(s);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return ss;
    }
    /*所有的订单数*/
    public int getCountOfFormOrder(){
        int val = 0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT COUNT(*) from formOrders");
            rs = psmt.executeQuery();
            while (rs.next()){
                val = rs.getInt(1);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return val;

    }
    //车主信息审核数量
    public int getCountOfOwnerAuthentication(){
        int val=0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT COUNT(*) from ownerauthentication");
            rs = psmt.executeQuery();
            while (rs.next()){
                val = rs.getInt(1);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return  val;
    }
    //货主信息审核数量
    public int getCountOfShipperAuthentication(){
        int val=0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT COUNT(*) from shipperauthentication");
            rs = psmt.executeQuery();
            while (rs.next()){
                val = rs.getInt(1);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return  val;
    }
    //车型类型数量
    public int getCountOfCarType(){
        int val=0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT COUNT(*) from cartype");
            rs = psmt.executeQuery();
            while (rs.next()){
                val = rs.getInt(1);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return  val;
    }
    //车长类型数量
    public int getCountOfCarLong(){
        int val=0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT COUNT(*) from carlong");
            rs = psmt.executeQuery();
            while (rs.next()){
                val = rs.getInt(1);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return  val;
    }
    //车厢类型数量
    public int getCountOfCoachType(){
        int val=0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT COUNT(*) from coachtype");
            rs = psmt.executeQuery();
            while (rs.next()){
                val = rs.getInt(1);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return  val;
    }
    //新闻数量
    public int getCountOfNews(){
        int val=0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT COUNT(*) from news");
            rs = psmt.executeQuery();
            while (rs.next()){
                val = rs.getInt(1);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return  val;
    }
}
