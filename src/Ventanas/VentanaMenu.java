package Ventanas;
import javax.swing.*;
import java.util.ArrayList;
import PracticaPersonajes.Personaje;

// Al extender de Jframe por si misma ya la clase es una ventana,
public class VentanaMenu extends JFrame {
        VentanaMagos ventanaMagos;

    public void mostrarVentana(ArrayList<Personaje> personajes){
        // Crear la ventana
        setTitle("Menú Principal");

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creamos las ventanas del menú
        VentanaMagos ventanaMagos=new VentanaMagos(personajes);
        VentanaClerigo ventanaClerigo=new VentanaClerigo(personajes);

        // Crear un panel (contenedor)
        JPanel panel = new JPanel();



        JButton botonMenuMagos = new JButton("Menu Magos");

        JButton botonMenuClerigos = new JButton("Menu Clérigos");


        panel.add(botonMenuMagos);
        panel.add(botonMenuClerigos);

        setVisible(true);

        add(panel);
        // Acción del botón
        botonMenuMagos.addActionListener(e -> {
            ventanaMagos.setVisible(true);
//            String nombre = campoTexto.getText();
//            JOptionPane.showMessageDialog(this, "Hola, " + nombre + "!");
        });

        botonMenuClerigos.addActionListener(e -> {
            ventanaClerigo.setVisible(true);
        });


    }
}
