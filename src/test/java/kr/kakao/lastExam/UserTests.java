package kr.kakao.lastExam;

import kr.kakao.lastExam.dao.UserRepository;
import kr.kakao.lastExam.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by JKKim on 2016. 5. 29..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { ApplicationContextForProject.class})
@WebAppConfiguration
@Transactional
public class UserTests {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(UserTests.class);

    @Autowired
    private UserRepository userRepository;
    private List<User> list;

    @Before
    public void init() {
        list = new ArrayList<>();
        User user1 = new User("aaaa","aa12","김재관","제주대학생","assets/img/1.jpg");
        User user2 = new User("bbbb","bb12","혜리","연예인","assets/img/2.jpg");
        User user3 = new User("cccc","cc12","수지","연예인","assets/img/3.jpg");
        User user4 = new User("dddd","dd12","김하늘","연기자","assets/img/4.jpg");
        User user5 = new User("eeee","ee12","이지은","가수","assets/img/5.jpg");
        User user6 = new User("ffff","ff12","제시카","모델","assets/img/6.jpg");
        User user7 = new User("gggg","gg12","가와이","배우","assets/img/7.jpg");
        User user8 = new User("hhhh","hh12","박소은","무명배우","assets/img/8.jpg");
        User user9 = new User("jjjj","jj12","이효리","가수","assets/img/9.jpg");
        User user10 = new User("kkkk","kk12","민효린","영화배우","assets/img/10.jpg");
        User user11 = new User("qqqq","qq12","트와이스","가수임","assets/img/11.jpg");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);
        list.add(user7);
        list.add(user8);
        list.add(user9);
        list.add(user10);
        list.add(user11);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void usersGet() {
        List<User> users = userRepository.findAll();
        for (int i = 0; i < users.size();i++) {
            assertTo(users.get(i), list.get(i));
        }
    }

    @Test
    public void userAdd(){
        User testUser = new User("wwww","ww12","테스트","백수","assets/img/12.jpg");
        userRepository.save(testUser);
        User user = userRepository.getOne("wwww");
        assertTo(testUser, user);
    }

    @Test
    @Rollback
    public void userUpdate() {
        User user = userRepository.getOne("aaaa");
        user.setDescription("바뀐설명");
        userRepository.save(user);

        User testUser = userRepository.findOne("aaaa");
        assertThat("바뀐설명",is(testUser.getDescription()));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void userDelete() {
        userRepository.delete("wwww");
        userRepository.getOne("wwww");
    }

    private void assertTo(User user1, User user2) {
        assertThat(user1.getUserId(), is(user2.getUserId()));
        assertThat(user1.getPassword(), is(user2.getPassword()));
        assertThat(user1.getName(), is(user2.getName()));
        assertThat(user1.getDescription(), is(user2.getDescription()));
        assertThat(user1.getImage(), is(user2.getImage()));
    }
}
