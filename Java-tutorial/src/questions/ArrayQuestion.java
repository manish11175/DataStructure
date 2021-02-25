package questions;

public class ArrayQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int arr[]= {1,2,3,4,5,6};
	getAns(arr);
	
	}
	
	public static void getAnsInO(int []arr)
	{
		
	}
	
	public static void getAns(int []arr)
	{
		
		int n=arr.length;
		int ans[]=new int[n];
		for(int i=0;i<n;i++)
	    {
	    	int sum=0;
	    	for(int j=i;j<=i*2 && j<n;j++)
	    	{
	    		sum+=arr[j];
	    	}
	    	ans[i]=sum;
	    }
	  for(int i:ans)
	  {
		  System.out.print(i+" ");
	  }
	}
	

}
