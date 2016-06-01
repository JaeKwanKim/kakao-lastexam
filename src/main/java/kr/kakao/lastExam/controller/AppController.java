package kr.kakao.lastExam.controller;

import kr.kakao.lastExam.dao.CommentRepository;
import kr.kakao.lastExam.dao.UserRepository;
import kr.kakao.lastExam.model.Comment;
import kr.kakao.lastExam.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * Created by JKKim on 2016. 5. 27..
 */
@Controller
@SessionAttributes(names = {"user"})
public class AppController {
    private final static Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
//    private static final ObjectMapper om = new ObjectMapper();
    private int pageNum;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @ModelAttribute("comments")
    public Page<Comment> comments(@PageableDefault(size = 7, direction = Sort.Direction.DESC, sort = "seqNum") Pageable pageable) {
        if(pageNum < 1 || pageNum > 1000 ) pageNum = 0;
        Page<Comment> commentList = commentRepository.findAll(pageable);
        if(pageNum > commentList.getTotalPages()) pageNum = 0;
//        List<Comment> commentList = commentRepository.findAll(new Sort(Sort.Direction.DESC,"seqNum"));
//        Collections.reverse(commentList);
//        DateTimeOver(commentList);
        return commentList;
    }

    @RequestMapping(value = "/")
    public ModelAndView index(@ModelAttribute User user, @ModelAttribute(value = "comments") Page<Comment> comments) {
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("user", convertObjectToJson(user));
//        if (!modelAndView.isEmpty()) {
//            modelAndView.addObject("user", new User());
//        }
//        modelAndView.addAllObjects(convertObject(user));
        System.out.println(user.getName() + "(" +user.getDescription() + ")");
        DateTimeOver(comments.getContent());
//        System.out.println(comments.get(0).getContext());
        modelAndView.addObject("comment", comments);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("index");
        modelAndView.addObject("pageNum", comments.getTotalPages());
//        model.addAllAttributes(convertObject(user));
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void loginAfter(@RequestParam(value = "login-id")String id,
                           @RequestParam(value = "login-password")String password,
                           Model model, HttpServletResponse response) throws IOException {
        try(PrintWriter writer = response.getWriter()) {
            User user = userRepository.getOne(id);
            if(password.equals(user.getPassword())) {
                model.addAttribute("user", user);
                writer.println("<script>window.opener.location.reload(); self.close(); </script>");
            } else {
                writer.println("<script>alert('Password Incorrect!! Rewrite that.'); location.href='/login';</script>");
            }
        } catch (EntityNotFoundException e) {
        }
    }

    @RequestMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public void writeComment(@RequestParam String writeId, @RequestParam String context,
                             HttpServletResponse response) throws IOException {
        try(PrintWriter writer = response.getWriter()) {
            Comment comment = new Comment(writeId, context);
            commentRepository.saveAndFlush(comment);
            writer.println("<script>window.opener.location.reload(); self.close(); </script>");
        } catch (EntityNotFoundException e){
            e.printStackTrace();
        }catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String getRegister(User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/popup")
    public String popup(@ModelAttribute User user, HttpServletResponse response) {
        if(user.getUserId() == null) {
            try(PrintWriter writer = response.getWriter()) {
                writer.println("<script>alert('First. Register That'); self.close(); window.opener.location.href='/register';</script>");
                return null;
            } catch (EntityNotFoundException e){
                e.printStackTrace();
            }catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return "popup";
    }

    @RequestMapping(value = "comments/{seqNum}", method = {RequestMethod.GET})
    public String delete(@PathVariable int seqNum) {
        commentRepository.delete(seqNum);
        return "redirect:/";
    }

    @RequestMapping(value = "/comments/like", method = RequestMethod.GET)
    public ResponseEntity<?> commentLike(@RequestParam(name = "seqNum") int seqNum) {
        Comment commentLike = commentRepository.getOne(seqNum);
        if(commentLike.getRecommend() == null) commentLike.setRecommend(1);
        else commentLike.setRecommend(commentLike.getRecommend() + 1);
        commentRepository.save(commentLike);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/comments/unlike", method = RequestMethod.GET)
    public ResponseEntity<?> commentUnlike(@RequestParam(name = "seqNum") int seqNum) {
        Comment commentUnlike = commentRepository.getOne(seqNum);
        if(commentUnlike.getOpposite() == null) commentUnlike.setOpposite(1);
        else commentUnlike.setOpposite(commentUnlike.getOpposite() + 1);
        commentRepository.save(commentUnlike);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/pageNum", method = RequestMethod.GET)
    public ResponseEntity<?> pageNum(@RequestParam(name = "pageNum") int pageNum) {
        setPageNum(pageNum);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void DateTimeOver(List<Comment> list) {
        Date crrentDate = new Date();
        for(int i = 0; i < list.size(); i++) {
            Date date = list.get(i).getCreate_date();
            long value = (crrentDate.getTime() - date.getTime())/1000;
            long diffDays = value / (24 * 60 * 60);
            if(diffDays >= 1) list.get(i).setCurrunt_time(diffDays+"일");
            else if (value > 3600) list.get(i).setCurrunt_time((value/3600) + "시간");
            else if(value > 60) list.get(i).setCurrunt_time((value/60) + "분");
            else list.get(i).setCurrunt_time(value + "초");
        }
        commentRepository.save(list);
    }
//    public static String convertObjectToJson(Object obj) {

//    private ModelMap convertObject(User user) {
//        ModelMap modelMap = new ModelMap();
//        modelMap.addAttribute("writeId", user.getUserId());
//        modelMap.addAttribute("password", user.getPassword());
//        modelMap.addAttribute("name", user.getName());
//        modelMap.addAttribute("description", user.getDescription());
//        modelMap.addAttribute("image", user.getImage());
//        modelMap.addAttribute("user_comments", user.getComments());
//        return modelMap;
//    }
}
