/**
 * Representa a una persona registrada en el sistema postal, la cual puede actuar
 * como remitente o como destinatario dentro de una guia de envio.
 *  * 
 * @author Diego Emiliano Sánchez Chávez. 324134195. , Luis Angel Lopez Perez. 324243174.
 * @version 2.0
 */
public class Persona {


    // 1. ATRIBUTOS

    /*
     PARTE 2 (DISENO ABIERTO):
     Define los atributos privados, constructores, getters/setters y metodos necesarios
     para modelar a una persona considerando al menos:
     - Un identificador corto unico
     - Nombre completo.
     - Ubicacion (ciudad, alcaldia o codigo postal) para distinguir envios locales de foraneos.
     */
    //Atributos
    /**
     * Representa el identificador corto de la persona.
     */
    private String identificador;
    /**
     * Representa el nombre de la persona.
     */
    private String nombre;
    /**
     * Representa la ciudad de donde es la persona.
     */
    private String ciudad;

    
    // POR HACER: Declara los atributos que consideres necesarios
    // para representar a la persona (identificador unico, nombre, ubicacion, etc.).

    // 2. CONSTRUCTORES 

    // POR HACER: Implementa al menos un constructor por omision y un constructor
    // con parametros (aplicando validaciones basicas para evitar cadenas nulas o vacias).

    public Persona(){
    this.nombre ="Sin nombre.";
    this.identificador = "PER-000";
    this.ciudad = "No hay ciudad.";
    }

    public Persona(String identificador, String nombre, String ciudad){
        if(identificador.length() <= 0 || identificador == null){
            this.identificador = "PER-000";
            System.out.println("Identificador inválido, se asignó uno por defecto.");
        }
        else{ 
            this.identificador = identificador;
        }
        if(nombre.length() <= 0 || nombre == null){
            this.nombre = "Sin nombre.";
            System.out.println("Nombre inválido, se asignó el valor por defecto.");
        }
        else{
            this.nombre = nombre;
        }
        if(ciudad.length() <= 0 || ciudad == null){
            this.ciudad = "No hay ciudad.";
            System.out.println("Ciudad inválida, se asignó el valor por defecto.");
        }
        else{
            this.ciudad = ciudad;
        }
    }

    // 3. GETTERS, SETTERS Y COLABORACION 
    // POR HACER: Implementa los getters y setters necesarios para tus atributos.
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        if (identificador != null && identificador.length() > 0) {
            this.identificador = identificador;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && nombre.length() > 0) {
            this.nombre = nombre;
        }
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        if (ciudad != null && ciudad.length() > 0) {
            this.ciudad = ciudad;
        }
    }
    /**
     * Determina si esta persona se encuentra en la misma ubicacion (ciudad o codigo postal)
     * que otra persona recibida como parametro, para saber si un envio entre ambas
     * es local o foraneo.
     * 
     * @param otra La otra persona con quien comparar la ubicacion.
     * @return true si otra no es null y ambas comparten la misma ubicacion; false en caso contrario.
     */
    public boolean mismaUbicacionQue(Persona otra) {
        // POR HACER: Compara la ubicacion de this contra la de 'otra'.
    if (otra != null && this.ciudad != null && otra.ciudad != null) {
        return this.ciudad.equalsIgnoreCase(otra.ciudad);
    }
        return false;}
    
    /**
     * Determina si este objeto Persona y el recibido como parametro representan
     * a la misma persona comparando su identificador unico.
     * 
     * @param otra La otra persona a comparar.
     * @return true si otra no es null y ambas tienen el mismo identificador; false en caso contrario.
     */
    public boolean esLaMismaPersona(Persona otra) {
        if (otra != null && this.identificador != null && otra.identificador != null) {
            return this.identificador.equalsIgnoreCase(otra.identificador);
        }
        return false;
    }

    // 4. REPRESENTACION TEXTUAL

    /**
     * Devuelve una representacion legible de la persona con sus datos principales.
     * 
     * @return Cadena con el identificador, nombre y ubicacion de la persona.
     */
    @Override
    public String toString() {
        // POR HACER: Sobrescribe toString() con el formato de tu preferencia.
        return "Identificador: " + identificador + ", Nombre: " 
        + nombre + ", Ciudad: " + ciudad;
    }
}
