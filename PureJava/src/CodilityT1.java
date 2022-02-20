import java.util.Arrays;

public class CodilityT1 {

public int solution(int[] P, int[] S) {
        // write your code in Java SE 8
        int peopleCount = 0;
        for (int pCount: P) {
            peopleCount += pCount;
        }

        Arrays.sort(S);

        int result = 0;
        for (int i = S.length-1; i>=0 && peopleCount >0; i--) {
            peopleCount -= S[i];
            result++;
        }

        return result;
    }
}
