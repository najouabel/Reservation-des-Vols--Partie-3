package Servlets.Client;


import Controllers.AuthentificationController;
import Entity.Clients;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ClientLoginServlet", value = "/ClientLoginServlet")
public class ClientLoginServlet extends HttpServlet {
    AuthentificationController authentificationController = new AuthentificationController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./Views/Client/LoginClient.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            if(authentificationController.isClientAuth(email, password) != null){
                Clients client = authentificationController.isClientAuth(email, password);
                request.getSession().setAttribute("IDClient", client.getId());
                request.getSession().setAttribute("clientName", client.getName());
                response.sendRedirect("./getAllVolServlet");
            }else{
                response.sendRedirect("./ClientLoginServlet");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
