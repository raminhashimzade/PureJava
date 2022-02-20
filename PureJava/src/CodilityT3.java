import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class CodilityT3 {

	public static int solution(int[] A) {

		// write your code in Java SE 8

		Map<Double, Integer> factories = new TreeMap<>(Collections.reverseOrder());

		double totalPollution = 0;

		for (int i = 0; i < A.length; i++) {
			double x = Double.valueOf(A[i]);
			totalPollution += x;
			factories.put(x, factories.get(x) != null ? factories.get(x) + 1 : 1);
		}

		double halfPollution = totalPollution / 2;

		int result = 0;
		while (totalPollution > halfPollution) {
			for (Map.Entry<Double, Integer> entry : factories.entrySet()) {
				totalPollution -= (entry.getKey() / 2);
				if (entry.getValue() > 1) {
					factories.put(entry.getKey(), entry.getValue() - 1);
					factories.put(entry.getKey() / 2,
							factories.get(entry.getKey() / 2) != null ? factories.get(entry.getKey() / 2) + 1 : 1);
				} else {
					factories.remove(entry.getKey());
					factories.put(entry.getKey() / 2,
							factories.get(entry.getKey() / 2) != null ? factories.get(entry.getKey() / 2) + 1 : 1);
				}
				break;
			}
			result++;
		}

		return result;

	}

	public static void main(String[] args) {

		int[] a = { 5, 19, 8, 1 };

		System.out.println(solution(a));
	}
}
