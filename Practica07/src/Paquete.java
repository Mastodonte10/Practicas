
public class Paquete {

    // Constantes
    private static final String CODIGO_DEFECTO = "SIN-CODIGO";

    private static final double PESO_DEFECTO = 1.0;

    private static final double DIMENSION_DEFECTO = 1.0;

    private static final double VALOR_DEFECTO = 0.0;

    private static final double FACTOR_VOLUMETRICO = 5000.0;

    private static final double TASA_RECARGO_EXPRES = 0.30;

    // *** ATRIBUTOS ***

    private String codigoRastreo;

    private double pesoKg;

    private double alto;

    private double ancho;

    private double largo;

    private double valorDeclarado;

    private boolean esExpres;

    // *** CONSTRUCTORES ***

    /**
     * Constructor por defecto. Crea un paquete con valores predeterminados validos:
     * codigo "SIN-CODIGO", 1.0 kg, dimensiones de 1.0 cm por lado, valor declarado
     * de $0.00 y envio no express.
     */
    public Paquete() {
        this.codigoRastreo = CODIGO_DEFECTO;
        this.pesoKg = PESO_DEFECTO;
        this.alto = DIMENSION_DEFECTO;
        this.ancho = DIMENSION_DEFECTO;
        this.largo = DIMENSION_DEFECTO;
        this.valorDeclarado = VALOR_DEFECTO;
        this.esExpres = false;
    }

    /**
     * Constructor con parametros. Valida cada dato recibido; si alguno no es valido
     * (codigo nulo o vacio, peso o dimensiones menores o iguales a cero, o valor
     * declarado negativo), ese atributo conserva su valor por defecto. El envio
     * se crea como no express.
     */
    public Paquete(String codigoRastreo, double pesoKg, double alto, double ancho,
                   double largo, double valorDeclarado) {
        this(); // parte de los valores por defecto, que se reemplazan solo si el dato es valido
        setCodigoRastreo(codigoRastreo);
        setPesoKg(pesoKg);
        setAlto(alto);
        setAncho(ancho);
        setLargo(largo);
        setValorDeclarado(valorDeclarado);
    }

    // *** METODOS DE ACCESO Y ASIGNACION ***

    /**
     * Consulta el codigo de rastreo.
     *
     * @return El codigo de rastreo del paquete.
     */
    public String getCodigoRastreo() {
        return codigoRastreo;
    }

    /**
     * Modifica el codigo de rastreo. Si es nulo o vacio, se conserva el valor actual. */
    public void setCodigoRastreo(String codigoRastreo) {
        if (codigoRastreo != null && !codigoRastreo.trim().isEmpty()) {
            this.codigoRastreo = codigoRastreo;
        }
    }

    /**
     * Consulta el peso fisico.
     *
     */
    public double getPesoKg() {
        return pesoKg;
    }

    /**
     * Modifica el peso fisico. Si no es mayor que 0, se conserva el valor actual.
     */
    public void setPesoKg(double pesoKg) {
        if (pesoKg > 0) {
            this.pesoKg = pesoKg;
        }
    }

    /**
     * Consulta el alto.
     */
    public double getAlto() {
        return alto;
    }

    /**
     * Modifica el alto. Si no es mayor que 0, se conserva el valor actual.
     */
    public void setAlto(double alto) {
        if (alto > 0) {
            this.alto = alto;
        }
    }

    //Consulta el ancho.
    public double getAncho() {
        return ancho;
    }

     //* Modifica el ancho. Si no es mayor que 0, se conserva el valor actual.
    public void setAncho(double ancho) {
        if (ancho > 0) {
            this.ancho = ancho;
        }
    }

    //Consulta el largo.
    public double getLargo() {
        return largo;
    }

    //Modifica el largo. Si no es mayor que 0, se conserva el valor actual
    public void setLargo(double largo) {
        if (largo > 0) {
            this.largo = largo;
        }
    }


    public double getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(double valorDeclarado) {
        if (valorDeclarado >= 0) {
            this.valorDeclarado = valorDeclarado;
        }
    }

    /**
     * Consulta si el envio es express.
     *
     */
    public boolean isEsExpres() {
        return esExpres;
    }

    /**
     * Indica si el envio es express.
     *
     * @param esExpres true para marcar el envio como express.
     */
    public void setEsExpres(boolean esExpres) {
        this.esExpres = esExpres;
    }

    // *** METODOS CALCULADORES BASE ***

    
    public double calculaPesoVolumetrico() {
        return (largo * ancho * alto) / FACTOR_VOLUMETRICO;
    }


    public double obtenerPesoCobrable() {
        return Math.max(pesoKg, calculaPesoVolumetrico());
    }

    // *** PROPUESTA PERSONAL ***

    public double calculaRecargoExpres(double importeBase) {
        if (esExpres && importeBase > 0) {
            return importeBase * TASA_RECARGO_EXPRES;
        }
        return 0.0;
    }
}
