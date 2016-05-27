package kr.kakao.lastExam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JKKim on 2016. 5. 27..
 */
@RestController
public class AppController {
    @RequestMapping("/")
    String rootRoute() {
        return "Hi, My Name is SpringBoot-Reloaded!!";
    }
}
