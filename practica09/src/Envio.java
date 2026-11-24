/**
 * Modela una Guia de Envio postal relacionando a una Persona remitente, 
 * una Persona destinatario y un objeto Paquete.
 * 
 * Cada guia recibe automaticamente un folio unico al momento de crearse
 * (compuesto por caracteres aleatorios y un numero consecutivo global).
 * 
 * @author Diego Emiliano Sánchez Chávez. 324134195. ,  Luis Angel Lopez Perez. 324243174.
 * @version 1.0
 */
public class Envio {

    // 1. ATRIBUTOS

    /** Cargo adicional fijo en pesos para envios foraneos (entre distintas ubicaciones). */
    public static final double CARGO_FORANEO = 80.0;

    // POR HACER:
    // 1. Declara los atributos para una guia:
    
    // 2. Deduce y declara lo necesario a nivel de clase para llevar el conteo
    //    consecutivo global de guias emitidas y generar automaticamente cada folioGuia.

    private String folioGuia;
    private Persona remitente;
    private Persona destinatario;
    private Paquete paquete;
    
    private static int totalGuiasEmitidas = 0;

    // 2. CONSTRUCTORES 

    /**
     * Constructor principal para emitir una nueva guia de envio.
     * Genera automaticamente el folioGuia (2 o 3 letras/digitos aleatorios + consecutivo).
     * Valida que ninguna referencia recibida sea invalida; si se envia a la misma
     * persona se permite (envio personal o mudanza).
     * 
     * @param remitente Persona que envia el paquete.
     * @param destinatario Persona que recibe el paquete.
     * @param paquete Paquete fisico amparado por esta guia.
     */

    public Envio(Persona remitente, Persona destinatario, Paquete paquete) {
        // POR HACER: Inicializa los atributos con validaciones defensivas
        // (no permitir null y validar el paquete con CotizadorEnvio) y asigna folioGuia. 
        if (remitente != null) {
            this.remitente = remitente;
        } else {
            this.remitente = new Persona();
        }
        if (destinatario != null) {
            this.destinatario = destinatario;
        } else {
            this.destinatario = new Persona();
        }
        if (paquete != null && CotizadorEnvio.esPaqueteValido(paquete)) {
            this.paquete = paquete;
        } else {
            this.paquete = new Paquete();
        }
        this.folioGuia = generarFolio();
    }


    /**
     * Constructor para copiar una guia existente cuando el mismo remitente envia
     * un nuevo paquete al mismo destinatario.
     * Conserva las referencias a remitente y destinatario de guiaBase, asocia el
     * nuevoPaquete y genera un NUEVO folioGuia consecutivo para esta guia.
     * 
     * @param guiaBase Guia original de la cual se toman remitente y destinatario.
     * @param nuevoPaquete El nuevo paquete que viajara bajo esta nueva guia.
     */
    public Envio(Envio guiaBase, Paquete nuevoPaquete) {
        // POR HACER: Implementa la copia de la guia con un nuevo paquete y nuevo folioGuia.
    if (guiaBase != null) {
            this.remitente = guiaBase.remitente;
            this.destinatario = guiaBase.destinatario;
        } else {
            this.remitente = new Persona();
            this.destinatario = new Persona();
        }

        if (nuevoPaquete != null && CotizadorEnvio.esPaqueteValido(nuevoPaquete)) {
            this.paquete = nuevoPaquete;
        } else {
            this.paquete = new Paquete();
        }

        this.folioGuia = generarFolio();
    }

    // 3. METODOS DE ACCESO (GETTERS) Y CONSULTA DE GUIAS EMITIDAS

/** @return El folio unico generado para esta guia. */
    public String getFolioGuia() {
        return folioGuia;
    }
    public Persona getRemitente() {
        return remitente;
    }
    public Persona getDestinatario() {
        return destinatario;
    }
    public Paquete getPaquete() {
        return paquete;
    }

    // POR HACER: Declara e implementa los metodos de acceso (getters) para remitente, 
    // destinatario y paquete.

