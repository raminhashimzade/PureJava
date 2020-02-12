import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task3OK {
	public static Set<Integer> alreadyFindPos = new HashSet<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] p = new int[n + 1];
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = scanner.nextInt();
		}
		//// solution
		for (int i = n; i > 0; i--) {
			int pos = findZeroPos(a);
			p[pos] = i;
			reCalcSum(a, pos);
			alreadyFindPos.add(pos);
		}
		////
		for (int i = 1; i <= n; i++) {
			System.out.print(p[i] + " ");
		}
		scanner.close();
	}

	private static void reCalcSum(int[] a, int pos) {
		for (int i = 1; i < a.length; i++) {
			a[i] = a[i] - (Math.abs(pos - i));
		}
	}

	public static int findZeroPos(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (alreadyFindPos.contains(i))
				continue;
			if (a[i] == 0)
				return i;
		}
		return 0;
	}
}
