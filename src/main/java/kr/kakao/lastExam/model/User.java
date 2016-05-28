package kr.kakao.lastExam.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by JKKim on 2016. 5. 27..
 */
@Data
@Entity
public class User {
    @Id
    private String id;
    private String name;
    private String password;
    private String description;
    private String image;
}
