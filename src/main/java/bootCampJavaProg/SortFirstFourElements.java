package bootCampJavaProg;

public class SortFirstFourElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] a={1,4,8,3,7,6,2};
		 int length = a.length-3;
		 int temp=0;
		 for (int i=0; i <length; i++){
			 for (int j = i+1; j < length; j++) {
				 System.out.println(a[i]);
				 System.out.println(a[j]);
				 	if(a[i]>=a[j]) {
				 			temp=a[i];
				 			a[i]=a[j];
				 			a[j]=temp;
				 	}
				 	 System.out.println(a[i]);
					 System.out.println(a[j]);
			 }
			
		 }
		 for (int i = 0; i <length; i++) {
			 System.out.println(a[i]);
			
		}


	}
}
