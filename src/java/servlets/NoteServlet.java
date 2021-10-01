/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author wenchi
 */
public class NoteServlet extends HttpServlet {

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
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            // to read files
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String title = "";
            String contents = "";
            title = br.readLine();
            System.out.println(title);
            contents = br.readLine();
            System.out.println(contents);
            Note note = new Note(title, contents);
            request.setAttribute("note", note);
        // If edit doesn't exist, open the view page
        if(request.getParameter("edit") == null)
        {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
            return;
        }
        // Open the edit page
        
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request,response);
        return;
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
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        String title = "";
        String contents = "";
        title = request.getParameter("title")+"\n";
        contents = request.getParameter("contents");
        pw.write(title);
        pw.append(contents);
        pw.close();
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
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
