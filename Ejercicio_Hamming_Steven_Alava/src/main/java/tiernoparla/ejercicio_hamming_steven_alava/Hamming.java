package tiernoparla.ejercicio_hamming_steven_alava;

public class Hamming {

    public static void main(String[] args) {

       int msg[] = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0};

        //total del array
        final int longmsg = msg.length;

        //potencia de 2
        final int potencia = 2;
        int bitpar = 0;

        //bucle para sacar la potencia para el bit de pariedad
        while (Math.pow(potencia, bitpar) < bitpar + longmsg + 1) {
            bitpar++;
        }//cierre while   

        System.out.println("El bit de pariedad es: " + bitpar);

        //añadimos el nuevo array con la longitud + pariedad + 1
        int tam = longmsg + (bitpar + 1);
        System.out.println("El tamaño del array nuevo es de :" + tam);
        int[] newmsg = new int[tam];

        //contador para agregar el mensaje original
        int contmsg = 0;

        // temporal para potencia
        int tmp2 = 0;

        //bucle para agregar el mensaje al array nuevo
        for (int i = 1; i < newmsg.length; i++) {
            if (Math.pow(potencia, tmp2) != i) {
                newmsg[i] = msg[contmsg];
                contmsg++;
            }//Cierre else
            else {
                newmsg[i] = 2;
                tmp2++;
            }//cierre else

            System.out.print(newmsg[i]);
        }//Cierre for

        //bit opration 
        int tmp3 = 0;
        double resultado = 0;
        int cont0 = 0;
        int cont1 = 0;
        System.out.println("");

        for (int i = 1; i < newmsg.length; i++) {
            if (Math.pow(potencia, tmp3) == i) {
                for (int j = 1; j < newmsg.length; j++) {
                    if ((i & j) == i) {
                        if (newmsg[j] == 0) {
                            cont0++;
                        }//cierre if
                        else {
                            cont1++;
                        }//cierre else
                    }//cierre if
                }//cierre for 2
            }//Cierreif
            if (cont1 > cont0) {
                newmsg[i] = 0;
                cont0 = 0;
                cont1 = 0;
            }//cierre if
            else {
                newmsg[i] = 1;
                cont0 = 0;
                cont1 = 0;
            }
            tmp3--;
            System.out.print(newmsg[i]);

    }//cierre 1º for

}//main
}//cierre
