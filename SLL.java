/**
* Class to implement a singly linked list
*
* @author 
* @version Spring 2024
*/

public class SLL<T> implements Phase1SLL<T>{
    private NodeSL<T> head;
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
            return null;
        }
        else{
            NodeSL<T> remove = this.head;
            this.head = this.head.getNext();
            // ❗️remove.setNext(null);
            return remove.getData();
        }
    }

    /** 
    *  Removes the given item from the tail of the list
    *  @return item removed
    */
    public T removeLast(){
        if (this.isEmpty()){
            return null;
        }
        else{
            NodeSL<T> n = this.head;
            while (n.getNext() != this.getTail()){
                n = n.getNext();
            }
            NodeSL<T> tail = this.getTail();
            n.setNext(null);
            return tail.getData();
        }
    }

    // /** 
    // *  Removes the node after the given position
    // *  @param here marks position to remove after
    // *  @return item removed
    // */
    // public T removeAfter(NodeSL<T> here);

    // /**
    // *  Returns a count of the number of elements in the list
    // *  @return current number of nodes
    // */
    // public int size();


    public static void main(String[] args) {
        SLL<String> a = new SLL<>();
        a.addLast("A");
        System.err.println(a);
    }

}
