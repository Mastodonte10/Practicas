import java.util.Scanner;

public class BinarioInteractivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            int numero = 0;
            boolean entradaValida = false;

            // Validacion de la entrada
            while (!entradaValida) {
                System.out.print("Ingresa un numero entero no negativo: ");
                if (sc.hasNextInt()) {
                    numero = sc.nextInt();
                    if (numero >= 0) {
                        entradaValida = true;
                    } else {
                        System.out.println("Error: El numero no puede ser negativo.");
                    }
                } else {
                    String error = sc.next();
                    System.out.println("Error: '" + error + "' no es un numero entero valido.");
                }
            }

            //conversion de decimal a binario 
            String binario = "";
            int temp = numero;

            if (temp == 0) {
                binario = "0";
            } else {
                while (temp > 0) {
                    int residuo = temp % 2;
                    binario = residuo + binario;
                    temp = temp / 2;
                }
            }

            System.out.println("El numero " + numero + " en binario es: " + binario);

            // Preguntar si desea hacer otra conversion
            System.out.print("\n¿Deseas convertir otro numero? (s/n): ");
            char respuesta = sc.next().charAt(0);

            if (respuesta != 's' && respuesta != 'S') {
                continuar = false;
                System.out.println("¡Hasta luego!");
            }
  
            System.out.println("|___________________________________________________|");
        }

        sc.close();
    }
}