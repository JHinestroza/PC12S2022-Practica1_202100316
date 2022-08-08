/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operacionesaritmeticas;

import java.util.Scanner;

/**
 *
 * @author Hinestroza
 */
public class OperacionesAritmeticas {

    static Scanner in = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        MenuPrincipal();
    }

    public static void MenuPrincipal() {

        Trigonometrria MenuTrigonometrico = new Trigonometrria(); //llamando metodo 
        Estadistica MenuEsdistica = new Estadistica();
        Calculos MenuCalulos = new Calculos();

        System.out.println("\n****************************************************");
        System.out.println("Ingrese el tipo de Operaciones que desea realizar");
        System.out.println("1. Para Arimeticas\n2. Para Trignometricas\n3. Para Estadística\n4. Para Calculo\n5. Para salir");
        System.out.println("****************************************************");
        System.out.print("\n Ingrese la opcion -->");
        int Operaciones = in.nextInt();
        switch (Operaciones) {
            case 1:
                MenuArimetico();
                break;
            case 2:
                MenuTrigonometrico.MenuTrigonometria();
                break;
            case 3:
                MenuEsdistica.MenuEstadistica();
                break;
            case 4:
                MenuCalulos.Calculos();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("\nNumero invalido, se cerrara automaticamente");
                System.exit(0);
                break;
        }
    }

    public static void MenuArimetico() {
        System.out.println("\n***********************************************************");
        System.out.println("Ingrese el numero segun la operacion  que desea realizar");
        System.out.println("1. Para sumar");
        System.out.println("2. Para restar");
        System.out.println("3. Para multiplicar");
        System.out.println("4. Para dividir");
        System.out.println("5. Para Potenciar");
        System.out.println("6. Para regresar al menu principal");
        System.out.println("***********************************************************");
        System.out.print("\n Ingrese la opcion -->");
        int Operaciones = in.nextInt();

        double num1, num2;

        switch (Operaciones) {
            case 1:
                System.out.println("\nIngrese el valor del primer numero");
                num1 = in.nextDouble();
                System.out.println("Ingrese el valor del segundo numero");
                num2 = in.nextInt();
                System.out.println("El total de la suma es de --->" + (num1 + num2) + "\n");
                break;
            case 2:
                System.out.println("\nIngrese el valor del primer numero");
                num1 = in.nextDouble();
                System.out.println("Ingrese el valor del segundo numero");
                num2 = in.nextDouble();
                System.out.println("El total de la resta es de --->" + (num1 - num2) + "\n");
                break;
            case 3:
                System.out.println("\nIngrese el valor del primer numero");
                num1 = in.nextDouble();
                System.out.println("Ingrese el valor del segundo numero");
                num2 = in.nextDouble();
                System.out.println("El total de la multiplicacion es de --->" + (num1 * num2) + "\n");
                break;
            case 4:
                System.out.println("\nIngrese el valor del primer numero");
                num1 = in.nextDouble();
                System.out.println("Ingrese el valor del segundo numero");
                num2 = in.nextDouble();
                if (num2 != 0) {
                    System.out.println("El total de la division es de --->" + (num1 / num2) + "\n");
                } else {
                    System.out.println("valor indeterminado\n");
                }
                break;
            case 5:
                System.out.println("\nIngrese la base a potenciar");
                num1 = in.nextDouble();
                System.out.println("Ingrese el valor de la potenciacion");
                num2 = in.nextDouble();
                double potencia = num1;

                if (num2 == 0) {
                    System.out.println("El total de la potenciasion es de --->1\n");

                } else {
                    for (int i = 0; i < num2 - 1; i++) {
                        potencia = potencia * num1;
                    }
                    System.out.println("El total de la potenciasion es de --->" + potencia + "\n");
                }
                break;
            case 6:
                break;
            default:
                System.out.println("Numero invalido, se cerrara automaticamente");
                System.exit(0);
                break;
        }
        MenuPrincipal();
    }

}
