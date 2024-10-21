import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CircleArray {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> circle = new ArrayList<>();
        for(int i = 1 ; i<= N; i++){
            circle.add(i);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");

        int index = 0;

        while(!circle.isEmpty()){
            index = (index + K -1) % circle.size();
            result.append(circle.remove(index));
            if(!circle.isEmpty()){
                result.append(", ");
            }
        }

        result.append(">");

        System.out.println(result);
    }
}
