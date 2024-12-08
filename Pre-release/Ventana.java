/**
 * Crea las interfaces y ventanas del programa
 *
 * @author Mauricio Gonzalez & team
 * @since 0.2
 * @created 08/12/2024
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    /**
     * Crear la ventana principal y todas sus funciones
     * @param agenda la agenda donde estan los contactos
     */
    public void ventanaPrincipal(AgendaContactos agenda){
        JFrame ventana = new JFrame("Agenda de Contactos");
        ventana.setLayout(null);
        JPanel mainPanel = new JPanel();
        JLabel bienvenida = new JLabel("Bienvenido a tu Agenda de Contactos");
        JLabel compania = new JLabel("Accel Contact");
        JLabel logo = new JLabel();
        bienvenida.setFont(new Font("Comic sans", Font.BOLD,20));
        compania.setFont(new Font("Comic sans", Font.BOLD,20));
        logo.setIcon(new ImageIcon("C:\\Users\\USUARIO\\IdeaProjects\\AccelContact\\out\\logo.jpg"));
        mainPanel.add(bienvenida);
        mainPanel.add(compania);
        mainPanel.add(logo);
        mainPanel.setBounds(300,75,400,400);

        JPanel panel2 = new JPanel(new GridLayout(6,1));
        panel2.setBounds(0,0,200,565);

        JButton botonAgregar = new JButton("Agregar");
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agenda.agregarContacto();
            }
        });
        panel2.add(botonAgregar);

        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agenda.buscarContactoNombre();
            }
        });
        panel2.add(botonBuscar);

        JButton botonActualizar = new JButton("Actualizar");
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion = JOptionPane.showInputDialog("¿Que quieres actualizar?");
                String persona = JOptionPane.showInputDialog("¿De quien?");
                if (seleccion.equalsIgnoreCase("Nombre")){
                    agenda.actualizarNombre(persona);
                }else if (seleccion.equalsIgnoreCase("Numero")){
                    agenda.actualizarNumero(persona);
                }else if (seleccion.equalsIgnoreCase("Correo")){
                    agenda.actualizarCorreo(persona);
                }
            }
        });
        panel2.add(botonActualizar);

        JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agenda.eliminarContacto();
            }
        });
        panel2.add(botonEliminar);

        JButton botonMostrar = new JButton("Mostrar");
        botonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agenda.mostrarAgenda(mainPanel);
            }
        });
        panel2.add(botonMostrar);

        JButton botonAcerdaDe = new JButton("Acerca De");
        botonAcerdaDe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana ventana = new Ventana();
                mainPanel.removeAll();
                mainPanel.revalidate();
                mainPanel.repaint();
                ventana.ventanaDeInicio(mainPanel);
                agenda.acercaDe(mainPanel);
            }
        });
        panel2.add(botonAcerdaDe);

        ventana.add(panel2);
        ventana.add(mainPanel);
        ventana.setResizable(false);
        ventana.setSize(800,600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
    public void ventanaDeInicio(JPanel panel){
        /**
         * Modifica la interfaz principal
         * @param panel objeto grafico que muestra informacion
         */
        JLabel bienvenida = new JLabel("Bienvenido a tu Agenda de Contactos");
        JLabel compania = new JLabel("Accel Contact");
        JLabel logo = new JLabel();
        bienvenida.setFont(new Font("Comic sans", Font.BOLD,20));
        compania.setFont(new Font("Comic sans", Font.BOLD,20));
        logo.setIcon(new ImageIcon("C:\\Users\\USUARIO\\IdeaProjects\\AccelContact\\out\\logo.jpg"));
        panel.add(bienvenida);
        panel.add(compania);
        panel.add(logo);
        panel.setBounds(300,75,400,400);
    }
    public void ventanaBuscar(String nombre, String numero, String correo){
        /**
         * Genera una ventana para la funcion "Buscar Contacto"
         *
         * @param nombre El nombre del contacto a buscar
         * @param numero El numero del contacto a buscar
         * @param correo El correo del contacto a buscar
         */
        JFrame ventanaBuscar = new JFrame("Buscar");
        JPanel panel = new JPanel();
        JLabel contNombre = new JLabel(nombre);
        JLabel contNumero = new JLabel(numero);
        JLabel contCorreo = new JLabel(correo);
        panel.add(contNombre);
        panel.add(contNumero);
        panel.add(contCorreo);

        ventanaBuscar.add(panel);
        ventanaBuscar.setSize(300,200);
        ventanaBuscar.setResizable(false);
        ventanaBuscar.setVisible(true);
    }
}
