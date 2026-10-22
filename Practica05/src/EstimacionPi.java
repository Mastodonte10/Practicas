import java.util.Scanner;

public class EstimacionPi 
{

    public static void main(String[] args)
     {
        // Se crea el objeto Scanner para leer los datos que ingrese el usuario desde la consola

        Scanner scanner = new Scanner(System.in);
      // Solicitamos al usuario la cantidad total de dardos que desea simular
        System.out.print("Seleccione el numero de dardos a lanzar: ");
        int dardosTot = scanner.nextInt();
      // Variable para llevar el recuento de los dardos que caen dentro del cuarto de círculo
        int dardosDentro = 0;
        int contador = 0;

        // Ciclo while para lanzar los dardos
        while (contador < dardosTot) {
            double x = Math.random();
            double y = Math.random();

            // Verifica si cayó dentro del cuarto de círculo
            if (x * x + y * y <= 1.0) {
                dardosDentro++;
            }

            contador++; 
            // Actualizamos el contador para evitar ciclo infinito
        }


// Calculamos la aproximación del valor de Pi usando la fórmula de las instrucciones
        double estimacionPi = 4.0 * dardosDentro / dardostot;

        // Mostramos los resultados finales formateados en la terminal
        System.out.println("|======================================|");
        System.out.println("Dardos totales = " + dardosTot);
        System.out.println("Dardos dentro del circulo = " + dardosDentro);
        System.out.printf("Estimacion de Pi: %.6f\n", estimacionPi);
        System.out.println("|======================================|");

        // Cerramos el objeto scanner para liberar los recursos
        scanner.close();
    }
}
