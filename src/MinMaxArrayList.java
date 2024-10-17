import java.util.Arrays;
import java.util.Scanner;

public class MinMaxArrayList {
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();           // 정수의 개수 N
        int[] arr = new int[N];         // 둘째줄에 받아올 정수를 담을 크기가 N인 배열

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println(arr[0] + " " + arr[N-1]);

    }
}
