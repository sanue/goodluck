package com.logistics.dao;

import com.logistics.bean.BaseInfo;
import com.logistics.bean.Goods;
import com.logistics.bean.Shipper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 * Created by Administrator on 2016/10/26.
 */
public class ShipperDao extends BaseDao {
    /*获取所有货主基本信息*/
    public ArrayList<BaseInfo> getAllBaseInfo(int identityStatus){
        ArrayList<BaseInfo> baseInfos = new ArrayList<BaseInfo>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT * from register WHERE identityStatus = ?");
            psmt.setInt(1 , identityStatus);
            rs = psmt.executeQuery();
            while (rs.next()){
                BaseInfo bs = new BaseInfo(rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getInt(5) , rs.getInt(6));
                baseInfos.add(bs);
            }

        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return  baseInfos;
    }
    /*获取所有完成验证的货主完整信息*/
    public ArrayList<Shipper> getAllShipper(){
        ArrayList<Shipper> shippers = new ArrayList<Shipper>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT r.name , r.password , r.sex , r.telephoneNum , r.identityStatus , r.status , s.trueName , s.identityCard , s.pic from register r INNER JOIN shipperauthentication s ON r.name = s.shippnerName ");
            rs = psmt.executeQuery();
            while (rs.next()){
                Shipper s = new Shipper(rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getInt(5) , rs.getInt(6) , rs.getString(7) , rs.getString(8) , rs.getString(9));
                shippers.add(s);
            }

        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return  shippers;
    }

    /*发布货源*/
    public int releaseGoods(Goods goods){
        int val = 0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("INSERT INTO goods(id,name,weight,carTypeId,coachTypeId,carLongId,startProvince,toProvince,startCity,toCity,shipmentTime,pic,shipper) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            psmt.setInt(1 , goods.getId());
            psmt.setString(2, goods.getName());
            psmt.setString(3, goods.getWeight());
            psmt.setInt(4, goods.getCarTypeId());
            psmt.setInt(5, goods.getCoachTypeId());
            psmt.setInt(6 , goods.getCarLongId());
            psmt.setString(7, goods.getStartProvince());
            psmt.setString(8, goods.getToProvince());
            psmt.setString(9 , goods.getStartCity());
            psmt.setString(10, goods.getToCity());
            psmt.setString(11 , goods.getShipmentTime());
            psmt.setString(12 , goods.getPic());
            psmt.setString(13 , goods.getShipper());
            val = psmt.executeUpdate();
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return  val;
    }
}
