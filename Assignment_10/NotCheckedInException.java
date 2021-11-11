public class NotCheckedInException extends Exception{
    public NotCheckedInException(){
        super("Error: Cannot check out; Not currently checked in");
    }
}
