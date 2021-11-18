package interviewProject.exceptions;

import net.bytebuddy.implementation.bytecode.Throw;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("Пользователь не найден");
    }
}
