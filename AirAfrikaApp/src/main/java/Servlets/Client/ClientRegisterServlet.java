package Servlets.Client;

import Controllers.ClientController;
import Entity.Clients;
import Services.hash;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;


import java.io.IOException;

@WebServlet(name = "ClientRegisterServlet", value = "/ClientRegisterServlet")
public class ClientRegisterServlet extends HttpServlet {
    private ClientController clientController = new ClientController();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./Views/Client/clientRegister.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String prenom = request.getParameter("prenom");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String hashedPassword =  hash.getHashedPassword(password);;

        Clients client = new Clients();
        client.setName(name);
        client.setPrenom(prenom);
        client.setPhone(phone);
        client.setEmail(email);
        client.setPassword(hashedPassword);

        boolean success = clientController.registerClient(client);

        if (success) {
            response.sendRedirect("./ClientLoginServlet");
        } else {
            request.setAttribute("errorMessage", "L'inscription a échoué. Veuillez réessayer.");
            request.getRequestDispatcher("./Views/Client/clientRegister.jsp").forward(request, response);
        }
    }
}
