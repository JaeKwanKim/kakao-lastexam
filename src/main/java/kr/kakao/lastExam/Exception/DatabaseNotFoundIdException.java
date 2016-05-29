package kr.kakao.lastExam.Exception;

/**
 * Created by JKKim on 2016. 5. 29..
 */
public class DatabaseNotFoundIdException extends RuntimeException {
    public DatabaseNotFoundIdException(String message) {
        super(message);
    }

    public DatabaseNotFoundIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
