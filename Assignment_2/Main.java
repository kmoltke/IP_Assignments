/**
 * @author Kristian Moltke Reitzel
 */
public class Main {
    public static void main(String[] args) {
        Student stud = new Student("Henri", 42);
        stud.setAge(15);
        System.out.println(stud.getAge());
    }
}
