/**
* Class to implement a singly linked list
*
* @author 
* @version Spring 2024
*/

public class SLL<T> implements Phase1SLL<T>, Phase2SLL<T>{
    private NodeSL<T> head;

    public SLL(){

    }

    public SLL (SLL<T> list){
        if (list.head == null){
            this.head = null;
        }
        else{
            NodeSL<T> n = list.head;
            this.addLast(list.head.getData());
            while(n.getNext() != null){
                n = n.getNext();
                T v = n.getData();
                this.addLast(v);
            }
        }
    }

    /** 
    *  Accessor for head node
    *  @return the head node
    */
    public NodeSL<T> getHead(){
        return this.head;
    }
  
    /** 
    *  Accessor for tail node
    *  @return the tail node
    */
    public NodeSL<T> getTail(){
        if (this.isEmpty()){
            return null;
        }
        else{
            NodeSL<T> n = this.head;
            while(n.getNext() != null){
                n = n.getNext();
            }
            return n;
        }
    }

    /** 
    *  Determines whether a list is empty
    *  @return T/F is the list empty?
    */
    public boolean isEmpty(){
        return this.head == null;
    }

    /** 
    *  Inserts the given item at the head of the list
    *  @param v item to insert 
    */
    @Override
    public void addFirst(T v){
        if (this.isEmpty()){
            this.head = new NodeSL<T>(v, null);
        }
        else{
            NodeSL<T> n = this.head;
            this.head = new NodeSL<T>(v, n);
        }
    }
  
    /** Converts to a string representation */
    public String toString(){
        String s = "[";
       for (NodeSL<T> n = this.head; n != null; n = n.getNext()){
            if (n.getNext() != null){
                s += String.valueOf(n.getData()) + ", ";
            }
            else{
                s += String.valueOf(n.getData());
            }
       }
       s += "]";
       return s;
    }

    /** 
    *  Inserts the given item at the tail of the list
    *  @param item to insert 
    */
    public void addLast(T v){
        if (this.head == null){
            this.head = new NodeSL<T>(v, null);
        }
        else{
            this.getTail().setNext(new NodeSL<T>(v, null));
        }
    }

    /** 
    *  Inserts the given item after the specified node
    *  @param here node to insert after
    *  @param v item to insert 
    */
    public void addAfter(NodeSL<T> here, T v){
        if (here == this.getTail()){
            here.setNext(new NodeSL<T>(v, null));
        }
        else{
            NodeSL<T> next = here.getNext();
            here.setNext(new NodeSL<T>(v, next));
        }
    }

    /** 
    *  Removes the given item from the head of the list
    *  @return v item removed
    */
    public T removeFirst(){
        if (this.isEmpty()){
            throw new MissingElementException();
        }
        else{
            T v = this.head.getData();
            this.head = this.head.getNext();
            return v;
        }
    }

    /** 
    *  Removes the given item from the tail of the list
    *  @return item removed
    */
    public T removeLast(){
        if (this.isEmpty()){
            throw new MissingElementException();
        }
        else if (this.head.getNext() == null){
            T v = this.head.getData();
            this.head = null;
            return v;
        }
        else{
            T v = this.getTail().getData();
            NodeSL<T> n = this.head;
            while (n.getNext() != this.getTail()){
                n = n.getNext();
            }
            n.setNext(null);
            return v;
        }
    }

    /** 
    *  Removes the node after the given position
    *  @param here marks position to remove after
    *  @return item removed
    */
    public T removeAfter(NodeSL<T> here){
        if (this.isEmpty()){
            throw new MissingElementException();
        }
        else if (here == null){
            T v = this.head.getData();
            this.head = this.head.getNext();
            return v;
        }
        else{
            NodeSL<T> n = this.head;
            while (n != here){
                n = n.getNext();
            }
            if (n.getNext() == null){
                return null;
            }
            else if (n.getNext().getNext() == null){
                T v = n.getNext().getData();
                n.setNext(null);
                return v;
            }
            else{
                NodeSL<T> next = n.getNext().getNext();
                T v = n.getNext().getData();
                n.setNext(next);
                return v;
            }
        }
    }

