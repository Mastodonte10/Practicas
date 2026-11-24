# Práctica 9: Agregación, Clonación de Objetos y Guías de Envío
**Introducción a las Ciencias de la Computación (Semestre 2027-1)**  
**Facultad de Ciencias, UNAM**

---

## Datos del alumno

> **Nota de privacidad:** Si publicas tu proyecto en un repositorio público de GitHub, **no es necesario que incluyas esta sección** en este archivo para proteger tu privacidad. Es suficiente con que tus datos completos estén registrados en la entrega directa de Google Classroom.

- **Nombre completo:** [Diego Emiliano Sánchez Chávez/ Luis Angel Lopez Perez]
- **Número de cuenta:** [324134195/324243174]
- **Correo institucional:** [diegosch0306@ciencias.unam.mx/luisalp@ciencias.unam.mx]

---

## Descripción de la práctica y decisiones de diseño en los métodos y clases

Describe brevemente los atributos, constructores y métodos que decidiste diseñar para `Persona.java`, así como tu implementación de `Envio.java`:

> Los atributos que desarrollamos para Persona.java fueron 3: Nombre, Identificador, y Ciudad. Todos fueron Strings que diferenciaba a cada persona. Desarrollamos 2 constructores, uno predeterminado, y otro con parámetros. 
Y, como parar todas las clases anteriores, hicimos los métodos getters y setters para obtener y cambiar los valores de los atributos del objeto. Dentro de esta clase hicimos un método para ver si dos personas comparten la misma ubicación, y otro para ver si son la misma persona. Y por último, hicimos un método para representar la información de la persona de forma legible.

> Los atributos que desarrollamos para Envio.java fueron 4: FolioGuia (de tipo String), Remitente(de la clase Persona), Destinatario(de la clase Persona), y Paquete(de la clase Paquete). Hicimos 2 constructores, uno para hacer una nueva guia de envío, y otro para copiar una guía que ya existiera.
Seguido de esto, hicimos los métodos getters, y uno estático para consultar cuantas guías de envió se han emitido. Luego, empezamos a desarrollar los métodos. El método generarFolio genera un folio aleatorio con los carácteres que tiene, y aumente una guía emitida. 
El método esEnvioForaneo verifica si el remitente y el destinatario viven en la misma ciudad. Si si, entonces devuelve true, si no, false.
El método esAutoEnvio hace algo similiar, solo que aqui verifica si son la misma persona o no.
Luego, hicimos un método para calcular el costo del envió, en el cual, dependiendo de la condición que se cumpla, se aplicara un precio distinto. 
Después, hicimos el método  para cambiar el envió a un nuevo destinatario, el cual devuelve true si el cambio se pudo hacer y false si no. El siguiente método fue el de generarGuiaRetorno, con el cual se creaba una nueva guía copiando a la actual, le cambia el código a RET-, y devuelve un nuevo objeto con todos los cambios realizados en el método.
Y finalmente, hicimos el método toString para representar los datos de la guia del envío en texto.

---

## Comandos para compilar, ejecutar y documentar

Ejecuta los siguientes comandos desde la terminal ubicado en la raíz de esta carpeta (`practica09/`):

### 1. Compilación
```bash
<javac -d bin src/*.java>
```

### 2. Ejecución de pruebas y simulación (`PruebaEnvio`)
```bash
<java -cp bin PruebaEnvio>
```

### 3. Ejecución del menú interactivo (`MenuPostal`)
```bash
<java -cp bin MenuPostal >
```

### 4. Generación de documentación Javadoc
```bash
<javadoc -encoding UTF-8 -charset UTF-8 -author -version -private -d doc src/*.java>
```

---

## Evidencia de ejecución

### 1. Salida de `PruebaEnvio`
Copia y pega aquí la salida final que mostró tu terminal al ejecutar `PruebaEnvio`:

