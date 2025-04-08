import PracticaPersonajes.Clerigo;
import PracticaPersonajes.Mago;
import PracticaPersonajes.Personaje;
import Ventanas.VentanaMenu;

import javax.swing.*;
import java.util.ArrayList;


public class Main {
        public static void main(String[] args) {




            ArrayList<Personaje> personajes=new ArrayList<Personaje>();
            VentanaMenu menu= new VentanaMenu();
//            Mago mago1=new Mago("Martín","Humano",10,20,100);
//
//
//
//            personajes.add(new Clerigo("Ramos","Humano",10,20,100,"oggun"));
//            personajes.add(new Clerigo("Ramos","Humano",10,20,100,"legua"));
//            Clerigo clerigo=(new Clerigo("Abdul","Humano",10,20,100,"Batala"));
//            clerigo.infoPersonaje();



            menu.mostrarVentana(personajes);









        }
}