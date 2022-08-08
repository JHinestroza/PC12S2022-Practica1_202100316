/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacionesaritmeticas;

import java.util.Scanner;

/**
 *
 * @author Hinestroza
 */
public class Calculos {

    static OperacionesAritmeticas Menu = new OperacionesAritmeticas();
    static Scanner in = new Scanner(System.in);

    public void Calculos() {

        System.out.println("\n************************************************");
        System.out.println("1. Resolver sistema de ecuaciones lineals NXN Gauss-Jordan");
        System.out.println("2. Salir");
        System.out.println("************************************************");
        System.out.print("\n Ingrese la opcion -->");
        int Opcion = in.nextInt();

        switch (Opcion) {
            case 1:
                LlamadaMatriz();
                break;
            case 2:
                Menu.MenuPrincipal();
                break;
            default:
                System.out.println("\nNumero invalido, se cerrara automaticamente");
                System.exit(0);
                break;
        }
    }

    public static void LlamadaMatriz() {
        int filas,columnas;
        System.out.println("\n***********************************************");
        System.out.print("Ingrese el numero de filas de las matriz --->");
        filas = in.nextInt();
        System.out.print("Ingrese el numero de columnas de las matriz (contando su expandida)--->");
        columnas = in.nextInt();
        float Matriz[][] = new float[filas][columnas]; //definiendo tamaño de matriz

        if (filas != (columnas - 1)) {
            System.out.println("\nNO ES UNA MATRIZ CUADRADA");
            Menu.MenuPrincipal();
        } else {
            String vector = "";
            for (int i = 0; i < filas; i++) {
                System.out.println("Ingrese la fila " + (i+1));
                vector = in.next();
                String[] fragmentos = vector.split(",");
                for (int j = 0; j < columnas; j++) {
                    Matriz[i][j] = Integer.parseInt(fragmentos[j]); //Almacenando variables en cada elemento
                    
                }
            }
        }
        System.out.println("La Matriz es:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("(" + Matriz[i][j] + ")   ");
            }
            System.out.println();
        }
        
        
        System.out.println("***********************************************");
        int tipodematriz;
        tipodematriz = OperacionesGauss(Matriz, filas);
        if (tipodematriz == 1) {
            tipodematriz = Determinate0(Matriz, filas, tipodematriz);
        }
        Matriz(Matriz, filas); // Imprime la matriz resultante debido a los calculos
        System.out.println("");
        Resultado(Matriz, filas, tipodematriz);
        Menu.MenuPrincipal();
    }

    public static int OperacionesGauss(float Matriz[][], int columnas) {
        int c, tipodematriz = 0, m = 0;
        float pro = 0;

        for (int i = 0; i < columnas; i++) {
            if (Matriz[i][i] == 0) {
                c = 1;
                while ((i + c) < columnas && Matriz[i + c][i] == 0) {
                    c++;
                }
                if ((i + c) == columnas) {
                    tipodematriz = 1;
                    break;
                }
                for (int j = i, k = 0; k <= columnas; k++) {
                    float temp = Matriz[j][k];
                    Matriz[j][k] = Matriz[j + c][k];
                    Matriz[j + c][k] = temp;
                }
            }

            for (int j = 0; j < columnas; j++) {
                if (i != j) {
                    float p = Matriz[j][i] / Matriz[i][i]; //esclar por el cual se multiplicara
                    for (int k = 0; k <= columnas; k++) {
                        Matriz[j][k] = Matriz[j][k] - (Matriz[i][k]) * p;    //restando los valores de cada fila multiplicada por esclar             
                    }
                }
            }
        }
        return tipodematriz;
    }

    public static int Determinate0(float Matriz[][], int n, int tipodematriz) {
        int i, j;
        float sum;

        tipodematriz = 3;
        for (i = 0; i < n; i++) {
            sum = 0;
            for (j = 0; j <= n; j++) {
                sum = sum + Matriz[i][j];
            }
            if (sum == 0) { //estableciedo si la suma es igual a 0 en una fila
                tipodematriz = 2; // hay infinitas soluciones
            }

        }
        return tipodematriz;
    }

    public static void Matriz(float Matriz[][], int columnas) {

        System.out.println("La Matriz resultante es:");
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j <= columnas; j++) {
                System.out.print("(" + Matriz[i][j] + ")   ");
            }
            System.out.println();
        }

    }

    public static void Resultado(float a[][], int n, int resultado) {
        System.out.print("El Resultado es: ");

        if (resultado == 2) {
            System.out.println("Hay infinitas soluciones");
        } else if (resultado == 3) {
            System.out.println("No existe solciones");
        } else {
            System.out.println("");
            for (int i = 0; i < n; i++) {
                System.out.print("su resultado"+(i+1)+" es: "+a[i][n] / a[i][i]+"\n");
            }
        }
    }
}
