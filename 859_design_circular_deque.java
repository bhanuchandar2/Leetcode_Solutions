class MyCircularDeque {
    int front=0;
    int end=0;
    int size=0;
    int data[];

    public MyCircularDeque(int k) {
        data = new int[k];
    }
    
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        front=(front-1+data.length)%data.length;
        data[front]=value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        data[end++]=value;
        end=end%data.length;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        front=(front+1)%data.length;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        end=(end-1+data.length)%data.length;
        size--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return data[front];
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return data[(end - 1 + data.length) % data.length];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==data.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */