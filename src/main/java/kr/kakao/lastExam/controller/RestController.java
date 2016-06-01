package kr.kakao.lastExam.controller;

import kr.kakao.lastExam.dao.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


/**
 * Created by hyh0408 on 2016. 5. 27..
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final static Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping(value = "comments/{seqNum}", method = {RequestMethod.POST, RequestMethod.DELETE})
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable int seqNum, UriComponentsBuilder builder) {
        commentRepository.delete(seqNum);
//        URI location = builder.path("comments/{seqNum}")
//                .buildAndExpand().toUri();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(location);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


//    @RequestMapping(value = "comments", method={RequestMethod.GET})
//    public ResponseEntity<?> list(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "15") Integer size) {
//        Page<Comment> comments = commentRepository.findAll(new PageRequest(page, size));
//        return new ResponseEntity<>(comments, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "comments", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public Comment save(@RequestBody Comment comment) {
//        return commentRepository.save(comment);
//    }
//
//    @RequestMapping(value = "/user/{id}", method = {RequestMethod.GET})
//    public ResponseEntity<?> getOne(@PathVariable("id") String id) {
//        User result = userRepository.findOne(id);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

}
