package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Articulo;
import classes.Producto;
import controllers.ControladorProducto;

/**
 * Servlet implementation class DeleteItem
 */
@WebServlet("/borraritem")
public class DeleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idproducto = Integer.parseInt(request.getParameter("idproducto"));
		
		HttpSession sesion = request.getSession(true);
		ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? new ArrayList<>() : (ArrayList) sesion.getAttribute("carrito");

		if(articulos != null) {
			for(Articulo a:articulos){
				if(a.getIdProducto() == idproducto){
					articulos.remove(a);
					break;
				}
			}
		}
		
		double total = 0;
		ControladorProducto cp = new ControladorProducto();
		for(Articulo a:articulos){
			Producto producto = cp.getProducto(a.getIdProducto());
			total += a.getCantidad() * producto.getPrecio();
		}
	
		response.getWriter().print(Math.round(total * 100.0) /100.0);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
