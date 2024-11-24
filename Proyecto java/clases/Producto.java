package clases;

public class Producto {
    private int id;
    private String titulo;
    private String tipo; 
    private double precio;
    private int stock;

    
    public Producto(int id, String titulo, String tipo, double precio, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.precio = precio;
        this.stock = stock;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
    public void mostrarProducto() {
        System.out.println("ID: " + id + " | Título: " + titulo + " | Tipo: " + tipo + " | Precio: $" + precio + " | Stock: " + stock);
    }

    
    public void actualizarStock(int cantidad) {
        this.stock += cantidad;
    }
}

