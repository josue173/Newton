package com.mycompany.newton;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author josue
 */
public class Newton {
    
    static Scanner leer = new Scanner(System.in);
    static ArrayList<Double> evaluaciones = new ArrayList<>();
    static ArrayList<Double> errores = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Ingrese el valor inicial: ");
        double inicio = leer.nextDouble();
        iterar(inicio);
        mostrar();
    }
    
    public static void iterar(double inicio) {
        double tolerancia = 0.001;
        double errorRelativo = 1;
        double resultadoFuncion;
        double resultadoDerivada;
        double resultadoProceso = 0;
        
        while (errorRelativo > tolerancia) {
            errorRelativo = 0.0;
            resultadoFuncion = funcion(inicio);
            resultadoDerivada = derivada(inicio);
            resultadoProceso = inicio - (resultadoFuncion / resultadoDerivada);
            errorRelativo = Math.abs(resultadoProceso - inicio);
            inicio = resultadoProceso;
            evaluaciones.add(resultadoProceso);
            errores.add(errorRelativo);
        }
        //System.out.println("Ultima evaluacion: " + resultadoProceso);
        //System.out.println("Error relativo final: " + errorRelativo);
    }
    
    public static double funcion(double x){
        return  Math.pow(Math.E, x) -5;
    }
    
    public static double derivada(double x){
        return Math.pow(Math.E, x);
    }
    
    public static void mostrar() {
        System.out.println("\nIteracion\tEvaluacion\t\tError relativo");
        for(int i = 0; i< evaluaciones.size(); i++) {
            System.out.println((i+1) + "\t\t" + evaluaciones.get(i) + "\t" + errores.get(i));
        }
    }
}
