import java.util.Arrays;

public class Dequeu {
    private int maxSize;
    private int[] queue;
    private int items;
    private int head;
    private int tail;

    public Dequeu(int s) {
        maxSize = s;
        queue = new int[maxSize];
        head = 0;
        tail = -1;
        items = 0;
    }

    public boolean isEmpty() { return (items == 0); }
    public boolean isFull() { return (items == maxSize); }
    public int size() { return items; }

    public void addFirst(int i) {
        if (isFull()) {
            increaseSize();
        }
        if (head == 0) {
            head = maxSize;
        }
        queue[--head] = i;
        ++items;
    }

    public void addLast(int i) {
        if (isFull()) {
            increaseSize();
        }
        if (tail == maxSize - 1) {
            tail = -1;
        }
        queue[++tail] = i;
        ++items;
    }

    public int removeFirst() {
        int temp = queue[head++];
        head %= maxSize;
        items--;
        return temp;
    }

    public int removeLast() {
        int temp = queue[tail--];
        if (tail == -1) {
            tail = maxSize - 1;
        }
        items--;
        return temp;
    }

    public int peekFirst() {
        return queue[head];
    }

    public int peekLast() {
        return queue[tail];
    }

    private void increaseSize() {
        maxSize *= 2;
        int[] tmpArr = new int[maxSize];
        if (tail >= head) {
            System.arraycopy(queue, 0, tmpArr, 0, queue.length);
        } else {
            System.arraycopy(queue, 0, tmpArr, 0, tail + 1);
            System.arraycopy(queue, head, tmpArr,
                    maxSize - (queue.length - head), queue.length - head);
            head = maxSize - head - 1;
        }
        queue = tmpArr;
    }

    @Override
    public String toString() {
        return "Dequeu{" +
                "maxSize=" + maxSize +
                ", queue=" + Arrays.toString(queue) +
                ", items=" + items +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
