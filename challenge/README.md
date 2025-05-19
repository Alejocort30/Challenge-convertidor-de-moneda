# Conversor de Monedas - Challenge Java

Este proyecto es un **conversor de monedas** desarrollado en Java como parte de un desafío de aprendizaje. Permite convertir montos de USD a varias monedas latinoamericanas y europeas, utilizando tasas de cambio obtenidas en tiempo real desde una API.

## Características

- Menú interactivo en consola para seleccionar la moneda de destino.
- Conversión de USD a: EUR, BRL, JPY, COP, MXN, ARS, CLP.
- Consulta de tasas de cambio en tiempo real usando [ExchangeRate-API](https://www.exchangerate-api.com/).
- Uso de las librerías externas **Gson** (para analizar JSON) y **HttpClient** (para consumir la API).
- Permite realizar múltiples conversiones hasta que el usuario decida salir.

## Requisitos

- Java 11 o superior.
- Archivo `gson-2.10.1.jar` en la carpeta del proyecto.

## Instalación y ejecución desde CMD

1. Descarga o clona este repositorio.
2. Descarga el archivo [`gson-2.10.1.jar`](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar) y colócalo en la carpeta del proyecto.
3. Abre la terminal (CMD) y navega a la carpeta del proyecto con:
   ```
   cd ruta\a\tu\proyecto\challenge
   ```
4. Compila el programa con:
   ```
   javac -cp .;gson-2.10.1.jar challenge.java
   ```
5. Ejecuta el programa con:
   ```
   java -cp .;gson-2.10.1.jar challenge
   ```

## Ejecución en IntelliJ IDEA

1. Crea un nuevo proyecto Java en IntelliJ.
2. Copia el archivo `challenge.java` y `gson-2.10.1.jar` a la carpeta del proyecto.
3. Ve a **File > Project Structure > Libraries** y agrega `gson-2.10.1.jar` como dependencia.
4. Ejecuta la clase `challenge` como aplicación Java.

## Uso

1. Al iniciar, verás un menú con las monedas disponibles.
2. Selecciona la moneda de destino ingresando el número correspondiente.
3. Ingresa el monto en USD que deseas convertir.
4. El programa mostrará el resultado de la conversión.
5. Puedes realizar tantas conversiones como desees o salir seleccionando la opción "Salir".

## Sobre la API

- Este programa utiliza la [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tasas de cambio en tiempo real.
- La conversión siempre se realiza **de USD a la moneda seleccionada**.
- Si deseas convertir entre otras monedas, primero deberás convertir a USD y luego a la moneda destino.

## Ejemplo de uso

```
Sea bienvenido/a al Conversor de Moneda

Opciones de monedas para convertir:
1. USD
2. EUR
3. BRL
4. JPY
5. COP
6. MXN
7. ARS
8. CLP
9. Salir
Elija una opción: 5
Ingrese el monto en USD a convertir: 100
100 USD equivale a 390000 COP
```

## Créditos

- Desarrollado por David Alejandro Cortes Sepulveda.
- Inspirado en el desafío de conversor de monedas de Alura Latam.

---

¡Gracias por probar este proyecto!