ASSIGNMENT 2

Create a class called Student.

The class has two fields:

The name of the student (String name)
The age of the student (int age)
and a constructor Student(String name, int age), that initializes the fields to the value of the parameters.
Create two methods String getName() and int getAge() to retrieve the name and age of a student.

Create a String toString method (A textual representation of an object). A student should be represented by the following text: "The name of the student is [name]. The student is [age] years old."

Create two setter methods void setName(String name) and void setAge(int age) to change the name and age for a student.

In the void setAge(int age) it is important to know that the university only admits students between 16 and 99 years old. If the student is too young print "The university does not accept students below 16". If the student is too old print "The university does not accept students that are older than 99". Only set the age, if the age is within the range.

CodeJudge is not an IDE nor a debugger
It may be tempting to solve this and coming exercises by writing your code, submit it to CodeJudge, get a result, and repeat. This is a very bad habit to get into. CodeJudge is not a debugger and using it as one is very inefficient and will not scale beyond the simplest of exercises. Test all of your code in your IDE of choice before uploading it to CodeJudge.

The easiest way to do this was covered in the first lecture - create a main method and either print expected outputs to the terminal to test your functions, or use the debugger to step through your code. As an example, to test that the method getName works as intended, you can use the following main method.

public static void main(String[] args) {
   Student stud = new Student("Jesper", 43);
   System.out.println("Testing stud.getName(): " + stud.getName());
}
The output of this program should be: Testing stud.getName(): Jesper.

This main method can then be expanded upon to test more functionality as you progress.

If you have any questions regarding this, contact a TA. In particular, if you ever get a compilation error from CodeJudge (your code does not even compile) you are not using the tools as they are intended.