/**
 * Programa de pruebas y simulacion para las Guias de Envios
 * Ejecuta pruebas automatizadas.
 * 
 * @author Diego Emiliano Sánchez Chávez. 324134195. ,  Luis Angel Lopez Perez. 324243174. 
 * @version 2.0
 */
public class PruebaEnvio {

    /*
    * - Incluye las secciones guiadas para que agregues las pruebas de tu diseno
    *   de Persona (Parte 2), Envio y generacion de folios consecutivos (Parte 3),
    *   asi como la simulacion integral de envios, clones y devolucion (Parte 4).
    */

    private static int pruebasExitosas = 0;
    private static int totalPruebas = 0;

    /**
     * Metodo principal de verificacion y simulacion no interactiva.
     * 
     * @param args Argumentos de linea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("  ICC 2027-1 | PRACTICA 9: AGREGACION, CLONACION Y GUIAS DE ENVIO");
        System.out.println("================================================================================\n");

        // ---------------------------------------------------------------------
        // PARTE 1: PAQUETES ESTANDARIZADOS (CONSTRUCTOR POR COPIA Y TOSTRING)
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 1: REPRESENTACION TEXTUAL Y CLONACION DE PAQUETE");
        Paquete kitBase = new Paquete("KIT-101", 4.0, 20.0, 20.0, 20.0, 500.0, false);
        Paquete otroPaquete = new Paquete("PKG-202", 12.0, 40.0, 30.0, 30.0, 1500.0, false);


    
        String txtKit = kitBase.toString();
        verificar("Paquete.toString() incluye el codigo de rastreo",
                  txtKit != null && txtKit.contains("KIT-101") && !txtKit.contains("Paquete@"));

        Paquete kitClon = new Paquete(kitBase);
        double pesoOriginal = kitBase.getPeso();
        kitBase.setPeso(99.0);
        verificar("Constructor por copia de Paquete crea instancia independiente en memoria",
                  kitClon != kitBase && Math.abs(kitClon.getPeso() - pesoOriginal) < 1e-6);
        kitBase.setPeso(pesoOriginal);

        kitClon.setCodigoRastreo("KIT-102"); // Nuevo codigo para envio en serie
        verificar("Modificar el codigo del paquete clonado no altera el paquete plantilla original",
                  "KIT-101".equals(kitBase.getCodigoRastreo()) && "KIT-102".equals(kitClon.getCodigoRastreo()));

        Paquete clonNulo = new Paquete(null);
        verificar("Constructor por copia con null asigna valores predeterminados validos",
                  clonNulo.getCodigoRastreo() != null && clonNulo.getPeso() > 0.0);
        System.out.println();

        // ---------------------------------------------------------------------
        // PARTE 2: PRUEBAS DE TU DISENO DE LA CLASE PERSONA
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 2: VERIFICACION DE LA CLASE PERSONA");
        // POR HACER (Parte 2):
        // Instancia al menos 3 objetos Persona con los constructores que disenaste:
        Persona personaX = new Persona("PER-XXX", "X", "Ciudad 1");
        Persona personaY= new Persona("PER-YYY", "Y", "Ciudad 1"); //ntp bro 
        Persona personaZ =  new Persona("PER-ZZZ", "Z", "Ciudad 2" ); 
        Persona copiPersonaX = new Persona("PER-XXX", "Copiado", "Ciudad 3");
        // - Dos personas en la misma ciudad/codigo postal (ej. personaX y personaY).
        // - Una persona en otra ciudad/codigo postal (ej. personaZ) y una copia con el mismo ID que personaX.
        // Agrega llamadas a verificar(...) para comprobar:
        // 1. Que mismaUbicacionQue(...) devuelve true entre personaX y personaY, y false con personaZ.
        verificar("PersonaX y PersonaY tienen la misma ubicación.", personaX.mismaUbicacionQue(personaY));
        verificar("PersonaX y PersonaZ no tienen la misma ubación.", !personaX.mismaUbicacionQue(personaZ));
        // 2. Que esLaMismaPersona(...) devuelve true para el mismo identificador unico y false para distinto o null.
        verificar("Verifica que es la misma persona.",
        personaX.esLaMismaPersona(copiPersonaX) && !personaX.esLaMismaPersona(personaY) && !personaX.esLaMismaPersona(null));
        // 3. Que toString() devuelve una cadena legible con sus datos.
        verificar("Persona.toString() devuelve datos legibles.",
        personaX.toString() != null && personaX.toString().contains("PER-XXX"));

        // ---------------------------------------------------------------------
        // PARTE 3: PRUEBAS DE AGREGACION, FOLIOS CONSECUTIVOS Y OPERACIONES EN ENVIO
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 3: VERIFICACION DE ENVIO Y FOLIOS AUTOMATICOS");
        // POR HACER (Parte 3):
        // 1. Verifica con tu metodo de consulta que al inicio se han emitido 0 guias.
        verificar("En el inicio se emitio 0 guias", Envio.getTotalGuiasEmitidas() == 0);
        // 2. Crea una guia local (entre personaX y personaY con kitBase) y una foranea (hacia personaZ con kitClon).
        Envio guiaLocal = new Envio(personaX, personaY, kitBase);
        Envio guiaForanea = new Envio (personaX, personaZ, kitClon);
        // 3. Verifica que ambas guias tienen folios no nulos, distintos y con numeracion consecutiva (1 y 2),
        //    y que el total de guias emitidas ahora es 2.

        verificar("Las guias tienen folios asignados (no nulos)", guiaLocal.getFolioGuia() != null && guiaForanea.getFolioGuia() != null);
        verificar("Los folios generados son distintos entre si", !guiaLocal.getFolioGuia().equals(guiaForanea.getFolioGuia()));
        verificar("Los folios tienen numeracion consecutiva (-1 y -2)", guiaLocal.getFolioGuia().endsWith("-1") && guiaForanea.getFolioGuia().endsWith("-2"));
        verificar("El contador global marca 2 guias emitidas", Envio.getTotalGuiasEmitidas() == 2);

        // 4. Verifica esEnvioForaneo(), esAutoEnvio() y calcularCostoTotal() (confirmando el cargo foraneo).

        verificar("La guia local no se marca como foranea", !guiaLocal.esEnvioForaneo());
        verificar("La guia hacia otra ciudad si se marca como foranea", guiaForanea.esEnvioForaneo());
        verificar("Al inicio ninguna de las dos guias es auto-envio", !guiaLocal.esAutoEnvio() && !guiaForanea.esAutoEnvio());
        verificar("El costo de la guia foranea incluye los $80 extra respecto a la local",
        guiaForanea.calcularCostoTotal() == guiaLocal.calcularCostoTotal() + Envio.CARGO_FORANEO);

        // 5. Verifica que cambiarDestinatario(...) rechaza null y acepta actualizar a otra persona (o a si misma).
       verificar("cambiarDestinatario devuelve false si recibe null", !guiaLocal.cambiarDestinatario(null));
        verificar("cambiarDestinatario actualiza al destinatario y detecta auto-envio", guiaLocal.cambiarDestinatario(personaX) && guiaLocal.esAutoEnvio());

        // ---------------------------------------------------------------------
        // PARTE 4: SIMULACION INTEGRAL (CLONACION DE GUIA Y DEVOLUCION / RETORNO)
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 4: SIMULACION DE ENVIOS, CLONACION DE GUIA Y RETORNO");
        // POR HACER (Parte 4):
        // Modela e imprime en consola el siguiente escenario completo:
        // a) Persona X envia 'kitBase' a Persona Y (imprime la guia generada).
        // b) Persona X necesita enviar un segundo paquete ('otroPaquete') a la misma Persona Y
        //    clonando la guia anterior; verifica que conserva remitente y destinatario
        //    pero tiene el nuevo paquete y un nuevo folio consecutivo.
        // c) Persona Y solicita devolver el primer paquete a Persona X generando una guia de retorno;
        //    verifica con verificar(...) que en la guia de retorno el remitente es Y, el destinatario es X,
        //    el paquete es una copia independiente con prefijo "RET-" y cuenta con un nuevo folio consecutivo.
        //    Imprime la guia de retorno y el total acumulado de guias emitidas en el sistema.

        System.out.println("\n================================================================================");
        System.out.println("  RESUMEN DE PRUEBAS: " + pruebasExitosas + " / " + totalPruebas + " pruebas superadas con exito");
        System.out.println("================================================================================");
    }

    /**
     * Evalua una condicion booleana e imprime [OK] o [FALLO].
     * 
     * @param nombrePrueba Descripcion breve del caso evaluado.
     * @param condicion Resultado booleano esperado (true si paso).
     */
    private static void verificar(String nombrePrueba, boolean condicion) {
        totalPruebas++;
        if (condicion) {
            pruebasExitosas++;
            System.out.println("  [OK]    " + nombrePrueba);
        } else {
            System.out.println("  [FALLO] " + nombrePrueba);
        }
    }
}
