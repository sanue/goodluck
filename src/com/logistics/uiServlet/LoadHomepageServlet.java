package com.logistics.uiServlet;



import com.logistics.bean.*;
import com.logistics.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Administrator on 2016/10/28.
 */
@WebServlet(name = "LoadHomepageServlet",urlPatterns = "/uiSite/index.html")
public class LoadHomepageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OwnerAuthenticationDao ownerAuthenticationDao = new OwnerAuthenticationDao();
        ArrayList<OwnerInfo> ownerInfos = ownerAuthenticationDao.getTenOwnersInfo();

       /* CarInfoDao carInfoDao = new CarInfoDao();
        ArrayList<CarInfo> carInfos = carInfoDao.getCarInfos(10);*/
        GoodsDao goodsDao = new GoodsDao();
        ArrayList<Goods> goods = goodsDao.getAllGoodsBylimit(9);

        NewsDao newsDao = new NewsDao();
        ArrayList<News> news = newsDao.getAllNewsByLimit(6);

        AdvertisementDao advertisementDao = new AdvertisementDao();
        ArrayList<Advertisement> ads = advertisementDao.getAds();

        request.setAttribute("ads",ads);
        request.setAttribute("ownerInfos",ownerInfos);
        request.setAttribute("goods",goods);
        request.setAttribute("news",news);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
