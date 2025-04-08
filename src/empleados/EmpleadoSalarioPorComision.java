package empleados;

public class EmpleadoSalarioPorComision extends EmpleadoPorVenta{
    private float sueldoBase;

    public EmpleadoSalarioPorComision(String nombre,String apellido,int num,float sueldoBase,float totalVentas,float comisionVenta){

        super(nombre,apellido,num,totalVentas,comisionVenta);
        this.sueldoBase=sueldoBase;

    }



     @Override
    public float calcularSalario(){
        return (this.sueldoBase)+(this.getComisionVenta()*this.getTotalVentas());

     }


}
