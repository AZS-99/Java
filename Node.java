public class Node<T> {
    private T value;
    private Node nxt;

    public Node(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public static void main(String args[]) {
        Node n = new Node(10);
        System.out.println(n);
    }

}
