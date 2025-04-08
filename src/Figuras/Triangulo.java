package Figuras;

public class Triangulo extends Figura{
    public Triangulo(){
        super();
    }

    public Triangulo(int alto,int largo){
        super(alto,largo);
    }

    @Override
    public void calcularArea() {
        System.out.println("Área: " +   (   (this.getAlto()*this.getLargo())/2)    );
    }




    @Override
    public void imprimir(){
        System.out.println("Largo: "    +   this.getLargo() +   " - Alto: "    +   this.getAlto());
    }


}
