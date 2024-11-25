import java.util.Scanner;

import clases.Cliente;
import clases.Producto;

public class TiendaComics {
    private static Producto[] productos = new Producto[20];
    private static Cliente[] clientes = new Cliente[5];
    private static int numProductos = 10; // Inicializamos con 10 productos
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDatos();

        boolean salir = false;
        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();
            switch (opcion) {
                case 1:
                    gestionarProductos();
                    break;
                case 2:
                    realizarVenta();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicación...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }
    }

    /**
     * Inicializa los productos y clientes con datos de ejemplo.
     */
    private static void inicializarDatos() {
        productos[0] = new Producto(1, "Spiderman", "Cómic", 12.99, 10);
        productos[1] = new Producto(2, "Batman", "Cómic", 10.99, 5);
        productos[2] = new Producto(3, "Naruto", "Manga", 9.99, 7);
        productos[3] = new Producto(4, "One Piece", "Manga", 11.99, 8);
        productos[4] = new Producto(5, "Iron Man", "Cómic", 14.99, 3);
        productos[5] = new Producto(6, "Bleach", "Manga", 8.99, 10);
        productos[6] = new Producto(7, "Wonder Woman", "Cómic", 13.99, 6);
        productos[7] = new Producto(8, "Attack on Titan", "Manga", 12.49, 4);
        productos[8] = new Producto(9, "Hulk", "Cómic", 15.99, 2);
        productos[9] = new Producto(10, "My Hero Academia", "Manga", 10.49, 8);

        clientes[0] = new Cliente("Alice", "alice@example.com", 5);
        clientes[1] = new Cliente("Bob", "bob@example.com", 5);
        clientes[2] = new Cliente("Charlie", "charlie@example.com", 5);
        clientes[3] = new Cliente("Diana", "diana@example.com", 5);
        clientes[4] = new Cliente("Eve", "eve@example.com", 5);

        // Agregamos compras a clientes como ejemplo
        clientes[0].agregarCompra(productos[0]);
        clientes[0].agregarCompra(productos[3]);
        clientes[1].agregarCompra(productos[2]);
    }
    /**
     * Muestra el menú principal de la tienda.
     */
    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Gestión de Productos");
        System.out.println("2. Realizar Venta");
        System.out.println("3. Salir");
        System.out.print("Selecciona una opción: ");
    }
    /**
     * Lee la opción seleccionada por el usuario desde la entrada estándar.
     * @return
     */
    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    /**
     * Gestiona la sección de productos, mostrando el menú relacionado con ellos.
     */
    private static void gestionarProductos() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n=== Gestión de Productos ===");
            System.out.println("1. Añadir nuevo producto");
            System.out.println("2. Mostrar la lista de productos disponibles");
            System.out.println("3. Buscar productos por título");
            System.out.println("4. Actualizar el stock");
            System.out.println("5. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            int opcion = leerOpcion();
            switch (opcion) {
                case 1:
                    añadirProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    buscarProductoPorTitulo();
                    break;
                case 4:
                    actualizarStock();
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }
    }
    /**
     * Añade un nuevo producto al inventario de la tienda.
     */
    private static void añadirProducto() {
        if (numProductos >= productos.length) {
            System.out.println("No se pueden añadir más productos, el inventario está lleno.");
            return;
        }
        try {
            System.out.print("Introduce el ID del producto: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Introduce el título del producto: ");
            String titulo = scanner.nextLine();
            System.out.print("Introduce el tipo (Cómic/Manga): ");
            String tipo = scanner.nextLine();
            System.out.print("Introduce el precio: ");
            double precio = Double.parseDouble(scanner.nextLine());
            System.out.print("Introduce el stock: ");
            int stock = Integer.parseInt(scanner.nextLine());

            productos[numProductos++] = new Producto(id, titulo, tipo, precio, stock);
            System.out.println("Producto añadido exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Intente de nuevo.");
        }
    }
    /**
     * Muestra todos los productos disponibles en la tienda.
     */
    private static void mostrarProductos() {
        System.out.println("\n=== Lista de Productos ===");
        for (int i = 0; i < numProductos; i++) {
            System.out.println(productos[i]);
        }
    }
    /**
     *  Busca productos por su título y los muestra si los encuentra.
     */
    private static void buscarProductoPorTitulo() {
        System.out.print("Introduce el título del producto a buscar: ");
        String titulo = scanner.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < numProductos; i++) {
            if (productos[i].getTitulo().equals(titulo)) {
                System.out.println(productos[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron productos con ese título.");
        }
    }
    /**
     * Actualiza el stock de un producto especificado por su ID.
     */
    private static void actualizarStock() {
        System.out.print("Introduce el ID del producto para actualizar el stock: ");
        int id = leerOpcion();
        boolean encontrado = false;

        for (int i = 0; i < numProductos; i++) {
            if (productos[i].getId() == id) {
                encontrado = true;
                System.out.print("Introduce el nuevo stock: ");
                try {
                    int nuevoStock = Integer.parseInt(scanner.nextLine());
                    productos[i].setStock(nuevoStock);
                    System.out.println("Stock actualizado correctamente.");
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Intente de nuevo.");
                }
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }
    /**
     * Realiza una venta de productos, gestionando la selección de producto y cliente.
     */
    private static void realizarVenta() {
        boolean volver = false;
        Producto productoSeleccionado = null;
        Cliente clienteSeleccionado = null;

        while (!volver) {
            System.out.println("\n=== Realizar Venta ===");
            System.out.println("1. Seleccionar producto");
            System.out.println("2. Seleccionar cliente");
            System.out.println("3. Confirmar venta");
            System.out.println("4. Aplicar descuento aleatorio");
            System.out.println("5. Ver historial de compras");
            System.out.println("6. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            int opcion = leerOpcion();
            switch (opcion) {
                case 1:
                    productoSeleccionado = seleccionarProducto();
                    break;
                case 2:
                    clienteSeleccionado = seleccionarCliente();
                    break;
                case 3:
                    if (productoSeleccionado != null && clienteSeleccionado != null) {
                        confirmarVenta(productoSeleccionado, clienteSeleccionado);
                    } else {
                        System.out.println("Debe seleccionar un producto y un cliente antes de confirmar la venta.");
                    }
                    break;
                case 4:
                    aplicarDescuentoAleatorio(productoSeleccionado);
                    break;
                case 5:
                    if (clienteSeleccionado != null) {
                        verHistorialCompras(clienteSeleccionado);
                    } else {
                        System.out.println("Debe seleccionar un cliente para ver su historial de compras.");
                    }
                    break;
                case 6:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }
    }
    /**
     * Selecciona un producto del inventario.
     * @return El producto seleccionado, o null si no se selecciona ninguno.
     */
     
    private static Producto seleccionarProducto() {
        mostrarProductos();
        System.out.print("Introduce el ID del producto a seleccionar: ");
        int id = leerOpcion();
        for (int i = 0; i < numProductos; i++) {
            if (productos[i].getId() == id) {
                if (productos[i].getStock() > 0) {
                    System.out.println("Producto seleccionado: " + productos[i]);
                    return productos[i];
                } else {
                    System.out.println("El producto no tiene stock disponible.");
                }
            }
        }
        System.out.println("Producto no encontrado.");
        return null;
    }
    /**
     * Selecciona un cliente de la lista de clientes.
     * @return El cliente seleccionado, o null si no se selecciona ninguno.
     */
    private static Cliente seleccionarCliente() {
        System.out.println("\n=== Lista de Clientes ===");
        for (int i = 0; i < clientes.length; i++) {
            System.out.println((i + 1) + ". " + clientes[i]);
        }
        System.out.print("Selecciona un cliente por número: ");
        int indice = leerOpcion() - 1;
        if (indice >= 0 && indice < clientes.length) {
            System.out.println("Cliente seleccionado: " + clientes[indice]);
            return clientes[indice];
        }
        System.out.println("Cliente no válido.");
        return null;
    }
    /**
     * Confirma la venta, restando el stock y registrando la compra.
     * @param producto
     * @param cliente
     */
    private static void confirmarVenta(Producto producto, Cliente cliente) {
        if (producto.getStock() > 0) {
            producto.setStock(producto.getStock() - 1);
            cliente.agregarCompra(producto);
            System.out.println("Venta confirmada. Producto añadido al historial de compras del cliente.");
        } else {
            System.out.println("El producto no tiene stock suficiente.");
        }
    }
    /**
     * Aplica un descuento aleatorio a un producto.
     * @param producto
     */
    private static void aplicarDescuentoAleatorio(Producto producto) {
        if (producto == null) {
            System.out.println("Debe seleccionar un producto antes de aplicar un descuento.");
            return;
        }
        double descuento = Math.random() * 0.3; // Hasta un 30% de descuento
        double precioConDescuento = producto.getPrecio() * (1 - descuento);
        System.out.printf("Se aplicó un descuento del %.2f%%. Nuevo precio: %.2f%n", descuento * 100, precioConDescuento);
    }
    /**
     * Muestra el historial de compras de un cliente.
     * @param cliente
     */
    private static void verHistorialCompras(Cliente cliente) {
        System.out.println("\n=== Historial de Compras ===");
        Producto[] historial = cliente.getHistorialCompras();
        for (int i = 0; i < cliente.getNumCompras(); i++) {
            System.out.println(historial[i]);
        }
    }
}
