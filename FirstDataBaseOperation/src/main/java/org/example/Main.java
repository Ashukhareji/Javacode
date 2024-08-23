package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       int[] arr={2,1,2,0,1,1,2};
      int[] arr2={0,1,2};
      int index=0;
       int[] temp=new int[arr.length];

       for(int i=0;i< arr2.length;i++){
           for(int j=0;j< arr.length;j++){
               if(arr2[i]==arr[j]){
                   temp[index++]=arr2[i];
               }
           }
       }
        System.out.println(Arrays.toString(temp));
    }
}