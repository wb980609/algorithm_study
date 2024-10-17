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

        Arrays.sort(arr);   // Arrays 내장함수 sort()를 사용하여 오름차순 정렬
        System.out.println(arr[0] + " " + arr[N-1]);    // 오름차순 정렬이므로 첫번째 인덱스가 최소 마지막 인덱스가 최대

    }
}
