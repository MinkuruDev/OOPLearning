package BTH2;

public class Cau4 {
    public static void main(String[] args) {
        testStack();
        testQueue();
    }

    public static void testStack(){
        Cau4 four = new Cau4();
        Stack stack = four.new Stack(5);
        int[] elements = {5, 1, 5, 6, 8, 9};

        for(int element : elements){
            if(stack.isEmpty())
                System.out.println("Stack rong");
            if(stack.isFull())
                System.out.println("Stack da day");
            if(stack.push(element))
                System.out.println("Them thanh cong phan tu " + element + " vao stack");
            else
                System.out.println("Khong the them phan tu " + element + " vao stack");
        }
    }

    public static void testQueue(){
        Cau4 four = new Cau4();
        Queue queue = four.new Queue(5);
        int[] elements = {5, 1, 6, 8, 7, 9};

        for(int element : elements){
            if(queue.isEmpty())
                System.out.println("Queue rong");
            if(queue.isFull())
                System.out.println("Queue da day");
            if(queue.push(element))
                System.out.println("Them thanh cong phan tu " + element + " vao queue");
            else
                System.out.println("Khong the them phan tu " + element + " vao queue");
        }
    }

    public class Stack{
        private int[] elements;
        private int index;

        public Stack(int maxsize){
            elements = new int[maxsize];
            index = 0;
        }

        public boolean isEmpty(){
            return index == 0;
        }

        public boolean isFull(){
            return index == elements.length;
        }

        /**
         * Cho 1 số nguyên vào đỉnh stack
         * @param value - giá trị cần đưa vào stack
         * @return - true nếu thành công đưa giá trị đó vào stack
         */
        public boolean push(int value){
            if(isFull()) return false;
            elements[index] = value;
            index++;
            return true;
        }

        public int pop(){
            index--;
            return elements[index];
        }
    }

    public class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
            next = null;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }
    }

    public class Queue{
        private Node head, tail;
        private int count, maxsize;

        public Queue(int maxsize){
            this.maxsize = maxsize;
            count = 0;
            head = null;
            tail = null;
        }

        public boolean isEmpty(){
            return count == 0;
        }

        public boolean isFull(){
            return count == maxsize;
        }

        /**
         * Cho 1 số vào cuối hàng đợi
         * @param value - Giá trị cần đưa vào
         * @return true nếu giá trị đã được đưa vào hàng đợi
         */
        public boolean push(int value){
            if(isFull()) return false;
            count++;
            if(count == 1){
                head = new Node(value);
                tail = head;
                return true;
            }

            tail.setNext(new Node(value));
            tail = tail.getNext();
            return true;
        }

        public int pop(){
            int res = head.getValue();
            head = head.getNext();
            count--;
            return res;
        }
    }
}
