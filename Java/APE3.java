import java.util.Scanner;

// Creacion de la clase Estudiante
class Estudiante {

    // Variables que se van a utilizar
    private String[] nombre = new String[5];
    private String[] cedula = new String[5];
    private float[][] notas = new float[5][3];
    private float[] promedio = new float[5];
    private String[] estado = new String[5];

    private int aprobado = 0;
    private int reprobado = 0;

    // Constructor de la clase
    public Estudiante() {
        for (int i = 0; i < 5; i++) {
            nombre[i] = "";
            cedula[i] = "";
            promedio[i] = 0;
            estado[i] = "";

            for (int j = 0; j < 3; j++) {
                notas[i][j] = 0;
            }
        }
    }

    // Metodo para ingresar informacion de los estudiantes
    public void ingresarInfo() {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {

            float suma = 0;

            System.out.print("Ingrese el nombre completo del estudiante " + (i + 1) + ": ");
            nombre[i] = sc.nextLine();

            System.out.print("Ingrese el numero de cedula del estudiante " + nombre[i] + ": ");
            cedula[i] = sc.nextLine();

            for (int j = 0; j < 3; j++) {

                // Ingreso y validacion de datos
                do {
                    System.out.print("Ingrese la nota " + (j + 1) + " del estudiante: ");
                    notas[i][j] = sc.nextFloat();

                    if (notas[i][j] > 10 || notas[i][j] < 0) {
                        System.out.println("El valor ingresado es invalido!");
                    }

                } while (notas[i][j] > 10 || notas[i][j] < 0);

                // Acumulador
                suma += notas[i][j];
            }

            // Calculo del promedio
            promedio[i] = suma / 3;

            // Contadores y estado del estudiante
            if (promedio[i] >= 7) {
                aprobado++;
                estado[i] = "Aprueba";
            } else {
                reprobado++;
                estado[i] = "Reprueba";
            }

            sc.nextLine(); 
        }

        sc.close();
    }

    // Metodo para mostrar la informacion de los estudiantes
    public void mostrarInfo() {

        System.out.printf("%-15s %-15s %-10s %-10s %-10s %-10s %-10s\n",
                "Estudiante", "Cedula", "Nota 1", "Nota 2",
                "Nota 3", "Promedio", "Estado");

        System.out.println("==========================================================================");

        for (int i = 0; i < 5; i++) {
            //Uso de printf para imprimir con formato
            System.out.printf("%-15s %-15s %-10.2f %-10.2f %-10.2f %-10.2f %-10s\n",
                    nombre[i],
                    cedula[i],
                    notas[i][0],
                    notas[i][1],
                    notas[i][2],
                    promedio[i],
                    estado[i]);
        }

        System.out.println("==========================================================================");

        System.out.println("Aprobados: " + aprobado +
                "\t\tReprobados: " + reprobado);
    }
}

// Main del programa
public class APE3 {

    public static void main(String[] args) {

        Estudiante e = new Estudiante();

        e.ingresarInfo();

        System.out.println("\n===================== Datos de los estudiantes =====================");

        e.mostrarInfo();

    }
}