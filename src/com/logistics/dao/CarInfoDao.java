package com.logistics.dao;

import com.logistics.bean.CarInfo;
import com.logistics.bean.CarInfoAndPhone;
import com.logistics.bean.RecordSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/26.
 */
public class CarInfoDao extends BaseDao{
/*
    private static final String SHOWALL_CARINFO="select c.pic, c.carNum,c.owner,c1.carLong,c2.type,c3.type,c.startProvince,c.startCity,c.toProvince,c.toCity from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id";
    private static final String GETCARINFO_BYCARNO="select c.pic, c.carNum,c.owner,c1.carLong,c2.type,c3.type,c.startProvince,c.startCity,c.toProvince,c.toCity from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id where id=?";
    private static final String INSERT_CARINFO="INSERT INTO carinfo(carNum,carLongId,carTypeId,coachType,startProvince,toProvince,pic,startCity,toCity,owner) VALUES (?,?,?,?,?,?,?,?,?,?) ";
*/
    private static final String SHOWALL_CARINFO="select c.pic, c.carNum,c.owner,c1.carLong,c2.type,c3.type,c.startProvince,c.startCity,c.toProvince,c.toCity from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id";
    private static final String GETCARINFO_BYCARNO="select c.id, c.pic, c.carNum,c.owner,c1.carLong,c2.type,c3.type,c.startProvince,c.startCity,c.toProvince,c.toCity from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id where c.id=?";
    private static final String INSERT_CARINFO="INSERT INTO carinfo(carNum,carLongId,carTypeId,coachType,startProvince,toProvince,pic,startCity,toCity,owner) VALUES (?,?,?,?,?,?,?,?,?,?) ";
    private static final String SHOWALL_CARTS = "select c.id,c.pic, c.carNum,c.owner,c1.carLong,c2.type,c3.type,c.startProvince,c.startCity,c.toProvince,c.toCity from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id";
    private static final String SHOWCARTS_CART = "select c.id,c.pic, c.carNum,c.owner,c1.carLong,c2.type,c3.type,c.startProvince,c.startCity,c.toProvince,c.toCity from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id where c1.carLong=? and c2.type=? and c3.type=? and c.startProvince=? and c.startCity=? and c.toProvince=? and c.toCity=?";
    private static final String SHOWCARTS_PAGE = "select c.pic, c.carNum,c.owner,c1.carLong,c2.type,c3.type,c.startProvince,c.startCity,c.toProvince,c.toCity from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id limit ?,?";
    private static final String SHOWCARTS_SEl = "select count(1) from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id WHERE 1=1 ";

