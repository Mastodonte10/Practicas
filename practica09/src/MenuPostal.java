import java.util.Scanner;

/**
 * Programa interactivo por consola para gestionar guias de envio (Parte 4).
 * 
 * @author Diego Emiliano Sánchez Chávez. 324134195. , Luis Angel Lopez Perez. 324243174.
 * @version 2.0
 */
public class MenuPostal {

    /**
     * Ciclo principal del menu interactivo.
     * 
     * @param args Argumentos de linea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Envio guiaActiva = null;
        boolean continuar = true;

        System.out.println("================================================================");
        System.out.println("  SISTEMA INTERACTIVO DE GUIAS POSTALES | ICC 2027-1");
        System.out.println("================================================================");

        while (continuar) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Emitir nueva guia de envio");
            System.out.println("2. Clonar guia activa con un nuevo paquete (mismo remitente y destinatario)");
            System.out.println("3. Clonar paquete de la guia activa para enviarlo a otro destinatario");
            System.out.println("4. Generar guia de retorno (devolucion al remitente)");
            System.out.println("5. Mostrar detalle y costo de la guia activa");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            String opcion = sc.nextLine().trim();

          switch (opcion) {
                case "1":
                    guiaActiva = emitirNuevaGuia(sc);
                    break;

                case "2":
                    guiaActiva = clonarGuiaActiva(sc, guiaActiva);
                    break;

                case "3":
                    guiaActiva = enviarPaqueteClonado(sc, guiaActiva);
                    break;

                case "4":
                    guiaActiva = procesarRetorno(guiaActiva);
                    break;

                case "5":
                    mostrarGuiaActiva(guiaActiva);
                    break;

                case "0":
                    continuar = false;
                    System.out.println("Saliendo del sistema postal...");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
                    break;
            }
    }
    } //deja lo hago xddd
//va
    /**
     * Metodo auxiliar que solicita al usuario por consola
     * los datos de un paquete y devuelve la instancia creada.
     * 
     * @param sc Lector de entrada estandar.
     * @return Nuevo objeto Paquete con los datos capturados.
     */
    private static Paquete capturarPaquete(Scanner sc) {
        System.out.println("\n--- Captura de datos del Paquete ---");
        System.out.print("  Codigo de rastreo (ej. PKG-500): ");
        String codigo = sc.nextLine().trim();

        System.out.print("  Peso fisico en kg (ej. 3.5): ");
        double peso = leerDouble(sc, 1.0);

        System.out.print("  Alto en cm (ej. 20): ");
        double alto = leerDouble(sc, 10.0);

        System.out.print("  Ancho en cm (ej. 20): ");
        double ancho = leerDouble(sc, 10.0);

        System.out.print("  Largo en cm (ej. 30): ");
        double largo = leerDouble(sc, 10.0);

        System.out.print("  Valor declarado en MXN (ej. 800): ");
        double valor = leerDouble(sc, 100.0);

        System.out.print("  ¿Es envio express? (s/n): ");
        boolean express = sc.nextLine().trim().equalsIgnoreCase("s");

        return new Paquete(codigo, peso, alto, ancho, largo, valor, express);
    }

    /**
     * Lee un numero decimal validando con hasNextDouble() y limpiando el salto de linea
     * del buffer de entrada sin utilizar manejo de excepciones.
     * 
     * @param sc Lector de entrada estandar.
     * @param valorPorOmision Valor a regresar si el usuario no ingresa un numero valido.
     * @return El numero leido, o valorPorOmision si la entrada no fue numerica.
     */
    private static double leerDouble(Scanner sc, double valorPorOmision) {
        if (sc.hasNextDouble()) {
            double valor = sc.nextDouble();
            sc.nextLine(); // Limpia el salto de linea pendiente en el buffer
            return valor;
        }
        sc.nextLine(); // Descarta la entrada no numerica
        return valorPorOmision;
    }

