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
         //Contar 0's y 1's del mensaje para calcular modificar el bit de pariedad
        System.out.println("El mensaje correcto es: ");
        int cont1 = 0;
        
        for (int x = 1; x < newmsg.length; x++) {
            for (int z = 1; z < newmsg.length; z++) {
                //bitwise operator
                if (newmsg[x] == 2 && (x & z) != 0 && newmsg[z] == 1) {
                    cont1++;
                }//if
            }//for2
            if (newmsg[x] == 2 && cont1 % 2 == 1) {
                newmsg[x] = 1;
                cont1 = 0;
            } else if (newmsg[x] == 2 && cont1 % 2 != 1) {
                newmsg[x] = 0;
                cont1 = 0;
            }//else if
            System.out.print(newmsg[x]);
        }//cierre for
        System.out.println(" ");
        
        //Contar todas las posiciones y colocar Bit global
        cont1 = 0;
        for (int i = 1; i < newmsg.length; i++) {
            if (newmsg[i] == 1) {
                cont1++;
            }//cierre if
        }//cierre for
        
        if ((cont1 % 2) == 0) {
            newmsg[0] = 0;
        }//cierre if
        else {
            newmsg[0] = 1;
        }//cierre
        System.out.println("El Bit global es: " + newmsg[0]);
        //Test OK
        //*********************************************************************
    }//cierre main

}//cierre Clase

