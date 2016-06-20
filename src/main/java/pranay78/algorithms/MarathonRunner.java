/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pranay78.algorithms;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pranay
 */
public class MarathonRunner {

    public static class CollageParticipate {
        private final int numberOfStudents;
        private int numberOfStudentsByCollage1;
        private int numberOfStudentByCollage2;

        public CollageParticipate(final int numberOfStudents) {
            this.numberOfStudents = numberOfStudents;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 67 * hash + this.numberOfStudents;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final CollageParticipate other = (CollageParticipate) obj;
            if (this.numberOfStudents != other.numberOfStudents) {
                return false;
            }
            return true;
        }
        
        public void incrementCollage1Student(){
            numberOfStudentsByCollage1++;
        }
        
         public void incrementCollage2Student(){
            numberOfStudentByCollage2++;
        }
         
         public boolean matched() {
             return numberOfStudentsByCollage1 == numberOfStudentByCollage2;
         } 
    }
    
    public static String collegecomparison(int input1,int[] input2,int[] input3){
        if(input2.length != input1 || input3.length != input1){
            return "Invalid";
        }
        Map<Integer,CollageParticipate> mapOfCollageParticapate = new HashMap();
        for(int i=0;i<input1;i++){
            if(input2[i] < 0 || input3[i] < 0){
                return "Invalid";
            }
            
            
            CollageParticipate collageParticipate1 = mapOfCollageParticapate.get(input2[i]);
            if(collageParticipate1 == null){
                collageParticipate1 = new CollageParticipate(input2[i]);
                collageParticipate1.incrementCollage1Student();
                mapOfCollageParticapate.put(input2[i], collageParticipate1);
            }else{
                collageParticipate1.incrementCollage1Student();
            }
            
            CollageParticipate collageParticipate2 = mapOfCollageParticapate.get(input3[i]);
            if(collageParticipate2 == null){
                collageParticipate2 = new CollageParticipate(input3[i]);
                collageParticipate2.incrementCollage2Student();
                mapOfCollageParticapate.put(input3[i], collageParticipate2);
            }else{
                collageParticipate2.incrementCollage2Student();
            }
        }
        
        Collection<CollageParticipate> collageParticipates = mapOfCollageParticapate.values();
        for(CollageParticipate collageParticipate : collageParticipates){
            if(!collageParticipate.matched()){
                return "Unequal";
            }
        }
        
        
        return "Equal";
    }
    
    public static void main(String[] args){
        int input1 = 7;
        int[] input2 = {12,11,5,2,7,5,11};
        int[] input3 = {5,12,5,7,11,2};
        System.out.println(collegecomparison(input1,input2,input3));
    }

}
