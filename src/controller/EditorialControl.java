package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EditorialDAO;
import model.Editorial;

/**
 * Servlet implementation class EditorialControl
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/EditorialControl" })
public class EditorialControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorialControl() {
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
		String nid=request.getParameter("nid");
		String nombre=request.getParameter("nombre");
		String telefono=request.getParameter("telefono");
		String direccion=request.getParameter("direccion");
		String email=request.getParameter("email");
		String sitioweb=request.getParameter("sitioweb");
		Editorial e= new Editorial();
		e.setNid(nid);
		e.setNombre(nombre);
		e.setTelefono(telefono);
		e.setDireccion(direccion);
		e.setEmail(email);
		e.setSitioweb(sitioweb);
		
		if (EditorialDAO.registrar(e)) {
			request.setAttribute("mensaje","La editorial fue guardada.");
		}else {
			request.setAttribute("mensaje","La editorial NO fue guardada.");
		}
		
		request.getRequestDispatcher("registroEditorial.jsp").forward(request, response);
				
	}

}
