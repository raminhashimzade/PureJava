import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopTalTest {

	// -------------- (1)
	private static List<Integer> getChange(BigDecimal M, BigDecimal P) {

		BigDecimal qaliq = M.subtract(P);

		BigDecimal[] d = { BigDecimal.valueOf(1), 
				BigDecimal.valueOf(0.5), 
				BigDecimal.valueOf(0.25), 
				BigDecimal.valueOf(0.1),
				BigDecimal.valueOf(0.05), 
				BigDecimal.valueOf(0.01) };
		
		List<Integer> result = new ArrayList<Integer>();

		System.out.println("qaliq22 = " + qaliq);
		for (int i = 0; i < d.length; i++) {

			int dm = qaliq.divide(d[i], 2, RoundingMode.FLOOR).intValue();
			System.out.println("di = "+d[i]+"    2.dm = " + dm);
			
			qaliq = qaliq.subtract(d[i].multiply(BigDecimal.valueOf(dm)));
			System.out.println("qaliq = " + qaliq);
			

			result.add(dm);
		}
		System.out.println(result);

		return result;
	}

	// -----------
	public static void main(String[] args) {

		System.out.println("Hello World!");

		Scanner scanner = new Scanner(System.in);

		BigDecimal m = scanner.nextBigDecimal();
		BigDecimal p = scanner.nextBigDecimal();
		scanner.close();

		getChange(m, p);
	}

}
