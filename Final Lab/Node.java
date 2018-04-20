
class Node {

    private Course data;  //data
    private Node next;

    public Node(Course data) {
        this.data = data;
    }

    public Course getData() {
        return data;
    }

    public void setData(Course data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public  String toString(){
        
        return this.getData().toString();
    }
}
