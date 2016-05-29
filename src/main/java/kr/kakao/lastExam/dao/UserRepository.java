package kr.kakao.lastExam.dao;

import kr.kakao.lastExam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by JKKim on 2016. 5. 29..
 */
public interface UserRepository extends JpaRepository<User, String> {
}
