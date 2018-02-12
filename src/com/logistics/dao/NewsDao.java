package com.logistics.dao;

import com.logistics.bean.News;
import com.logistics.bean.RecordSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/27.
 */
public class NewsDao extends BaseDao{
    /*获取所有新闻*/
    public ArrayList<News> getAllNews() {
        ArrayList<News> newses = new ArrayList<News>();
        Connection con =null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT * FROM news ORDER BY redeployTime DESC ");
            rs = psmt.executeQuery();
            while (rs.next()) {
                News n = new News(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getString(4));
                newses.add(n);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt ,con);
        }
        return  newses;
    }
    /*根据id获取新闻*/
    public News getNewsById( int id) {
        News news =null;
        Connection con =null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT * FROM news WHERE id = ?");
            psmt.setInt(1 , id);
            rs = psmt.executeQuery();
            while (rs.next()) {
                news = new News(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getString(4));
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt ,con);
        }
        return  news;
    }
    /*添加新闻*/
    public int addNews(News news){
        int val = 0;
        Connection con =null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("INSERT INTO news(id , redeployTime , newsTitle , messages) VALUES (? , ? ,? ,?)");
            psmt.setInt(1 , news.getId());
            psmt.setString(2 , news.getDate());
            psmt.setString(3 , news.getTitle());
            psmt.setString(4 , news.getContent());
            val = psmt.executeUpdate();
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt ,con);
        }
        return val;
    }
    /*修改新闻*/
    public int modifyNews(News news){
        int val = 0;
        Connection con =null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("UPDATE news SET redeployTime = ? , newsTitle = ? , messages = ? WHERE id = ?");
            psmt.setString(1 , news.getDate());
            psmt.setString(2 , news.getTitle());
            psmt.setString(3 , news.getContent());
            psmt.setInt(4 , news.getId());
            val = psmt.executeUpdate();
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt ,con);

        }
        return val;
    }
    /*删除新闻*/
    public int deleteNews(int id){
        int val = 0;
        Connection con =null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("DELETE FROM news WHERE id=?");
            psmt.setInt(1 , id);
            val = psmt.executeUpdate();
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt ,con);

        }
        return val;
    }

    public ArrayList<News> getAllNewsByLimit(int limit) {
        ArrayList<News> newses = new ArrayList<News>();
        Connection con =null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT * FROM news ORDER BY redeployTime DESC limit ? ");
            psmt.setInt(1,limit);
            rs = psmt.executeQuery();
            while (rs.next()) {
                News n = new News(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getString(4));
                newses.add(n);
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt ,con);
        }
        return  newses;
    }

    /*获取前几个新闻的详情*/
    public ArrayList<News> getNewsBYLimit(int limit){
        ArrayList<News> news = new ArrayList<News>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = super.getConnection();
            psmt = con.prepareStatement("SELECT * from news  ORDER BY redeployTime DESC limit 0,?; ");
            psmt.setInt(1, limit);
            rs = psmt.executeQuery();
            while (rs.next()) {
                News n = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                news.add(n);
            }
        } catch (Exception e) {
            System.out.print("发生错误，错误信息：" + e.getMessage());
        } finally {
            closeAll(rs, psmt, con);
        }
        return news;
    }
    /*获取所有新闻和分页功能*/
    public RecordSet<News> getAllNewsByPage(int start ,int count) {
        RecordSet<News> recordSet = new RecordSet<News>();
        recordSet.setPageSize(count);
        ArrayList<News> newses = new ArrayList<News>();
        Connection con =null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            psmt = con.prepareStatement("SELECT * FROM news ORDER BY redeployTime DESC limit ?,?");
            psmt.setInt(1, start);
            psmt.setInt(2 , count);
            rs = psmt.executeQuery();
            while (rs.next()) {
                News n = new News(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getString(4));
                newses.add(n);
            }
            recordSet.setRecordSet(newses);

            rs = psmt.executeQuery("select count(1) FROM news");
            if(rs.next()){
                recordSet.setRowCount(rs.getInt(1));
            }
        }catch (Exception e){
            System.out.print("发生错误，错误信息："+e.getMessage());
        }finally {
            closeAll(rs , psmt ,con);
        }
        return recordSet;
    }
}

