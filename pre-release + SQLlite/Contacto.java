/**
 * Genera los contactos, así como la agenda donde se almacenan
 *
 * @author Mauricio Gonzalez & team
 * @version 2.0
 * @created 08/12/2024
 * @university Universidad de Pamplona
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Contacto {
    /**
     * Crea el contacto con su información y propiedades
     * @param nombre nombre del contacto
     * @param numero numero del contacto
     * @param correo correo del contacto
     */

    String nombre;
    String numero;
    String correo;

    public Contacto(String nombre, String numero, String correo) {
        this.nombre = nombre;
        this.numero = numero;
        this.correo = correo;
    }

    /**
     * Regresa el parámetro especificado
     * @return nombre
     * @return numero
     * @return correo
     */
    public String getNombre() { return nombre; }
    public String getNumero() { return numero; }
    public String getCorreo() { return correo; }

    /**
     * Asigna o modifica las propiedades de un contacto
     * @param nombre nombre del contacto
     * @param numero numero del contacto
     * @param correo correo del contacto
     */
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setNumero(String numero) { this.numero = numero; }
    public void setCorreo(String correo) { this.correo = correo; }
}

class AgendaContactos {
    /**
     * Genera un ArrayList donde se almacenan los contactos
     */
    ArrayList<Contacto> agenda = new ArrayList<>();

    public AgendaContactos() {
        crearTabla(); // Llama a crearTabla al iniciar la clase
    }

    /**
     * Crea la conexión a la base de datos
     */
    private Connection connect() {
        String url = "jdbc:sqlite:contactos.db"; // Ruta de la base de datos
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS contactos ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " nombre TEXT NOT NULL,"
                + " numero TEXT NOT NULL,"
                + " correo TEXT NOT NULL"
                + ");";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void agregarContactoBD(Contacto contacto) {
        String sql = "INSERT INTO contactos(nombre, numero, correo) VALUES(?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getNumero());
            pstmt.setString(3, contacto.getCorreo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Contacto> obtenerContactosBD() {
        ArrayList<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT nombre, numero, correo FROM contactos";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Contacto contacto = new Contacto(rs.getString("nombre"), rs.getString("numero"), rs.getString("correo"));
                contactos.add(contacto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return contactos;
    }

    public void eliminarContactoBD(String nombre) {
        String sql = "DELETE FROM contactos WHERE nombre = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void agregarContacto() {
        JFrame agregarVentana = new JFrame("Agregar");
        agregarVentana.setSize(300, 200);
        agregarVentana.setResizable(false);
        agregarVentana.setVisible(true);
        JPanel panel = new JPanel();
        JLabel nombre = new JLabel("Nombre:");
        nombre.setFont(new Font("Thomas", Font.ITALIC, 14));
        JTextField strNombre = new JTextField(15);
        panel.add(nombre);
        panel.add(strNombre);

        JLabel numero = new JLabel("Numero:");
        numero.setFont(new Font("Thomas", Font.ITALIC, 14));
        JTextField strNumero = new JTextField(15);
        panel.add(numero);
        panel.add(strNumero);

        JLabel correo = new JLabel("Correo:");
        correo.setFont(new Font("Thomas", Font.ITALIC, 14));
        JTextField strCorreo = new JTextField(15);
        panel.add(correo);
        panel.add(strCorreo);

        JButton guardar = new JButton("Guardar");
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contacto contacto = new Contacto(strNombre.getText(), strNumero.getText(), strCorreo.getText());
                agenda.add(contacto);
                agregarContactoBD(contacto); // Guardar en la base de datos
                agregarVentana.setVisible(false);
            }
        });
        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarVentana.setVisible(false);
            }
        });
        panel.add(guardar, BorderLayout.SOUTH);
        panel.add(cancelar, BorderLayout.SOUTH);

        agregarVentana.add(panel);
    }

    /**
     * Muestra por pantalla los contactos de la agenda
     * @param panel espacio gráfico donde se muestran los contactos
     */
    public void mostrarAgenda(JPanel panel) {
        agenda = obtenerContactosBD(); // Obtener contactos de la base de datos
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        for (Contacto contacto : agenda) {
            JLabel contactos = new JLabel(contacto.getNombre() + ", " + contacto.getNumero() + ", " + contacto.getCorreo());
            contactos.setFont(new Font("Letra", Font.BOLD, 16));
            panel.add(contactos);
        }
    }

    /**
     * Busca un contacto en específico
     */
    public void buscarContactoNombre() {
        String nombre = JOptionPane.showInputDialog("Ingrese un nombre");
        Ventana ventana = new Ventana();
        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                ventana.ventanaBuscar(contacto.getNombre(), contacto.getNumero(),
                        contacto.getCorreo());
            }
        }
    }

    /**
     * Modifica el nombre de un contacto ya existente
     * @param nombre nombre del contacto a modificar
     */
    public void actualizarNombre(String nombre) {
        String nuevoNombre = JOptionPane.showInputDialog("Nuevo Nombre");
        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                contacto.setNombre(nuevoNombre);
            }
        }
    }

    /**
     * Modifica el número de un contacto ya existente
     * @param nombre nombre del contacto a modificar
     */
    public void actualizarNumero(String nombre) {
        String nuevoNumero = JOptionPane.showInputDialog("Número Nuevo");
        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                contacto.setNumero(nuevoNumero);
            }
        }
    }

    /**
     * Modifica el correo de un contacto ya existente
     * @param nombre nombre del contacto a modificar
     */
    public void actualizarCorreo(String nombre) {
        String nuevoCorreo = JOptionPane.showInputDialog("Correo Nuevo");
        for (Contacto contacto : agenda) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                contacto.setCorreo(nuevoCorreo);
            }
        }
    }

    /**
     * Elimina a un contacto de la agenda
     */
    public void eliminarContacto() {
        String nombre = JOptionPane.showInputDialog("Ingrese un nombre");
        eliminarContactoBD(nombre); // Eliminar de la base de datos
        agenda.removeIf(contacto -> contacto.getNombre().equalsIgnoreCase(nombre)); // Eliminar de la lista
    }

    /**
     * Genera una ventana con información sobre el equipo
     * @param mainPanel interfaz de la ventana generada
     */
    public void acercaDe(JPanel mainPanel) {
        JFrame infoVentana = new JFrame("Acerca De");
        JPanel panel = new JPanel();
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("C:\\Users\\USUARIO\\IdeaProjects\\AccelContact\\out\\Imagen1.jpg"));
        panel.add(new JLabel("Accel Contact - 'Agenda hoy, contacta mañana'"));
        panel.add(new JLabel("Equipo de Desarrollo:"));
        panel.add(new JLabel("Product Owner: Mauricio Gonzalez"));
        panel.add(new JLabel("Scrum Master: Jhon Mantilla"));
        panel.add(new JLabel("Equipo de Desarrollo: Juan Moreno, Luis Viloria"));
        panel.add(new JLabel("Ver 1.0.0"));
        panel.add(logo);
        infoVentana.add(panel);
        infoVentana.setSize(300, 300);
        infoVentana.setResizable(false);
        infoVentana.setVisible(true);
    }
}