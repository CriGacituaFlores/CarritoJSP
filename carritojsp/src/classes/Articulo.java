package classes;

public class Articulo {

	private int idProducto;
	private int cantidad;
	
	public Articulo(int idProducto, int cantidad) {
		super();
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
