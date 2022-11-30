package tiernoparla.ejercicio_hamming_steven_alava;

import java.util.Random;
import java.util.Scanner;

public class Hamming {

    public static void main(String[] args) {
        //SENDER
        //Longitud y Creacion del mensaje aleatorio
        Scanner longitud = new Scanner(System.in);
        Random rnd = new Random();
        
        int longmsg;
        System.out.println("Indicame longitud del mensaje aleatorio");
        longmsg = longitud.nextInt();
        int[] msg = new int[longmsg];
        

        System.out.println("Tu mensaje es: ");
        for (int i = 0; i < msg.length; i++) {
            msg[i] = rnd.nextInt(1 - 0 + 1) + 0;
            System.out.print(msg[i]);
        }//cierre for
        System.out.println(" ");

        //Calcular la Potencia de dos necesarias para el bit de pariedad
        final int POTENCIA = 2;
        int bitpar = 0;
        while (Math.pow(POTENCIA, bitpar) < bitpar + longmsg + 1) {
            bitpar++;
        }//while  

        System.out.println("Los bits de pariedad que usaremos son: " + bitpar);
        //***********************************************************
        //añadimos el nuevo array con la longitud + pariedad + 1
        final int TAM = longmsg + (bitpar + 1);
        int[] newmsg = new int[TAM];
        System.out.println("El tamaño del array nuevo + bitpar es de :" + TAM);

        //variables de uso
        int exponente = 0;
        int contmsg = 0;

        //calcular posicion de Bit de Pariedad
        calcularPosBit(msg, newmsg, POTENCIA, exponente, contmsg);
        System.out.println(" ");

        //Contar 0's y 1's del mensaje para calcular modificar el bit de pariedad
        System.out.println("El mensaje calculando los bits de pariedad es: ");
        contarDependientesBitPar(newmsg);
        System.out.println(" ");

        //Contar todas las posiciones y colocar Bit global
        calcularBitGlobal(newmsg);
        System.out.println("El Bit global es: " + newmsg[0]);
        //Test OK
        //***********************************************************          
        //NOISE
        //Creamos un nuevo array con el mensaje de ruido para tratarlo
        System.out.println("El mensaje original es: ");
        int[] noisemsg = new int[TAM];
        arraysNuevos(noisemsg, newmsg);
        System.out.println(" ");

        //Introducimos un mensaje aleatorio dentro del array nuevo
        System.out.println("El mensaje con ruido es: ");
        agregarFallos(noisemsg, TAM);
        System.out.println(" ");
        //Test OK
//*******************************************************************
        //RECIEVER
        //Crear nuevo array de respuesta para tratarlo
        System.out.println("El mensaje recibido es: ");
        int[] recevermsg = new int[TAM];
        arraysNuevos(recevermsg, noisemsg); //cierre for
        System.out.println(" ");

        //Contar 0's y 1's del mensaje para calcular modificar el bit de pariedad
        System.out.println("El mensaje calculando los bits de pariedad es: ");
        contarDependientesBitPar(recevermsg);
        System.out.println(" ");

        //Contar todas las posiciones y colocar Bit global
        calcularBitGlobal(recevermsg);
        System.out.println("El Bit global es: " + recevermsg[0]);

    }//main
    public static void agregarFallos(int[] noisemsg, final int TAM) {
        int contf = 0;
        int aleatorio = 0;
        for (int i = 0; i < noisemsg.length; i++) {
            aleatorio = (int) (Math.random() * TAM + 1);
            /*se pone (TAM/3) para que las posibilidades sean 1/3 de tener
            2 fallos */
            if (aleatorio <= (TAM / 3) && contf != 2) {
                noisemsg[i] = (int) (Math.random() * 1 + 1);
                contf++;
            }
            System.out.print(noisemsg[i]);
        }
    }

    public static void arraysNuevos(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            array1[i] = array2[i];
            System.out.print(array1[i]);
        }
    }

    public static void calcularBitGlobal(int[] newmsg) {
        int cont1 = 0;
        for (int i = 1; i < newmsg.length; i++) {
            if (newmsg[i] == 1) {
                cont1++;
            }
        }
        if ((cont1 % 2) == 0) {
            newmsg[0] = 0;
        }
        else {
            newmsg[0] = 1;
        }
    }

    public static void contarDependientesBitPar(int[] newarr) {
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

    public static void calcularPosBit(int[] msg, int[] newarr, final int POTENCIA, int exponente, int contmsg) {
        for (int i = 1; i < newarr.length; i++) {
            if (Math.pow(POTENCIA, exponente) != i) {
                newarr[i] = msg[contmsg];
                contmsg++;
            } else {
                newarr[i] = 2;
                exponente++;
            }
            System.out.print(newarr[i]);
        }
    }
}//cierre Clase