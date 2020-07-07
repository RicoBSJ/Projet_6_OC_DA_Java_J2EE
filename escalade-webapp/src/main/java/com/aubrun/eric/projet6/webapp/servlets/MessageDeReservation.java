package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aubrun.eric.projet6.business.service.MessageService;
import com.aubrun.eric.projet6.business.service.TopoService;
import com.aubrun.eric.projet6.business.service.UtilisateurService;
import com.aubrun.eric.projet6.model.bean.Message;
import com.aubrun.eric.projet6.model.bean.Topo;
import com.aubrun.eric.projet6.model.bean.Utilisateur;
import com.aubrun.eric.projet6.webapp.forms.MessageDeReservationForm;

@WebServlet( "/messageDeReservation" )
public class MessageDeReservation extends HttpServlet {

    private static final long  serialVersionUID   = 1L;

    public static final String ATT_USER           = "utilisateur";
    public static final String ATT_FORM           = "form";
    public static final String ATT_SESSION_USER   = "sessionUtilisateur";
    public static final String VUE                = "/WEB-INF/jsp/messageDeReservation.jsp";

    private MessageService     messageService     = new MessageService();
    private TopoService        topoService        = new TopoService();
    private UtilisateurService utilisateurService = new UtilisateurService();

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Utilisateur connectedUser = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( connectedUser == null || !connectedUser.getMembre() ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        MessageDeReservationForm form = new MessageDeReservationForm();

        HttpSession session = request.getSession();

        Utilisateur connectedUser = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( connectedUser == null || !connectedUser.getMembre() ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        }

        Message message = form.messageReservation( request );
        Integer idTopo = Integer.parseInt( request.getParameter( "idDispo" ) );
        Integer idUser = Integer.parseInt( request.getParameter( "idDest" ) );
        Topo topoDispo = topoService.findDetails( idTopo );
        Utilisateur userTopo = utilisateurService.findById( idUser );
        message.setDestinataire( userTopo );
        message.setEmetteur( connectedUser );
        message.setTopo( topoDispo );

        messageService.reserveMessage( message );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}