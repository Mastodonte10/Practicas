/**
 * Modela la entidad de un paquete para la empresa de envios postales y paqueteria.
 * Encapsula la informacion fisica (peso, dimensiones espaciales), codigo de rastreo
 * y valor monetario declarado. Provee metodos para determinar el peso
 * volumetrico, peso cobrable, constructor por copia y representacion
 * textual (toString).
 * 
 * @author Diego Emiliano Sánchez Chávez, Luis Angel Lopez Perez. 324243174.
 * @version 2.0
 */
public class Paquete {

    // ATRIBUTOS

    /** Codigo alfanumerico unico que identifica al paquete en el almacen. */
    private String codigoRastreo;

    /** Peso fisico real de la mercancia en kilogramos. */
    private double peso;

    /** Altura del paquete en centimetros. */
    private double alto;

    /** Anchura del paquete en centimetros. */
    private double ancho;

    /** Longitud o largo del paquete en centimetros. */
    private double largo;

    /** Valor comercial declarado del contenido en moneda nacional (MXN). */
    private double valorDeclarado;

    /** Indica si el cliente solicito entrega prioritaria urgente / express. */
    private boolean envioExpress;


    // =========================================================================
    // CONSTRUCTORES
    // =========================================================================

    /**
     * Crea un paquete estandar con dimensiones y valores minimos predeterminados.
     */
    public Paquete() {
        this.codigoRastreo = "ND-000";
        this.peso = 1.0;
        this.alto = 10.0;
        this.ancho = 10.0;
        this.largo = 10.0;
        this.valorDeclarado = 100.0;
        this.envioExpress = false;
    }

    /**
     * Crear un paquete con los parametros especificados
     * 
     * @param codigoRastreo Codigo unico de rastreo.
     * @param peso Peso fisico en kilogramos (debe ser mayor a 0).
     * @param alto Altura en centimetros (debe ser mayor a 0).
     * @param ancho Anchura en centimetros (debe ser mayor a 0).
     * @param largo Longitud en centimetros (debe ser mayor a 0).
     * @param valorDeclarado Valor monetario declarado (mayor o igual a 0).
     */
    public Paquete(String codigoRastreo, double peso, double alto, double ancho, double largo, double valorDeclarado) {
        this.codigoRastreo = (codigoRastreo != null && !codigoRastreo.equals("")) 
                             ? codigoRastreo : "SIN-CODIGO";
        this.peso = (peso > 0.0) ? peso : 1.0;
        this.alto = (alto > 0.0) ? alto : 10.0;
        this.ancho = (ancho > 0.0) ? ancho : 10.0;
        this.largo = (largo > 0.0) ? largo : 10.0;
        this.valorDeclarado = (valorDeclarado >= 0.0) ? valorDeclarado : 0.0;
        this.envioExpress = false;
    }

    /**
     * Constructor con todos los parametros.
     * 
     * @param codigoRastreo Codigo unico de rastreo.
     * @param peso Peso fisico en kilogramos (debe ser mayor a 0).
     * @param alto Altura en centimetros (debe ser mayor a 0).
     * @param ancho Anchura en centimetros (debe ser mayor a 0).
     * @param largo Longitud en centimetros (debe ser mayor a 0).
     * @param valorDeclarado Valor monetario declarado (mayor o igual a 0).
     * @param envioExpress true si requiere envio prioritario express; false en envio normal.
     */
    public Paquete(String codigoRastreo, double peso, double alto, double ancho, double largo, 
                   double valorDeclarado, boolean envioExpress) {
        this.codigoRastreo = (codigoRastreo != null && !codigoRastreo.equals("")) 
                             ? codigoRastreo : "SIN-CODIGO";
        this.peso = (peso > 0.0) ? peso : 1.0;
        this.alto = (alto > 0.0) ? alto : 10.0;
        this.ancho = (ancho > 0.0) ? ancho : 10.0;
        this.largo = (largo > 0.0) ? largo : 10.0;
        this.valorDeclarado = (valorDeclarado >= 0.0) ? valorDeclarado : 0.0;
        this.envioExpress = envioExpress;
    }

    /**
     * Crea un nuevo objeto independiente en memoria cuyos atributos iniciales
     * sean replicas exactas de los del paquete recibido.
     * 
     * @param otro El paquete original a duplicar. Si es null, inicializa con valores por omision.
     */
    public Paquete(Paquete otro) {
        if(otro != null){
            this.codigoRastreo = otro.codigoRastreo;
            this.peso = otro.peso;
            this.alto = otro.alto;
            this.ancho = otro.ancho;
            this.largo = otro.largo;
            this.valorDeclarado = otro.valorDeclarado;
            this.envioExpress = otro.envioExpress;
        }
        else{
            this.codigoRastreo = "ND-000";
            this.peso = 1.0;
            this.ancho = 10.0;
            this.alto = 10.0;
            this.largo = 10.0;
            this.valorDeclarado = 100.0;
            this.envioExpress = false;
        }
        // POR HACER: Implementa el constructor por copia asegurando
        // la independencia de referencias en memoria.
    }

