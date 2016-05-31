package kr.kakao.lastExam.controller;

import kr.kakao.lastExam.dao.CommentRepository;
import kr.kakao.lastExam.dao.UserRepository;
import kr.kakao.lastExam.model.Comment;
import kr.kakao.lastExam.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by JKKim on 2016. 5. 27..
 */
@Controller
@SessionAttributes(names = {"user","comments"})
public class AppController {
    private final static Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
//    private static final ObjectMapper om = new ObjectMapper();

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @ModelAttribute("comments")
    public List<Comment> comments() {
        return commentRepository.findAll();
    }

    @RequestMapping("/")
    public ModelAndView index(@ModelAttribute User user, @ModelAttribute(value = "comments") List<Comment> comments, Model model) {
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("user", convertObjectToJson(user));
//        if (!modelAndView.isEmpty()) {
//            modelAndView.addObject("user", new User());
//        }
//        modelAndView.addAllObjects(convertObject(user));
        System.out.println(user.getName() + "(" +user.getDescription() + ")");
        System.out.println(comments.get(0).getContext());
        modelAndView.addObject("comment", comments);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("index");
        model.addAttribute("hello", "hello");
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
//                ObjectMapper mapper = new ObjectMapper();
                model.addAttribute("user", user);
                writer.println("<script>window.opener.location.reload(); self.close(); </script>");
//                return model;
            } else {
                writer.println("<script>alert('Password Incorrect!! Rewrite that.'); location.href='/login';</script>");
            }
        } catch (EntityNotFoundException e) {
        }
//        return null;
    }

    @RequestMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/popup")
    public String popup() {
        return "popup";
    }

    @RequestMapping(value = "/test/{name}")
    public String test1(@PathVariable String name, Model model) {
        model.addAttribute(name);
        return "/hello";
    }

//    public static String convertObjectToJson(Object obj) {
//        String result = "";
//        try {
//            result = om.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
//        } catch (JsonProcessingException e) {
//            logger.error("Error In JSON conversion : {}", e);
//        }
//        return result;
//    }

//    private ModelMap convertObject(User user) {
//        ModelMap modelMap = new ModelMap();
//        modelMap.addAttribute("userId", user.getUserId());
//        modelMap.addAttribute("password", user.getPassword());
//        modelMap.addAttribute("name", user.getName());
//        modelMap.addAttribute("description", user.getDescription());
//        modelMap.addAttribute("image", user.getImage());
//        modelMap.addAttribute("user_comments", user.getComments());
//        return modelMap;
//    }
}
