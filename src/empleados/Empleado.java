package empleados;

public abstract class Empleado {
    private String nombre;
    private String apellido;
    private int numSocial;

    public Empleado(String nombre,String apellido,int num){
        this.nombre=nombre;
        this.apellido=apellido;
        this.numSocial=num;
    }



    public abstract float calcularSalario();

    public void imprimirDatos(){
        System.out.println("Nombre: "+this.nombre+ " - Apellido: "+this.apellido+" - Numero Social: "+this.numSocial+" - Sueldo: "+ calcularSalario()+"$");
    }

}
