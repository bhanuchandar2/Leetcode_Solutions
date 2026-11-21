class LRUCache {
    int capacity;
    Node head;
    Node tail;
    HashMap<Integer,Node>  mp = new HashMap<>();
    public LRUCache(int capacity) {
        mp.clear();
        this.capacity = capacity;

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.previous = head;

    }
    
    public int get(int key) {
        if(!mp.containsKey(key)){
            return -1;
        }
        Node node=mp.get(key);
        deletenode(node);
        insertAfterhead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            node.value = value;
            deletenode(node);
            insertAfterhead(node);
            return;
        }
        else{
            if(mp.size()==capacity){
                Node node = tail.previous;
                mp.remove(node.key);
                deletenode(node);
                Node newNode = new Node(key,value);
                mp.put(key,newNode);
                insertAfterhead(newNode);
                return;
            }
            else{
                Node node = new Node(key,value);
                mp.put(key,node);
                insertAfterhead(node);
                return;
            }
        }
    }
    public  void insertAfterhead(Node node){
        Node after = head.next;
        head.next=node;
        node.previous=head;
        node.next=after;
        after.previous=node;
        return;
    }
    public  void deletenode(Node node){
        Node prev=node.previous;
        Node after=node.next;
        prev.next=after;
        after.previous=prev;
        return;
    }
}

class Node {
    int key;
    int value;
    Node previous;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */