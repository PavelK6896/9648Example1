package tree;

class Stack {
    private int maxSize;
    private Node[] stack;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stack = new Node[this.maxSize];
        this.top = -1;
    }

    public void push(Node n) {
        try {
            this.stack[++this.top] = n;
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    public Node pop() {
        Node node = null;
        try {
            node = this.stack[this.top--];
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return node;
    }

    public Node peek() {
        return this.stack[this.top];
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public boolean isFull() {
        return (this.top == this.maxSize - 1);
    }
}
