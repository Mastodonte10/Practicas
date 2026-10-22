import java.util.Scanner;

public class PrecisionPi {

    public static void main(String[] args) {
        // Se crea el objeto Scanner para leer la tolerancia desde la consola
        Scanner scanner = new Scanner(System.in);

        // Solicitamos al usuario el margen de error máximo permitido (tolerancia)
        System.out.print("Ingrese la tolerancia deseada (ej. 0.1, 0.01, 0.001): ");
        double tolerancia = scanner.nextDouble();

        long dardosTot = 0;
        long dardosDentro = 0;

// Variables para llevar la estimación actual de Pi 
        double estimacionPi = 0.0;
        double error = Double.MAX_VALUE; 
        while (error >= tolerancia) {
 // Genera las coordenadas del dardo
            double x = Math.random();
            double y = Math.random();

            // Verificamos si cayó dentro del cuarto de círculo
            if (x * x + y * y <= 1.0) {
                dardosDentro++;
            }


            dardosTot++;

            // Recalculamos la estimación de Pi con los dardos acumulados
            estimacionPi = 4.0 * dardosDentro / dardosTot;

            // Calculamos el error absoluto comparando con Math.PI usando Math.abs()
            error = Math.abs(estimacionPi - Math.PI);
        }

        // Mostramos los resultados obtenidos al romper la condición del ciclo
        System.out.println("|======================================|");
        System.out.println("Tolerancia objetivo: " + tolerancia);
        System.out.println("Dardos necesarios: " + dardosTot);
        System.out.println("Dardos dentro del circulo: " + dardosDentro);
        System.out.printf("Estimacion final de Pi: %.6f\n", estimacionPi);
        System.out.printf("Error final alcanzado: %.6f\n", error);
        System.out.println("|======================================|");
        scanner.close();
    }
}