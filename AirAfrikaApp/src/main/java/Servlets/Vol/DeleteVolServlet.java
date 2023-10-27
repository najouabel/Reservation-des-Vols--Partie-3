package Servlets.Vol;

import Dao.Imple.VolsDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/DeleteVolServlet")
public class DeleteVolServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Long volId = Long.parseLong(request.getParameter("id"));

         VolsDao volsDao = new VolsDao();

         boolean deleteSuccessful = volsDao.delete(volId);

        if (deleteSuccessful) {
            response.sendRedirect("DashboardAdminServlet");
        } else {
            response.sendRedirect("errorPage.jsp");
        }
    }
}
