import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n+1];
        for (int i=1;i<=n;i++) {
            a[i] = scanner.nextInt();
        }
        int[] memberColors = new int[n+1];
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(1);
        memberColors[1]=1;

        for (int i=2;i<=n;i++) {
            if (i != n) {
                if (a[i - 1] == a[i]) {
                    memberColors[i] = memberColors[i - 1];
                } else {
                    memberColors[i] = getDifferentColor(colors, memberColors[i - 1],0);
                }
             } else {
                int color1=0;int color2=0;
                if (a[i - 1] == a[i]) {
                    color1=0;
                } else {
                    color1=memberColors[i - 1];
                }

                if (a[1] == a[i] ){
                    color2=0;
                } else {
                    color2 = memberColors[1];
                }
                memberColors[i] = getDifferentColor(colors, color1,color2);
            }
        }
        System.out.println(colors.size());
        for (int i=1;i<=n;i++) {
            System.out.print (memberColors[i]+" ");
        }

    }

    private static int getDifferentColor(ArrayList<Integer> colors, int color1, int color2) {
        int resultColor=0;
        for (int j = 0; j < colors.size(); j++) {
            if (color1 != colors.get(j) && color2 != colors.get(j)) {
                resultColor = colors.get(j);
                break;
            }
        }
        if (resultColor==0) {
                int newColor=colors.size()+1;
                colors.add(newColor);
                resultColor = newColor;
        }
        return resultColor;
    }

}