package empleados;

public class EmpleadoPorVenta extends Empleado{
    private float totalVentas;
    private float comisionVenta;


    public EmpleadoPorVenta(String nombre,String apellido,int num,float totalVentas,float comisionVenta){
        super(nombre,apellido,num);
        this.totalVentas=totalVentas;
        this.comisionVenta=comisionVenta/100;
    }


    public float getTotalVentas(){
        return this.totalVentas;
    }
    public float getComisionVenta(){
        return this.comisionVenta;
    }

    @Override
    public float calcularSalario(){

        return this.totalVentas*this.comisionVenta;

    }
}
