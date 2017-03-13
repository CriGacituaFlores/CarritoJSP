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

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/agregarproducto")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		int idproducto = Integer.parseInt(request.getParameter("idproducto"));
	
		//Varialbe de sesion
		HttpSession sesion = request.getSession(true);
		
		//Array list
		//Se pone (ArrayList) ya que es un objeto que debe ser pasado a arraylist
		ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? new ArrayList<>() : (ArrayList) sesion.getAttribute("carrito");
	
		boolean flag = false;
		
		//en caso de que el producto no exista en el carrito, lo crea
		if(articulos.size() > 0){
			for(Articulo a:articulos){
				if(idproducto == a.getIdProducto()){
					a.setCantidad(a.getCantidad() + cantidad);
					flag = true;
					//Al ser break; no se ejecuta el !flag de abajo
					break;
				}
			}
		}
		
		if(!flag){
			articulos.add(new Articulo(idproducto,cantidad));
		}
		
		sesion.setAttribute("carrito", articulos);
		
		response.sendRedirect("cart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
