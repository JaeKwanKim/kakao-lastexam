package kr.kakao.lastExam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JKKim on 2016. 5. 27..
 */
@Controller
public class AppController {

    private final static Logger logger = LoggerFactory.getLogger(AppController.class);

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
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
}
