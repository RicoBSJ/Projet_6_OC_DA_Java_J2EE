package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aubrun.eric.projet6.business.service.SiteService;
import com.aubrun.eric.projet6.model.bean.Site;

@WebServlet( "/TaguerUnSiteOfficiel" )
public class TaguerUnSiteOfficiel extends HttpServlet {

    private static final long  serialVersionUID = 1L;

    /* Constantes */
    public static final String VUE              = "/WEB-INF/jsp/detailsSite.jsp";

    private SiteService        siteService      = new SiteService();

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        Site siteATaguer = new Site();

        siteService.tagOfficialSite( siteATaguer );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet( request, response );
    }

}