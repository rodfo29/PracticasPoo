/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package PracticaPersonajes;

import javax.swing.JOptionPane;
import java.util.Arrays;

/**
 *
 * @author labbd-14
 */
public class Mago extends Personaje{
    private String[] hechizos;
    private int cantHechizos;


    public Mago(String nombre,String raza,int fuerza,int inteligencia,int maxHp){
        super(nombre,raza,fuerza,inteligencia,maxHp);
        this.hechizos=new String[4];
        this.cantHechizos=0;

    }


    public void setArray(String[] array){
        this.hechizos=array;
    }

    public void lanzaHechizo(Personaje enemigo){
//         Validamos que el mago tenga disponibles hechizos.
        if (cantHechizos==0){
            JOptionPane.showMessageDialog(null,"El mago no tiene hechizos disponibles, agregar nuevos hechizos.....","No hay hechizos disponibles",JOptionPane.WARNING_MESSAGE);
            return;
        }

        String cadenaHechizos="";

        // Iteramos los hechizos y los concatenamos a la variable de cadenaHechizos.
        for (int i=0;i<this.hechizos.length;i++){
            if (this.hechizos[i]!=null){
            cadenaHechizos+=this.hechizos[i] +   " -> N.Identificador: "   +   (i+1) +"\n ";
            }
        }
        // Añadimos la parte final para poder dar un buen formato a la hora de elegir el hechizo.
        cadenaHechizos+="\n\nEscribir Identificador del hechizo.";

        System.out.println(cadenaHechizos);

        while(true){
            int hechizoSeleccionado=Integer.parseInt(JOptionPane.showInputDialog(cadenaHechizos));

            // El identificador (índice) no cumple con las restricciones del tamaño del array.
            if ((hechizoSeleccionado-1)<0 || (hechizoSeleccionado-1)>3 ){
                JOptionPane.showMessageDialog(null,"El identificador Sobrepasa el rango disponible. Ingresar identificador válido","Hechizo Index Error",JOptionPane.ERROR_MESSAGE);
                continue; // Pasamos a la siguiente iteración.
            }

            // El identificador (indice) corresponde un hechizo no disponible (null)
            if (hechizos[hechizoSeleccionado-1] == null){
                JOptionPane.showMessageDialog(null,"El identificador corresponde a un hechizo no disponible.","Hechizo no disponible.",JOptionPane.WARNING_MESSAGE);
                continue; // Pasamos a la siguiente iteración.
            }


            // Actualizamos la vida del enemigo (-10)
            enemigo.setHp(-10);
            JOptionPane.showMessageDialog(null,"Atacante: " + this.getNombre() +
                    "\nEnemigo: "  +   enemigo.getNombre()  +   "\nAtaque Recibido:  "  +   hechizos[hechizoSeleccionado-1] +
                    "\nDaño Recibido: 10 attks" +
                    "\nVida Actual Enemigo: " + enemigo.getHp()  );

            // Eliminamos el hechizo utilizado
            hechizos[hechizoSeleccionado-1]=null;
            cantHechizos--;
            break;






        }





    }



    public void aprendeHechizo(String hechizoNuevo){
        if (cantHechizos==4){
            JOptionPane.showMessageDialog(null,"Se han alcanzado el numero máximo de hechizos","Numero máximo de hechizos",JOptionPane.WARNING_MESSAGE);
            return;
        }

        this.hechizos[cantHechizos]=hechizoNuevo;
        cantHechizos++;
    }



    @Override
    public void infoPersonaje() {
        String mensaje="Nombre: "   +   this.getNombre()
                + "\nRaza: "    +   this.getRaza()
                + "\nFuerza: "  +   this.getFuerza()
                + "\nInteligencia: "    +   this.getInteligencia()
                + "\nVida actual: " +   this.getHp()
                + "\nHechizos disponibles: "    + Arrays.toString(this.hechizos);

        JOptionPane.showMessageDialog(null,mensaje,"Inforamción Mago",JOptionPane.DEFAULT_OPTION);

    }

}