    /**
     * Solicita por consola los datos de una Persona de acuerdo con los atributos
     * que disenaste en Persona.java y devuelve el objeto instanciado.
     * 
     * @param sc Lector de entrada estandar.
     * @return Nueva instancia de Persona con los datos capturados.
     */
        // POR HACER (Parte 4):
        // Pide al usuario por consola los atributos que definiste en tu clase Persona
        // (por ejemplo: identificador corto, nombre completo y ciudad/ubicacion)
        // y devuelve la instancia creada.
        private static Persona capturarPersona(Scanner sc) {
        System.out.print("  Identificador corto (ej. PER-01): ");
        String id = sc.nextLine().trim();

        System.out.print("  Nombre completo: ");
        String nombre = sc.nextLine().trim();

        System.out.print("  Ciudad / Ubicacion: ");
        String ciudad = sc.nextLine().trim();

        return new Persona(id, nombre, ciudad);
    }

    private static Envio clonarGuiaActiva(Scanner sc, Envio guiaActiva) {
        if (guiaActiva == null) {
            System.out.println("Aviso: Primero debes emitir una guia (Opcion 1).");
            return null;
        }
        System.out.println("\n--- Clonar guia activa con nuevo paquete ---");
        Paquete nuevoPaquete = capturarPaquete(sc);
        Envio guiaClonada = new Envio(guiaActiva, nuevoPaquete);
        System.out.println("\nGuia clonada con exito:\n" + guiaClonada);
        return guiaClonada;
    }

    private static Envio enviarPaqueteClonado(Scanner sc, Envio guiaActiva) {
        if (guiaActiva == null) {
            System.out.println("Aviso: Primero debes emitir una guia (Opcion 1).");
            return null;
        }
        System.out.println("\n--- Clonar paquete hacia otro destinatario ---");
        System.out.print("  Nuevo codigo de rastreo para el paquete clonado: ");
        String nuevoCodigo = sc.nextLine().trim();

        Paquete paqueteClonado = new Paquete(guiaActiva.getPaquete());
        paqueteClonado.setCodigoRastreo(nuevoCodigo);

        System.out.println("\n--- Datos del NUEVO DESTINATARIO ---");
        Persona nuevoDestinatario = capturarPersona(sc);

        Envio nuevoEnvio = new Envio(guiaActiva.getRemitente(), nuevoDestinatario, paqueteClonado);
        System.out.println("\nGuia con paquete clonado emitida con exito:\n" + nuevoEnvio);
        return nuevoEnvio;
    }

    private static Envio procesarRetorno(Envio guiaActiva) {
        if (guiaActiva == null) {
            System.out.println("Aviso: Primero debes emitir una guia (Opcion 1).");
            return null;
        }
        Envio guiaRetorno = guiaActiva.generarGuiaRetorno();
        System.out.println("\nGuia de retorno generada con exito:\n" + guiaRetorno);
        return guiaRetorno;
    }

    /**
     * Opcion 1 (REFERENCIA IMPLEMENTADA): Captura remitente, destinatario
     * y paquete para emitir y mostrar una nueva guia de envio.
     * 
     * @param sc Lector de entrada estandar.
     * @return La nueva guia de envio creada.
     */
    private static Envio emitirNuevaGuia(Scanner sc) {
        System.out.println("\n--- Captura de datos del REMITENTE ---");
        Persona remitente = capturarPersona(sc);

        System.out.println("\n--- Captura de datos del DESTINATARIO ---");
        Persona destinatario = capturarPersona(sc);

        Paquete paquete = capturarPaquete(sc);
        Envio nuevaGuia = new Envio(remitente, destinatario, paquete);
        System.out.println("\nGuia emitida con exito:\n" + nuevaGuia);
        return nuevaGuia;
    }

     private static void mostrarGuiaActiva(Envio guiaActiva){
    if (guiaActiva == null) {
        System.out.println("No hay ninguna guia activa");
        return;
    }
    System.out.println("/n ->>Detalles de la guia<<-");
    System.out.println(guiaActiva);
    }
}
    // Declara e implementa aqui tus propios metodos auxiliares (private static)
    // para resolver las opciones 2, 3, 4 y 5 del menu (validando cuando guiaActiva == null).

