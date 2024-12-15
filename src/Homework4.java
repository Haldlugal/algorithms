

public class Homework4 {

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.insert(1);
        queue.insert(3);
        queue.insert(2);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue);
    }


}
