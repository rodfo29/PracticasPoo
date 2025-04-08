package Ventanas;

import PracticaPersonajes.Clerigo;
import PracticaPersonajes.Mago;
import PracticaPersonajes.Personaje;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class VentanaClerigo extends JFrame {
    public VentanaClerigo(ArrayList<Personaje> personajes){
        // Crear la ventana
        setTitle("Ventana Clerigos");

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra esta ventana, pero no la aplicación completa.


        // Crear un panel (contenedor)
        JPanel panel = new JPanel();


        JButton crearClerigo= new JButton("Crear Clerigo");
        JButton curarAliado= new JButton("Curar Aliado");
        JButton infoClerigo= new JButton("Información Clerigo");


        panel.add(crearClerigo);
        panel.add(curarAliado);
        panel.add(infoClerigo);

        // Agregamos el panel
        add(panel);

        crearClerigo.addActionListener(e -> {
            crearClerigoVentana(personajes);
        });

        curarAliado.addActionListener(e -> {
            curarAliado(personajes);
        });

        infoClerigo.addActionListener(e -> {
            infoClerigoVentana(personajes);
        });
    }


    public void crearClerigoVentana(ArrayList<Personaje> personajes) {
        while (true) {
            String nombre = JOptionPane.showInputDialog(null, "Ingresar nombre del mago: ");
            String raza = JOptionPane.showInputDialog(null, "Ingresar Raza del mago: ");

            int fuerza = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar fuerza (>=18) : "));
            if (fuerza < 18) {
                JOptionPane.showMessageDialog(null, "La fuerza ingresada es menor a 18.", "Valor No Aceptado", JOptionPane.WARNING_MESSAGE);
                continue;
            }

            int inteligencia = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa inteligencia (12 - 16) : "));
            if (inteligencia < 12 || inteligencia>16) {
                JOptionPane.showMessageDialog(null, "La inteligencia Ingresada no es aceptada.", "Valor Ingresado No Válido", JOptionPane.WARNING_MESSAGE);
                continue;
            }


            int hpMax = Integer.parseInt(JOptionPane.showInputDialog("Ingresar Hp Máxima: "));
            if (hpMax > 100 || hpMax < 0) {
                JOptionPane.showMessageDialog(null, "La Vida máxima ingresada no es aceptada.");
                continue;
            }
            String dios=JOptionPane.showInputDialog("Ingresar nombre del dios: ");
            Clerigo clerigoNuevo=new Clerigo(nombre,raza,fuerza,inteligencia,hpMax,dios);
            personajes.add(clerigoNuevo);

            break;
        }

    }


    public void curarAliado(ArrayList<Personaje>personajes){
        int i=0;
        String text="";

        for(Personaje personaje:personajes){
            if (personaje instanceof Clerigo){
                text+= "Identificador: "    +   (i+1)  +    " -> "  +        personaje.getNombre()+"\n";
                i++;
                continue;
            }

            i++;
        }
        text+="\n\nIngresar Identificador del clerigo";

        int resp;
        while(true){
            resp=Integer.parseInt(JOptionPane.showInputDialog(text));
            if ((resp-1)<0 || (resp-1)>(i-1) || (!(personajes.get(resp-1) instanceof Clerigo))){
                JOptionPane.showMessageDialog(null,"El Identificador ingresado no es correcto.");
                continue;
            }

            break;
        }

        // Buscamos al enemigo a curar
        i=0;
        text="";

        for (Personaje personaje:personajes){

            // El mago seleccionado no se mostrará como una optión disponible en el listado de enemigos.
            if (i==(resp-1)){ // resp= 3
                i++;
                continue;
            }

            text+= (i+1)+ ") "    +   personaje.getNombre()+"\n";
            i++; // Al salir del bucle el índice tiene la cantidad de objetos. No sirve para luego hacer comparaciones de posición.

        }
        text+="\n\nIngresar numero del Aliado a curar.";

        int resp2;
        while(true){
            resp2=Integer.parseInt(JOptionPane.showInputDialog(null,text,"Curar Aliado",JOptionPane.DEFAULT_OPTION));
            if ((resp2-1)<0  || (resp2-1) > (i-1) ||  (resp2-1)==(resp-1)){ // si la respuesta anterior coincide con la actual no podemos seleccionar al mismo mago.
                // Si queremos hacer comparaciones usando el índice real del último elemento, debemos usar ( i - 1 ). Al final lo que queremos es que el índice real exista en el array.
                JOptionPane.showMessageDialog(null,"Ingresar número válido.","Índice Inválido",JOptionPane.WARNING_MESSAGE);
                continue;
            }
            break;
        }

        Clerigo clerigo=(Clerigo)personajes.get(resp-1);

        clerigo.curar(personajes.get(resp2-1));




    }

    public void infoClerigoVentana(ArrayList<Personaje>personajes){
        int i=0;
        String text="";
        for(Personaje personaje:personajes){
            if (personaje instanceof Clerigo){
                text+= "Identificador: "    +   (i+1)  +    " -> "  +        personaje.getNombre()+"\n";
                i++;
                continue;
            }
            i++;
        }
        text+="\n\nIngresar Identificador del Clerigo";

        int resp;
        while (true){
            resp=Integer.parseInt(JOptionPane.showInputDialog(null,text,"Información Mago",JOptionPane.DEFAULT_OPTION));

            if ((resp-1)<0 || (resp-1)>(i-1) || (   !(personajes.get(resp-1) instanceof Clerigo)  ) ){
                JOptionPane.showMessageDialog(null,"Identificador inválido.");
                continue;
            }

            break;


        }

        Clerigo clerigoNuevo=(Clerigo)personajes.get(resp-1);
        clerigoNuevo.infoPersonaje();

    }



}
