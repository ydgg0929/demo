package com.example.demo.controller.restcontroller;

import com.example.demo.service.PostsService;
import com.example.demo.vo.PostsVo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("restApi")
public class WebRestController {

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    //전체 조회
    @RequestMapping("/")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PostsVo>> getAllList(){
        List<PostsVo> resultList = postsService.findAllDesc();
        return new ResponseEntity<List<PostsVo>>(resultList, HttpStatus.OK);
    }

    //조건 조회
    @GetMapping(value = "/{pokey}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PostsVo> getList(@PathVariable("pokey") Long pokey){
        Optional<PostsVo> result = postsService.findById(pokey);
        return new ResponseEntity<PostsVo>(result.get(), HttpStatus.OK);
    }

    //삭제
    @DeleteMapping(value = "/{pokey}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deletePosts(@PathVariable("pokey") Long pokey){
        postsService.deleteByPokey(pokey);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //저장
    @PostMapping(value = "/posts", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Long> savePosts(@RequestBody PostsVo postsVo){
        Long pokey = postsService.save(postsVo);
        return new ResponseEntity<Long>(pokey, HttpStatus.NO_CONTENT);
    }

    //수정
    @PutMapping(value = "/{pokey}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Long> updatePosts(@PathVariable("pokey") Long pokey, @RequestBody PostsVo postsVo){
        Long returnPokey = postsService.updateByPokey(pokey, postsVo);
        return new ResponseEntity<Long>(returnPokey, HttpStatus.NO_CONTENT);
    }
}