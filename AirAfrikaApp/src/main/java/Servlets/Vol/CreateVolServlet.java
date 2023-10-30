package Servlets.Vol;


import Dao.Imple.SocieteDao;
import Dao.Imple.VolsDao;
import Entity.Societe;
import Entity.Vols;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/CreateVolServlet")
public class CreateVolServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        SocieteDao SocieteDao = new SocieteDao();


        List<Societe> societies = SocieteDao.all();


        request.setAttribute("societies", societies);

        request.getRequestDispatcher("./Views/Admin/createVol.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String villeDepart = request.getParameter("ville_depart");
        String villeArrivee = request.getParameter("ville_arrivee");
        int nbre_place = Integer.parseInt(request.getParameter("nbre_place"));

        int societe_id = Integer.parseInt(request.getParameter("societe_id"));

            Vols vol = new Vols();

            VolsDao volsDao = new VolsDao();
            vol.setVilleDepart(villeDepart);
            vol.setVilleArrivee(villeArrivee);
            vol.setNbPlace(nbre_place);

            SocieteDao societeDao = new SocieteDao();
            Societe societe = societeDao.findById((long) societe_id).orElse(null);


            vol.setId_societe(societe);
            Vols createdVol = volsDao.save(vol);

            if (createdVol != null ) {
                response.sendRedirect("DashboardAdminServlet");
            } else {
                request.setAttribute("errorMessage", "La création du vol a échoué. Veuillez réessayer.");
                request.getRequestDispatcher("./Views/Admin/createvol.jsp").forward(request, response);
            }

    }
}