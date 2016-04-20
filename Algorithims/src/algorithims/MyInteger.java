/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithims;

import java.util.Arrays;

/**
 *
 * @author Pranay
 */
public class MyInteger {
    private final int value;
    public MyInteger(final int value){
        this.value = value;
    }
    
    @Override
    public String toString(){
        long startTime = System.nanoTime();
            int tempValue = this.value ;
            boolean isNagative = false;
                if(this.value < 0) {
                    isNagative = true;
                }
                int divValue = tempValue /10;
                int modValue = tempValue % 10;
                StringBuilder sb  = new StringBuilder();
                sb.append(Character.forDigit(Math.abs(modValue), 10));
                while(divValue != 0){
                     modValue = divValue % 10;
                     divValue = divValue /10;
                
              
                sb.append(Math.abs(modValue));
                }
                if(isNagative){
                    sb.append("-");
                }
                sb.reverse();
                long endTime = System.nanoTime();
                System.out.println("Time taken  " + (endTime - startTime));
        return sb.toString();
    }
    
    public static void main(String[] args){
        
    	MyInteger myInteger = new MyInteger(-125);
        System.out.println("algorithims.MyInteger.main()" + myInteger);
        System.out.println("algorithms.MyInteger.lowLevelToString()" + lowLevelToString(-125));
        
        System.out.println("algorithims.MyInteger.main() "  +Integer.MAX_VALUE);
        System.out.println("algorithims.MyInteger.main() "  +Integer.MIN_VALUE);

    }
    
    private static String lowLevelToString(int num) {
    	
    	long startTime = System.nanoTime();
    	
    	char[] characters = new char[12];
    	int i;
    	int character;
    	char sign=' ';
    	if(num<0) {
    		sign='-';
    		num=num*-1;
    	}
    	for(i=11;i>=0;i--) {
    		if(num==0) {
    			break;
    		}
    		character = num%10;
    		if(character==0) {
    			characters[i]= '0';
    		} else {
    			characters[i]= (char)('1'-1+character);
    		}
    		
    		num=num/10;
    	}
    	characters[i]=sign;
    	String returnValue = String.valueOf(characters, i, (12-i));
    	
        long endTime = System.nanoTime();
        
        System.out.println("Time taken (lowLevelToString) = " + (endTime - startTime));

    	return returnValue;
    }
}
