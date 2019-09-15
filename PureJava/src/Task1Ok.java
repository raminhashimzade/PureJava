import java.util.Scanner;

public class Task1Ok {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int[] t = new int[a];
		int dif;
		int min = -1, m = -1;

		for (int i = 0; i < a; i++) {
			
			t[i] = scanner.nextInt();
			
			for (int j = 0; j < i; j++) {
				dif = t[i] - t[j];
				if (Math.abs(dif) <= 5) {
					m = i - j - 1;
					if (m < min || min == -1)
						min = m;
				}
			}
		}
		System.out.println(min);
	}
}
