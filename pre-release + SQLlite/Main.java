/**
 * Este programa permite guardar y manejar contactos
 * @author Mauricio Gonzalez & team
 * @version 1.0
 * @created 08/12/2024
 * @university Universidad de Pamplona
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Main {
    /**
     * Crea la agenda y la interfaz grafica del programa
     */
    public static void main(String[] args) {
        AgendaContactos agenda = new AgendaContactos();
        Ventana ventana = new Ventana();
        ventana.ventanaPrincipal(agenda);
    }
}
