/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entity.Categories;
import Entity.Movie;
import Entity.ReviewMovie;
import Entity.Reviewers;
import Entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class IndexServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_JustTellYou_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Movie.findAll");

        Movie m = new Movie();
        List<Categories> rs = m.getCategoriesList();

        Query a = em.createNamedQuery("Categories.findAll");
        request.setAttribute("r", a.getResultList());

        //Show Rating
        Query cc = em.createQuery("select r from ReviewMovie r WHERE r.rating = null");
        Query c = em.createQuery("select r from ReviewMovie r WHERE r.rating >= 8.0");
        List<ReviewMovie> bestmv = c.getResultList();
        List<ReviewMovie> cs = cc.getResultList();

        request.setAttribute("bestmv", bestmv);

        request.setAttribute("rs", rs);
        request.setAttribute("cs", cs);
        request.getRequestDispatcher(
                "/Index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
