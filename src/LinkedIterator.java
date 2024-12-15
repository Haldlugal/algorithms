import org.w3c.dom.Node;

import java.util.LinkedList;

public class LinkedIterator<T> {

    LinkedList<T> linkedList;
    int counter = 0;

    public LinkedIterator(LinkedList<T> list){
        linkedList = list;
        this.reset();
    }

    public void reset(){
        counter = 0;
    }

    public void nextLink() {
        counter++;
    }

    public T getCurrent() {
        return linkedList.get(counter);
    }

    public boolean atEnd() {
        return counter == (linkedList.size() - 1);
    }

    public void insertAfter(T element) {
        linkedList.add(counter + 1, element);
    }

    public void insertBefore(T element) {
        linkedList.add(counter - 1, element);
    }

    public void deleteCurrent() {
        linkedList.remove(counter);
    }


//    reset() — перемещение в начало списка;
//● nextLink() — перемещение итератора к следующему элементу;
//● getCurrent() — получение элемента, на который указывает итератор;
//● atEnd() — возвращает true, если итератор находится в конце списка;
//● insertAfter() — вставка элемента после итератора;
//● insertBefore() — вставка элемента до итератора;
//● deleteCurrent()


}
