class MyCircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int size;
    private int k;

    public MyCircularQueue(int k) {
        this.k = k;
        data = new int[k];
        head = -1;
        tail = -1;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        if (isEmpty()) {
            head = 0;
        }
        tail = (tail + 1) % k;
        data[tail] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % k;
        }
        size--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return data[head];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return data[tail];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */