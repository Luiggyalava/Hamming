package tiernoparla.ejercicio_hamming_steven_alava;

//import java.util.Random;

import java.util.Random;
import java.util.Scanner;

//import java.util.Scanner;
public class Hamming {

    public static void main(String[] args) {

        //SENDER
        //Longitud y Creacion del mensaje aleatorio
        Scanner longitud = new Scanner(System.in);
        int longmsg;
        System.out.println("Indicame longitud del mensaje aleatorio");
        longmsg = longitud.nextInt();
        int[] msg = new int[longmsg];
        Random rnd = new Random();

        System.out.println("Tu mensaje es: ");
        for (int i = 0; i < msg.length; i++) {
            msg[i] = rnd.nextInt(1 - 0 + 1) + 0;
            System.out.print(msg[i]);
        }//cierre for
        System.out.println(" ");

        //Calcular la Potencia de dos necesarias para el bit de pariedad
        final int potencia = 2;
        int bitpar = 0;

        while (Math.pow(potencia, bitpar) < bitpar + longmsg + 1) {
            bitpar++;
        }//while  

        System.out.println("Los bits de pariedad que usaremos son: " + bitpar);

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

        //calcular posicion de Bit de Pariedad
        calcularPosBit(msg, newmsg, potencia, exponente, contmsg);
        System.out.println(" ");

        //Contar 0's y 1's del mensaje para calcular modificar el bit de pariedad
        System.out.println("El mensaje calculando los bits de pariedad es: ");

        contarDependientesBitPar(newmsg);
        System.out.println(" ");

        //Contar todas las posiciones y colocar Bit global
        calcularBitGlobal(newmsg);

        System.out.println("El Bit global es: " + newmsg[0]);
        //Test OK
        
//*********************************************************************          
        //NOISE
        //Creamos un nuevo array con el mensaje de ruido para tratarlo
        System.out.println("El mensaje original es: ");
        int[] noisemsg = new int[tam];
        arraysNuevos(noisemsg, newmsg);
        System.out.println(" ");

        //Introducimos un mensaje aleatorio dentro del array nuevo
        int contf = 0;
        int aleatorio = (int) (Math.random() * tam + 1);
        System.out.println("El mensaje con ruido es: ");
        agregarFallos(noisemsg, aleatorio, contf, tam);
        System.out.println(" ");
        //Test OK

    }//main

    public static void agregarFallos(int[] noisemsg, int aleatorio, int contf,
                                     final int tam) {
        for (int i = 0; i < noisemsg.length; i++) {
            if (aleatorio <= i && contf != 2) {
                noisemsg[i] = (int) (Math.random() * 1 + 1);
                contf++;
            } else {
                aleatorio = (int) (Math.random() * tam + 1);
            }//else
            System.out.print(noisemsg[i]);
        }//cierre for
    }

    private static void arraysNuevos(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            array1[i] = array2[i];
            System.out.print(array1[i]);
        }
    }

    private static void calcularBitGlobal(int[] newmsg) {
        int cont1 = 0;
        for (int i = 1; i < newmsg.length; i++) {
            if (newmsg[i] == 1) {
                cont1++;
            }
        }
        if ((cont1 % 2) == 0) {
            newmsg[0] = 0;
        }//cierre if
        else {
            newmsg[0] = 1;
        }
    }

    private static void contarDependientesBitPar(int[] newarr) {
        int cont1 = 0;
        for (int x = 1; x < newarr.length; x++) {
            for (int z = 1; z < newarr.length; z++) {
                //bitwise operator
                if (newarr[x] == 2 && (x & z) != 0 && newarr[z] == 1) {
                    cont1++;
                }
            }
            if (newarr[x] == 2 && cont1 % 2 == 1) {
                newarr[x] = 1;
                cont1 = 0;
            } else if (newarr[x] == 2 && cont1 % 2 != 1) {
                newarr[x] = 0;
                cont1 = 0;
            }
            System.out.print(newarr[x]);
        }
    }

    private static void calcularPosBit(int[] msg, int[] newarr, final int
                                       potencia, int exponente, int contmsg) {
        for (int i = 1; i < newarr.length; i++) {
            if (Math.pow(potencia, exponente) != i) {
                newarr[i] = msg[contmsg];
                contmsg++;
            }
            else {
                newarr[i] = 2;
                exponente++;
            }
            System.out.print(newarr[i]);
        }
    }
}//cierre Clase

