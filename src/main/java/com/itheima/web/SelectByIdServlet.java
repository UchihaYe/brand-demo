package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.Brandservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    Brandservice service = new Brandservice();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受id
        String id = request.getParameter("id");
        //2.调用service查询
        Brand brand = service.selectById(Integer.parseInt(id));
        //3.存储到request中
        request.setAttribute("brand",brand);

        //4.转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
