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
public class Trigonometrria {

    OperacionesAritmeticas Menus = new OperacionesAritmeticas();

    public void MenuTrigonometria() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n************************");
        System.out.println("1. Seno\n2. Coseno\n3. Tangente\n4. Salir");
        System.out.println("************************");
        System.out.print("\n Ingrese la opcion -->");
        int Opcion = in.nextInt();
        double potencia = 0;
        double numero;

        switch (Opcion) {
            case 1:
                System.out.println("\n****************************************************");
                System.out.println("Ingrese el escalar de los grados en sexagesimales");
                System.out.print("Ingrese la opcion -->");
                numero = in.nextDouble();
                System.out.println("****************************************************");

                double acum = 0;

                double seno = 0;

                for (double i = 0; i <= 51; i++) {

                    seno += Potencia(-1, i) * Potencia(numero, (2 * i + 1)) / Factorial(2 * i + 1);

                }
                System.out.println("El seno de "+numero+" es de "+seno);

                break;
            case 2:
                System.out.println("\n****************************************************");
                System.out.println("Ingrese el escalar de los grados en sexagesimales");
                System.out.print("Ingrese la opcion -->");
                numero = in.nextDouble();
                System.out.println("****************************************************");

                double coseno = 0;

                for (double i = 0; i <= 51; i++) {
                    
                    coseno += Potencia(-1, i) * Potencia(numero, (2 * i)) / Factorial(2 * i);

                }
                System.out.println("El coseno de "+numero+" es de "+coseno);
                break;
            case 3:
                System.out.println("\n****************************************************");
                System.out.println("Ingrese el ángulo a calcular, unicamente su escalar");
                System.out.print("Ingrese la opcion -->");
                numero = in.nextDouble();
                System.out.println("****************************************************");
                seno = 0;
                coseno = 0;

                for (double i = 0; i <= 51; i++) {
                    seno += Potencia(-1, i) * Potencia(numero, (2 * i + 1)) / Factorial(2 * i + 1);
                    coseno += Potencia(-1, i) * Potencia(numero, (2 * i)) / Factorial(2 * i);

                }
                double tangente =  seno/coseno;
                System.out.println("la tangente de "+numero+" es de " +tangente);
                break;
                
            default:
                System.out.println("Numero invalido, se cerrara automaticamente");
                System.exit(0);
                break;
        }
        Menus.MenuPrincipal();
    }

    public static double Factorial(double numero) {
        if (numero == 0) {
            return 1;
        } else {
            return (numero * Factorial(numero - 1)); //Calcula el factorial de un numero con recursividad
        }
    }

    public static double Potencia(double base, double potencia) {
        double acum = 1;
        for (int i = 0; i < potencia; i++) {
            acum = acum * base;
        }
        return (acum);
    }
}
