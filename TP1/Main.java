import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AgendaContactos agenda = new AgendaContactos();
        JFrame ventana = new JFrame("Agenda de Contactos");
        JPanel panel = new JPanel(new FlowLayout());

        JButton botonAgregar = new JButton("Agregar");
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agenda.agregarContacto();
            }
        });
        panel.add(botonAgregar);

        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agenda.buscarContactoNombre();
            }
        });
        panel.add(botonBuscar);

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
        panel.add(botonActualizar);

        JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agenda.eliminarContacto();
            }
        });
        panel.add(botonEliminar);

        JButton botonMostrar = new JButton("Mostrar");
        botonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agenda.mostrarAgenda();
            }
        });
        panel.add(botonMostrar);

        ventana.add(panel);
        ventana.setSize(350,350);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
