package Figuras;

public abstract class Figura {
    private int alto;
    private int largo;

    public Figura(int alto,int largo){
        this.alto=alto;
        this.largo=largo;
    }

    public Figura(){
        this.alto=0;
        this.largo=0;

    }


    public void setAlto(int alto){
        this.alto=alto;
    }


    public void setLargo(int largo){
        this.largo=largo;
    }

    public int getAlto(){
        return this.alto;
    }
    public int getLargo(){
        return this.largo;
    }


    public abstract void imprimir();

    public abstract void calcularArea();


}
