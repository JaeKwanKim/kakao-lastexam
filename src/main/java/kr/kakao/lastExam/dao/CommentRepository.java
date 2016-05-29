package kr.kakao.lastExam.dao;


import kr.kakao.lastExam.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hyh0408 on 2016. 5. 26..
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
