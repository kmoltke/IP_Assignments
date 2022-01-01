import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class Todo 
 */
public class Todo {
    private List<Task> tasks;   // list of all tasks in this Todo
    private int workDone;       // Running total of work done

    /**
     * Instansiate tasks and set workDone to 0
     */
    public Todo() {
        this.tasks = new ArrayList<>();
        this.workDone = 0;
    }

    /**
     * Add task to tasks
     * catch InvalidPriorityException and print error message
     * catch InvalidWorkloadException and print error message
     * @param description
     * @param priority
     * @param minutes
     */
    public void addTask(String description, int priority, int minutes) {
        try {
            tasks.add(new Task(description, priority, minutes)); 
        } 
        catch (InvalidPriorityException e) {
            System.out.println(description + " has invalid priority");
        }
        catch (InvalidWorkloadException e) {
            System.out.println(description + " has invalid workload");
        }
    }

    /**
     * Print all tasks in Todo
     */
    public void print() {
        System.out.println("Todo:");
        System.out.println("-----");
        if (tasks.isEmpty()) {
            System.out.println("You're all done for today! #TodoZero");
        }
        else {
            // tasks.forEach(task -> System.out.println(task.toString()));
            tasks.forEach(System.out::println); // same as above
        }
        if (workDone > 0) {
            System.out.println(workDone + " minutes of work done!");
        }
    }

    /**
     * Add work load to workDone
     * Remove the task from tasks
     * @param index
     */
    public void completeTask(int index) {
        try {
            workDone += tasks.get(index).getWorkLoad();
            tasks.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index");
        }
    }

    /**
     * Print all tasks in Todo that have a more important priority
     * than limit
     * @param limit
     */
    public void printPriority(int limit) {
        if (tasks.stream().noneMatch(t -> t.getPriority() <= limit)) {
            System.out.println("No tasks with given priority");
        }

        else {
            System.out.println("Filtered todo:");
            System.out.println("--------------");
            tasks.stream()
                .filter(t -> t.getPriority() <= limit)
                .forEach(System.out::println);
        }
    }

    /**
     * Print all tasks sorted by priority
     * If more priorities are equal, sort by work load
     * 
     * Inspiration for the sorting using the Comparator
     * is taken from https://www.baeldung.com/java-8-sort-lambda#stream-sort
     * after finding out that the .sorted method takes a so-called "Comparator"
     */
    public void printPrioritized() {
        System.out.println("Prioritized todo:");
        System.out.println("-----------------");

        tasks.stream()
            .sorted(Comparator.comparing(Task::getWorkLoad))
            .sorted(Comparator.comparing(Task::getPriority))
            .forEach(System.out::println);
    }
}
