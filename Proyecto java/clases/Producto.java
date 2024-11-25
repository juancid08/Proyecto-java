package clases;


public class Producto {
    private int id;
    private String titulo;
    private String tipo; 
    private double precio;
    private int stock;

    /**
     * Constructor para crear un producto.
     * @param id El ID del producto.
     * @param titulo El título del producto.
     * @param tipo El tipo de producto (Cómic/Manga).
     * @param precio El precio del producto.
     * @param stock El stock disponible del producto.
     */
    public Producto(int id, String titulo, String tipo, double precio, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.precio = precio;
        this.stock = stock;
    }
     /**
     * Devuelve el ID del producto.
     * @return El ID del producto.
     */
    public int getId() {
        return id;
    }

     /**
     * Devuelve el título del producto.
     * @return El título del producto.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Devuelve el tipo del producto.
     * @return El tipo de producto (Cómic/Manga).
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Devuelve el precio del producto.
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Devuelve el stock del producto.
     * @return El stock disponible.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece el stock del producto.
     * @param stock El nuevo stock del producto.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Devuelve una representación en cadena del producto.
     * @return Una cadena que representa el producto.
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + titulo + ", Tipo: " + tipo + ", Precio: $" + precio + ", Stock: " + stock;
    }
}
