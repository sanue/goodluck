package com.logistics.dao;

import com.logistics.bean.CarLong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/27.
 */
public class CarLongDao extends BaseDao{
    private static final String SHOWALL_CARLONG ="select id,carLong from carlong";
    private static final String ADD_NEWCARLONG="insert into carlong(carLong)values(?) ";
    private static final String UPDATE_CARLONG="update carlong set carLong=? where id=?";
    private static final String SHOWCARLONG= "select id,carLong from carlong where carLong=?";
    Connection con = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    //获取所有的车长
    public ArrayList<CarLong> getAllCarLongs(){
        ArrayList<CarLong> carLongs=new ArrayList<CarLong>();
        try {
            con = super.getConnection();
            psmt=con.prepareStatement(SHOWALL_CARLONG);
            rs=psmt.executeQuery();
            while (rs.next()){
                CarLong c=new CarLong(rs.getInt(1),rs.getString(2));
                carLongs.add(c);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            super.closeAll(rs , psmt , con);
        }

        return carLongs;
    }
    //添加车长
    public int insertNewCarLong(String carLong){
        int val = 0;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement(ADD_NEWCARLONG);
            psmt.setString(1, carLong);
            val=psmt.executeUpdate();
        }catch (Exception e) {
            System.out.println("添加车长失败，原因："+e.getMessage());
        }finally{
            super.closeAll(rs, psmt, con);
        }
        return val;
    }
    //修改车长
    public int modifyCarLong(CarLong carLong){
        int val = 0;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement(UPDATE_CARLONG);
            psmt.setString(1, carLong.getCarsLong());
            psmt.setInt(2, carLong.getId());
            val=psmt.executeUpdate();
        }catch (Exception e) {
            System.out.println("修改车长失败，原因："+e.getMessage());
        }
        return val;
    }
    //获取新添加的车长
    public CarLong getCarLongByLong(String carLong) {
        CarLong carLong1=null;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement(SHOWCARLONG);
            psmt.setString(1, carLong);
            rs=psmt.executeQuery();
            if(rs.next()){
                int id=rs.getInt(1);
                String carsLong=rs.getString(2);
                carLong1=new CarLong(id, carsLong);
            }
        }catch (Exception e) {
            System.out.println("失败，原因："+e.getMessage());
        }finally{
            super.closeAll(rs, psmt, con);
        }
        return carLong1;
    }
}
