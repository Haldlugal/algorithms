

public class Homework4 {

    public static void main(String[] args) {
        Queue queue = new Queue();
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
