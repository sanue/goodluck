package com.logistics.dao;

import com.logistics.bean.Advertisement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * Created by Administrator on 2016/10/28.
 */
public class AdvertisementDao extends BaseDao  {
     /*获取六条广告信息*/
     public ArrayList<Advertisement> getAllAd() {
         ArrayList<Advertisement> ads = new ArrayList<Advertisement>();
         Connection con = null;
         PreparedStatement psmt = null;
         ResultSet rs = null;
         try {
             con = super.getConnection();
             psmt = con.prepareStatement("SELECT id,pic ,state from advertisement where state=1");
             rs = psmt.executeQuery();
             while (rs.next()){
                 Advertisement ad =new Advertisement(rs.getInt(1),rs.getString(2) ,rs.getInt(3));
                 ads.add(ad);
             }
         }catch (Exception e){
             System.out.print("获取广告失败，错误信息："+e.getMessage());
         }finally {
             closeAll(rs , psmt , con);
         }
         return ads;
     }
    /*添加广告*/
    public int addAdvertisement(Advertisement ad){
        int val = 0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("INSERT INTO advertisement(id , pic , state)VALUES(?,?,?) ");
            psmt.setInt(1 , ad.getId());
            psmt.setString(2 , ad.getImage());
            psmt.setInt(3 , ad.getState());
            val = psmt.executeUpdate();
        }catch (Exception e){
            System.out.print("添加广告失败，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return val;
    }
    /*应用广告或者不应用广告*/
    public int applyAdvertisement(int id  , int state){
        int val = 0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("UPDATE advertisement SET state = ? WHERE id = ?");
            psmt.setInt(1 , state);
            psmt.setInt(2 , id);
            val = psmt.executeUpdate();
        }catch (Exception e){
            System.out.print("应用广告失败，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return val;
    }
    /*删除广告信息*/
    public int deleteAdvertisement(int id ){
        int val = 0;
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("DELETE FROM advertisement WHERE id = ?");
            psmt.setInt(1 , id);
            val = psmt.executeUpdate();
        }catch (Exception e){
            System.out.print("应用广告失败，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return val;
    }
    /*获取应用的广告信息*/
    public ArrayList<Advertisement> getAds() {
        ArrayList<Advertisement> ads = new ArrayList<Advertisement>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT id,pic from advertisement where state=1");
            rs = psmt.executeQuery();
            while (rs.next()){
                Advertisement ad =new Advertisement(rs.getInt(1),rs.getString(2));
                ads.add(ad);
            }
        }catch (Exception e){
            System.out.print("获取广告失败，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return ads;
    }

}
