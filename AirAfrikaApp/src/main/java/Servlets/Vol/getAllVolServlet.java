package Servlets.Vol;

import Dao.Imple.VolsDao;
import Entity.Vols;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "getAllVolServlet", value = "/getAllVolServlet")
public class getAllVolServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VolsDao volsDao = new VolsDao();

        List<Vols> volsList = volsDao.all();
        request.setAttribute("vols", volsList);


        request.getRequestDispatcher("./Views/Client/ListVols.jsp").forward(request, response);

    }
}
