import java.util.LinkedList;

public class Queue {
        private final LinkedList<Integer> list;

        public Queue() {
            list = new LinkedList<>();
        }

        public boolean isEmpty() { return (list.size() == 0); }
        public int size() { return list.size(); }

        public void insert(int i) {
            list.addFirst(i);
        }

        public int remove() {
            Integer tmp = list.getLast();
            list.removeLast();
            return tmp;
        }

        public int peek(){
            return list.getLast();
        }


    @Override
    public String toString() {
        return "Queue{" +
                "list=" + list +
                '}';
    }
}