package com.logistics.dao;

import com.logistics.bean.CoachType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/28.
 */
public class CoachTypeDao extends  BaseDao{
    private static final String SHOWALL_COACHTYPE="select id,type from coachtype";
    private static final String ADD_NETCOACHTYPE="insert into coachtype(type)values(?) ";
    private static final String UPDATE_COACHTYPE="update coachtype set type=? where id=?";
    private static final String SHOWCOACHTYPE= "select id,type from coachtype where type=?";
    Connection con = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    //获取所有车的类型信息
    public ArrayList<CoachType> getAllCoachTypes(){
        ArrayList<CoachType> coachTypes=new ArrayList<CoachType>();
        try {
            con = super.getConnection();
            psmt=con.prepareStatement(SHOWALL_COACHTYPE);
            rs=psmt.executeQuery();
            while (rs.next()){
                CoachType c=new CoachType(rs.getInt(1),rs.getString(2));
                coachTypes.add(c);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            super.closeAll(rs , psmt , con);
        }

        return coachTypes;
    }
    //添加新车型
    public int insertNewCoachType(String type){
        int val = 0;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement(ADD_NETCOACHTYPE);
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
    public int modifyCoachType(CoachType coachType){
        int val = 0;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement(UPDATE_COACHTYPE);
            psmt.setString(1, coachType.getType());
            psmt.setInt(2, coachType.getId());
            val=psmt.executeUpdate();
        }catch (Exception e) {
            System.out.println("修改车型失败，原因："+e.getMessage());
        }
        return val;
    }
    //获取新添加的车类型
    public CoachType getCoachTypeByType(String type) {
        CoachType coachType=null;
        try{
            con=super.getConnection();
            psmt=con.prepareStatement(SHOWCOACHTYPE);
            psmt.setString(1, type);
            rs=psmt.executeQuery();
            if(rs.next()){
                int id=rs.getInt(1);
                String cType=rs.getString(2);
                coachType=new CoachType(id, cType);
            }
        }catch (Exception e) {
            System.out.println("失败，原因："+e.getMessage());
        }finally{
            super.closeAll(rs, psmt, con);
        }
        return coachType;
    }

}
