package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibroDAO;
import model.Libro;

/**
 * Servlet implementation class LibroControl
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/LibroControl" })
public class LibroControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibroControl() {
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
		String isbn=request.getParameter("isbn");
		String titulo=request.getParameter("titulo");
		String descripcion=request.getParameter("descripcion");
		String nombre_autor=request.getParameter("nombre_autor");
		String fecha_publicacion=request.getParameter("fecha_publicacion");
		int codigo_categoria=Integer.parseInt(request.getParameter("cod_categoria"));
		String nid_editorial=request.getParameter("nid_editorial");
		
		String accion=request.getParameter("accion").toLowerCase();
		
		Libro lib = new Libro();
		
		lib.setIsbn(isbn);
		lib.setTitulo(titulo);
		lib.setDescripcion(descripcion);
		lib.setNombre_autor(nombre_autor);
		lib.setFecha_publicacion(fecha_publicacion);
		lib.setCodigo_categoria(codigo_categoria);
		lib.setNid_editorial(nid_editorial);
		
		
		if (accion.equals("registrar")) {
			if (LibroDAO.registrar(lib)) {
				request.setAttribute("mensaje", "Libro registrado");
			} else {
				request.setAttribute("mensaje", "Libro NO registrado");
			}
		} 
		else if (accion.equals("actualizar")) {
			if (LibroDAO.actualizar(lib)) {
				request.setAttribute("mensaje", "Libro actualizado");
			} else {
				request.setAttribute("mensaje", "Libro NO actualizado");
			}
		}
		else if (accion.equals("eliminar")) {
			if (LibroDAO.eliminar(lib)) {
				request.setAttribute("mensaje", "Libro eliminado");
			} else {
				request.setAttribute("mensaje", "Libro NO eliminado");
			}
		}
		else {
			request.setAttribute("mensaje", "Acción desconocida");
		}
		
		request.getRequestDispatcher("registroLibro.jsp").forward(request, response);
		
	}

}
