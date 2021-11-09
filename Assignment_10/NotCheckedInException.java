public class NotCheckedInException extends Exception{
    public NotCheckedInException(){
        System.out.println("Error: Cannot check out; Not currently checked in");
    }
}
