package empleados;

public class EmpleadoAsalariado extends  Empleado{
    private float sueldo;

    public EmpleadoAsalariado(String nombre,String apellido,int num,float s){
        super(nombre,apellido,num);
        this.sueldo=s;
    }

    @Override
    public float calcularSalario() {
        return this.sueldo;
    }
}
