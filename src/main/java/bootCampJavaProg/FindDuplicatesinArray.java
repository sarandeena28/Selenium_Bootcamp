package bootCampJavaProg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindDuplicatesinArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int j=1;
		number(j);
	}
		public static void number(int i) {
			if(i<=100) {
				
				System.out.println(i);
				number(i+1);
				
			}
		}
		
//		int[] a ={1,2,2,3,4,4,5,5,6,7};
//		int[] duplicateValue=new int[10];
//		HashSet<Integer> duplicate=new HashSet<Integer>();
//		HashSet<Integer> noDuplicates=new HashSet<Integer>();
//		for (int i = 0; i < a.length; i++) {
//			for (int j =i+1; j < a.length; j++) {
//				if(a[i]==a[j]) {
//					duplicate.add(a[i]);
//				}
//				else {
//					noDuplicates.add(a[i]);
//				}
//				
//			}
//		}
//		System.out.println("Duplicate values are:"+duplicate);
//		System.out.println("Non duplicates"+noDuplicates);

//		for (int i = 0; i < a.length; i++) {
//			for (int j = i+1; j < a.length; j++)
//					if(a[i]==a[j])	{
//						System.out.println(a[j]);
//					}
//
//		}
	
	}


