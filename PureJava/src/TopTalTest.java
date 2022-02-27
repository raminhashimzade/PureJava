import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopTalTest {

	//-------------- (1)
	private static List<Integer> getChange(float M, float P) {
		
		float qaliq = M-P;
		
		float[] d = {1,(float)0.5,(float)0.25,(float)0.1,(float)0.05,(float)0.01};
		List<Integer> result = new ArrayList<Integer>(); 
		
			
		for (int i = 0; i < d.length; i++) {
			int dm = (int) Math.floor(qaliq/d[i]);			
			qaliq = qaliq - dm*d[i];			
			result.add(dm);
		}		
		System.out.println(result);
		
		return result;
	}

	//-----------
	public static void main(String[] args) {

		System.out.println("Hello World!");

		Scanner scanner = new Scanner(System.in);
		
		float m = scanner.nextFloat();
		float p = scanner.nextFloat();		
		scanner.close();

		getChange(m, p);
	}
	
	
}
