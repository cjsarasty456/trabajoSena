/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ciclos;

import java.util.Scanner;

/**
 *
 * @author caliche
 */
public class CICLOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // for(int i=100;i>=1;i--){
        //   System.out.println(i);
        /// }
        /*
       Crear un menú, con un número de elemetos
       si el usuario se equivoca indicarle el error
       y volver a mostrar el menú
         */
        int opcion;
        Scanner scan = new Scanner(System.in);
        /*
        do{ hacer
        instrucciones que se deben repetir
        }while(condición); mientras se cumple condición
        */
        do {
            System.out.println("Ingrese alguna de las siguiente opciones");
            System.out.println("1 opción A");
            System.out.println("2 opción B");
            System.out.println("3 opción C");
            System.out.println("4 opción D");
            opcion = scan.nextInt();
            if(opcion>4 || opcion<1){
                System.out.println("Opción no valida, vuelve a intentar");
            }
        }while(opcion>4 || opcion<1);
            switch (opcion) {
                case 1:
                    System.out.println("Opción A");
                    break;
                case 2:
                    System.out.println("Opción B");
                    break;
                case 3:
                    System.out.println("Opción C");
                    break;
                case 4:
                    System.out.println("Opción D");
                    break;
                default:
                    System.out.println("Opción invalida");
            }
        }

    }
