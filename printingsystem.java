package Queue;


public class printingsystem {


public static void main(String[] args) {
        Printer system = new Printer();


        
        system.enqueue(new PrintGenerator("10"));
        system.enqueue(new PrintGenerator("20"));
        system.enqueue(new PrintGenerator("30"));
        system.enqueue(new PrintGenerator("40"));
        
        system.dequeue();
        
        while (!system.isEmpty()) {
            PrintGenerator task = system.dequeue();
            System.out.println("Printing: " + task.document);
        }
    }
}


class PrintGenerator {
    String document;


    PrintGenerator(String document) {
        this.document = document;
    }
}


class Printer {
    private PrintGenerator[] queue;
    private int head, tail, size;


    Printer() {
        size = 10; 
        queue = new PrintGenerator[size];
        head = tail = -1;
    }


    void enqueue(PrintGenerator task) {
        if (tail >= size - 1) {
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) {
            head = tail = 0;
        } else {
            tail++;
        }
        queue[tail] = task;
    }




    PrintGenerator dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        PrintGenerator task = queue[head];
        if (head == tail) {
            head = tail = -1;
        } else {
            head++;
        }
        return task;
    }


   
    boolean isEmpty() {
        return head == -1;
    }
}