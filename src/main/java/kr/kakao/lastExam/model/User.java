package kr.kakao.lastExam.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by JKKim on 2016. 5. 27..
 */
@Entity
public class User implements Serializable {
    @Id
    private String userId;
    @Column(nullable = false)
    private String password;
    private String name;
    private String description;
    private String image;
    @OneToMany(mappedBy = "user")
//    @JoinColumn(referencedColumnName = "userId")
    private List<Comment> comments;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User(String userId, String password, String name, String description, String image) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public User() {
    }
}