    /**
    *  Returns a count of the number of elements in the list
    *  @return current number of nodes
    */
    public int size(){
        if (this.head == null){
            return 0;
        }
        else{
            int cnt = 1;
            NodeSL<T> n = this.head;
            while(n.getNext() != null){
                cnt += 1;
                n = n.getNext();
            }
            return cnt;
        }
    }

    /** 
    *  Makes a copy of elements from the original list
    *  @param here  starting point of copy
    *  @param n  number of items to copy
    *  @return the copied list
    */
    public SLL<T> subseqByCopy(NodeSL<T> here, int n){
        if (this.head == null){
            throw new MissingElementException();
        }
        if (this.size() < n){
            throw new MissingElementException();
        }
        else{
            SLL<T> copy = new SLL<>();
            NodeSL<T> node = this.head;
            while(node != here){
                node = node.getNext();
            }
            copy.addLast(node.getData());
            while(n > 1){
                node = node.getNext();
                copy.addLast(node.getData());
                n -= 1;
            }
            return copy;
        }
    }

    /**
    *  Places copy of the provided list into this after the specified node.
    *  @param list  the list to splice in a copy of
    *  @param afterHere  marks the position in this where the new list should go
    */
    public void spliceByCopy(SLL<T> list, NodeSL<T> afterHere){
        SLL<T> copyList = new SLL<>(list);
        NodeSL<T> next = null;
        if (copyList.head != null){
            if (afterHere == null){
                next = this.head;
                this.head = new NodeSL<T>(copyList.head.getData(), null);
                NodeSL<T> node = this.head;
                NodeSL<T> n = copyList.head;
                for (n = n.getNext(); n != null; n = n.getNext()) {
                    node.setNext(n);
                    node = node.getNext();
                }
                node.setNext(next);
            }
            else{
                next = afterHere.getNext();
                afterHere.setNext(new NodeSL<T>(copyList.head.getData(), null));
                afterHere = afterHere.getNext();
                NodeSL<T> n = copyList.head;
                for (n = n.getNext(); n != null; n = n.getNext()) {
                    afterHere.setNext(n);;
                    afterHere = afterHere.getNext();
                }
                afterHere.setNext(next);
            }
        }
    }

    /** 
    *  Extracts a subsequence of nodes and returns them as a new list
    *  @param afterHere  marks the node just before the extraction
    *  @param toHere  marks the node where the extraction ends
    *  @return  the new list
    */
    public SLL<T> subseqByTransfer(NodeSL<T> afterHere, NodeSL<T> toHere){
        SLL<T> transfer = new SLL<>();
        SLL<T> copy = new SLL<>(this);
        NodeSL<T> copyAfter = copy.head;
        while (copyAfter !=  afterHere){
            copyAfter = copyAfter.getNext();
        }
        transfer.head = copyAfter.getNext();
        NodeSL<T> n = transfer.head;
        if (toHere != this.getTail()){
            while (n.getNext() != toHere.getNext()){
                n = n.getNext();
            }
            //n.setNext(null);
        }
        else {
            while (n.getNext() != null){
                n = n.getNext();
            }
            //n.setNext(null);
        }
        NodeSL<T> node = this.head;
        while(node != afterHere){
            node = node.getNext();
        }
        node.setNext(toHere.getNext());
        return transfer;
    }

    /** 
    *  Takes the provided list and inserts its elements into this
    *  after the specified node.  The inserted list ends up empty.
    *  @param list  the list to splice in.  Becomes empty after the call
    *  @param afterHere  Marks the place where the new elements are inserted
    */
    public void spliceByTransfer(SLL<T> list, NodeSL<T> afterHere){
        if (afterHere == null){
            NodeSL<T> next = this.head;
            this.head = list.head;
            list.getTail().setNext(next);
            list.head = null;
        }
        else{
            NodeSL<T> next = afterHere.getNext();
            afterHere.setNext(list.head);
            list.getTail().setNext(next);
            list.head = null;
        }
    }

    public static void main(String[] args) {
        SLL<String> a = new SLL<>();
        a.addLast("D");
        //a.addLast("E");
        a.addLast("B");
        a.addLast("A");
        a.addLast("C");
        SLL<String> b = new SLL<>();
        b.addLast("E");
        //b.addLast("B");
        a.spliceByTransfer(b,null);
        System.err.println(a);
        System.err.println(b);
    }

}