```text
================================================================================
  ICC 2027-1 | PRACTICA 9: AGREGACION, CLONACION Y GUIAS DE ENVIO
================================================================================

>>> PARTE 1: REPRESENTACION TEXTUAL Y CLONACION DE PAQUETE
  [OK]    Paquete.toString() incluye el codigo de rastreo
  [OK]    Constructor por copia de Paquete crea instancia independiente en memoria
  [OK]    Modificar el codigo del paquete clonado no altera el paquete plantilla original
  [OK]    Constructor por copia con null asigna valores predeterminados validos

>>> PARTE 2: VERIFICACION DE LA CLASE PERSONA
  [OK]    PersonaX y PersonaY tienen la misma ubicación.
  [OK]    PersonaX y PersonaZ no tienen la misma ubación.
  [OK]    Verifica que es la misma persona.
  [OK]    Persona.toString() devuelve datos legibles.
>>> PARTE 3: VERIFICACION DE ENVIO Y FOLIOS AUTOMATICOS
  [OK]    En el inicio se emitio 0 guias
  [OK]    Las guias tienen folios asignados (no nulos)
  [OK]    Los folios generados son distintos entre si
  [OK]    Los folios tienen numeracion consecutiva (-1 y -2)
  [OK]    El contador global marca 2 guias emitidas
  [OK]    La guia local no se marca como foranea
  [OK]    La guia hacia otra ciudad si se marca como foranea
  [OK]    Al inicio ninguna de las dos guias es auto-envio
  [OK]    El costo de la guia foranea incluye los $80 extra respecto a la local
  [OK]    cambiarDestinatario devuelve false si recibe null
  [OK]    cambiarDestinatario actualiza al destinatario y detecta auto-envio
>>> PARTE 4: SIMULACION DE ENVIOS, CLONACION DE GUIA Y RETORNO

================================================================================
  RESUMEN DE PRUEBAS: 19 / 19 pruebas superadas con exito
================================================================================

```

### 2. Ejemplo de ejecución interactiva (`MenuPostal`)
Copia y pega aquí un ejemplo sencillo de interacción en terminal ejecutando `MenuPostal`:

```text
[================================================================
  SISTEMA INTERACTIVO DE GUIAS POSTALES | ICC 2027-1
================================================================


--- MENU PRINCIPAL ---
1. Emitir nueva guia de envio
2. Clonar guia activa con un nuevo paquete (mismo remitente y destinatario)
3. Clonar paquete de la guia activa para enviarlo a otro destinatario
4. Generar guia de retorno (devolucion al remitente)
5. Mostrar detalle y costo de la guia activa
6. Salir
Seleccione una opcion: 1

--- Captura de datos del REMITENTE ---
  Identificador corto (ej. PER-01): PER-01
  Nombre completo: Fulano
  Ciudad / Ubicacion: CDMX

--- Captura de datos del DESTINATARIO ---
  Identificador corto (ej. PER-01): PER-02
  Nombre completo: Merengano
  Ciudad / Ub…]
```

---

## Preguntas de reflexión 

1. **¿En qué se diferencia clonar un `Paquete` (`new Paquete(kitBase)`) de clonar una guía de `Envio` (`new Envio(guiaBase, nuevoPaquete)`) respecto a qué objetos se comparten y cuáles se duplican en memoria?**
   > [Para crear un paquete clonado, solo se tiene que meter en parámetros el paquete que quieres clonar para que copie sus atributos, mientras que para clonar una guía, necesitamos la guía que queremos copiar, y aparte un objeto paquete. ]

2. **Para generar el `folioGuia` con un número consecutivo global y consultar cuántas guías se han emitido en total, ¿qué modificador tuviste que utilizar en ese atributo y en su método de consulta? ¿Por qué no funcionaría si el contador fuera un atributo normal de instancia?**
   > [Fue un método estático, para que al momento de crear una guía se vaya actualizando, y no se vaya creando uno nuevo por cada guía que se haga. Si fuera un atributo normal, cada guía tendría su propio contador de guías, y lo que queremos es ir contando cuantas guías se van creando.]

3. **Si una guía `envio1` se descarta (`envio1 = null;`), ¿qué ocurre en memoria con los objetos `Persona` (remitente/destinatario) y `Paquete` que estaban asociados a ella?**
   > [Sobreviven, ya que Persona Y Paquete no dependen de la clase Envio para poder existir, y lo que haría en null solo es vaciar el envio, no los otros dos objetos.]