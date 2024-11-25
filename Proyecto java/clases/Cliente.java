package clases;

public class Cliente {
    private String nombre;
    private String email;
    private Producto[] historialCompras;
    private int numCompras;

 /**
     * Constructor para crear un cliente.
     * @param nombre El nombre del cliente.
     * @param correo El correo electrónico del cliente.
     * @param numCompras El número de compras iniciales (solo usado para ejemplos).
     */
    public Cliente(String nombre, String email, int maxCompras) {
        this.nombre = nombre;
        this.email = email;
        this.historialCompras = new Producto[maxCompras];
        this.numCompras = 0;
    }
   /**
     * Devuelve el nombre del cliente.
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Devuelve el email del cliente
     * @return El email del cliente
     */
    public String getEmail() {
        return email;
    }

    /**
     * Agrega una compra al historial del cliente.
     * @param producto
     */
    public void agregarCompra(Producto producto) {
        if (numCompras < historialCompras.length) {
            historialCompras[numCompras++] = producto;
        }
    }
    /**
     * Devuelve el historial de compras.
     * @return El historial de compras.
     */
    public Producto[] getHistorialCompras() {
        return historialCompras;
    }
    /**
     * Devuelve el número de compras.
     * @return El número de compras
    */
    public int getNumCompras() {
        return numCompras;
    }
    /**
     * Devuelve una representación en cadena del cliente.
     * @Override
     */
    
    public String toString() {
        return "Nombre: " + nombre + ", Email: " + email + ", Compras realizadas: " + numCompras;
    }
}
