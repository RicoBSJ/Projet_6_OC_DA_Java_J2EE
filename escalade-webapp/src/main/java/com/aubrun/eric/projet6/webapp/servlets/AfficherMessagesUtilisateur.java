package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aubrun.eric.projet6.business.service.MessageService;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

@WebServlet( "/afficherMessagesUtilisateur" )
public class AfficherMessagesUtilisateur extends HttpServlet {

    private static final long  serialVersionUID = 1L;

    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE_MESSAGE      = "message";
    public static final String VUE              = "/WEB-INF/jsp/afficherMessagesUtilisateur.jsp";

    private MessageService     messageService   = new MessageService();

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Utilisateur connectedUser = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( connectedUser == null ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        }

        request.setAttribute( "messages", messageService.findDetailsMessagesUser( connectedUser.getId() ) );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
