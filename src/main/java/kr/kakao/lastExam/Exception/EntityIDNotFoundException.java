package kr.kakao.lastExam.Exception;

/**
 * Created by JKKim on 2016. 5. 29..
 */
public class EntityIDNotFoundException extends RuntimeException {
    public EntityIDNotFoundException(String message) {
        super(message);
    }

    public EntityIDNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
