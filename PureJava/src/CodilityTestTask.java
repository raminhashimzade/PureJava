import java.util.Arrays;

public class CodilityTestTask {
    public static int solution(int[] A) {
    	Arrays.sort(A);
    	
        Integer out;
        int prev = 0;
        int curr = 0;
        
        for (int i = 0; i < A.length; i++) {        	
        	curr = A[i];
        	
			if (i > 0) {
				prev = A[i-1];
			}
			
			int a = curr-prev;			
			out = prev+1;			
			if(a>1 & out > 0) {				
				return out;
			}			
		}
        
        if (curr > 0)
        	return curr+1;
        else
        	return 1;
    }
    
    
	public static void main(String[] args) {		

        //int[] a = {1,3,6,4,1,2};
		int[] a = {1,2,3};
        
        System.out.println(solution(a));
       
        
    }    
}
