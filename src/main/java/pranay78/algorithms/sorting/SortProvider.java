/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pranay78.algorithms.sorting;

import java.util.Arrays;


/**
 *
 * @author Pranay
 */
public class SortProvider {

   public static void  quickSort(int[] dataToSort,int startIndex ,int endIndex){
	   
		if (dataToSort == null) {
			throw new NullPointerException(" Input Array cannot be null");
		}
		// System.out.println("start index" +startIndex);
		// System.out.println("endIndex" +endIndex);
		if (startIndex >= endIndex) {
			return;
		}

		// chose the rightmost element
		int pivotIndex = endIndex;
		int leftIndex = startIndex;
		int rightIndex = pivotIndex - 1;
		boolean done = false;

		   System.out.printf("quickSort() data:%s ; startIndex:%d ; endIndex:%d ; pivotIndex:%d \n",
				   Arrays.toString(Arrays.copyOfRange(dataToSort, startIndex, endIndex+1)), startIndex, endIndex, pivotIndex);
		   
		while (!done) {
			while ((rightIndex > leftIndex) && (dataToSort[leftIndex] <= dataToSort[pivotIndex])) {
				leftIndex++;
			}

			while ((rightIndex > leftIndex) && (dataToSort[rightIndex] >= dataToSort[pivotIndex])) {
				rightIndex--;
			}
			
			if (rightIndex < leftIndex) {
				done = true;
			} else {
				// int tempPIValue = dataToSort[pivotIndex];
				int tempLeftValue = dataToSort[leftIndex];
				int tempRightValue = dataToSort[rightIndex];
				// dataToSort[pivotIndex] = tempLeftValue;
				dataToSort[leftIndex] = tempRightValue;
				dataToSort[rightIndex] = tempLeftValue;
				// pivotIndex = rightIndex;
				rightIndex--;
				leftIndex++;
			}

		}
		
//		System.out.println("Before Pivot Insert:" + pivotIndex + " Result:" + Arrays.toString(dataToSort));
		
		leftIndex--;
		int tempPIValue = dataToSort[pivotIndex];
		dataToSort[pivotIndex] = dataToSort[leftIndex];
		dataToSort[leftIndex] = tempPIValue;
		
		System.out.printf("After Pivot Insert Element: %d Result: %s \n", 
				tempPIValue, Arrays.toString(Arrays.copyOfRange(dataToSort, startIndex, endIndex+1)));
		
		quickSort(dataToSort, startIndex, leftIndex - 1);
		quickSort(dataToSort, leftIndex + 1, endIndex);
       
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
