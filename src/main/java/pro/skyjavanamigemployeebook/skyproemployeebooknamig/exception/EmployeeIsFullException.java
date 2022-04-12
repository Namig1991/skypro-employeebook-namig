package pro.skyjavanamigemployeebook.skyproemployeebooknamig.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeIsFullException extends RuntimeException {

    public EmployeeIsFullException(String message) {
        super(message);
    }

}
