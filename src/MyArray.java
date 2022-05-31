public class MyArray {
    private int[] arr;
    private int capacity;

    //new int[5];
    public MyArray(int size) {
        this.capacity = 0;
        this.arr = new int[size];
    }

    // = {1,2,3,4,5};
    public MyArray(int[] init) {
        this.capacity = init.length;
        this.arr = init;
    }

    void display() {
        for (int i = 0; i < this.capacity; ++i) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

    public int get(int idx) {
        return arr[idx];
    }

    public void set(int value, int idx) {
        arr[idx] = value;
    }

    boolean delete(int value) {
        for (int i = 0; i < this.capacity; i++) {
            if (this.arr[i] == value) {
                System.arraycopy(this.arr, i + 1, this.arr, i, this.capacity - i - 1);
                --capacity;
                return true;
            }
        }
        return false;
    }

    public boolean deleteAll(int value) {
        for (int i = 0; i < this.capacity; i++) {
            if (this.arr[i] == value) {
                System.arraycopy(this.arr, i + 1, this.arr, i, this.capacity - i - 1);
                --capacity;
            }
        }
        return false;
    }

    public boolean deleteAll() {
        this.arr = new int[this.capacity];
        return true;
    }

    void insert(int idx, int value) /* shift the tail */ {
        for(int i = capacity - 1; i > idx; i--) {
            this.arr[i] = this.arr[i - 1];
        }
        this.arr[idx] = value;
    }

    void append(int value) {
        if (this.capacity == this.arr.length) {
            int[] old = this.arr;
            this.arr = new int[old.length * 2];
            System.arraycopy(old, 0, arr, 0, old.length);
        }
        this.arr[this.capacity++] = value;
    }

    public boolean isInArray(int value) { // O(n)
        for (int i = 0; i < this.capacity; i++)
            if (this.arr[i] == value)
                return true;
        return false;
    }

    //O(log(N))
    public boolean hasValue(int value) {
        int low = 0;
        int high = this.capacity - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (value == this.arr[mid]) {
                return true;
            } else {
                if (value < this.arr[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    private void swap(int a, int b) {
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
    }

    public void sortBubble() /*сложность O(n^2)*/ {
        for (int iter = 0; iter < capacity; iter++)
            for (int idx = 0; idx < capacity - 1; idx++)
                if (this.arr[idx] > this.arr[idx + 1])
                    swap(idx, idx + 1);
    }

    public void sortShaker() /*улучшенная пузырьком, но все равно сложность O(n^2)*/ {
        int margin = 0;

        while (margin != capacity - 1) {
            for (int i = 0; i < capacity - margin - 1; i++) {
                if (this.arr[i] > this.arr[i + 1])
                    swap(i, i + 1);
            }
            margin++;
            for (int i = capacity - margin - 2; i > 0; i--) {
                if (this.arr[i] < this.arr[i - 1])
                    swap(i, i - 1);
            }
        }
    }

    public void countSort() {
        int min = arr[0];
        int max = arr[0];
        //диапазон чисел
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }
        //вспомогательный массив для счетчиков
        int[] helperArray = new int[max - min + 1];
        //поползли по исходному массиву 1 2 3
        // добавляем единицу в соответствующую ячейку массива счетчиков
        for (int j : arr) {
            helperArray[j - min] += 1;
        }
        for (int t : helperArray) {
            System.out.print(t + " ");
        }
        //теперь на основании данных из вспомогательного массива собираем сортированный массив
        int[] result = new int[capacity];
        int iterator = 0;
        for(int i = 0; i < helperArray.length; i++){
            for (int t = 0; t < helperArray[i]; t++) {
                result[t + iterator] = i + min;
            }
            iterator += helperArray[i];
        }
        System.out.println();
        System.out.println("res");
        for (int t : result) {
            System.out.print(t + " ");
        }
        System.out.println();
//
//        int emptyCounter = 0;
//        for (int i = 0; i < capacity; i++) {
//            boolean found = false;
//            for (int t = 0; t < helperArray.length; t+=2) {
//                if (this.arr[i] == helperArray[t] ) {
//                    helperArray[t+1] += 1;
//                    found = true;
//                    System.out.println("found element! " + this.arr[i]);
//                    break;
//                }
//            }
//            if (!found) {
//                helperArray[emptyCounter] = this.arr[i];
//                helperArray[emptyCounter + 1] = 1;
//                emptyCounter += 2;
//            } else {
//                break;
//            }
//        }
//        System.out.println("helper ");
//        for (int i = 0 ; i < helperArray.length; i+=2) {
//            System.out.print(helperArray[i] + " " + helperArray[i+1] + " / ");
//
//        }
//        System.out.println();
    }

    public void sortSelect() /*сложность O(n^2)*/{
        for (int idx = 0; idx < capacity; idx++) {
            int curr = idx;
            for (int srch = idx + 1; srch < capacity; srch++)
                if (this.arr[srch] < this.arr[curr])
                    curr = srch;
            if (curr != idx)
                swap(idx, curr);
        }
    }

    public void sortInsert() /*сложность O(n^2)*/{
        for (int curr = 1; curr < capacity; curr++) {
            int temp = this.arr[curr];
            int move = curr;
            while (move > 0 && this.arr[move - 1] >= temp) {
                this.arr[move] = this.arr[move - 1];
                move--;
            }
            this.arr[move] = temp;
        }
    }


}