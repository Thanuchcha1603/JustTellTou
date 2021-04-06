/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entity.Actors;
//import Entity.Actors_;
import Entity.Categories;
import Entity.Directors;
import Entity.Movie;
import Entity.ReviewMovie;
import Entity.Reviewers;
import Entity.Users;
import com.mysql.cj.Session;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.stream.events.Comment;

/**
 *
 * @author Dell
 */
public class ReviewServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        String movieID = request.getParameter("movieID");
//        Comment comment = request.getParameter("comment");
        int id = (Integer.parseInt(movieID));
        Movie m = em.find(Movie.class, id);

        Query q = em.createQuery("select r from ReviewMovie r where r.movieID.movieID =:param");
//        Query ccc = em.createNamedQuery("Comment.findAll");
//        List<ReviewMovie> s = q.getResultList();
        q.setParameter("param", id);

        ReviewMovie r = (ReviewMovie) q.getSingleResult();

        if (r.getReviewText() == null) {
            request.setAttribute("no", "Coming soon!");

        }
        List<Actors> a = r.getMovieID().getActorsList();
        Reviewers rr = em.find(Reviewers.class, r.getReviewerID());
        List<Directors> d = r.getMovieID().getDirectorsList();

        Query cc = em.createQuery("select r from ReviewMovie r WHERE r.rating >= 8.0");
        List<ReviewMovie> bestmv = cc.getResultList();
        request.setAttribute("bestmv", bestmv);

        Query comment = em.createNamedQuery("Comment.findByMovieID");
        comment.setParameter("movieID", m);
        List<Comment> cccc = comment.getResultList();
        request.setAttribute("cm", cccc);

        Query c = em.createNamedQuery("Categories.findAll");
        request.setAttribute("Cat", c.getResultList());
        //request.setAttribute("id", m);
        request.setAttribute("actor", a);
        request.setAttribute("director", d);
        request.setAttribute("id", r);
        session.setAttribute("movieID", m);

        request.setAttribute("r", rr);
//        request.setAttribute("cm", rrr);

        request.getRequestDispatcher("/ReviewMovie.jsp").forward(request, response);
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
