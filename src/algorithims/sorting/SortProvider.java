/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithims.sorting;

import java.util.Arrays;


/**
 *
 * @author Pranay
 */
public class SortProvider {

   public static void  quickSort(int[] dataToSort,int startIndex ,int endIndex){
       if(dataToSort == null){
           throw new NullPointerException(" Input Array cannot be null");
       }
    //   System.out.println("start index" +startIndex);
     //  System.out.println("endIndex" +endIndex);
       if(startIndex >= endIndex) {
           return;
       }
       
       // chose the rightmost element
       int pivotIndex = endIndex;
       int leftIndex = startIndex;
       int rightIndex = pivotIndex-1;
       boolean done  = false;
       while(done){
           while((rightIndex > leftIndex) && (dataToSort[leftIndex] <= dataToSort[pivotIndex])){
               leftIndex++;
           }
           
           while((rightIndex > leftIndex) && (dataToSort[rightIndex] >= dataToSort[pivotIndex])) {
                rightIndex--;
           }
          if(rightIndex > leftIndex){
              done = true;
          }
          {
           int tempPIValue = dataToSort[pivotIndex];
           int tempLeftValue = dataToSort[leftIndex];
           int tempRightValue = dataToSort[rightIndex];
           dataToSort[pivotIndex] = tempLeftValue;
           dataToSort[leftIndex] = tempRightValue;
           dataToSort[rightIndex] = tempPIValue;
            pivotIndex = rightIndex;
          rightIndex--;
          leftIndex++;
          }
                  
       }
       quickSort(dataToSort,startIndex,pivotIndex -1 );
        quickSort(dataToSort, pivotIndex +1, endIndex);
   }
   
   public static void main(String[] args){
       int[] dataToSort =  {9, 7, 5, 11, 12, 2, 14, 3, 10, 6};
       quickSort(dataToSort,0,dataToSort.length-1);
       print(dataToSort);
   }

    private static void print(int[] dataToSort) {
        for(int data : dataToSort){
            System.out.print(data + " ");
        }
        System.out.println();
    }
}
