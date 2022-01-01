public class Main {
    public static void main(String[] args) {
        // Task t1 = new Task("Read", 3, 50);
        // System.out.println(t1.toString());

        Todo todo = new Todo();
        todo.addTask("Read", 2, 10);
        todo.addTask("Workout", 3, 60);
        todo.addTask("Sleep", 3, 50);
        todo.addTask("Eat", 2, 5);
        todo.addTask("Code", 1, 60);
        todo.addTask("Shower", 4, 30);
        // todo.print();
        // todo.completeTask(2);
        // todo.print();
        todo.printPriority(2);
        // todo.printPrioritized();
        

        
    }
}
