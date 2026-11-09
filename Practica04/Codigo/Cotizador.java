public class Cotizador {
    public static void main(String[]args) {
        // Usamos un string para poner los datos de Robbie
        String cliente = "Robbie Valentino";
        // E para cliente estandar
        char Cliente = 'E';
         // Precio de la laptop en pesos 
        double precio = 12899.0;
        // Interes anual del 15%
        double tasanual = 15.0;
        // Plazo en meses 
        int plzoalMes = 21;

// Conversion de meses a anios para la formula de interes simple
        double tiempo = plzoalMes / 12.0;
        
// Para el interes
        double interes = precio * (tasanual / 100.0) * tiempo;

// Calculo del total y la mensualidad
        double cstfinal = precio + interes;
        double mensualidad = cstfinal / plzoalMes; 

// Ahora le ponemos el encabezado
        System.out.println("|--->>> COTIZADOR DE LA CABAÑA DEL MISTERIO <<<---|");

// Imprime el nombre (%s) y la clasificacion (%c) del cliente
System.out.printf("Nombre: %s | Tipo: %c%n", cliente, Cliente);
        
// Imprime el valor prestado formateado como moneda con 2 decimales (%.2f)
System.out.printf("Precio original: $%.2f%n", precio);
        
// Imprime el plazo en meses (%d), equivalencia en anios (%.2f) y el porcentaje de interes (%.1f%%) segun las equivalencias de la tabla
System.out.printf("Plazo: %d meses (%.2f anios) al %.1f%% de interes anual%n", plzoalMes, tiempo, tasanual);

// Separador visual decorativo
        System.out.println("=======================================");
        
// Imprime el monto final de intereses cobrados con 2 decimales (%.2f)
System.out.printf("Intereses generados: $%.2f%n", interes);
        
// Imprime la suma total que pagara el cliente redondeada a 2 decimales (%.2f)
System.out.printf("Costo final total: $%.2f%n", cstfinal);
        
// Imprime la cuota mensual a pagar redondeada limpiamente a 2 decimales (%.2f)
System.out.printf("Pago mensual: $%.2f%n", mensualidad);
        
// Cierre decorativo al final 
System.out.println("=======================================");

}}