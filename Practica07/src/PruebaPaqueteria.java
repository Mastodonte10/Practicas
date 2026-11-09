/**
 * Programa de prueba para verificar el correcto funcionamiento de las clases
 */
public class PruebaPaqueteria {

    /**
     * Metodo principal: ejecuta los casos de prueba y muestra los resultados en consola.
     */
    public static void main(String[] args) {
        System.out.println("|======================================================|");
        System.out.println("| PRUEBAS DEL SISTEMA DE ENVIOS POSTALES               |");             
        System.out.println("|======================================================|\n");

        // CASO 1: Paquete estandar pequeno (peso fisico domina)
        // Datos requeridos: codigo "PK-001", peso 3.5 kg, dimensiones 20x15x10 cm,
        // valor declarado $800.0 pesos.
        System.out.println("--- Caso 1: Paquete pequeno estandar ---");
        Paquete p1 = new Paquete("PK-001", 3.5, 20.0, 15.0, 10.0, 800.0);
        mostrarDetallePaquete(p1);
        System.out.println("Es valido?: " + CotizadorEnvio.esPaqueteValido(p1));
        System.out.printf("Costo de envio cotizado: $%.2f (Esperado: $120.00)\n", CotizadorEnvio.cotizarEnvio(p1));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p1));
        System.out.println();

        // CASO 2: Paquete liviano pero voluminoso (peso volumetrico domina)
        // Datos requeridos: codigo "PK-002", peso 2.0 kg, dimensiones 50x40x50 cm,
        // valor declarado $1500.0 pesos.
        System.out.println("--- Caso 2: Paquete voluminoso (volumen predomina) ---");
        Paquete p2 = new Paquete("PK-002", 2.0, 50.0, 40.0, 50.0, 1500.0);
        mostrarDetallePaquete(p2);
        if (CotizadorEnvio.esPaqueteValido(p2)) {
            System.out.printf("Peso volumetrico calculado: %.2f kg\n", p2.calculaPesoVolumetrico());
            System.out.printf("Peso cobrable final: %.2f kg\n", p2.obtenerPesoCobrable());
        }
        System.out.printf("Costo de envio cotizado: $%.2f (Esperado: $425.00)\n", CotizadorEnvio.cotizarEnvio(p2));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p2));
        System.out.println();

        // CASO 3: Paquete de alto valor comercial (requiere seguro por monto)
        // Datos requeridos: codigo "PK-003", peso 4.0 kg, dimensiones 30x25x20 cm,
        // valor declarado $6500.0 pesos.
        System.out.println("--- Caso 3: Paquete de alto valor monetario ---");
        Paquete p3 = new Paquete("PK-003", 4.0, 30.0, 25.0, 20.0, 6500.0);
        mostrarDetallePaquete(p3);
        System.out.printf("Costo de envio: $%.2f\n", CotizadorEnvio.cotizarEnvio(p3));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p3) + " (Esperado: true)");
        System.out.println();

        // CASO 4: Paquete sobredimensionado (arista > 60 cm o suma > 150 cm)
        // Datos requeridos: codigo "PK-004", peso 5.0 kg, dimensiones 70x30x20 cm,
        // valor declarado $1200.0 pesos.
        System.out.println("--- Caso 4: Paquete sobredimensionado ---");
        Paquete p4 = new Paquete("PK-004", 5.0, 70.0, 30.0, 20.0, 1200.0);
        mostrarDetallePaquete(p4);
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p4) + " (Esperado: true por dimensiones)");
        System.out.println();

        // CASO 5: Validacion de referencia nula (null)
        System.out.println("--- Caso 5: Validacion de referencia nula (null) ---");
        Paquete pNulo = null;
        System.out.println("Es valido un paquete null?: " + CotizadorEnvio.esPaqueteValido(pNulo) + " (Esperado: false)");
        System.out.printf("Cotizacion de un paquete null: $%.2f (Esperado: -1.00)\n", CotizadorEnvio.cotizarEnvio(pNulo));
        System.out.println("Requiere seguro un paquete null?: " + CotizadorEnvio.requiereSeguro(pNulo) + " (Esperado: false)");
        System.out.println();

        // CASO 6: PRUEBAS DE MI METODO PERSONAL
        System.out.println("|======================================================|");
        System.out.println("|        PRUEBAS DE LA PROPUESTA PERSONAL             | ");
        System.out.println("|======================================================|");

        // Prueba 1: paquete express. 4 kg, 40x30x50 cm -> peso volumetrico 12 kg,
        // cobrable 12 kg --> importe base $246.00 -> recargo esperado 246 * 0.30 = $73.80
        System.out.println("--- Prueba 1: Paquete express con importe base normal ---");
        Paquete pExpres = new Paquete("PK-EXP-01", 4.0, 40.0, 30.0, 50.0, 2500.0);
        pExpres.setEsExpres(true);
        double baseExpres = CotizadorEnvio.cotizarEnvio(pExpres);
        double recargo1 = pExpres.calculaRecargoExpres(baseExpres);
        System.out.printf("Importe base: $%.2f | Recargo express: $%.2f (Esperado: $73.80) | Total: $%.2f (Esperado: $319.80)\n",
                baseExpres, recargo1, baseExpres + recargo1);
        System.out.println();

        // Prueba 2: mismo paquete SIN express -> sin recargo
        System.out.println("--- Prueba 2: Mismo paquete sin express ---");
        Paquete pNormal = new Paquete("PK-EXP-02", 4.0, 40.0, 30.0, 50.0, 2500.0);
        double baseNormal = CotizadorEnvio.cotizarEnvio(pNormal);
        System.out.printf("Es express?: %b | Recargo: $%.2f (Esperado: $0.00)\n",
                pNormal.isEsExpres(), pNormal.calculaRecargoExpres(baseNormal));
        System.out.println();

        // Prueba 3: paquete por defecto -> esExpres es false por defecto
        System.out.println("--- Prueba 3: Paquete creado con el constructor por defecto ---");
        Paquete pDefecto = new Paquete();
        double baseDefecto = CotizadorEnvio.cotizarEnvio(pDefecto);
        System.out.printf("Es express?: %b | Importe base: $%.2f | Recargo: $%.2f (Esperado: $0.00)\n",
                pDefecto.isEsExpres(), baseDefecto, pDefecto.calculaRecargoExpres(baseDefecto));
        System.out.println();

        // Prueba 4: el setter cambia el comportamiento del objeto
        System.out.println("--- Prueba 4: El paquete de la Prueba 2 tras setEsExpres(true) ---");
        pNormal.setEsExpres(true);
        System.out.printf("Es express?: %b | Recargo: $%.2f (Esperado: $73.80)\n",
                pNormal.isEsExpres(), pNormal.calculaRecargoExpres(baseNormal));
        System.out.println();

        // Prueba 5: caso limite, importe base no valido (negativo) -> sin recargo
        System.out.println("--- Prueba 5: Caso limite con importe base negativo ---");
        System.out.printf("Recargo con importe base -50.00: $%.2f (Esperado: $0.00)\n",
                pExpres.calculaRecargoExpres(-50.0));
        System.out.println();
    }

    /**
     * Metodo auxiliar para imprimir en consola los datos basicos de un paquete.
     * Utiliza los metodos de acceso (getters) implementados en la clase Paquete.
     */
    private static void mostrarDetallePaquete(Paquete p) {
        if (!CotizadorEnvio.esPaqueteValido(p)) {
            System.out.println("  [Paquete no valido o no instanciado]");
            return;
        }
        System.out.println("  Codigo de rastreo: " + p.getCodigoRastreo());
        System.out.printf("  Peso fisico: %.2f kg\n", p.getPesoKg());
        System.out.printf("  Dimensiones (alto x ancho x largo): %.1f x %.1f x %.1f cm\n",
                p.getAlto(), p.getAncho(), p.getLargo());
        System.out.printf("  Valor declarado: $%.2f\n", p.getValorDeclarado());
    }
}
