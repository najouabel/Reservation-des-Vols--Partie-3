package Servlets.Vol;

import Dao.Imple.VolsDao;
import Entity.Vols;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/updateVolServlet")
public class UpdateVolServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));

        Optional<Vols> vols1 = new VolsDao().findById(id);

        if (vols1.isPresent()) {
            Vols vols = vols1.get();
            req.setAttribute("vols", vols);
            req.getRequestDispatcher("./Views/Admin/editVol.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String newVilleDepart = request.getParameter("ville_depart");
        String newVilleArrivee = request.getParameter("ville_arrivee");

        VolsDao volsDao = new VolsDao();
        Optional<Vols> existingVolOptional = volsDao.findById(id);

        if (existingVolOptional.isPresent()) {
            Vols existingVol = existingVolOptional.get();
            existingVol.setVilleDepart(newVilleDepart);
            existingVol.setVilleArrivee(newVilleArrivee);
            boolean updateSuccessful = volsDao.update(id, existingVol);

            if (updateSuccessful) {
                response.sendRedirect("DashboardAdminServlet");
            } else {
                response.sendRedirect("errorPage.jsp");
            }
        } else {
            response.sendRedirect("errorPage.jsp");
        }
    }
}
