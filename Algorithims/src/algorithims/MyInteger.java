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
System.out.println("algorithims.MyInteger.main() "  +Integer.MAX_VALUE);
System.out.println("algorithims.MyInteger.main() "  +Integer.MIN_VALUE);

    }
}
