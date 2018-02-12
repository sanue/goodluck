package com.logistics.dao;

import com.logistics.bean.CarType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/27.
 */
public class CarTypeDao extends  BaseDao{
    private static final String SHOWALL_CARTYPE="select id,type from cartype";
    private static final String ADD_NETCARTYPE="insert into cartype(type)values(?) ";
    private static final String UPDATE_CARTYPE="update cartype set type=? where id=?";
    private static final String SHOWCARTYPE= "select id,type from cartype where type=?";
    Connection con = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    //获取所有车的类型信息
    public  ArrayList<CarType> getAllCarTypes(){
        ArrayList<CarType> carTypes=new ArrayList<CarType>();
        try {
            con = super.getConnection();
            psmt=con.prepareStatement(SHOWALL_CARTYPE);
            rs=psmt.executeQuery();
            while (rs.next()){
                CarType c=new CarType(rs.getInt(1),rs.getString(2));
                carTypes.add(c);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            super.closeAll(rs , psmt , con);
        }

        return carTypes;
    }
    //添加新车型
    public int insertNewCarType(String type){
        int val = 0;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement(ADD_NETCARTYPE);
            psmt.setString(1, type);
            val=psmt.executeUpdate();
        }catch (Exception e) {
            System.out.println("添加车类型失败，原因："+e.getMessage());
        }finally{
            super.closeAll(rs, psmt, con);
        }
        return val;
    }
    //修改新车型
    public int modifyCarType(CarType carType){
        int val = 0;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement(UPDATE_CARTYPE);
            psmt.setString(1, carType.getType());
            psmt.setInt(2, carType.getId());
            val=psmt.executeUpdate();
        }catch (Exception e) {
            System.out.println("修改车型失败，原因："+e.getMessage());
        }
        return val;
    }
    //获取新添加的车类型
    public CarType getCarTypeByType(String type) {
        CarType carType=null;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement(SHOWCARTYPE);
            psmt.setString(1, type);
            rs=psmt.executeQuery();
            if(rs.next()){
                int id=rs.getInt(1);
                String cType=rs.getString(2);
                carType=new CarType(id, cType);
            }
        }catch (Exception e) {
            System.out.println("失败，原因："+e.getMessage());
        }finally{
            super.closeAll(rs, psmt, con);
        }
        return carType;
    }

}
