# Agenda de Contactos

Este proyecto es una aplicación de escritorio en Java que permite gestionar una agenda de contactos. Los usuarios pueden agregar, buscar, actualizar y eliminar contactos de manera sencilla utilizando una interfaz gráfica.

## Características

- **Agregar Contacto**: Permite al usuario ingresar un nuevo contacto con nombre, número y correo electrónico.
- **Buscar Contacto**: Permite buscar un contacto por su nombre y mostrar sus detalles.
- **Actualizar Contacto**: Permite actualizar el nombre, número o correo electrónico de un contacto existente.
- **Eliminar Contacto**: Permite eliminar un contacto de la agenda.
- **Mostrar Agenda**: Muestra todos los contactos almacenados en la agenda.

## Clases del Proyecto

### Contacto

**Descripción**: Esta clase representa un contacto en la agenda.

- **Atributos**:
  - `String nombre`: El nombre del contacto.
  - `String numero`: El número de teléfono del contacto.
  - `String correo`: La dirección de correo electrónico del contacto.

- **Métodos**:
  - `String getNombre()`: Devuelve el nombre del contacto.
  - `void setNombre(String nombre)`: Establece el nombre del contacto.
  - `String getNumero()`: Devuelve el número de teléfono del contacto.
  - `void setNumero(String numero)`: Establece el número de teléfono del contacto.
  - `String getCorreo()`: Devuelve la dirección de correo electrónico del contacto.
  - `void setCorreo(String correo)`: Establece la dirección de correo electrónico del contacto.

### Agenda

**Descripción**: Esta clase gestiona la colección de contactos.

- **Atributos**:
  - `List<Contacto> contactos`: Una lista que almacena todos los contactos.

- **Métodos**:
  - `void agregarContacto(Contacto contacto)`: Agrega un nuevo contacto a la agenda.
  - `Contacto buscarContacto(String nombre)`: Busca un contacto por su nombre y devuelve el objeto `Contacto` correspondiente.
  - `void actualizarContacto(Contacto contacto)`: Actualiza la información de un contacto existente.
  - `void eliminarContacto(String nombre)`: Elimina un contacto de la agenda por su nombre.
  - `List<Contacto> mostrarAgenda()`: Devuelve una lista de todos los contactos en la agenda.

### Main

**Descripción**: Esta clase contiene el método principal que inicia la aplicación.

- **Métodos**:
  - `public static void main(String[] args)`: Método principal que inicializa la interfaz gráfica y la lógica de la aplicación.

## Requisitos

- Java Development Kit (JDK) 8 o superior.
- Un entorno de desarrollo integrado (IDE) como Eclipse, IntelliJ IDEA o NetBeans (opcional, pero recomendado).
- Libreria necesaria para el proyecto: SQLLite https://github.com/xerial/sqlite-jdbc/releases

## Instalación de Community JDK

Sigue estos pasos para instalar el Community JDK:

1. **Descargar el JDK**:
   - Ve al sitio web oficial de [Adoptium](https://adoptium.net/) o [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
   - Selecciona la versión de JDK que deseas descargar (recomendamos la última versión estable).

2. **Instalar el JDK**:
   - Ejecuta el instalador descargado y sigue las instrucciones en pantalla.
   - Asegúrate de seleccionar la opción para agregar el JDK a la variable de entorno `PATH` durante la instalación.

3. **Verificar la instalación**:
   - Abre una terminal o símbolo del sistema.
   - Escribe el siguiente comando y presiona Enter:
     ```bash
     java -version
     ```
   - Deberías ver la versión de Java instalada.

## Instalación del Proyecto

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/tu_usuario/agenda-contactos.git
