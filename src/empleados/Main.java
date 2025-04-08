package empleados;

public class Main {
    public static void main(String[]args){

        Empleado empleado1=new EmpleadoAsalariado("martin","Pinto",31894388,2500);

        empleado1.imprimirDatos();

        EmpleadoSalarioPorComision emp2=new EmpleadoSalarioPorComision("martin","Alejandro",31894388,2500.23f,25000,10);

        emp2.imprimirDatos();



    }
}
