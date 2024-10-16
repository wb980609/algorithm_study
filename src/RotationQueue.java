import java.util.LinkedList;
import java.util.Scanner;


public class RotationQueue {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 예상 로직 (양방향 순환 큐 이므로 dequeue 로 가정할 수도 있을 것 같다
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

        LinkedList<Integer> queue = new LinkedList<Integer>();

        int count = 0;	// 2, 3번 연산 횟수 누적 합 변수

        int N = sc.nextInt();	// 큐의 크기(1 ~ N)
        int M = sc.nextInt();	// 뽑으려는 숫자의 개수

        // 1부터 N까지 덱에 담아둔다.
        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int[] seq = new int[M];	// 뽑고자 하는 수를 담은 배열

        for(int i = 0; i < M; i++) {
            seq[i] = sc.nextInt();
        }

        for(int i = 0; i < M; i++) {

            // 덱에서 뽑고자 하는 숫자의 위치(index) 찾기
            int target_idx = queue.indexOf(seq[i]);
            int half_idx;
            // 중간지점을 설정해야하는데 현재 덱의 원소가 홀수개라면 queue.size() % 2를,
            // 짝수 개라면 중간 지점을 queue.size() % 2 - 1 을 중간점으로 잡는다

            if(queue.size() % 2 == 0) {
                half_idx = queue.size() / 2 - 1;
            }
            else {
                half_idx = queue.size() / 2;
            }

            // 중간 지점 또는 중간 지점보다 원소의 위치가 앞에 있을 경우
            if(target_idx <= half_idx) {
                // idx 보다 앞에 있는 원소들을 모두 Rear로 보낸다. (2번 연산)
                for(int j = 0; j < target_idx; j++) {
                    int temp = queue.pollFirst();
                    queue.offerLast(temp);
                    count++;
                }
            }
            else {	// 중간 지점보다 원소의 위치가 뒤에 있는 경우
                // idx를 포함한 뒤에 있는 원소들을 모두 Front로 보낸다. (3번 연산)
                for(int j = 0; j < queue.size() - target_idx; j++) {
                    int temp = queue.pollLast();
                    queue.offerFirst(temp);
                    count++;
                }

            }
            queue.pollFirst();	// 연산이 끝나면 맨 앞 원소를 삭제
        }

        System.out.println(count);

    }
}
