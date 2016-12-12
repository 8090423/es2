/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es2.git;

import java.util.Scanner;

/**
 *
 * @author Titi_
 */
public class Es2Git {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


       Scanner scan = new Scanner(System.in);
        int num = 0;
        
        System.out.println("Insira um caracter: I , X , C , M , V , L , D:");
        String car = scan.next();
        
        switch(car){
            case "I" : case "i":
                num = 1;
                break;
            case "X": case "x":
                num = 10;
                break;
            case "C": case "c":
                num = 100;
                break;
            case "M": case "m":
                num = 1000;
                break;
            case "V": case "v":
                num = 5;
                break;
            case "L": case "l":
                num = 50;
                break;
            case "D": case "d":
                num = 500;
                break;
        }
        
        System.out.println("Numero em arabico: " + num);
        
    }
    
}
