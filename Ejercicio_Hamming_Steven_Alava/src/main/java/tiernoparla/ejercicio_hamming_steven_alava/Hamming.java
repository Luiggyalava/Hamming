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
    }//cierre main

}//cierre Clase

