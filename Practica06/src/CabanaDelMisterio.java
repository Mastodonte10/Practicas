
import java.util.Scanner;

public class CabanaDelMisterio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ---------- REGISTRO ----------
        System.out.println("|<<<<Sistema de prestamos de la Cabana del Misterio>>>>>|");
        
        // 1. Nombre (primer dato para evitar bronca con nextLine)
        String nombre = "";
        while (true) {
            System.out.print("Nombre completo del cliente: ");
            nombre = sc.nextLine().trim();
            if (!nombre.isEmpty()) {
                break;
            } else {
                System.out.println("Error: El nombre no puede estar vacio.");
            }
        }

        // 2. Tipo de cliente P,E,R
        char tipoChar = ' ';
        String tipoNombre = "";
        while (true) {
            System.out.print("Tipo de cliente (P - Preferido, E - Estandar, R - Riesgoso): ");
            String entrada = sc.nextLine().trim().toUpperCase();
            if (entrada.length() == 1) {
                char c = entrada.charAt(0);
                if (c == 'P' || c == 'E' || c == 'R') {
                    tipoChar = c;
                    if (c == 'P') tipoNombre = "Preferido";
                    else if (c == 'E') tipoNombre = "Estandar";
                    else tipoNombre = "Riesgoso";
                    break;
                }
            }
            System.out.println("Error: El cliente no es valido. Debe ser P, E o R.");
        }

        // 3. Capital de prestamo
        double capital = 0;
        while (true) {
            System.out.print("Capital del prestamo: ");
            if (!sc.hasNextDouble()) {
                String mal = sc.next();
                System.out.println("Error: El capital debe ser un numero. Usted escribio: " + mal);
                continue;
            }
            capital = sc.nextDouble();
            sc.nextLine(); // limpiar
            if (capital < 0) {
                System.out.println("Error: El capital debe ser mayor que cero.");
            } else {
                break;
            }
        }

        // 4. Tasa anual base
        double tasaBase = 0;
        while (true) {
            System.out.print("Tasa anual base (%): ");
            if (!sc.hasNextDouble()) {
                String mal = sc.next();
                System.out.println("Error: La tasa debe ser un numero. Usted escribio: " + mal);
                continue;
            }
            tasaBase = sc.nextDouble();
            sc.nextLine();
            if (tasaBase < 0) {
                System.out.println("Error: La tasa no puede ser negativa.");
            } else {
                break;
            }
        }

        // 5. Plazo en meses
        int plazo = 0;
        while (true) {
            System.out.print("Plazo en meses: ");
            if (!sc.hasNextInt()) {
                if (sc.hasNextDouble()) {
                    double dec = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Error: El plazo debe ser un numero entero, no decimal. Usted escribio: " + dec);
                } else {
                    String mal = sc.next();
                    System.out.println("Error: El plazo debe ser un numero entero. Usted escribio: " + mal);
                }
                continue;
            }
            plazo = sc.nextInt();
            sc.nextLine();
            if (plazo <= 0) {
                System.out.println("Error: El plazo debe ser mayor que cero.");
            } else {
                break;
            }
        }

        //Menu de opciones
        int operaciones = 0;
        int errores = 0;
        String motivoFin = "";
        boolean salir = false;

        while (!salir && operaciones < 5 && errores < 3) {
            System.out.println("|-------------------------------------------------|");
            System.out.println("|---------Las operaciones disponibles son---------|");
            System.out.println(" 1) Cotizar con interes simple.");
            System.out.println(" 2) Cotizar con interes compuesto.");
            System.out.println(" 3) Comparar interes simple y compuesto.");
            System.out.println(" 4) Cambiar el capital del prestamo.");
            System.out.println(" 0) Salir.");
            System.out.print("> Por favor, elige una opcion: ");
            System.out.println("|-------------------------------------------------|");
            int opcion;
            if (!sc.hasNextInt()) {
                String mal = sc.next();
                errores++;
                System.out.println("Error: Opcion no valida '" + mal + "'. Debe ser un numero entre 0 y 4. Errores: " + errores + "/3");
                if (errores >= 3) {
                    motivoFin = "Limite de 3 errores en el menu alcanzado";
                    break;
                }
                continue;
            }
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion < 0 || opcion > 4) {
                errores++;
                System.out.println("Error: Opcion " + opcion + " no existe. Elige entre 0 y 4. Errores: " + errores + "/3");
                if (errores >= 3) {
                    motivoFin = "Limite de 3 errores en el menu alcanzado";
                    break;
                }
                continue;
            }

            if (opcion == 0) {
                motivoFin = "El usuario eligio salir (opcion 0)";
                salir = true;
                break;
            }

            // Ajuste de tasa segun cliente (Estandar no cambia, para que cuadre con Robbie)
            double tasaAjustada = tasaBase;
            if (tipoChar == 'P') {
                tasaAjustada = tasaBase - 2.0; // Premium: -2%
                if (tasaAjustada < 0) tasaAjustada = 0;
            } else if (tipoChar == 'R') {
                tasaAjustada = tasaBase + 4.0; // Riesgoso: +4%
            }

            // Calculos base
            double tasaMensual = tasaAjustada / 12.0 / 100.0;
            double interesSimple = capital * (tasaAjustada / 100.0) * (plazo / 12.0);
            double totalSimple = capital + interesSimple;

            // Compuesto
            double montoCompuesto = capital;
            // Guardamos para imprimir mes por mes solo si se pide opcion 2
            // Calculo final
            double totalCompuestoFinal = capital * Math.pow(1 + tasaMensual, plazo);
            double interesCompuesto = totalCompuestoFinal - capital;

            if (opcion == 1) {
                System.out.println("\n### Opcion 1 : Cotizacion de interes simple ###");
                System.out.printf("- Nombre : %s\n", nombre);
                System.out.printf("- Tipo de cliente : %s (%c)\n", tipoNombre, tipoChar);
                System.out.printf("- Capital del prestamo : %.2f\n", capital);
                System.out.printf("- Tasa anual base : %.2f (ajustada: %.2f)\n", tasaBase, tasaAjustada);
                System.out.printf("- Plazo en meses : %d\n", plazo);
                System.out.printf("> Interes simple = %.2f\n", interesSimple);
                System.out.printf("> Total a pagar = %.2f\n", totalSimple);
                operaciones++;

            } else if (opcion == 2) {
                System.out.println("\n### Opcion 2 : Cotizacion de interes compuesto ###");
                System.out.printf("- Nombre : %s\n", nombre);
                System.out.printf("- Tipo de cliente : %s (%c)\n", tipoNombre, tipoChar);
                System.out.printf("- Capital del prestamo : %.2f\n", capital);
                System.out.printf("- Tasa anual : %.2f (ajustada: %.2f)\n", tasaBase, tasaAjustada);
                System.out.printf("- Plazo en meses : %d\n", plazo);
                double temp = capital;
                for (int mes = 1; mes <= plazo; mes++) {
                    temp = temp * (1 + tasaMensual);
                    System.out.printf("> Mes %d = %.2f\n", mes, temp);
                }
                System.out.printf("> Interes compuesto = %.2f\n", interesCompuesto);
                System.out.printf("> Total a pagar = %.2f\n", totalCompuestoFinal);
                operaciones++;

            } else if (opcion == 3) {
                System.out.println("\n### Opcion 3 : Comparacion de intereses ###");
                System.out.printf("> Interes simple = %.2f\n", interesSimple);
                System.out.printf("> Interes compuesto = %.2f\n", interesCompuesto);
                double diff = Math.abs(interesCompuesto - interesSimple);
                System.out.printf("> La diferencia entre ellos es de %.2f\n", diff);
                if (interesCompuesto > interesSimple) {
                    System.out.println("> El interes compuesto es mayor.");
                } else if (interesSimple > interesCompuesto) {
                    System.out.println("> El interes simple es mayor.");
                } else {
                    System.out.println("> Ambos intereses son iguales.");
                }
                operaciones++;

            } else if (opcion == 4) {
                double nuevoCapital = 0;
                while (true) {
                    System.out.print("Nuevo capital del prestamo: ");
                    if (!sc.hasNextDouble()) {
                        String mal = sc.next();
                        System.out.println("Error: El capital debe ser un numero. Usted escribio: " + mal);
                        continue;
                    }
                    nuevoCapital = sc.nextDouble();
                    sc.nextLine();
                    if (nuevoCapital <= 0) {
                        System.out.println("Error: El capital debe ser mayor que cero.");
                    } else {
                        break;
                    }
                }
                capital = nuevoCapital;
                System.out.printf("Capital actualizado a %.2f. A partir de ahora todas las cotizaciones usaran este valor.\n", capital);
                operaciones++;
            }

            if (operaciones >= 5) {
                motivoFin = "Limite de 5 operaciones efectivas alcanzado";
                System.out.println("\nSe alcanzo el limite de 5 operaciones efectivas.");
            }
        }

        // ---------- RESUMEN ----------
        System.out.println("|========== RESUMEN FINAL ==========|");
        System.out.printf("Cliente: %s\n", nombre);
        System.out.printf("Numero de operaciones efectivas: %d\n", operaciones);
        System.out.printf("Numero de errores en el menu: %d\n", errores);
        System.out.printf("Capital con el que termino el prestamo: %.2f\n", capital);
        System.out.printf("Motivo de terminacion: %s\n", motivoFin.isEmpty() ? "Desconocido" : motivoFin);
        System.out.println("Gracias por usar el sistema de la Cabana del Misterio. ¡Hasta luego!");
        System.out.println("|===================================|");
        sc.close();
    }
}
