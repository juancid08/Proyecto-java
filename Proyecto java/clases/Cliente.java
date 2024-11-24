package clases;

public class Cliente {
    private String nombre;
    private String email;
    private Producto[] historialCompras;
    private int numCompras;

    
    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.historialCompras = new Producto[10]; 
        this.numCompras = 0;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Producto[] getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(Producto[] historialCompras) {
        this.historialCompras = historialCompras;
    }

    
    public void agregarCompra(Producto producto) {
        if (numCompras < historialCompras.length) {
            historialCompras[numCompras] = producto;
            numCompras++;
        } else {
            System.out.println("Historial de compras lleno.");
        }
    }

   
    public void mostrarHistorial() {
        if (numCompras == 0) {
            System.out.println("No tiene compras registradas.");
        } else {
            for (int i = 0; i < numCompras; i++) {
                System.out.println(historialCompras[i].getTitulo());
            }
        }
    }
}
