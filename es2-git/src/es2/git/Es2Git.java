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

    public static int getArab(String c){
        
        
        
       
        int num = 0;
        
        
        
        switch(c){
            case "I" : 
                num = 1;
                break;
            case "X": 
                num = 10;
                break;
            case "C": 
                num = 100;
                break;
            case "M": 
                num = 1000;
                break;
            case "V": 
                num = 5;
                break;
            case "L": 
                num = 50;
                break;
            case "D": 
                num = 500;
                break;
            default: 
                num = -1;
        }
        
       return num;
        
        
    }
    
    public static String toUpper(String c){
        return c.toUpperCase();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       
       Scanner scan = new Scanner(System.in);
       
        System.out.println("Insira um caracter: I , X , C , M , V , L , D:");
        String car = scan.next();
        
        
        
        System.out.println(getArab(toUpper(car)));
        
    }
    
}
