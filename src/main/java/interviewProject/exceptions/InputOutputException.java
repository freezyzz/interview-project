package interviewProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class InputOutputException extends RuntimeException {
    public InputOutputException() {
        super("Ошибка чтения/записи файла");
    }
}
