package kr.kakao.lastExam.controller;

import kr.kakao.lastExam.dao.CommentRepository;
import kr.kakao.lastExam.model.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by hyh0408 on 2016. 5. 27..
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final static Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping(value = "/comments", method={RequestMethod.GET})
    public ResponseEntity<?> list(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "15") Integer size) {
        Page<Comment> comments = commentRepository.findAll(new PageRequest(page, size));
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @RequestMapping(value = "/comment/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<?> save(@PathVariable("id") Integer id, @RequestBody Comment comment) {
        Comment result = commentRepository.save(comment);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/comment/{id}", method = {RequestMethod.GET})
    public ResponseEntity<?> save(@PathVariable("id") Integer id) {
        Comment result = commentRepository.findOne(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
