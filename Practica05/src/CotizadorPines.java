import java.util.Scanner;
import java.util.Locale;

public class CotizadorPines {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("|--<<<COTIZADOR DE PRÉSTAMOS DEL SEÑOR PINES>>>--|");

        // Lectura de datos del cliente
        System.out.print("Ingrese el prestamo solicitado ($): ");
        double prestamo = scanner.nextDouble();
        System.out.print("Ingrese el plazo en meses: ");
        int plazoMeses = scanner.nextInt();
        System.out.print("Ingrese la tasa de interes anual base (%): ");
        double tasaBase = scanner.nextDouble();
        System.out.print("Ingrese el tipo de cliente (P = Preferente, E = Estandar, R = Riesgoso): ");
        char tipoCliente = scanner.next().toUpperCase().charAt(0);
        // Actividad 2.1: Validación de datos
    if (prestamo <= 0) {
            System.out.println("\n[ERROR] El monto del prestamo debe ser mayor a cero.");
            scanner.close();
            return;

        } else if (plazoMeses <= 0) {
            System.out.println("\n[ERROR] El plazo en meses debe ser mayor a cero.");
            scanner.close();
            return;
        }
         else if (tasaBase <= 0) {
            System.out.println("\n[ERROR] La tasa de interes debe ser mayor a cero.");
            scanner.close();
            return;
        }
         else if (tipoCliente != 'P' && tipoCliente != 'E' && tipoCliente != 'R') {
            System.out.println("\n[ERROR] Tipo de cliente invalido. Solo se permite P, E o R.");
            scanner.close();
            return;
        }
        // Ajuste de la tasa según el tipo de cliente
        double tasaAplicada = tasaBase;
        if (tipoCliente == 'P') {
            tasaAplicada -= 2.0;
        } 
        else if (tipoCliente == 'R') {
            tasaAplicada += 3.0; 
        }
        // Cálculo del Interés Simple 
        double interesSimple = prestamo * (tasaAplicada / 100.0) * (plazoMeses / 12.0);
        double totalSimple = prestamo + interesSimple;
        

        double tasaMensual = (tasaAplicada / 100.0) / 12.0;
        double saldoAcumulado = prestamo;

        System.out.println("\n--- TABLA DE SALDO MES A MES (INTERÉS COMPUESTO) ---");        for (int mes = 1; mes <= plazoMeses; mes++) {
            saldoAcumulado *= (1.0 + tasaMensual);
            System.out.printf("En el mes %d se tiene un saldo de %.2f\n", mes, saldoAcumulado);
        }


        double totalCompuestoCiclo = saldoAcumulado;
        double interesCompuestoCiclo = totalCompuestoCiclo - prestamo;

        // Cálculo directo del Interés Compuesto
      double totalCompuestoFormula = prestamo * Math.pow(1.0 + tasaMensual, plazoMeses);

        // Despliegue de resultados finales para comparación
        System.out.println("|================ RESUMEN FINAL ================|");
        System.out.printf("Tasa aplicada: %.2f%%\n", tasaAplicada);
        System.out.printf("Prestamo: $%.2f\n", prestamo);
        System.out.printf("Meses de pago: %d\n", plazoMeses);
        System.out.println("_________________________________________________");
        System.out.printf("Interes simple: $%.2f\n", interesSimple);
        System.out.printf("Total con interes simple: $%.2f\n", totalSimple);
        System.out.println("_________________________________________________");
        System.out.printf("Interes compuesto (Ciclo): $%.2f\n", interesCompuestoCiclo);
        System.out.printf("Total con interes compuesto: $%.2f\n", totalCompuestoCiclo);
        System.out.printf("Total con interes compuesto: $%.2f\n", totalCompuestoFormula);
        System.out.println("|===============================================|");

        scanner.close();
    }
}
