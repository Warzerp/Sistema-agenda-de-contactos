import javax.swing.*;
import java.util.ArrayList;

public class Contacto {
    String nombre;
    String numero;
    String correo;
    public Contacto(String nombre, String numero, String correo) {
        this.nombre = nombre;
        this.numero = numero;
        this.correo = correo;
    }
    public String getNombre(){ return nombre;}
    public String getNumero(){return numero;}
    public String getCorreo(){return correo;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setNumero(String numero) {this.numero = numero;}
    public void setCorreo(String correo) {this.correo = correo;}
}
class AgendaContactos{
    ArrayList<Contacto> agenda = new ArrayList<>();

    public void agregarContacto(){
        String nombre = JOptionPane.showInputDialog("Nombre");
        String numero = JOptionPane.showInputDialog("Numero");
        String correo = JOptionPane.showInputDialog("Correo");
        Contacto contacto = new Contacto(nombre, numero, correo);
        agenda.add(contacto);
    }
    public void mostrarAgenda(){
        for (Contacto contacto : agenda){
            System.out.println(contacto.getNombre() + ", " + contacto.getNumero()
                    + ", " + contacto.getCorreo());
        }
    }
    public void buscarContactoNombre(){
        String nombre = JOptionPane.showInputDialog("Ingrese un nombre");
        for (Contacto contacto : agenda){
            if (contacto.getNombre().equalsIgnoreCase(nombre)){
                System.out.println(contacto.getNombre() + ", " + contacto.getNumero()
                        + ", " + contacto.getCorreo());
            }
        }
    }
    public void actualizarNombre(String nombre){
        String nuevoNombre = JOptionPane.showInputDialog("Nuevo Nombre");
        for (Contacto contacto : agenda){
            if (contacto.getNombre().equalsIgnoreCase(nombre)){
                contacto.setNombre(nuevoNombre);
            }
        }
    }
    public void actualizarNumero(String nombre){
        String nuevoNumero = JOptionPane.showInputDialog("Numero Nuevo");
        for (Contacto contacto : agenda){
            if (contacto.getNombre().equalsIgnoreCase(nombre)){
                contacto.setNumero(nuevoNumero);
            }
        }
    }
    public void actualizarCorreo(String nombre){
        String nuevoCorreo = JOptionPane.showInputDialog("Correo Nuevo");
        for (Contacto contacto : agenda){
            if (contacto.getNombre().equalsIgnoreCase(nombre)){
                contacto.setCorreo(nuevoCorreo);
            }
        }
    }
    public void eliminarContacto(){
        String nombre = JOptionPane.showInputDialog("Ingrese un nombre");
        for (int i=0; i< agenda.size(); i++){
            if (agenda.get(i).getNombre().equalsIgnoreCase(nombre)){
                agenda.remove(i);
            }
        }
    }
    public void acercaDe(){
        JFrame infoVentana = new JFrame("Acerca De");
        JPanel panel = new JPanel();
        panel.add(new JLabel("Accel Contact - 'Agenda hoy, contacta mañana'"));
        panel.add(new JLabel("Equipo de Desarrollo:"));
        panel.add(new JLabel("Product Owner: Mauricio Gonzalez"));
        panel.add(new JLabel("Scrum Master: Jhon Mantilla"));
        panel.add(new JLabel("Equipo de Desarrollo: Juan Moreno, Luis Viloria"));
        panel.add(new JLabel("Ver 1.0.0"));
        infoVentana.add(panel);
        infoVentana.setSize(300,300);
        infoVentana.setResizable(false);
        infoVentana.setVisible(true);
    }
}
