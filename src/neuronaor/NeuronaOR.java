/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuronaor;

/**
 *
 * @author alver.grisales
 */
public class NeuronaOR {

    public static void main(String[] args) {
        /*
        Se crean tuplas de la forma (X1,X2,Y1) para representar los valores de
        la tabla de verdad. para este caso 1= true y -1= false;
        */
        int[][] tv = {{1, 1, 1}, {1, -1, 1}, {-1, 1, 1}, {-1, -1, -1}};

        System.out.println("\nInicializar pesos:\n");
        double w1 = Math.random();
        double w2 = Math.random();
        double θ = -1.0*Math.random(); // el bias

        double y = 0;
        final double E = 0.5;//Factor de aprendizaje        

        System.out.println("w1: " + w1);
        System.out.println("w2: " + w2);
        System.out.println("θ: " + θ);

        System.out.println("\nIniciando fase de aprendizaje puerta logica OR...\n");
        int i = 0;
        int cont = 1;
        while (i < tv.length && cont < 100) {
            y = Math.tanh((tv[i][0] * w1) + (tv[i][1] * w2) + (-1 * θ));
            y = (y >= θ) ? 1 : -1;
            System.out.println("Entrada[" + tv[i][0] + "," + tv[i][1]
                    + "]) Valor esperado[" + tv[i][2]
                    + "] Salida[" + (int) y + "]");
            if (y == tv[i][2]) {
                i++;
            } else {
                System.out.println("Valor esperado difiere de la salida. Hay que reajustar pesos...");
                //Ajuste de pesos
                w1 = w1 + 2 * E * tv[i][2] * tv[i][0];
                w2 = w2 + 2 * E * tv[i][2] * tv[i][1];
                θ = θ + 2 * E * tv[i][2] * (-1);

                System.out.println("\nAjuste de pesos (" + cont + "):");
                System.out.println("w1: " + w1);
                System.out.println("w2: " + w2);
                System.out.println("θ: " + θ + "\n");
                cont++;
                i = 0;
            }
        }

        if (cont <= 9999) {
            System.out.println("\nFase de aprendizaje terminado con exito en " + cont +" iteraciones");
            System.out.println("\nResultados:");
            System.out.println("w1: " + w1);
            System.out.println("w2: " + w2);
            System.out.println("θ: " + θ);
        } else {
            System.out.println("\nFase de aprendizaje ha fallado\n");
        }

    }
}
