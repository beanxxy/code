import java.util.Deque;
import java.util.LinkedList;

public class bb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<String> deque = new LinkedList<String>();
		deque.offerFirst("a1");
		deque.offerFirst("a2");
		deque.offerLast("a3");
		deque.offerFirst("a4");
		while(deque.size()!=0) {
			System.out.println(deque.poll()); 
		}
	}

}