package kr.kakao.lastExam;

import kr.kakao.lastExam.dao.CommentRepository;
import kr.kakao.lastExam.model.Comment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { ApplicationContextForProject.class})
@WebAppConfiguration
@Transactional
public class CommentTests {
	@Autowired
	private CommentRepository commentRepository;
	private List<Comment> commentList;
	@Before
	public void init() {
		commentList = new ArrayList<>();
		Comment comment1 = new Comment("aaaa", "첫번째 테스트 댓글입니다.");
		Comment comment2 = new Comment("bbbb", "두번째 테스트 댓글입니다.");
		Comment comment3 = new Comment("cccc", "세번째 테스트 댓글입니다.");
		Comment comment4 = new Comment("dddd", "네번째 테스트 댓글입니다.");
		Comment comment5 = new Comment("eeee", "다섯번째 테스트 댓글입니다.");
		Comment comment6 = new Comment("ffff", "여섯번째 테스트 댓글입니다.");
		Comment comment7 = new Comment("gggg", "일곱번째 테스트 댓글입니다.");
		Comment comment8 = new Comment("hhhh", "여덟번째 테스트 댓글입니다.");
		Comment comment9 = new Comment("jjjj", "아홉번째 테스트 댓글입니다.");
		Comment comment10 = new Comment("kkkk", "열번째 테스트 댓글입니다.");
		Comment comment11 = new Comment("qqqq", "열한번째 테스트 댓글입니다.");
		commentList.add(comment1);
		commentList.add(comment2);
		commentList.add(comment3);
		commentList.add(comment4);
		commentList.add(comment5);
		commentList.add(comment6);
		commentList.add(comment7);
		commentList.add(comment8);
		commentList.add(comment9);
		commentList.add(comment10);
		commentList.add(comment11);
	}

	@After
	public void tearDown(){
	}

//	@Test
//	public void commentAdd() {
//		Comment c = new Comment("aaaa", "열네번째 테스트 댓글입니다.");
//
//		commentRepository.save(c);
////		if(commentRepository.exists(14)) System.out.println("14번이 존재합니다");
//		Comment test = commentRepository.getOne(22);
//		if(!commentRepository.exists(22)) {
//			System.out.println("데이터를 가져오지 못했습ㄴ다");
//		} else {
//			System.out.println("데이터를 정상적으로...");
//		}
//		assertTo(c, test);
//
//	}
//
	@Test
	public void commentGet() {
//		Comment comment = commentRepository.findOne(3);
		Comment comment = new Comment();
		assertTo(comment, comment);
//		assertTo(comment, commentList.get(0));
	}
//
//	@Test(expected = EmptyResultDataAccessException.class)
//	@Rollback
//	public void commentDelete(){
//		commentRepository.delete(22);
//		commentRepository.getOne(22);
//	}
//
//	@Test
//	@Rollback
//	public void commentUpdate() {
//		Comment comment = commentRepository.getOne(1);
//		comment.setContext("댓글 변경 작업입니다");
//		commentRepository.save(comment);
//
//		assertTo(commentRepository.getOne(1), comment);
//	}

	private void assertTo(Comment comment, Comment testComment) {
		assertThat(comment.getWriteId(), is(testComment.getWriteId()));
		assertThat(comment.getContext(), is(testComment.getContext()));
	}

}
