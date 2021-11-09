public class NotCheckedInException extends Exception{
    // private String message;
    public NotCheckedInException(){
        super("Error: Cannot check out; Not currently checked in");
        // System.out.println("Error: Cannot check out; Not currently checked in");
    }
}
