import java.util.HashMap;

/**
 * Task
 */
public class Task {
    private String description;
    private int priority;
    private int minutes;
    private HashMap<Integer, String> priorities;

    /**
     * Set details about the task
     * Put priorities in priorities
     * @param description
     * @param priority
     * @param minutes
     * @throws InvalidPriorityException if priority is not defined in priorities
     * @throws InvalidWorkloadException if minutes is negative
     */
    public Task(String description, int priority, int minutes) 
            throws InvalidPriorityException, InvalidWorkloadException {
        this.description = description;
        this.priority = priority;
        this.minutes = minutes;
        this.priorities = new HashMap<>();

        priorities.put(1, "very important");
        priorities.put(2, "important");
        priorities.put(3, "unimportant");
        priorities.put(4, "after learn Portuguese");

        if (priorities.get(priority) == null) {
            throw new InvalidPriorityException();
        }
        if (minutes < 0) {
            throw new InvalidWorkloadException();
        }   
    }

    @Override
    public String toString() {
        return description + " takes " + minutes + " minutes and has priority " + priorities.get(priority);
    }

    /**
     * @return work load in minutes
     */
    public int getWorkLoad() {
        return minutes;
    }

    /**
     * @return this task's priority
     */
    public int getPriority() {
        return priority;
    }

}