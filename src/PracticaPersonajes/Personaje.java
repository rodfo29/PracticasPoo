/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticaPersonajes;

import javax.swing.JOptionPane;


public  abstract class Personaje {

    private String nombre;
    private String raza;
    
    private int fuerza; // 0 - 20
    private int inteligencia; // 0 - 20
    
    private int hp; //  0 - 100
    private int maxHp; // 0 - 100
    
    

    
    
    
    public Personaje(){
        this.nombre="";
        this.raza="";
        this.fuerza=0;
        this.inteligencia=0;
        this.hp=0;
        this.maxHp=0;
        
    }


    public Personaje(String nombre,String raza,int fuerza,int inteligencia,int maxHp){
        this.nombre=nombre;
        this.raza=raza;
        this.fuerza=fuerza;
        this.inteligencia=inteligencia;
        this.maxHp=maxHp;
        this.hp=maxHp;
    }


    
    protected void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    protected void setRaza(String raza){
        this.raza=raza;
    }
    
    protected void setFuerza(int fuerza){
        this.fuerza=fuerza;
    }
    
    protected void setInteligencia(int inteligencia){
        this.inteligencia=inteligencia;
    }
     
    
    protected void setHp(int hp){
        int vidaActual=this.hp+hp;
        if (vidaActual>=0 && vidaActual<=this.maxHp)
        {
            this.hp=vidaActual;
        }



    }

    protected void setMaxHp(int maxHp){
        this.maxHp=maxHp;
    }
        
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getRaza(){
        return this.raza;
    }
    
    public int getFuerza(){
        return this.fuerza;
    }
    
    public int getInteligencia(){
        return this.inteligencia;
    }
    
    public int getHp(){
        return this.hp;
    }
    
    public int getMaxHp(){
        return this.maxHp;
    }
    
    
    // Implementar con JOptionPane.
    public abstract void infoPersonaje();
    
    
    
    
}
