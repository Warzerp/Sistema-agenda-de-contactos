import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        AgendaContactos agenda = new AgendaContactos();
        JFrame ventana = new JFrame("Agenda de Contactos");
        ventana.setLayout(null);
        JPanel mainPanel = new JPanel();
        mainPanel.add(new JLabel("Bienvenido a tu Agenda de Contactos -"));
        mainPanel.add(new JLabel("Accel Contact"));
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
                agenda.mostrarAgenda();
            }
        });
        panel2.add(botonMostrar);

        JButton botonAcerdaDe = new JButton("Acerca De");
        botonAcerdaDe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agenda.acercaDe();
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
}
