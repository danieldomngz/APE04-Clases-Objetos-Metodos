#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

//Creacion de la clase Estudiantes
class Estudiante{
    private:
    //Variables que se van a utilizar
    string nombre[5];
    string cedula[5];
    float notas[5][3];
    float promedio[5];
    string estado[5];
    int aprobado=0, reprobado=0;
    
    //Constructor de la clase
    public:
    Estudiante(){
        for (int i = 0; i < 5; i++) {
        nombre[i] = "";
        for (int j = 0; j < 3; j++) {
        notas[i][j] = 0;
        }
    }
    }

    //Metodo para ingresar informacion de los estudiantes
    void ingresarInfo(){
        for (int i = 0; i < 5; i++){
        float suma=0;
        cout << "Ingrese el nombre completo del estudiante " << (i+1) << ": ";
        getline(cin, nombre[i]);
        cout << "Ingrese el numero de cedula del estudiante " << nombre[i] << ": ";
        getline(cin, cedula[i]);
        for (int j = 0; j < 3; j++){
        
        //Ingreso y validacion de datos
        do{
        cout << "Ingrese la nota " << (j+1) << " del estudiante: ";
        cin >> notas[i][j];

        if(notas[i][j]>10 || notas[i][j]<0){
        cout << "El valor ingresado es invalido! \n";
        }
        }while (notas[i][j]>10 || notas[i][j]<0);
        
        //Acumulador
        suma += notas[i][j];
        
        }

        //Calculo del promedio
        promedio[i]=(suma/3);

        //Contadores y estado del estudiante
        if(promedio[i]>=7){
            aprobado++;
            estado[i]="Aprueba";
        }else{
            reprobado++;
            estado[i]="Reprueba";
        }
        cin.ignore();
        }
        
    }

    //Metodo para mostrar la informacion de los estudiantes
    void mostrarInfo(){
        cout << left << setw(15) << "Estudiante" 
        << right << setw(15) << "Cedula"
        << right << setw(15) << "Nota 1"
        << right << setw(15) << "Nota 2" 
        << right << setw(15) << "Nota 3"
        << right << setw(15) << "Promedio"
        << right << setw(15) << "Estado\n";

        cout << "=====================================================================\n";

        for (int i = 0; i < 5; i++){
        //Uso de setw para imprimir con formato
        cout << left << setw(15) << nombre[i]
        << right << setw(15) << cedula[i]
        << right << setw(15) << notas[i][0] 
        << right << setw(15) << notas[i][1] 
        << right << setw(15) << notas[i][2] 
        << fixed << setprecision(2) << right << setw(15) << promedio[i]
        << right << setw(15) << estado[i]
        << endl;
        }

        cout << "=====================================================================\n";
        cout<< "Aprobados: " << aprobado << "\t\tReprobados: " << reprobado << endl;
        
    };
    };

    //Main del programa
    int main(){
        Estudiante e;
        e.ingresarInfo();
        
        cout << "\n=====================Datos de los estudiantes=====================\n";

        e.mostrarInfo();

        return 0;

    }
