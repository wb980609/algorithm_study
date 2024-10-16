import java.util.LinkedList;
import java.util.Queue;

public class Practice2 {
    public static void main(String[] args){
        Queue queue = new LinkedList();

        for(int i = 1; i<11; i++){
            queue.add(i);
        }
        System.out.println(queue.poll());

        System.out.println(queue);

        System.out.println(queue.peek());

        System.out.println(queue);

        System.out.println(queue.size());

        System.out.println(queue.isEmpty());
    }
}
