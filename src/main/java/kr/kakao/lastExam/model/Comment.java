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
    private static final long serialVersionUID = 7170599505179953251L;
    @Id
    @GeneratedValue
    @Column(name = "seq_num")
    private Integer seqNum;
    @NotNull
    private String writeId;
    private String context;
    private Integer recommend;
    private Integer opposite;
    @CreatedDate
    private Date create_date;
    private String currunt_time;
    @ManyToOne
    @JoinColumn(name = "writeId", insertable = false, updatable = false)
    private User user;


    public Integer getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Integer seqNum) {
        this.seqNum = seqNum;
    }

    public String getWriteId() {
        return writeId;
    }

    public void setWriteId(String writeId) {
        this.writeId = writeId;
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

    public String getCurrunt_time() {
        return currunt_time;
    }

    public void setCurrunt_time(String current_time) {
        this.currunt_time = current_time;
    }

    public Comment() {
    }

    public Comment(String writeId, String context) {
        this.writeId = writeId;
        this.context = context;
        this.recommend = 0;
        this.opposite = 0;
    }
}