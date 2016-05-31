package kr.kakao.lastExam.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by JKKim on 2016. 5. 27..
 */
@Entity
public class Comment implements Serializable{
    @Id
    @GeneratedValue
    private Integer seq_num;
    @NotNull
    private String userId;
    private String context;
    private Integer recommend;
    private Integer opposite;
    @CreatedDate
    private Date create_date;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Integer getSeq_num() {
        return seq_num;
    }

    public void setSeq_num(Integer seq_num) {
        this.seq_num = seq_num;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Integer getOpposite() {
        return opposite;
    }

    public void setOpposite(Integer opposite) {
        this.opposite = opposite;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonFormat(pattern = "yyyy-MM-dd hh-mm-ss")
    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Comment() {
    }

    public Comment(String userId, String context) {
        this.userId = userId;
        this.context = context;
        this.recommend = 0;
        this.opposite = 0;
    }
}