/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mpeht
 */
public class Count {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        System.out.println("Enter the size of vector:");
        num = sc.nextInt();
        int vector [] = new int[num];
        System.out.println("Enter the values for vector fill:");
        for(int i = 0; i < vector.length; i++)   {
            vector[i] = sc.nextInt();
        }
        countSort(vector);
    }
    
    public static void countSort(int vect [])    {
        
        int biggestNumber = getNumber(vect);
        
        int c [] = new int[biggestNumber + 1];
        for(int i = 0; i < vect.length; i++) {
            c[vect[i]] += 1;
        }
        for(int i = 1; i < c.length; i++)   {
            c[i] += c[i - 1];
        }
        int b [] = new int[vect.length];
        for(int i = b.length - 1; i >= 0; i--)  {
            b[c[vect[i]] -1] = vect[i];
            c[vect[i]]--;
        }
        System.out.println(Arrays.toString(b));
    }
    
    public static int getNumber(int [] vet) {
        int max = Integer.MIN_VALUE;
        int a;
        for(a = 0; a < vet.length; a++) {
            if(max < vet[a])    {
                max = vet[a];
            }
        }
        return max;
    }
    
}
