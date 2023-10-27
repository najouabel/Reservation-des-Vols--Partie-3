package Servlets.Admin;


import Dao.Imple.VolsDao;
import Entity.Vols;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "DashboardAdminServlet", value = "/DashboardAdminServlet")
public class DashboardAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

            if (path.equals("/DashboardAdminServlet")) {
                VolsDao volsDao = new VolsDao();

                List<Vols> volsList = volsDao.all();
                request.setAttribute("vols", volsList);


                request.getRequestDispatcher("./Views/Admin/adminDash.jsp").forward(request, response);
            }


            if (path.equals("/AdminLoginServlet")) {

                response.sendRedirect("./AdminLoginServlet");
            }
        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