    // POR HACER: Declara e implementa el metodo que permita consultar en cualquier
    // momento cuantas guias de envio se han emitido en total durante la ejecucion,
    // así como el metodo auxiliar para generar el folio aleatorio + consecutivo.
    
    public static int getTotalGuiasEmitidas() {
        return totalGuiasEmitidas;
    }

    private static String generarFolio() {
        totalGuiasEmitidas++;
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String aleatorio = "";
        int i = 0;
        while (i < 3) {
            int indice = (int) (Math.random() * caracteres.length());
            aleatorio += caracteres.charAt(indice);
            i++;
        }
        return "GUIA-" + aleatorio + "-" + totalGuiasEmitidas;
    }

    // 4. METODOS DE OPERACION SOBRE LOS OBJETOS AGREGADOS  

    /**
     * Determina si el envio es foraneo verificando si el remitente y el destinatario
     * se encuentran en distinta ubicacion.
     * 
     * @return true si viaja entre distintas ubicaciones; false si es un envio local.
     */
    public boolean esEnvioForaneo() {
        return !this.remitente.mismaUbicacionQue(this.destinatario);
    }

    /**
     * Determina si el remitente y el destinatario representan a la misma persona
     * (por ejemplo, un envio personal o mudanza).
     * 
     * @return true si remitente y destinatario son la misma persona; false en caso contrario.
     */
    public boolean esAutoEnvio() {
        return this.remitente.esLaMismaPersona(this.destinatario);
    }
    /**
     * Calcula el costo total del envio:
     * Obtiene la tarifa base del paquete y, si es un envio foraneo,
     * suma el cargo adicional correspondiente.
     * 
     * @return El costo total de la guia en pesos (MXN), o -1.0 si el paquete es invalido.
     */
    public double calcularCostoTotal() {
    double costoBase = CotizadorEnvio.cotizarEnvio(this.paquete);
    if (costoBase < 0.0) {
        return -1.0;
    }
    if (esEnvioForaneo()) {
        return costoBase + CARGO_FORANEO;
    }
    return costoBase;
    }

    /**
     * Redirige el envio a un nuevo destinatario antes de su despacho.
     * Verifica unicamente que nuevoDestinatario no sea null.
     * 
     * @param nuevoDestinatario Nueva persona destinataria.
     * @return true si el cambio fue valido y aplicado; false si nuevoDestinatario es null.
     */
    public boolean cambiarDestinatario(Persona nuevoDestinatario) {
    if (nuevoDestinatario != null) {
        this.destinatario = nuevoDestinatario;
        return true;
    }
    return false;
    }

    /**
     * Genera y devuelve una NUEVA guia de envio para devolver la mercancia al origen:
     * 1. Invierte los roles entre remitente y destinatario.
     * 2. Crea una copia independiente del paquete en memoria y actualiza su codigo
     *    de rastreo anteponiendo el prefijo "RET-".
     * 3. La nueva guia recibe automaticamente su propio folioGuia consecutivo.
     * 
     * @return Nuevo objeto Envio configurado para el retorno al remitente original.
     */
    public Envio generarGuiaRetorno() {
    Paquete paqueteRetorno = new Paquete(this.paquete);

    paqueteRetorno.setCodigoRastreo("RET-" + paqueteRetorno.getCodigoRastreo());

    return new Envio(this.destinatario, this.remitente, paqueteRetorno);
    }

    /**
     * Emite el comprobante textual de la guia de envio delegando en toString()
     * de remitente, destinatario y paquete, e indicando el folio, tipo de ruta
     * (LOCAL o FORANEO) y el costo total.
     * 
     * @return Cadena con el formato completo de la guia de envio.
     */
    @Override
    public String toString() {
    String ruta = esEnvioForaneo() ? "FORANEO" : "LOCAL";
    String auto = esAutoEnvio() ? " [AUTO-ENVIO]" : "";
    return "Folio: " + folioGuia + " (" + ruta + auto + ")\n"
         + "  Remitente: " + remitente.toString() + "\n"
         + "  Destinatario: " + destinatario.toString() + "\n"
         + "  Paquete: " + paquete.toString() + "\n"
         + "  Costo Total: $" + calcularCostoTotal() + " MXN";}
}