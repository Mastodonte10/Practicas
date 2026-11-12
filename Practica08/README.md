# Práctica 8 (Mini-Lab): La Clase Punto
**Introducción a las Ciencias de la Computación (Semestre 2027-1)**  
**Facultad de Ciencias, UNAM**

---

## Datos del alumno

> **Nota de privacidad:** Si publicas tu proyecto en un repositorio público de GitHub, **no es necesario que incluyas esta sección** en este archivo para proteger tu privacidad. Es suficiente con que tus datos completos estén registrados en la entrega directa de Google Classroom.

- **Nombre completo:** [Lopez Perez Luis Angel]
- **Número de cuenta:** [324243174]
- **Correo institucional:** [luisalp@ciencias.unam.mx]

---

## Descripción de la práctica

En esta práctica se implementó la clase `Punto` en Java para modelar un punto en el plano cartesiano bidimensional $\mathbb{R}^2$ aplicando los principios de encapsulamiento, paso de mensajes y uso de objetos como parámetros[cite: 1]. Se declararon los atributos privados `x` e `y` junto con sus constructores (por omisión en el origen y parametrizado usando `this`), métodos de acceso y modificación (`getters` y `setters`), operaciones geométricas (`desplazar`, `distancia`, `puntoMedio`, `cuadrante` y `estanAlineados` mediante producto cruz 2D) y la sobrescritura de los métodos estándar `toString()` y `equals(Object)` con tolerancia numérica para números de punto flotante[cite: 1, 2].
>
---

## Comandos para compilar, ejecutar y documentar

Ejecuta los siguientes comandos desde la terminal ubicado en la raíz de esta carpeta:

### 1. Compilación
```bash
javac -d bin src/*.java
```

### 2. Ejecución de la verificación
```bash
java -cp bin PruebaPunto
```

### 3. Generación de documentación Javadoc
```bash
javadoc -d doc -author -version src/Punto.java
```

---

## Evidencia de ejecución

Copia y pega aquí el resumen final que mostró tu terminal al ejecutar `PruebaPunto`:

```text
================================================================================
  ICC 2027-1 | VERIFICACION AUTOMATIZADA: CLASE PUNTO (MINI-LAB 8)
================================================================================

>>> 1. PROBANDO CONSTRUCTORES Y GETTERS:
  [OK] Constructor por omision inicializa en (0.0, 0.0)
  [OK] Constructor con parametros inicializa en (3.0, 4.0)

>>> 2. PROBANDO SETTERS:
  [OK] Setters modifican correctamente las coordenadas

>>> 3. PROBANDO METODO DESPLAZAR:
  [OK] desplazar(1.5, -1.0) actualiza a (3.5, 2.0)

>>> 4. PROBANDO DISTANCIA EUCLIDIANA:
  [OK] Distancia de (0.0, 0.0) a (3.0, 4.0) es 5.0
  [OK] Distancia de (1.0, 2.0) a (4.0, 6.0) es 5.0
  [OK] Distancia con referencia null regresa -1.0

>>> 5. PROBANDO PUNTO MEDIO (OBJETO RETORNADO):
  [OK] Punto medio entre (1.0, 2.0) y (4.0, 6.0) es (2.5, 4.0)
  [OK] Punto medio con null regresa null

>>> 6. PROBANDO DETERMINACION DE CUADRANTES:
  [OK] Cuadrante de (5.0, 8.0) es I
  [OK] Cuadrante de (-3.0, 4.0) es II
  [OK] Cuadrante de (-2.0, -7.0) es III
  [OK] Cuadrante de (6.0, -1.0) es IV
  [OK] Cuadrante de (0.0, 5.0) en eje es 0
  [OK] Cuadrante del origen (0.0, 0.0) es 0

>>> 7. PROBANDO METODO toString():
  [OK] toString() de (3.0, 4.0) devuelve "(3.0, 4.0)"

>>> 8. PROBANDO METODO EQUALS (IDENTIDAD VS CONTENIDO):
  [OK] p1.equals(new Punto(3.0, 4.0)) retorna true
  [OK] p1.equals(new Punto(3.0, 4.1)) retorna false
  [OK] p1.equals(null) retorna false de forma segura

>>> 9. PROBANDO COLINEALIDAD (RETO: TRES PUNTOS EN UNA RECTA):
  [OK] (1,1), (2,2) y (5,5) estan alineados
  [OK] (1,1), (2,2) y (5,6) NO estan alineados

================================================================================
  RESUMEN DE PRUEBAS: 21 / 21 pruebas superadas con exito.
  ¡FELICIDADES! Todos los metodos de la clase Punto funcionan correctamente.
================================================================================

Loading source file src/Punto.java...
Constructing Javadoc information...
Building index for all the packages and classes...
Standard Doclet version 21.0.12.1+1-1-26.04.4-Ubuntu
Building tree for all the packages and classes...
Generating doc/Punto.html...
Generating doc/package-summary.html...
Generating doc/package-tree.html...
Generating doc/overview-tree.html...
Building index for all classes...
Generating doc/allclasses-index.html...
Generating doc/allpackages-index.html...
Generating doc/index-all.html...
Generating doc/search.html...
Generating doc/index.html...
Generating doc/help-doc.html...
```

---

## Preguntas de reflexión (1.0 punto)

1. **¿Por qué el método `puntoMedio` crea y regresa un nuevo objeto `Punto`, mientras que `desplazar` modifica al mismo objeto que recibe el mensaje?**
>[Porque puntoMedio calcula un tercer punto independiente sin alterar los originales, mientras que desplazar es un mutador diseñado para cambiar la posición (el estado interno) del punto que recibe el mensaje.]

2. **Al ejecutar `p1.distancia(p2)`, ¿a qué objeto en memoria hace referencia `this` y cómo accede el método a las coordenadas de `p2`?**
   > [this hace referencia al objeto receptor p1, y a las coordenadas de p2 se accede mediante el parámetro otroPunto llamando a sus getters (otroPunto.getX() y otroPunto.getY())]

3. **Observa el archivo `PruebaPunto.java`: ¿por qué los atributos `pruebasExitosas`, `totalPruebas` y el método `verificar` están declarados como `static`? ¿Qué ocurriría si les quitáramos la palabra `static` y los llamáramos desde `main`? Menciona además dos métodos estáticos de las bibliotecas estándar de Java que utilizaste en `Punto.java`.**
   > [Son static para pertenecer a la clase y poder usarse directamente desde main (que también es static) sin instanciar un objeto de PruebaPunto. Si se quitara static, el programa no compilaría por intentar acceder a miembros de instancia desde un contexto estático. Dos métodos estáticos usados en Punto.java son Math.sqrt() y Math.abs()]
