/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacionesaritmeticas;

import java.util.Scanner;
import static operacionesaritmeticas.OperacionesAritmeticas.MenuArimetico;

/**
 *
 * @author Hinestroza
 */
public class Estadistica {

    OperacionesAritmeticas Menus = new OperacionesAritmeticas();
    static Scanner in = new Scanner(System.in);

    public void MenuEstadistica() {
        System.out.println("\n****************************************************");
        System.out.println("Ingrese el tipo de Operaciones que desea realizar");
        System.out.println("1. Promedio");;
        System.out.println("2. Moda");
        System.out.println("3. Varianza");
        System.out.println("4. Desviacion Estandar");
        System.out.println("5. Salir");
        System.out.println("****************************************************");
        System.out.print("\n Ingrese la opcion -->");
        int Operaciones = in.nextInt();

        int tamaño = 0;
        double acum = 0;
        int vector[] = new int[tamaño];

        switch (Operaciones) {
            case 1:
                System.out.print("Ingrese el tamaño del vector --->");
                tamaño = in.nextInt();
                vector = Vectores(tamaño);

                for (int i = 0; i < tamaño; i++) {
                    acum += vector[i];
                }
                double promedio = acum / tamaño;
                System.out.println("El promedio es de " + promedio);
                break;

            case 2:
                int contadornumeros = 0; // contador para hallar moda
                int comparador = 0; //se usara como comparador cual numeor hay mas
                int moda = 0;
                System.out.print("\nIngrese el tamaño del vector --->");
                tamaño = in.nextInt();
                vector = Vectores(tamaño);
                int ModaVector[] = new int[tamaño];

                for (int i = 0; i < vector.length; i++) {
                    contadornumeros = 0; // reiniciando contador
                    int numero = vector[i]; // estableciendo el numero a contar
                    for (int j = 0; j < vector.length; j++) { //recorrido de vector buscando numero iguales
                        if (vector[j] == numero) { // busqueda de un numero igual
                            contadornumeros++;
                        }
                    }
                    if (contadornumeros > comparador) {
                        comparador = contadornumeros;
                        moda = vector[i];// estableciendo el numero de la moda (numero mas repetido)
                    }
                }
                System.out.println("La moda es "+moda);
               

                break;
            case 3:
                System.out.print("Ingrese el tamaño del vector --->");
                tamaño = in.nextInt();
                vector = Vectores(tamaño);

                for (int i = 0; i < tamaño; i++) {
                    acum += vector[i];
                }
                promedio = acum / tamaño;
                double restas;
                double sumador = 0;

                for (int i = 0; i < tamaño; i++) {
                    restas = Potencia(vector[i] - promedio, 2);
                    sumador += restas;
                }
                double varianza = sumador / tamaño;
                System.out.println("la varianza es de  " + varianza);

                break;
            case 4:
                System.out.print("Ingrese el tamaño del vector --->");
                tamaño = in.nextInt();
                vector = Vectores(tamaño);

                for (int i = 0; i < tamaño; i++) {
                    acum += vector[i];
                }
                promedio = acum / tamaño;
                acum = 0;
                for (int i = 0; i < tamaño; i++) {
                    acum += Potencia(vector[i] - promedio, 2);
                }
                double Raiz = Raiz(acum / (tamaño - 1));
                System.out.println("la desviacion estandar es de " + (Raiz));
                break;
            case 5:
                break;
            default:
                System.out.println("\nNumero invalido, se cerrara automaticamente");
                System.exit(0);
                break;
        }
        Menus.MenuPrincipal(); //regresa al menu despues de calcular todo

    }

    public static double Potencia(double base, double potencia) {
        double acum = 1;
        for (int i = 0; i < potencia; i++) {
            acum = acum * base;
        }
        return (acum);
    }

    public int[] Vectores(int tamaño) {
        int Vector[] = new int[tamaño];
        System.out.print("Ingrese el vector separados por comas ---->");
        String numero = in.next();//Ingresa el vector
        String[] fragamentos = numero.split(","); //1,2,2 ejemplicando el ingreso

        if (fragamentos.length == tamaño) { //comparando para evitar colapso del programa
            for (int i = 0; i < tamaño; i++) {
                Vector[i] = Integer.parseInt(fragamentos[i]); // String a Integer
            }
            return Vector;
        } else {
            System.out.println("Los tamaños del vector y del vector no concuerda");
            Menus.MenuPrincipal();
            return Vector;
        }
    }

    public static double Raiz(double number) {
        double temporal;
        double sr = number / 2;
        do {
            temporal = sr; // se remplaza datos de los valores
            sr = (temporal + (number / temporal)) / 2;
        } while ((temporal - sr) != 0);
        return sr; // retorna el valor de la raiz
    }
}
