/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithims;

/**
 *
 * @author Pranay
 */
public class EmployeeHieght {
     public static int[] uniqueValue(int input1,int[] input2)
    {
        int[] output = new int[input1]; //
        
        for(int i=input1-1;i>=0;i--){
            int indexOfOutput  =  input2[i];
            if(output[indexOfOutput] == 0){
                output[indexOfOutput] = i+1;
            }else{
               // int valueAtIndex = output[indexOfOutput]; 
               move(indexOfOutput,output);
                output[indexOfOutput] = i+1;
               
               
            }
        }
        
        return output;
    }
     
     private static void move(int index , int[] array ){
         if(index == array.length -1){
             return;
         }
         if(array[index+1] != 0){
             move(index+1,array);
         }
         array[index+1] = array[index];
     }
     
     public static void main(String[] args){
         
        // int[] output = uniqueValue(4, new int[] {2,1,1,0});
//         int[] output = uniqueValue(5, new int[] {3,2,2,1,0});
//         for(int i=0;i<5;i++){
//             System.out.print(output[i] + " " );
//         }

 int[] output = uniqueValue(6, new int[] {3,2,0,2,1,0});
         for(int i=0;i<6;i++){
             System.out.print(output[i] + " " );
         }
     }
}
