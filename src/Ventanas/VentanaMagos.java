package Ventanas;

import PracticaPersonajes.Mago;
import PracticaPersonajes.Personaje;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;




public class VentanaMagos extends JFrame{
    public VentanaMagos(ArrayList<Personaje> personajes){
        // Crear la ventana
        setTitle("Ventana Magos");

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra esta ventana, pero no la aplicación completa.


        // Crear un panel (contenedor)
        JPanel panel = new JPanel();

        JButton crearMagoButton= new JButton("Crear Mago");
        JButton aprenderHechizoButton= new JButton("Aprender Hechizo");
        JButton lanzarHechizoButton= new JButton("Lanzar Hechizo");
        JButton infoMagoButton= new JButton("Información Mago");

        panel.add(crearMagoButton);
        panel.add(aprenderHechizoButton);
        panel.add(lanzarHechizoButton);
        panel.add(infoMagoButton);

        // Agregamos el panel
        add(panel);

        // Botones
        crearMagoButton.addActionListener(e -> {
            crearMagoVentana(personajes);
        });

        lanzarHechizoButton.addActionListener(e -> {
            lanzarHechizoVentana(personajes);

        });

        aprenderHechizoButton.addActionListener(e -> {
            aprenderHechizoVentana(personajes);
        });

        infoMagoButton.addActionListener(e -> {
            infoMagoVentana(personajes);

        });



    }

    public void crearMagoVentana(ArrayList<Personaje> personajes){
        while (true){
            String nombre= JOptionPane.showInputDialog(null,"Ingresar nombre del mago: ");
            String raza=JOptionPane.showInputDialog(null,"Ingresar Raza del mago: ");

            int fuerza=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresar fuerza (<=15) : "));
            if (fuerza>15){
                JOptionPane.showMessageDialog(null,"La fuerza ingresada es mayor a 15.","Valor No Aceptado",JOptionPane.WARNING_MESSAGE);
                continue;
            }

            int inteligencia=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa inteligencia (>=17) : "));
            if (inteligencia<17){
                JOptionPane.showMessageDialog(null,"La inteligencia Ingresada no es aceptada.","Valor Ingresado No Válido",JOptionPane.WARNING_MESSAGE);
                continue;
            }


            int hpMax=Integer.parseInt(JOptionPane.showInputDialog("Ingresar Hp Máxima: "));
            if (hpMax>100||hpMax<0){
                JOptionPane.showMessageDialog(null,"La Vida máxima ingresada no es aceptada.");
                continue;
            }

            Mago nuevoMago=new Mago(nombre,raza,fuerza,inteligencia,hpMax);
            personajes.add(nuevoMago);

            break; // En caso de que todos los datos sean ingresados de manera correcta salimos de bucle.
        }


    }



    public void lanzarHechizoVentana(ArrayList<Personaje> personajes){
        String text="";
        int i=0;

        // Solicitamos al mago atacante
        for (Personaje personaje:personajes){
            if (personaje instanceof Mago){
            text+= "Identificador: "    +   (i+1)  +    " -> "  +        personaje.getNombre()+"\n";
            i++;
            continue;
            }
            i++;

        }





        text+="\n\nIngresar numero del Mago atacante.";

        int resp; // (resp-1) índice del Mago atacante.
        while (true){
            resp=Integer.parseInt(JOptionPane.showInputDialog(null,text,"Personajes",JOptionPane.DEFAULT_OPTION));
            if ((resp-1)<0  || (resp-1) > (i-1) || (!(personajes.get(resp-1) instanceof Mago))){ // si no cumple los límites de los índices o no es instancia de mago.
                JOptionPane.showMessageDialog(null,"Ingresar número válido.","Índice Inválido",JOptionPane.WARNING_MESSAGE);
                continue;
            }
            break;
        }



        // Solicitamos al mago enemigo
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


        text+="\n\nIngresar numero del Enemigo.";


        int resp2; // (resp2-1) Índice del enemigo.


        while (true){
            resp2=Integer.parseInt(JOptionPane.showInputDialog(null,text,"Enemigos",JOptionPane.DEFAULT_OPTION));
            if ((resp2-1)<0  || (resp2-1) > (i-1) ||  (resp2-1)==(resp-1)){ // si la respuesta anterior coincide con la actual no podemos seleccionar al mismo mago.
                    // Si queremos hacer comparaciones usando el índice real del último elemento, debemos usar ( i - 1 ). Al final lo que queremos es que el índice real exista en el array.
                JOptionPane.showMessageDialog(null,"Ingresar número válido.","Índice Inválido",JOptionPane.WARNING_MESSAGE);
                continue;
            }
            break;
        }

        // Casteamos al mago seleccionado para realizar el ataque.
        Mago magoAtacante=(Mago)personajes.get(resp-1);
        magoAtacante.lanzaHechizo(personajes.get(resp2-1)); // Le pasamos como argumento al enemigo que seleccionaron.


        // Verificamos si la salud del enemigo llegó a cero para eliminarlo del ArrayList.
         i=0;
        for(Personaje personaje:personajes){

            if (personaje.getHp()==0){

                JOptionPane.showMessageDialog(null,"El Enemigo: "   +   personaje.getNombre() + " Ha sido eliminado\n","Eliminando enemigo",JOptionPane.WARNING_MESSAGE);

                personajes.remove(i); // La i en está indicando la posición actual del

            }

            i++;

        }
    }

    public void aprenderHechizoVentana(ArrayList<Personaje> personajes){

        int i=0;
        String text="";
        for(Personaje personaje:personajes){
            if (personaje instanceof Mago){
                text+= "Identificador: "    +   (i+1)  +    " -> "  +        personaje.getNombre()+"\n";
                i++;
                continue;
            }
            i++;
        }
        text+="\n\nIngresar Identificador del mago a Entrenar.";
        int resp;
        while(true){
            resp=Integer.parseInt(JOptionPane.showInputDialog(null,text,"Aprender hechizo",JOptionPane.DEFAULT_OPTION));
            if ((resp-1)<0 || (resp-1)>(i-1) || (   !(personajes.get(resp-1) instanceof Mago)  ) ){
                JOptionPane.showMessageDialog(null,"Identificador inválido.");
                continue;
            }
            break;
        }

        Mago mago=(Mago)personajes.get(resp-1);
        String nuevoHechizo=JOptionPane.showInputDialog("Ingresar Nombre del hechizo.");
        mago.aprendeHechizo(nuevoHechizo);



    }

    public void infoMagoVentana(ArrayList<Personaje> personajes){
        int i=0;
        String text="";

        for(Personaje personaje:personajes){
            if (personaje instanceof Mago){
                text+= "Identificador: "    +   (i+1)  +    " -> "  +        personaje.getNombre()+"\n";
                i++;
                continue;
            }
            i++;
        }

        text+="\n\nIngresar Identificador del mago.";

        int resp;

        while(true){
            resp=Integer.parseInt(JOptionPane.showInputDialog(null,text,"Información Mago",JOptionPane.DEFAULT_OPTION));

            if ((resp-1)<0 || (resp-1)>(i-1) || (   !(personajes.get(resp-1) instanceof Mago)  ) ){
                JOptionPane.showMessageDialog(null,"Identificador inválido.");
                continue;
            }


            break;

        }

        // Mostramos la información del mago seleccionado.
        Mago mago=(Mago)personajes.get(resp-1);
        mago.infoPersonaje();






    }















}