    Connection con =null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    //获取所有的车源信息
     public ArrayList<CarInfo> getAllCarInfo(){
         ArrayList<CarInfo> CarInfos=new ArrayList<CarInfo>();
         try {
             con =super.getConnection();
             psmt = con.prepareStatement(SHOWALL_CARINFO);
             rs = psmt.executeQuery();
             while (rs.next()) {
                 String carNum=rs.getString(2);
                 String startProvince=rs.getString(7);
                 String toProvince=rs.getString(9);
                 String carPic=rs.getString(1);
                 String startCity=rs.getString(8);
                 String toCity=rs.getString(10);
                 String carLong=rs.getString(4);
                 String carType=rs.getString(5);
                 String coachType=rs.getString(6);
                 String owner=rs.getString(3);
                 CarInfo c=new CarInfo(carPic,carNum,owner,carLong, carType,coachType,startProvince,startCity,toProvince,toCity);
                 CarInfos.add(c);

             }
         } catch (Exception e) {
             System.out.println("获取 车源信息失败，原因："+e.getMessage());
         } finally {
             super.closeAll(rs, psmt, con);
         }
         return  CarInfos;
     }
    //根据id获取车源信息
    public CarInfo getCarInfoByCarNum(int id){
        CarInfo carInfo=null;
        try{
            con =super.getConnection();
            psmt = con.prepareStatement(GETCARINFO_BYCARNO);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            if(rs.next()){
                int Id = rs.getInt(1);
                String carPic=rs.getString(2);
                String carNum=rs.getString(3);
                String owner=rs.getString(4);
                String carLong=rs.getString(5);
                String carType=rs.getString(6);
                String coachType=rs.getString(7);
                String startProvince=rs.getString(8);
                String startCity=rs.getString(9);
                String toProvince=rs.getString(10);
                String toCity=rs.getString(11);
                carInfo =new CarInfo(Id, carPic,carNum,owner,carLong, carType,coachType,startProvince,startCity,toProvince,toCity);

            }
        }catch (Exception e){

        }finally {
            super.closeAll(rs, psmt, con);
        }
        return  carInfo;
    }
    //发布车源信息
    //INSERT INTO carinfo(carNum,carLongId,carTypeId,coachType,startProvice,toProvice,pic,startCity,toCity
    public int releaseCarInfo(CarInfo carinfos){
        int val = 0;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement(INSERT_CARINFO);
            psmt.setString(1, carinfos.getCarNum());
            psmt.setString(2, carinfos.getCarLong());
            psmt.setString(3, carinfos.getCarType());
            psmt.setString(4 , carinfos.getCoachType());
            psmt.setString(5, carinfos.getStartProvince());
            psmt.setString(6, carinfos.getToProvince());
            psmt.setString(7 , carinfos.getCarPic());
            psmt.setString(8 , carinfos.getStartCity());
            psmt.setString(9 , carinfos.getToCity());
            psmt.setString(10 , carinfos.getOwner());
            val = psmt.executeUpdate();
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs, psmt, con);
        }
        return  val;
    }
    //获取前几个车源信息（推荐车主信息）
    public ArrayList<CarInfo> getCarInfos(int limit){
        ArrayList<CarInfo> CarInfos = new ArrayList<CarInfo>();
        try{
            con=super.getConnection();
            psmt = con.prepareStatement("select c.pic, c.carNum,c.owner,c1.carLong,c2.type,c3.type,c.startProvince,c.startCity,c.toProvince,c.toCity from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id limit 0,?");
            psmt.setInt(1, limit);
            rs = psmt.executeQuery();
            while(rs.next()){
                String carPic=rs.getString(1);
                String carNum=rs.getString(2);
                String owner=rs.getString(3);
                String carLong=rs.getString(4);
                String carType=rs.getString(5);
                String coachType=rs.getString(6);
                String startProvince=rs.getString(7);
                String startCity=rs.getString(8);
                String toProvince=rs.getString(9);
                String toCity=rs.getString(10);
                CarInfo c=new CarInfo(carPic,carNum,owner,carLong, carType,coachType,startProvince,startCity,toProvince,toCity);
                CarInfos.add(c);

            }

        }catch(Exception ex){
            System.out.print("获取列表信息失败，原因"+ex.getMessage());
        }finally{
            super.closeAll(rs, psmt, con);
        }
        return CarInfos;
    }
    //获取所有的所有车源信息
    public ArrayList<CarInfo> getAllCarInfos(){
        ArrayList<CarInfo> CarInfos=new ArrayList<CarInfo>();
        try {
            con =super.getConnection();
            psmt = con.prepareStatement(SHOWALL_CARTS);
            rs = psmt.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(1);
                String carPic=rs.getString(2);
                String carNum=rs.getString(3);
                String owner=rs.getString(4);
                String carLong=rs.getString(5);
                String carType=rs.getString(6);
                String coachType=rs.getString(7);
                String startProvince=rs.getString(8);
                String startCity=rs.getString(9);
                String toProvince=rs.getString(10);
                String toCity=rs.getString(11);
                CarInfo c=new CarInfo(Id,carPic,carNum,owner,carLong, carType,coachType,startProvince,startCity,toProvince,toCity);
                CarInfos.add(c);

            }
        } catch (Exception e) {
            System.out.println("获取 车源信息失败，原因："+e.getMessage());
        } finally {
            super.closeAll(rs, psmt, con);
        }
        return  CarInfos;
    }
    //根据车的信息搜索相关车源信息
    public ArrayList<CarInfo> getCarInfosByCarInfo(String carLong,String carType,String coachType,String startProvince,String startCity,String toProvince,String toCity){
        ArrayList<CarInfo> CarInfos=new ArrayList<CarInfo>();
        try {
            con =super.getConnection();
            psmt = con.prepareStatement(SHOWCARTS_CART);
            psmt.setString(1, carLong);
            psmt.setString(2, carType);
            psmt.setString(3,coachType);
            psmt.setString(4,startProvince);
            psmt.setString(5,startCity);
            psmt.setString(6,toProvince);
            psmt.setString(7,toCity);
            rs = psmt.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(1);
                String carPic=rs.getString(2);
                String carNum=rs.getString(3);
                String owner=rs.getString(4);
                carLong=rs.getString(5);
                carType=rs.getString(6);
                coachType=rs.getString(7);
                startProvince=rs.getString(8);
                startCity=rs.getString(9);
                toProvince=rs.getString(10);
                toCity=rs.getString(11);
                CarInfo c=new CarInfo(Id,carPic,carNum,owner,carLong, carType,coachType,startProvince,startCity,toProvince,toCity);
                CarInfos.add(c);

            }
        } catch (Exception e) {
            System.out.println("获取 车源信息失败，原因："+e.getMessage());
        } finally {
            super.closeAll(rs, psmt, con);
        }
        return  CarInfos;
    }
    /*根据地点获取车源*/
    public ArrayList<CarInfo> getCarInfosByRegion( String city){
        String sql = SHOWALL_CARTS+" where c.startCity = '"+city+"'";
        ArrayList<CarInfo> CarInfos=new ArrayList<CarInfo>();
        try {
            con =super.getConnection();
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(1);
                String carPic=rs.getString(2);
                String carNum=rs.getString(3);
                String owner=rs.getString(4);
                String carLong=rs.getString(5);
                String carType=rs.getString(6);
                String coachType=rs.getString(7);
                String startProvince=rs.getString(8);
                String startCity=rs.getString(9);
                String toProvince=rs.getString(10);
                String toCity=rs.getString(11);
                CarInfo c=new CarInfo(Id,carPic,carNum,owner,carLong, carType,coachType,startProvince,startCity,toProvince,toCity);
                CarInfos.add(c);

            }
        } catch (Exception e) {
            System.out.println("获取 车源信息失败，原因："+e.getMessage());
        } finally {
            super.closeAll(rs, psmt, con);
        }
        return  CarInfos;
    }
    /*登录之后显示手机号*/
    public ArrayList<CarInfoAndPhone> getCarInfosBylogin( String city){
        ArrayList<CarInfoAndPhone> CarInfos=new ArrayList<CarInfoAndPhone>();
        try {
            con =super.getConnection();
            psmt = con.prepareStatement("select c.id,c.pic, c.carNum,c.owner,c1.carLong,c2.type,c3.type,c.startProvince,c.startCity,c.toProvince,c.toCity , rg.telephoneNum from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 JOIN register as rg on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id and c.owner = rg.name WHERE c.startCity=?");
            psmt.setString(1 , city);
            rs = psmt.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(1);
                String carPic=rs.getString(2);
                String carNum=rs.getString(3);
                String owner=rs.getString(4);
                String carLong=rs.getString(5);
                String carType=rs.getString(6);
                String coachType=rs.getString(7);
                String startProvince=rs.getString(8);
                String startCity=rs.getString(9);
                String toProvince=rs.getString(10);
                String toCity=rs.getString(11);
                String phone = rs.getString(12);
                CarInfoAndPhone c=new CarInfoAndPhone(Id,carPic,carNum,owner,carLong, carType,coachType,startProvince,startCity,toProvince,toCity ,phone );
                CarInfos.add(c);

            }
        } catch (Exception e) {
            System.out.println("获取 车源信息失败，原因："+e.getMessage());
        } finally {
            super.closeAll(rs, psmt, con);
        }
        return  CarInfos;
    }
