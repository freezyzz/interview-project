package interviewProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncorrectURIException extends RuntimeException{
    public IncorrectURIException(){
        super("Incorrect URI");
    }
}
