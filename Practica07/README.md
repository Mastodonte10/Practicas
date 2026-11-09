# Práctica 7: Introducción a la Programación Orientada a Objetos
**Introducción a las Ciencias de la Computación (Semestre 2027-1)**  
**Facultad de Ciencias, UNAM**

---

## Datos del alumno

> **Nota de privacidad:** Si publicas tu proyecto en un repositorio público de GitHub, **no es necesario que incluyas esta sección**  en este archivo para proteger tu privacidad. Es suficiente con que tus datos completos estén registrados en el reporte PDF adjuntado directamente en Google Classroom.

- **Nombre completo:** López Pérez Luis Ángel
- **Número de cuenta:** [Escribe aquí tu número de cuenta]
- **Correo institucional:** [tu_correo@ciencias.unam.mx]

---

## Descripción del proyecto
El proyecto modela el sistema de una empresa de entrega de paquetes. La clase `Paquete` representa un paquete con su código de rastreo, peso, dimensiones (alto, ancho y largo) y valor declarado, valida sus datos en los constructores y setters, y calcula su peso volumétrico y su peso cobrable. Como propuesta personal agrega el atributo `esExpres` y el método `calculaRecargoExpres`, que calcula un recargo del 30 % para envíos urgentes.

La clase `CotizadorEnvio` es una clase de utilería con métodos estáticos: valida si un paquete es válido (no nulo y con datos positivos), cotiza el envío con una tarifa escalonada por peso cobrable y determina si el paquete requiere seguro obligatorio (valor declarado mayor a $3,000.00 o sobredimensionado). Finalmente, `PruebaPaqueteria` instancia los paquetes de prueba y muestra los resultados en consola.

---

## Comandos para compilar, ejecutar y documentar

Escribe en las siguientes secciones los comandos que utilizaste desde la terminal (ubicado en la raíz de tu carpeta de trabajo):

### 1. Compilación
```bash
javac -encoding UTF-8 -d bin src/*.java
```

### 2. Ejecución
```bash
java -cp bin PruebaPaqueteria
```

### 3. Generación de documentación Javadoc
```bash
javadoc -encoding UTF-8 -charset UTF-8 -author -d doc src/*.java
```
