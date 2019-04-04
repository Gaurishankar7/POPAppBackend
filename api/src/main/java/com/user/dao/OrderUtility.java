package com.user.dao;

import java.util.Arrays;

public class OrderUtility {

	static int i;
	
	public static int getSize(int arr[])
	{
		int size = arr.length;
		return size;
		
	}
	public static  int[] convertStringToIntArray(String s) {
        String[] items = s.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(","); 
        int[] results = new int[items.length];
        for (int i = 0; i < items.length; i++) { 
            try { 
                    results[i] = Integer.parseInt(items[i]); 
                System.out.println(results[i]);
               
            } 
          
            catch (NumberFormatException nfe) {
                //NOTE: write something here if you need to recover from formatting errors }; 
            }
        }//for
        return results;
}
	
	
	public static  int convertStringToIntArray1(String s) {
        String[] items = s.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(","); 
        int size = items.length;
        System.out.println();
        System.out.println(size);
        int[] results = new int[items.length];
        System.out.println(items.length);
        for (int i = 0; i < items.length; i++) { 
            try { 
                    results[i] = Integer.parseInt(items[i]); 
                System.out.println(results[i]);
               
            } 
          
            catch (NumberFormatException nfe) {
              nfe.printStackTrace();
              System.out.println(nfe);
            }
        }
        
		return results[i];
}
	public static String convertIntArrayToString(int arr[])
	{
		String testString = Arrays.toString(arr);
		return testString;
				
	}
//	public static void main(String args[])
//	{
//		int a = OrderUtility.convertStringToIntArray1("[1,2,3]");
//		int arr []= {1,2,3};
//		int size = OrderUtility.getSize(arr);
//		System.out.println(size);
//	}
}