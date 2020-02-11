/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MAC04
 */
public class Add extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        String n0 = request.getParameter("name");
        String n1 = request.getParameter("addr");
        String n2 = request.getParameter("city");
        String n3 = request.getParameter("state");
        String n4 = request.getParameter("zip");
        String n5 = request.getParameter("hPhone");
        String n6 = request.getParameter("oPhone");
        String n7 = request.getParameter("fax");
        String n8 = request.getParameter("cPhone");
        String n9 = request.getParameter("email");
        String n10 = request.getParameter("url");
        String url = "jdbc:oracle:thin:@10.1.67.153:1521:ORCL";
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Connection con = DriverManager.getConnection(url,"msc17pw13","msc17pw");
            PreparedStatement st = con.prepareStatement("INSERT into ADDRBOOK values(?,?,?,?,?,?,?,?,?,?,?)");
         
            st.setString(1,n0);
            st.setString(2,n1);
            st.setString(3,n2);
            st.setString(4,n3);
            st.setString(5,n4);
            st.setString(6,n5);
            st.setString(7,n6);
            st.setString(8,n7);
            st.setString(9,n8);
            st.setString(10,n9);
            st.setString(11,n10);
            
            st.executeQuery();
            out.println("<h1>Value inserted successfully " + "</h1>");
            
        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
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
