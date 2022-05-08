package pro.skyjavanamigemployeebook.skyproemployeebooknamig.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InavalidNameException extends IllegalAccessError {
    public InavalidNameException(String name){
        super(name);
    }
}
