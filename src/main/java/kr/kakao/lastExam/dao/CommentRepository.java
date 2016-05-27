package kr.kakao.lastExam.dao;


import kr.kakao.lastExam.model.CommentData;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by hyh0408 on 2016. 5. 26..
 */
public interface CommentRepository extends PagingAndSortingRepository<CommentData, Integer> {
}
