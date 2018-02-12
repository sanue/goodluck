package com.logistics.dao;

import com.logistics.bean.OwnerInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
/**
 * Created by Administrator on 2016/10/26.
 */
public class BaseInfoDao extends BaseDao {
    private static final String SHOWALL_OWNERINFO="select r.name,o.trueName ,r.sex,r.telephoneNum,r.identityStatus,r.status from register as r join ownerauthentication as o on r.name=o.ownerName where r.identityStatus=?";
    Connection con = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    //获取所有的车主信息
    public ArrayList<OwnerInfo> getAllOwnerInfo(int identityStatus) {
        ArrayList<OwnerInfo> OwnerInfos = new ArrayList<OwnerInfo>();
        try {
            con =super.getConnection();
            psmt = con.prepareStatement(SHOWALL_OWNERINFO);
            psmt.setInt(1 , identityStatus);
            rs = psmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                String trueName=rs.getString(2);
                String sex=rs.getString(3);
                String telephoneNum=rs.getString(4);
                int identity=rs.getInt(5);
                int status=rs.getInt(6);
                OwnerInfo o=new OwnerInfo(name,trueName,sex,telephoneNum,identity,status);
                OwnerInfos.add(o);
            }
        } catch (Exception e) {
            System.out.println("获取 车主信息失败，原因："+e.getMessage());
        } finally {
            super.closeAll(rs, psmt, con);
        }
        return OwnerInfos;
    }
}
