import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskHacker1 {
	
	

	

	
	public static void main(String[] args) {
		
	}
	
	
	/*
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		List<Integer> arr = new ArrayList<Integer>(n);
		
		for (int i = 1; i <= n; i++)
			arr.add(scanner.nextInt());
		

	 
		Integer b;
		Integer c;
		for (int i = 0; i < arr.size(); i++) {
			System.out.println("i="+i);
			
			b = 0;
			c = null;
			for (int j = 0; j <= i-1; j++) {
				b += arr.get(j);
				c = arr.get(j+1);
				
				if (b == c)
					System.out.println(i);
			}

			b = 0;
			for (int k = i+1; k < arr.size(); k++) {
				b += arr.get(k);
				c = arr.get(k-1);
				
				if (b == c)
					System.out.println(i);
			}				
		}
		
		
		
		
		for (int i = 1; i <= n; i++) {
			if (i%3 == 0 && i%5 == 0)
				System.out.println("FizzBuzz");
			else if (i%3 == 0 && i%5 != 0)
				System.out.println("Fizz");
			else if (i%5 == 0 && i%3 != 0)
				System.out.println("Buzz");
			else
				System.out.println(i);
		}

		
		
		scanner.close();
	}
	
	static String balancedSums(ArrayList<Integer> arr) {
	    int x = 0;
	    int sum = 0;
	    for (int a : arr) {
	      sum += a;
	    }
	
	    for (int y : arr) {
	      if (2 * x == sum - y) {
	        return "YES";
	      }
	      x = x + y;
	    }
	    return "NO";
	}
	*/
}
