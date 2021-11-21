package interviewProject.exceptions;

public class ConvertToTimestapException extends RuntimeException{
    public ConvertToTimestapException(){
        super("Неверный формат timestamp");
    }
}
