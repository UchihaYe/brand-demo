package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.Brandservice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delByIdServlet")
public class DelByIdServlet extends HttpServlet {
    Brandservice service = new Brandservice();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受id
        String id = request.getParameter("id");
        //2.调用service删除
        service.delById(Integer.parseInt(id));

        request.getRequestDispatcher("/selectAllServlet")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
    }
}
