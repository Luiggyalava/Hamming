package tiernoparla.ejercicio_hamming_steven_alava;

//import java.util.Random;
//import java.util.Scanner;
public class Hamming {

    public static void main(String[] args) {
        //SENDER
        int msg[] = {1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1};

        //calcular el total del array
        final int longmsg = msg.length;

        //Calcular la Potencia de dos necesarias para el bit de pariedad
        final int potencia = 2;
        int bitpar = 0;
  
        while (Math.pow(potencia, bitpar) < bitpar + longmsg + 1) {
            bitpar++;
        }//while
        
        //**********************************************************************
        //añadimos el nuevo array con la longitud + pariedad + 1
        final int tam = longmsg + (bitpar + 1);

        System.out.println("El tamaño del array nuevo + bitpar es de :" + tam);
        int[] newmsg = new int[tam];
        //variable exponente para reutilizar*
        int exponente = 0;
        
        /*bucle para agregar el mensaje al array nuevo e identificar posicion
        del bit de pariedad */
        int contmsg = 0;
        
        for (int i = 1; i < newmsg.length; i++) {
            if (Math.pow(potencia, exponente) != i) {
                newmsg[i] = msg[contmsg];
                contmsg++;
            }//if
            else {
                newmsg[i] = 2;
                exponente++;
            }//else
            System.out.print(newmsg[i]);
        }//for
        System.out.println(" ");
    }//cierre main

}//cierre Clase

