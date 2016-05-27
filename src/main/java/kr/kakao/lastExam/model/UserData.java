package kr.kakao.lastExam.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by JKKim on 2016. 5. 27..
 */
@Data
@Entity
@Table(name = "userInfo")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
}
