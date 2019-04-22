package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import model.Categoria;

/**
 * Servlet implementation class CategoriaControl
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/CategoriaControl" })
public class CategoriaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaControl() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String nombre=request.getParameter("nombre");
		Categoria c= new Categoria();
		c.setNombre(nombre);
		
		if (CategoriaDAO.registrar(c)) {
			request.setAttribute("mensaje","La categoria fue guardada.");
		}else {
			request.setAttribute("mensaje","La categoria NO fue guardada.");
		}
		
		request.getRequestDispatcher("registroCategoria.jsp").forward(request, response);
		
	}

}
