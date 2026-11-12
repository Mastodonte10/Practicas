/**
 * Modela un punto en el plano cartesiano bidimensional (2D).
 * 
 * @author Luis Angel Lopez Perez
 * @version 1.1
 */
public class Punto {

    // Practica 8 (Mini-Lab): Metodos, Mensajes y Objetos como Parametros.
 // Completa las partes marcados con comentarios 'POR HACER'.

    // ATRIBUTOS PRIVADOS

    // POR HACER: Declara los dos atributos privados de tipo double:
    // 'x' para la coordenada horizontal (abscisa) y 'y' para la vertical (ordenada).
    private double x;
    private double y;

    // CONSTRUCTORES

    /**
     * Inicializa el punto exactamente en el origen de coordenadas (0.0, 0.0).
     */
    public Punto() {
        // Constructor por omision / defecto.
        // POR HACER: Asigna 0.0 a las coordenadas x e y
        this.x = 0.0;
        this.y = 0.0;
    }

    /**
     * Inicializa el punto en las coordenadas cartesianas especificadas.
     * Recuerda utilizar 'this' para desambiguar el atributo del parametro.
     * 
     * @param x Coordenada en el eje X.
     * @param y Coordenada en el eje Y.
     */
    public Punto(double x, double y) {
        // Constructor con parametros.
        // POR HACER: Asigna los parametros a los atributos correspondientes usando 'this'
        this.x = x;
        this.y = y;
    }


    // POR HACER: Implementa los metodos de consulta y asignacion (getters y setters)
    
    // METODOS DE CONSULTA Y ASIGNACION (GETTERS Y SETTERS)
    // 
    /**
     * Obtiene la coordenada X del punto.
     * 
     * @return Coordenada horizontal x.
     */
    public double getX() {
        return this.x;
    }

    /**
     * Obtiene la coordenada Y del punto.
     * 
     * @return Coordenada vertical y.
     */
    public double getY() {
        return this.y;
    }

    /**
     * Modifica la coordenada X del punto.
     * 
     * @param x Nueva coordenada horizontal.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Modifica la coordenada Y del punto.
     * 
     * @param y Nueva coordenada vertical.
     */
    public void setY(double y) {
        this.y = y;
    }

    // METODOS CALCULADORES [ OPERACIONES GEOMETRICAS ]
    // =========================================================================

    /**
     * Desplaza el punto sumando desplazamientos (deltas) a sus coordenadas actuales.
     * 
     * @param deltaX Desplazamiento horizontal.
     * @param deltaY Desplazamiento vertical.
     */
    public void desplazar(double deltaX, double deltaY) {
        // POR HACER: Suma deltaX a x, y deltaY a y
        this.x += deltaX;
        this.y += deltaY;
    }

    /**
     * Calcula la distancia euclidiana entre este punto y otro punto recibido.
     * Formula: sqrt((x2 - x1)^2 + (y2 - y1)^2)
     * 
     * @param otroPunto El punto destino respecto al cual se calculara la distancia.
     * @return La distancia euclidiana entre ambos puntos. Si 'otroPunto' es null, regresa -1.0.
     */
    public double distancia(Punto otroPunto) {

        // POR HACER: Valida si 'otroPunto' es null (regresa -1.0 si es null).
        // En caso contrario, calcula y regresa la distancia euclidiana.
        if (otroPunto == null) {
            return -1.0;
        }
        double dx = otroPunto.getX() - this.x;
        double dy = otroPunto.getY() - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Calcula y retorna el punto medio entre este punto y otro punto recibido.
     * Formula de coordenadas medias: xm = (x1 + x2) / 2, ym = (y1 + y2) / 2.
     * 
     * @param otro El otro punto para calcular el punto medio.
     * @return Una nueva instancia de Punto situada en las coordenadas medias. Si 'otro' es null, regresa null.
     */
    public Punto puntoMedio(Punto otro) {
        // POR HACER: Valida si 'otro' es null (regresa null).
        // Calcula xm y ym, e instancia y retorna un NUEVO objeto Punto con dichas coordenadas.
        if (otro == null) {
            return null;
        }
        double xm = (this.x + otro.getX()) / 2.0;
        double ym = (this.y + otro.getY()) / 2.0;
        return new Punto(xm, ym);
    }

    /**
     * Determina el cuadrante del plano cartesiano en el que se ubica el punto.
     * 
     * @return 1 (I Cuadrante: x &gt; 0, y &gt; 0),
     *         2 (II Cuadrante: x &lt; 0, y &gt; 0),
     *         3 (III Cuadrante: x &lt; 0, y &lt; 0),
     *         4 (IV Cuadrante: x &gt; 0, y &lt; 0),
     *         o 0 si se ubica sobre alguno de los ejes o en el origen.
     */
    public int cuadrante() {
        // POR HACER: Implementa la clasificacion de cuadrantes con estructuras if-else
        if (this.x > 0 && this.y > 0) {
            return 1;
        } else if (this.x < 0 && this.y > 0) {
            return 2;
        } else if (this.x < 0 && this.y < 0) {
            return 3;
        } else if (this.x > 0 && this.y < 0) {
            return 4;
        } else {
            return 0;
        }
    }

    /**
     * Determina si este punto y otros dos puntos recibidos son colineales
     * (es decir, si los tres puntos pasan sobre la misma linea recta).
     * 
     * @param p2 Segundo punto a evaluar.
     * @param p3 Tercer punto a evaluar.
     * @return true si los tres puntos estan alineados; false en caso contrario (o si alguno es null).
     */
    public boolean estanAlineados(Punto p2, Punto p3) {
        // POR HACER: Valida que p2 y p3 no sean null.
        // Evalua la condicion de colinealidad
        if (p2 == null || p3 == null) {
            return false;
        }
        double delta = (p2.getX() - this.x) * (p3.getY() - this.y)
                     - (p2.getY() - this.y) * (p3.getX() - this.x);
        return Math.abs(delta) < 1e-9;
    }

    /**
     * Representacion textual del punto en formato estandar de par ordenado: (x, y).
     * 
     * @return Cadena con el formato "(x, y)".
     */
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    /**
     * Compara si este punto es equivalente a otro objeto recibido.
     * Dos puntos se consideran iguales si la distancia entre ellos o la diferencia absoluta
     * de sus coordenadas es menor a una tolerancia pequena (ej. 1e-6).
     * 
     * @param obj El objeto a comparar.
     * @return true si el objeto es un Punto con coordenadas equivalentes; false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        // POR HACER: Verifica si obj es null o si no es una instancia de Punto.
        // Compara por distancia o diferencia absoluta de coordenadas con tolerancia.
        if (obj == null || !(obj instanceof Punto)) {
            return false;
        }
        Punto otro = (Punto) obj;
        return this.distancia(otro) < 1e-6;
    }
}