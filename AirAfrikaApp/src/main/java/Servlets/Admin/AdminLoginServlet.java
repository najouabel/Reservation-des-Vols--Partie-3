package Servlets.Admin;


import Controllers.AuthentificationController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    AuthentificationController authentificationController = new AuthentificationController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./Views/Admin/LoginAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            if(authentificationController.isAdminAuth(email, password) != null){
                request.setAttribute("IdAdmin", authentificationController.isAdminAuth(email, password).getId());
                response.sendRedirect("./DashboardAdminServlet");
            }else{
                response.sendRedirect("./AdminLoginServlet");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
