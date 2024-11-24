import java.util.Scanner;

import clases.Cliente;
import clases.Producto;

import java.util.Scanner;

public class TiendaComics {
    static Producto[] productos = new Producto[10];
    static Cliente[] clientes = new Cliente[5];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDatos();

        while (true) {
            mostrarMenuPrincipal();
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer de entrada

            switch (opcion) {
                case 1:
                    menuGestionProductos();
                    break;
                case 2:
                    menuVenta();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }
    }

    // Inicializar productos y clientes de ejemplo
    public static void inicializarDatos() {
        productos[0] = new Producto(1, "Spider-Man", "Cómic", 15.99, 20);
        productos[1] = new Producto(2, "Naruto", "Manga", 10.99, 15);
        // Rellenar el resto de productos de manera similar...

        clientes[0] = new Cliente("Juan Perez", "juan@example.com");
        clientes[1] = new Cliente("Maria Lopez", "maria@example.com");
        // Rellenar el resto de clientes de manera similar...
    }

    // Menú principal
    public static void mostrarMenuPrincipal() {
        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Gestión de Productos");
        System.out.println("2. Realizar Venta");
        System.out.println("3. Salir");
        System.out.print("Selecciona una opción: ");
    }

    // Menú de gestión de productos
    public static void menuGestionProductos() {
        while (true) {
            System.out.println("\n=== Gestión de Productos ===");
            System.out.println("1. Añadir nuevo producto");
            System.out.println("2. Mostrar lista de productos disponibles");
            System.out.println("3. Buscar producto por título");
            System.out.println("4. Actualizar stock");
            System.out.println("5. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    anadirProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    buscarProducto();
                    break;
                case 4:
                    actualizarStock();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // Añadir un nuevo producto
    public static void anadirProducto() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Tipo (Cómic/Manga): ");
        String tipo = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        Producto nuevoProducto = new Producto(id, titulo, tipo, precio, stock);
        // Agregar el nuevo producto al primer lugar disponible en el array
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null) {
                productos[i] = nuevoProducto;
                break;
            }
        }
    }

    // Mostrar productos
    public static void mostrarProductos() {
        System.out.println("\n=== Productos Disponibles ===");
        for (Producto producto : productos) {
            if (producto != null) {
                producto.mostrarProducto();
            }
        }
    }

    // Buscar un producto por título
    public static void buscarProducto() {
        System.out.print("Introduce el título del producto: ");
        String titulo = scanner.nextLine();
        for (Producto producto : productos) {
            if (producto != null && producto.getTitulo().equalsIgnoreCase(titulo)) {
                producto.mostrarProducto();
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    // Actualizar el stock de un producto
    public static void actualizarStock() {
        System.out.print("Introduce el ID del producto a actualizar: ");
        int id = scanner.nextInt();
        System.out.print("Introduce la cantidad a añadir al stock: ");
        int cantidad = scanner.nextInt();
        for (Producto producto : productos) {
            if (producto != null && producto.getId() == id) {
                producto.actualizarStock(cantidad);
                System.out.println("Stock actualizado.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    // Menú de realizar venta
    public static void menuVenta() {
        // Aquí implementarás las opciones del menú de venta
    }
}
