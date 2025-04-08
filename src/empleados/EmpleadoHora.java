package empleados;

public class EmpleadoHora extends Empleado{
    private float sueldoHora;
    private float horasTrabajadas;
    private float sueldoHoraExtra;

    public EmpleadoHora(String nombre,String apellido,int num,float sueldoHora,float horasTrabajadas, float sueldoHoraExtra){
        super(nombre,apellido,num);
        this.sueldoHora=sueldoHora;
        this.horasTrabajadas=horasTrabajadas;
        this.sueldoHoraExtra=sueldoHoraExtra;


    }

    @Override
    public float calcularSalario() {
        if (this.horasTrabajadas<=0){
            return 0;
        }
        else if (this.horasTrabajadas>40){
            float horasExtra=this.horasTrabajadas-40;
            float sueldoExtra=horasExtra*this.sueldoHoraExtra;
            return ((40*this.sueldoHora)+sueldoExtra);
        }

        return (this.horasTrabajadas*this.sueldoHora);
    }




}