//*******************************************************
//获取所有信息加分页
public RecordSet<CarInfo> getCarInfos(int start ,int count){
    RecordSet<CarInfo> recordSet = new RecordSet<CarInfo>();
    recordSet.setPageSize(count);
    ArrayList<CarInfo> Car = new ArrayList<CarInfo>();
    Connection con = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    try{
        con = getConnection();
        psmt = con.prepareStatement(SHOWCARTS_PAGE);
        psmt.setInt(1, start);
        psmt.setInt(2 , count);
        rs = psmt.executeQuery();

        while(rs.next()){
            String carPic=rs.getString(1);
            String carNum=rs.getString(2);
            String owner=rs.getString(3);
            String carLong=rs.getString(4);
            String carType=rs.getString(5);
            String coachType=rs.getString(6);
            String startProvince=rs.getString(7);
            String startCity=rs.getString(8);
            String toProvince=rs.getString(9);
            String toCity=rs.getString(10);
            CarInfo c=new CarInfo(carPic,carNum,owner,carLong, carType,coachType,startProvince,startCity,toProvince,toCity);
            Car.add(c);
        }

        recordSet.setRecordSet(Car);

        rs = psmt.executeQuery("select count(1) from carinfo");
        if(rs.next()){
            recordSet.setRowCount(rs.getInt(1));
        }
    }
    catch(Exception ex){
        System.out.println("获取分页失败�:" + ex.getMessage());
    }
    finally {
        closeAll(rs , psmt , con);
    }
    return recordSet;
}
    //获取所有信息和电话加分页
    public RecordSet<CarInfoAndPhone> getCarInfosAndPhone(int start ,int count){
        String sql = "select c.id,c.pic, c.carNum,c.owner,c1.carLong,c2.type,c3.type,c.startProvince,c.startCity,c.toProvince,c.toCity , rg.telephoneNum from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 JOIN register as rg on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id and c.owner = rg.name";
        sql+=" limit ?,?";
        String sql1= "select count(1) from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 JOIN register as rg on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id and c.owner = rg.name";
        RecordSet<CarInfoAndPhone> recordSet = new RecordSet<CarInfoAndPhone>();
        recordSet.setPageSize(count);
        ArrayList<CarInfoAndPhone> Car = new ArrayList<CarInfoAndPhone>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try{
            con = getConnection();
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, start);
            psmt.setInt(2 , count);
            rs = psmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String carPic=rs.getString(2);
                String carNum=rs.getString(3);
                String owner=rs.getString(4);
                String carLong=rs.getString(5);
                String carType=rs.getString(6);
                String coachType=rs.getString(7);
                String startProvince=rs.getString(8);
                String startCity=rs.getString(9);
                String toProvince=rs.getString(10);
                String toCity=rs.getString(11);
                String phone = rs.getString(12);
                CarInfoAndPhone c=new CarInfoAndPhone(id ,carPic,carNum,owner,carLong, carType,coachType,startProvince,startCity,toProvince,toCity,phone);
                Car.add(c);
            }

            recordSet.setRecordSet(Car);

            rs = psmt.executeQuery(sql1);
            if(rs.next()){
                recordSet.setRowCount(rs.getInt(1));
            }
        }
        catch(Exception ex){
            System.out.println("获取分页失败�:" + ex.getMessage());
        }
        finally {
            closeAll(rs , psmt , con);
        }
        return recordSet;
    }
    //根据车的信息搜索相关车源信息+分页功能
    public RecordSet<CarInfo> getCarInfosBySelect(int start ,int count,String carLong,String carType,String coachType,String startProvince,String startCity,String toProvince,String toCity){
        RecordSet<CarInfo> recordSet = new RecordSet<CarInfo>();
        recordSet.setPageSize(count);
        ArrayList<CarInfo> Car = new ArrayList<CarInfo>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        String sql = SHOWALL_CARTS;
        String sql1= SHOWCARTS_SEl;
        if(!"".equals(carLong)){
            sql+=" and c1.carLong= '"+carLong+"'";
            sql1+=" and c1.carLong= '"+carLong+"'";
        }
        if (!"".equals(carType)){
            sql+=" and c2.type= '"+carType+"'";
            sql1+=" and c2.type= '"+carType+"'";
        }
        if (!"".equals(coachType)){
            sql+=" and c3.type= '"+coachType+"'";
            sql1+=" and c3.type= '"+coachType+"'";
        }
        if (!"".equals(startProvince)){
            sql+=" and c.startProvince= '"+startProvince+"'";
            sql1+=" and c.startProvince= '"+startProvince+"'";
        }
        if (!"".equals(startCity)){
            sql+=" and c.startCity= '"+startCity+"'";
            sql1=" and c.startCity= '"+startCity+"'";
        }
        if (!"".equals(toProvince)){
            sql+=" and c.toProvince= '"+toProvince+"'";
            sql1+=" and c.toProvince= '"+toProvince+"'";
        }
        if(!"".equals(toCity)){
            sql+=" and c.toCity= '"+toCity+"'";
            sql1+=" and c.toCity= '"+toCity+"'";
        }
        sql+=" limit ?,?";
        try{
            con = getConnection();
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, start);
            psmt.setInt(2 , count);
            rs = psmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);
                String carPic=rs.getString(2);
                String carNum=rs.getString(3);
                String owner=rs.getString(4);
                String carLong1=rs.getString(5);
                String carType1=rs.getString(6);
                String coachType1=rs.getString(7);
                String startProvince1=rs.getString(8);
                String startCity1=rs.getString(9);
                String toProvince1=rs.getString(10);
                String toCity1=rs.getString(11);
                CarInfo c=new CarInfo(id ,carPic,carNum,owner,carLong1, carType1,coachType1,startProvince1,startCity1,toProvince1,toCity1);
                Car.add(c);
            }

            recordSet.setRecordSet(Car);

            rs = psmt.executeQuery(sql1);
            if(rs.next()){
                recordSet.setRowCount(rs.getInt(1));
            }
        }
        catch(Exception ex){
            System.out.println("获取分页失败�:" + ex.getMessage());
        }
        finally {
            closeAll(rs , psmt , con);
        }
        return recordSet;
    }
    //根据车的信息搜索相关车源和手机号信息+加分页功能
    public RecordSet<CarInfoAndPhone> getCarInfosAndPhoneBySelect(int start ,int count,String carLong,String carType,String coachType,String startProvince,String startCity,String toProvince,String toCity){
        RecordSet<CarInfoAndPhone> recordSet = new RecordSet<CarInfoAndPhone>();
        recordSet.setPageSize(count);
        ArrayList<CarInfoAndPhone> Car = new ArrayList<CarInfoAndPhone>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        String sql = "select c.id,c.pic, c.carNum,c.owner,c1.carLong,c2.type,c3.type,c.startProvince,c.startCity,c.toProvince,c.toCity , rg.telephoneNum from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 JOIN register as rg on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id and c.owner = rg.name where 1=1";

        String sql1= "select count(1) from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 JOIN register as rg on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id and c.owner = rg.name where 1=1";
        if(!"".equals(carLong)){
            sql+=" and c1.carLong= '"+carLong+"'";
            sql1+=" and c1.carLong= '"+carLong+"'";
        }
        if (!"".equals(carType)){
            sql+=" and c2.type= '"+carType+"'";
            sql1+=" and c2.type= '"+carType+"'";
        }
        if (!"".equals(coachType)){
            sql+=" and c3.type= '"+coachType+"'";
            sql1+=" and c3.type= '"+coachType+"'";
        }
        if (!"".equals(startProvince)){
            sql+=" and c.startProvince= '"+startProvince+"'";
            sql1+=" and c.startProvince= '"+startProvince+"'";
        }
        if (!"".equals(startCity)){
            sql+=" and c.startCity= '"+startCity+"'";
            sql1+=" and c.startCity= '"+startCity+"'";
        }
        if (!"".equals(toProvince)){
            sql+=" and c.toProvince= '"+toProvince+"'";
            sql1+=" and c.toProvince= '"+toProvince+"'";
        }
        if(!"".equals(toCity)){
            sql+=" and c.toCity= '"+toCity+"'";
            sql1+=" and c.toCity= '"+toCity+"'";
        }
        sql+=" limit ?,?";
        try{
            con = getConnection();
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, start);
            psmt.setInt(2 , count);
            rs = psmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);
                String carPic=rs.getString(2);
                String carNum=rs.getString(3);
                String owner=rs.getString(4);
                String carLong1=rs.getString(5);
                String carType1=rs.getString(6);
                String coachType1=rs.getString(7);
                String startProvince1=rs.getString(8);
                String startCity1=rs.getString(9);
                String toProvince1=rs.getString(10);
                String toCity1=rs.getString(11);
                String phone = rs.getString(12);
                CarInfoAndPhone c=new CarInfoAndPhone(id ,carPic,carNum,owner,carLong1, carType1,coachType1,startProvince1,startCity1,toProvince1,toCity1,phone);
                Car.add(c);
            }

            recordSet.setRecordSet(Car);

            rs = psmt.executeQuery(sql1);
            if(rs.next()){
                recordSet.setRowCount(rs.getInt(1));
            }
        }
        catch(Exception ex){
            System.out.println("获取分页失败�:" + ex.getMessage());
        }
        finally {
            closeAll(rs , psmt , con);
        }
        return recordSet;
    }
    //根据装货地，卸货地，货主姓名，获取对应的发布信息
    public ArrayList<CarInfo> getCarByShipperStartCityToCity(String owner,String fromCity,String toCity){
        ArrayList<CarInfo> carInfos=new ArrayList<CarInfo>();
        String sql="select c.id,c.pic, c.carNum,c.owner,c1.carLong,c2.type,c3.type,c.startProvince,c.startCity,c.toProvince,c.toCity from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id where c.owner='"+owner+"'";
        if(!"".equals(fromCity)){
            sql+=" and c.startCity='"+fromCity+"'";
        }
        if(!"".equals(toCity)){
            sql+=" and c.toCity='"+toCity+"'";
        }
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try{
            con = super.getConnection();
            psmt = con .prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()){
                CarInfo g=new CarInfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
                carInfos.add(g);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误原因："+e.getMessage());
        }finally {
            closeAll(rs ,psmt ,con);
        }
        return  carInfos;
    }
    //根据ID删除车单
    public int delete(int carId){
        int val=0;
        Connection con=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement("delete from carinfo where id=?");
            psmt.setInt(1,carId);
            val=psmt.executeUpdate();
        }catch (Exception e){
            System.out.print("删除订单信息失败，原因是"+e.getMessage());
        }finally {
            closeAll(rs,psmt,con);
        }
        return  val;
    }
    //根据姓名获取车源信息
    public ArrayList<CarInfo> getCarInfoByName(String owner){
        ArrayList<CarInfo> CarInfos=new ArrayList<CarInfo>();
        try {
            con =super.getConnection();
            psmt = con.prepareStatement("select c.id, c.pic, c.carNum,c.owner,c1.carLong,c2.type,c3.type,c.startProvince,c.startCity,c.toProvince,c.toCity from carinfo as c join carlong as c1 join cartype as c2 join coachtype as c3 on c.carLongId=c1.id and c.carTypeId=c2.id and c.coachType=c3.id WHERE c.owner=?");
            psmt.setString(1,owner);
            rs = psmt.executeQuery();
            while (rs.next()) {

                CarInfo c=new CarInfo(rs.getInt(1) , rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
                CarInfos.add(c);
            }
        } catch (Exception e) {
            System.out.println("获取 车源信息失败，原因："+e.getMessage());
        } finally {
            super.closeAll(rs, psmt, con);
        }
        return  CarInfos;
    }

}
