package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aubrun.eric.projet6.business.service.TopoService;
import com.aubrun.eric.projet6.model.bean.Topo;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

@WebServlet( "/reserverTopo" )
public class ReserverTopo extends HttpServlet {

    private static final long  serialVersionUID = 1L;

    public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE              = "/WEB-INF/jsp/reserverTopo.jsp";

    private TopoService        topoService      = new TopoService();

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Utilisateur connectedUser = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( connectedUser == null || !connectedUser.getMembre() ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        }

        Integer idTopo = Integer.parseInt(request.getParameter("idTopo"));
        Topo reservedTopo = topoService.findDetails(idTopo);
        topoService.reserveTopo( reservedTopo );

        request.setAttribute( ATT_USER, reservedTopo );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}