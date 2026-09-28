package org.example;

import java.util.Arrays;

import java.util.Scanner;

/* Makail Casey, 9/28/2029, Cosc 214

 */

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    
    public static void main(String[] args) {
        
        // Lab Work: Ask the user how many integer numbers to be sorted
        //Declare the array and populate the array
        
        System.out.printf("\nInput the amount of values you want to put into the array: ");
        
        Scanner userInput = new Scanner(System.in);
        
        int input_size = userInput.nextInt();
        
        // Use scanner objet and nextInt() to initialize input_size
        int [] input = new int[input_size];
        
        for (int i = 0; i < input.length; i++) {
            System.out.printf("\nInput integer for element " + i + ": " );
            
            input[i] = userInput.nextInt();
            
            System.out.println(Arrays.toString(input));
        }
        
        // take input from the user here using a loop
        
        // Java array is passes by value or reference?? <---- It passes by value
        int low = 0;
        
        int high = input.length - 1;
        
        MergeSort(input, low, high);
        
        System.out.println("The sorted array: " + Arrays.toString(input));
        
    }
    
    //low = lowest element. High = Highest element
    public static void MergeSort(int [] A, int low, int high) {
        
        if (low < high) {
            
            //divide
            int mid = low + (high - low)/2;
            
            //Using Recursion to seperate an array into 2 halves, sorts both halves within mergesort, then puts
            // them back together
            MergeSort(A, low, mid);
            
            MergeSort(A, mid+1, high);
            
            Merge(A, low, mid, high);
            
        }
        
    }
    
    public static void Merge(int [] A, int low, int mid, int high){
        
        /* We did all of this in class I just had to add a little bit to the end to add back
        everything from the tempeorary arrray to the new one
        
        The K variable determines how the array gets cut in half, i/j determines how the
        method iterates inside each half of the array*/
        int i = low;
        
        int k = mid + 1;
        
        /* This array is created as a temporary one to store the seperated array values and then
        add it back into the original array */
        int[] array1 = new int [high - low + 1];
        
        int j = 0;
        
        while (i <= mid && k <= high) {
            
            //We did all of this below in class this monday
            if (A[i] <= A[k]) {
                
                array1[j] = A[i];
                i++;
            }
            else {
                array1[j] = A[k];
                k++;
            }
            
            j++;
        }
        
        // Take an element from the first half of the array and then add them back to the original
        while (i <= mid) {
            array1[j] = A[i];
            i++;
            j++;
        }
        
        // Take an element from the second half of the array and then add them back to the original
        while (k <= high) {
            array1[j] = A[k];
            j++;
            k++;
        }
        
        // Putting the temperoray array back into the original array
        for (j = 0; j < array1.length; j++) {
            A[low + j] = array1[j];
        }
    }
    
}