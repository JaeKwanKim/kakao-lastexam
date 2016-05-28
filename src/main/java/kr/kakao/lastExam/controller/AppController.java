package kr.kakao.lastExam.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JKKim on 2016. 5. 27..
 */
@RestController
public class AppController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String rootRoute() {
        return "index";
    }

    @RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
    public String test1(@PathVariable String name, Model model) {
        model.addAttribute(name);
        return "/hello";
    }
}
