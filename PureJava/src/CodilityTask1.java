
public class CodilityTask1 {

	public int solution(int[] A, int Y) {
        // write your code in Java
        int max = Y;
        int N = A.length;

        int l = A[0];
        int i=0;
        int k;
        while (i<N) {
            k=0;
            l=A[i];
            while (i<N && A[i]==l)  {
                i++;
                k++;
            }
            int R=N-i;
            if (R>=Y) R = Y;
            if ((k+R) > max) max = k+R;
        }
        return max;
    }
	
	public static void main(String[] args) {
		CodilityTask1 solution = new CodilityTask1();

        int[] a = {1, 1, 3, 3, 3, 4, 5, 5, 5, 5};
        int y = 2;
        System.out.println(solution.solution(a, y));
    }

}
