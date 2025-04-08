package Figuras;

public class Cuadrado extends Figura{
    public  Cuadrado(){
        super();
    }

    public  Cuadrado(int lado){
        super(lado,lado);
    }

    @Override
    public void imprimir(){
        System.out.println("Longitud lado: "    +   this.getLargo());
    }

    @Override
    public void calcularArea(){
        System.out.println("Area cuadrado: "    +   (   this.getLargo()*this.getLargo() )   );
    }



}
