package br.com.projeto.servelet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.beans.NivelUsuario;
import br.com.projeto.dao.NivelUsuarioDAO;

/**
 * Servlet implementation class Niveis
 */
@WebServlet("/Niveis")
public class Niveis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Niveis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 

		 
//		 try {
//			NivelUsuario nu = new NivelUsuario();
//			NivelUsuarioDAO nuDAO = new NivelUsuarioDAO();
//			
//			ArrayList<NivelUsuario> listaResul = nuDAO.todosNivelUsuario(nu);
//			
//			request.setAttribute("listaResul", listaResul);
//			RequestDispatcher saida = request.getRequestDispatcher("listaResul");
//		    saida.forward(request, response);
//		 }catch(Exception e) {
//			 
//		 }
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
