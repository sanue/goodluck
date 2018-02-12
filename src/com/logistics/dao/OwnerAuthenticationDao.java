package com.logistics.dao;

import com.logistics.bean.OwnerAuthentication;
import com.logistics.bean.OwnerInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/26.
 */
public class OwnerAuthenticationDao extends BaseDao {
    private static final String SHOWALL_OWNERAUTHENTICATION="select o.truename,o.headPic,o.driversLicensePic,o.carNum,o.pic,r.status,r.name from ownerauthentication as o join register as r where o.ownerName = r.name";
    private static final String INSERT_OWNERAUTHENTICATION="insert into ownerauthentication(ownerName,trueName,driversLicensePic,carNum,pic,headPic)values(?,?,?,?,?,?)";
    private static  final String SHOWTEN_OWNERSINFO ="select o.ownerName,c.carNum,c.startProvince,c.toProvince,c.startCity,c.toCity,c1.carLong,c2.type,c3.type ,register.telephoneNum,o.headPic from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 join ownerauthentication as o join register on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id and o.carNum=c.carNum and register.name=o.ownerName limit 10";
    private static  final String CHECKEXIST_OWNERTRUENAME ="select trueName from ownerauthentication where trueName =?";
    private static  final String CHECKEXIST_OWNERNAME ="select ownerName from ownerauthentication where ownerName =?";
    private static final String SHOWCURRENT_OWNER="select * from ownerauthentication where ownerName=?";
    private static final String CHECKAUTHSUCCESS_OWNER="select * from register where status=1 and name=? ";
    private static final String CHECKAUTHFALSE_OWNER="select * from register where status=2 and name=? ";
    Connection con =null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    //获取所有车主审核信息
    public ArrayList<OwnerAuthentication> getAllOwnerInfo(){
        ArrayList<OwnerAuthentication> OwnerAuthentications = new ArrayList<OwnerAuthentication>();
        try {
            con =super.getConnection();
            psmt = con.prepareStatement(SHOWALL_OWNERAUTHENTICATION);
            rs = psmt.executeQuery();
            while (rs.next()) {
                String trueName = rs.getString(1);
                String headPic=rs.getString(2);
                String driversLicensePic=rs.getString(3);
                String carNum=rs.getString(4);
                String pic=rs.getString(5);
                int status=rs.getInt(6);
                String ownerName=rs.getString(7);
                OwnerAuthentication owner=new OwnerAuthentication(trueName,headPic,driversLicensePic,carNum,pic,status,ownerName);
                OwnerAuthentications.add(owner);

            }
        } catch (Exception e) {
            System.out.println("获取 车主审核信息失败，原因："+e.getMessage());
        } finally {
            super.closeAll(rs, psmt, con);
        }
        return  OwnerAuthentications;
    }
    //提交车主认证信息
    public int OwnerAuthentication(OwnerAuthentication OwnerAuthentication){
        int val = 0;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement(INSERT_OWNERAUTHENTICATION);
            psmt.setString(1 , OwnerAuthentication.getOwnerName());
            psmt.setString(2 , OwnerAuthentication.getTrueName());
            psmt.setString(3, OwnerAuthentication.getDrivesLicensePic());
            psmt.setString(4 , OwnerAuthentication.getCarNum());
            psmt.setString(5 , OwnerAuthentication.getIdentityPic());
            psmt.setString(6 , OwnerAuthentication.getHeadPic());
            val = psmt.executeUpdate();
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt , con);
        }
        return  val;
    }
    /*获取前１０个车主信息*/
    public ArrayList<OwnerInfo> getTenOwnersInfo() {
        ArrayList<OwnerInfo> OwnersInfos = new ArrayList<OwnerInfo>();
        try {
            con =super.getConnection();
            psmt = con.prepareStatement(SHOWTEN_OWNERSINFO);
            rs = psmt.executeQuery();
            while (rs.next()) {
                String ownerName = rs.getString(1);
                String carNum=rs.getString(2);
                String startProvince=rs.getString(3);
                String toProvince=rs.getString(4);
                String startCity=rs.getString(5);
                String toCity=rs.getString(6);
                String carLong=rs.getString(7);
                String carType=rs.getString(8);
                String coachType=rs.getString(9);
                String telephoneNum = rs.getString(10);
                String headPic = rs.getString(11);
/*OwnerInfo(name,toCity,startCity,toProvince,startProvince,coachType,carType,carLong,carNum,telephoeNum)*/
                OwnerInfo ownersInfo = new OwnerInfo(ownerName,toCity,startCity,toProvince,startProvince,coachType,carType,carLong,carNum,telephoneNum,headPic);
                OwnersInfos.add(ownersInfo);

            }
        } catch (Exception e) {
            System.out.println("获取 车主信息失败，原因："+e.getMessage());
        } finally {
            super.closeAll(rs, psmt, con);
        }
        return  OwnersInfos;
    }
    /*获取车主是否存在*/
    public int checkExistOwner(String ownerName){
        int val=0;
        try {
            con =super.getConnection();
            psmt = con.prepareStatement(CHECKEXIST_OWNERNAME);
            psmt.setString(1,ownerName);
            rs = psmt.executeQuery();
            while (rs.next()) {
                /*String name = rs.getString(1);*/
                val=1;
            }
        } catch (Exception e) {
            System.out.println("获取 车主审核信息失败，原因："+e.getMessage());
        } finally {
            super.closeAll(rs, psmt, con);
        }
        return  val;
    }
    /*查看车主真名是否存在*/
    public int checkExistTrueName(String trueName){
        int val=0;
        try {
            con =super.getConnection();
            psmt = con.prepareStatement(CHECKEXIST_OWNERTRUENAME);
            psmt.setString(1,trueName);
            rs = psmt.executeQuery();
            while (rs.next()) {
                String ownerName = rs.getString(1);
                val=1;
            }
        } catch (Exception e) {
            System.out.println("获取 车主审核信息失败，原因："+e.getMessage());
        } finally {
            super.closeAll(rs, psmt, con);
        }
        return  val;
    }
    /*显示当前车主认证信息*/
    public OwnerAuthentication getCurrentOwnerAuth(String name) {
        OwnerAuthentication ownerAuthentication = new OwnerAuthentication();
        try {
            con =super.getConnection();
            psmt = con.prepareStatement(SHOWCURRENT_OWNER);
            psmt.setString(1,name);
            rs = psmt.executeQuery();
            while (rs.next()) {
                String ownerName = rs.getString(1);
                String trueName=rs.getString(2);
                String driversLicensePic=rs.getString(3);
                String carNum=rs.getString(4);
                String pic=rs.getString(5);
                String headPic=rs.getString(6);

                ownerAuthentication = new OwnerAuthentication(ownerName,trueName,headPic,driversLicensePic,carNum,pic);
            }
        } catch (Exception e) {
            System.out.println("获取当前车主审核信息失败，原因："+e.getMessage());
        } finally {
            super.closeAll(rs, psmt, con);
        }
        return  ownerAuthentication;
    }
    //批准认证
    public int changeOwnerAnthenticationStatus(int status , String name){
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
    //显示车主是否已经审核成功
    public int checkOwnerAuthSuccess(String name){
        int val=0;
        try {
            con =super.getConnection();
            psmt = con.prepareStatement(CHECKAUTHSUCCESS_OWNER);
            psmt.setString(1,name);
            rs = psmt.executeQuery();
            if (rs.next()) {
                val=1;
            }
        } catch (Exception e) {
            System.out.println("获取 车主审核信息失败，原因："+e.getMessage());
        } finally {
            super.closeAll(rs, psmt, con);
        }
        return  val;
    }
    //删除审核不通过的车主信息
    public int deleteOwnerInfo(String name){
        int val = 0;
        Connection con =null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("DELETE FROM ownerauthentication WHERE ownerName=?");
            psmt.setString(1 , name);
            val = psmt.executeUpdate();
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt ,con);

        }
        return val;
    }
    //显示车主是否已经审核失败
    public int checkOwnerAuthFalse(String name){
        int val=0;
        try {
            con =super.getConnection();
            psmt = con.prepareStatement(CHECKAUTHFALSE_OWNER);
            psmt.setString(1,name);
            rs = psmt.executeQuery();
            if (rs.next()) {
                val=1;
            }
        } catch (Exception e) {
            System.out.println("获取 车主审核信息失败，原因："+e.getMessage());
        } finally {
            super.closeAll(rs, psmt, con);
        }
        return  val;
    }
}
