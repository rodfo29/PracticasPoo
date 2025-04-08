package PracticaPersonajes;

import javax.swing.*;
import java.util.Arrays;

public class Clerigo extends Personaje{
     private String dios;

     public Clerigo(String nombre,String raza,int fuerza,int inteligencia,int maxHp,String dios){
         super(nombre,raza,fuerza,inteligencia,maxHp);
         this.dios=dios;

    }





    public void curar(Personaje personaje){
        personaje.setHp(10); // Sumamos 10 puntos de vida al personaje indicado.
        JOptionPane.showMessageDialog(null,"El Clerigo (  "  +   this.getNombre()
        + " ) Ha curado a :  "   +   personaje.getNombre()   +   "\nCuración: +10 hp.","Curando personaje",JOptionPane.DEFAULT_OPTION);

     }


    public void setDios(String nuevoDios){
         this.dios=nuevoDios;
    }

    public String getDios(){
         return this.dios;
    }


     @Override
        public void infoPersonaje(){

         String mensaje="Nombre: "   +   this.getNombre()
                 + "\nRaza: "    +   this.getRaza()
                 + "\nFuerza: "  +   this.getFuerza()
                 + "\nInteligencia: "    +   this.getInteligencia()
                 + "\nVida actual: " +   this.getHp()
                 + "\nDios: "    + this.getDios();

         JOptionPane.showMessageDialog(null,mensaje,"Información Clerigo",JOptionPane.DEFAULT_OPTION);

     }




}
