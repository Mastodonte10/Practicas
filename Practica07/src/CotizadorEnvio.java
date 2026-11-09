
public class CotizadorEnvio {

    private static final double CUOTA_BASE = 120.0;

    private static final double LIMITE_TRAMO_1 = 5.0;

    private static final double LIMITE_TRAMO_2 = 15.0;

    private static final double COSTO_KG_TRAMO_2 = 18.0;

    private static final double CUOTA_TRAMO_3 = 300.0;


    private static final double COSTO_KG_TRAMO_3 = 25.0;

    private static final double VALOR_SEGURO = 3000.0;

    private static final double ARISTA_MAXIMA = 60.0;

    private static final double SUMA_MAXIMA = 150.0;

    /**
     * Evalua si una referencia recibida corresponde a un paquete valido para operar.
     *
     */
    public static boolean esPaqueteValido(Paquete p) {
        // La comprobacion de null va primero: si p es null, consultar sus propiedades
        // provocaria un NullPointerException (&& evita evaluar lo demas).
        return p != null
                && p.getPesoKg() > 0
                && p.getAlto() > 0
                && p.getAncho() > 0
                && p.getLargo() > 0;
    }

    public static double cotizarEnvio(Paquete p) {
        if (!esPaqueteValido(p)) {
            return -1.0; // codigo de error
        }
        double pesoCobrable = p.obtenerPesoCobrable();
        if (pesoCobrable <= LIMITE_TRAMO_1) {
            return CUOTA_BASE;
        } else if (pesoCobrable <= LIMITE_TRAMO_2) {
            return CUOTA_BASE + COSTO_KG_TRAMO_2 * (pesoCobrable - LIMITE_TRAMO_1);
        } else {
            return CUOTA_TRAMO_3 + COSTO_KG_TRAMO_3 * (pesoCobrable - LIMITE_TRAMO_2);
        }
    }

   
    public static boolean requiereSeguro(Paquete p) {
        if (!esPaqueteValido(p)) {
            return false;
        }
        boolean valorAlto = p.getValorDeclarado() > VALOR_SEGURO;
        boolean aristaLarga = p.getAlto() > ARISTA_MAXIMA
                || p.getAncho() > ARISTA_MAXIMA
                || p.getLargo() > ARISTA_MAXIMA;
        boolean sumaExcedida = (p.getAlto() + p.getAncho() + p.getLargo()) > SUMA_MAXIMA;
        return valorAlto || aristaLarga || sumaExcedida;
    }
}