    // METODOS DE CONSULTA Y MODIFICACION (GETTERS Y SETTERS)

    /** @return El codigo de rastreo del paquete. */
    public String getCodigoRastreo() { 
        return codigoRastreo; 
    }

    /** @param codigoRastreo El nuevo codigo alfanumerico de rastreo. */
    public void setCodigoRastreo(String codigoRastreo) {
        if (codigoRastreo != null && !codigoRastreo.equals("")) {
            this.codigoRastreo = codigoRastreo;
        }
    }

    /** @return El peso fisico en kilogramos. */
    public double getPeso() { return peso; }

    /** @param peso El nuevo peso fisico (debe ser mayor a cero). */
    public void setPeso(double peso) {
        if (peso > 0.0) {
            this.peso = peso;
        }
    }

    /** @return La altura en centimetros. */
    public double getAlto() { 
        return alto; 
    }

    /** @param alto La nueva altura en centimetros (debe ser mayor a cero). */
    public void setAlto(double alto) {
        if (alto > 0.0) {
            this.alto = alto;
        } else {
            System.out.println("Error: La altura debe ser mayor a cero.");
        }
    }

    /** @return La anchura en centimetros. */
    public double getAncho() { 
        return ancho; 
    }

    /** @param ancho La nueva anchura en centimetros (debe ser mayor a cero). */
    public void setAncho(double ancho) {
        if (ancho > 0.0) {
            this.ancho = ancho;
        } else {
            System.out.println("Error: La anchura debe ser mayor a cero.");
        }
    }

    /** @return La longitud en centimetros. */
    public double getLargo() { 
        return largo; 
    }

    /** @param largo La nueva longitud en centimetros (debe ser mayor a cero). */
    public void setLargo(double largo) {
        if (largo > 0.0) {
            this.largo = largo;
        } else {
            System.out.println("Error: La longitud debe ser mayor a cero.");
        }
    }

    /** @return El valor monetario declarado en pesos (MXN). */
    public double getValorDeclarado() { 
        return valorDeclarado; 
    }

    /** @param valorDeclarado El nuevo valor declarado (no puede ser negativo). */
    public void setValorDeclarado(double valorDeclarado) {
        if (valorDeclarado >= 0.0) {
            this.valorDeclarado = valorDeclarado;
        } else {
            System.out.println("Error: El valor declarado no puede ser negativo.");
        }
    }

    /** @return true si tiene modalidad express activa; false en caso contrario. */
    public boolean isEnvioExpress() { 
        return envioExpress; 
    }

    /** @param envioExpress Modalidad de envio express a asignar. */
    public void setEnvioExpress(boolean envioExpress) {
        this.envioExpress = envioExpress;
    }


    // METODOS CALCULADORES 

    /**
     * Calcula el peso volumetrico equivalente de acuerdo al factor de conversion IATA:
     * (largo * ancho * alto) / 5000.
     * 
     * @return El peso volumetrico en kilogramos.
     */
    public double calculaPesoVolumetrico() {
        return (this.largo * this.ancho * this.alto) / 5000.0;
    }

    /**
     * Determina el peso cobrable final de la orden postal, que corresponde
     * al valor maximo entre el peso fisico real y el peso volumetrico calculado.
     * 
     * @return El mayor entre el peso real y el volumetrico.
     */
    public double obtenerPesoCobrable() {
        double pesoVolumetrico = calculaPesoVolumetrico();
        return (this.peso >= pesoVolumetrico) ? this.peso : pesoVolumetrico;
    }


    // REPRESENTACION TEXTUAL 

    /**
     * Ficha tecnica textual de un paquete
     * 
     * @return Cadena estructurada con codigo, pesos, dimensiones y valor declarado.
     */
    @Override
    public String toString() {
        // POR HACER (Parte 1): Devuelve una representacion en texto legible del paquete.
        return "|Código de rastreo del paquete: " + getCodigoRastreo() + 
                "|Peso real: " + getPeso() + 
                "|Peso volumétrico: " + calculaPesoVolumetrico() + 
                "|Peso cobrable: " + obtenerPesoCobrable() + 
                "|Valor declarado: " + getValorDeclarado() +
                "Modalidad express: " + isEnvioExpress();
    }
} 
