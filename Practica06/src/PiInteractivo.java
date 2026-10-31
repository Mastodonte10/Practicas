import java.util.Scanner;

public class PiInteractivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dardos = 0;
        // Validara si es posible la entrada
        boolean entradaCorrecta = false;

        // Si no es falsa continua
        while (!entradaCorrecta) {
            System.out.print("Ingrese el numero de dardos a lanzar: ");
            if (sc.hasNextInt()) {
                dardos = sc.nextInt();
                if (dardos > 0) {
                    entradaCorrecta = true;
                } else {
                    System.out.println("Error: El numero de dardos debe ser mayor a 0.");
                }
            } else {
                String error = sc.next();
                System.out.println("Error: '" + error + "' no es un numero entero valido.");
            }
        }

        // Ejecuta lo del codigo pasado
        int dentroDelCirculo = 0;

        for (int i = 0; i < dardos; i = i + 1) {
            double x = Math.random();
            double y = Math.random();

            if (x * x + y * y <= 1.0) {
                dentroDelCirculo = dentroDelCirculo + 1;
            }
        }

        double estimacionPi = 4.0 * dentroDelCirculo / dardos;
        System.out.println("_____________________________________________");
        System.out.println("\n--- Resultados ---");
        System.out.println("Dardos lanzados: " + dardos);
        System.out.println("Dardos dentro del circulo: " + dentroDelCirculo);
        System.out.printf("Estimacion de PI: %.6f%n", estimacionPi);
        System.out.println("_____________________________________________");
        sc.close();
    }
}