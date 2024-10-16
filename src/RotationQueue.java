import java.util.LinkedList;
import java.util.Scanner;


public class RotationQueue {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]		예시

        //[2, 3, 4, 5, 6, 7, 8, 9, 10, 1]		조건2        count++      1
        //[3, 4, 5, 6, 7, 8, 9, 10, 1]		    조건1		poll(2)
        //[1, 3, 4, 5, 6, 7, 8, 9, 10]		    조건3        count++      2
        //[10, 1, 3, 4, 5, 6, 7, 8, 9]		    조건3        count++      3
        //[9, 10, 1, 3, 4, 5, 6, 7, 8]		    조건3        count++      4
        //[10, 1, 3, 4, 5, 6, 7, 8]			    조건1		poll(9)
        //[8, 10, 1, 3, 4, 5, 6, 7]			    조건3        count++      5
        //[7, 8, 10, 1, 3, 4, 5, 6]			    조건3        count++      6
        //[6, 7, 8, 10, 1, 3, 4, 5]			    조건3        count++      7
        //[5, 6, 7, 8, 10, 1, 3, 4]			    조건3        count++      8
        //[6, 7, 8, 10, 1, 3, 4]			    조건1		poll(5)

        LinkedList<Integer> deque = new LinkedList<Integer>();

        int count = 0;	// 2, 3번 연산 횟수 누적 합 변수

        int N = sc.nextInt();	// 큐의 크기(1 ~ N)
        int M = sc.nextInt();	// 뽑으려는 숫자의 개수

        // 1부터 N까지 덱에 담아둔다.
        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] seq = new int[M];	// 뽑고자 하는 수를 담은 배열

        for(int i = 0; i < M; i++) {
            seq[i] = sc.nextInt();
        }
    }
}
