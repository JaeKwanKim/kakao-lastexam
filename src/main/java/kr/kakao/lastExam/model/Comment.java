package kr.kakao.lastExam.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by JKKim on 2016. 5. 27..
 */
@Data
@Entity
public class Comment {
    @Id
    private String id;
    private String content;
    private Integer recommend;
    private Integer opposite;
    @CreatedDate
    private Date create_date = new Date();
    @JoinColumn(name = "id")
    @ManyToOne
    private User user;

    @JsonFormat(pattern = "yyyy-MM-dd hh-mm-ss")
    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}