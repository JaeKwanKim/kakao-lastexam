package kr.kakao.lastExam.object;

import lombok.Data;

/**
 * Created by JKKim on 2016. 5. 27..
 */
@Data
public class recommedData {
    private long id;
    private String userImage;
    private String recommend;
    private String userName;
    private long isLike;
    private long isNotLike;
}
