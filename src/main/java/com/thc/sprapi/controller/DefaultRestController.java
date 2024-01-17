package com.thc.sprapi.controller;

import com.thc.sprapi.domain.Tbboard;
import com.thc.sprapi.dto.TestDTO;
import com.thc.sprapi.service.TbboardService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController //페이지를 보여주는 것이 아니라, Rest 방식을 사용할때!!
public class DefaultRestController {

    private final TbboardService tbboardService;
    public DefaultRestController(TbboardService tbboardService) {
        this.tbboardService = tbboardService;
    }
    //오토와이어드 쓸수도 있지만, 이렇게 주입하는 방식을 선호!!
//    @CrossOrigin
//    @PostMapping(value = {"/form"}) //어떤 url과 연결할 것인가
//    public void PostForm(@RequestBody TestDTO param) {
//        System.out.println(param.getInputId());
//        System.out.println(param.getInputPw());
//    }
    @CrossOrigin
    @PostMapping(value = {"/form"}) //어떤 url과 연결할 것인가
    public void PostForm(@RequestBody TestDTO testDTO) {
        System.out.println(testDTO.getInputId());
        tbboardService.create(testDTO);
    }
    @GetMapping({"/test123"})
    public void test() {
        System.out.println("test");
    }
    @CrossOrigin
    @GetMapping({"/getArticles"})
    public List<Tbboard> getArticles() {
        return tbboardService.getAll();
    }

    @GetMapping({"/paramTest"})
    public Map<String, Object> paramTest(
            @RequestParam String aaa
    ) {
        Map<String, Object> a_map = new HashMap<>();
        a_map.put("name", "sprapi!!");
        a_map.put("phone", "010!!");
        return a_map;
    }
    @GetMapping({"/test"})
    public Map<String, Object> getTest() {
        Map<String, Object> a_map = new HashMap<>();
        a_map.put("name", "sprapi!!");
        a_map.put("phone", "010!!");
        return a_map;
    }

    @GetMapping({"/create"})
    public int createTbboard(
            @RequestParam(value = "aaa", required = true) String aaa
            /*
            @RequestParam(value = "title", required = true) String title
            ,@RequestParam(value = "content", required = true) String content
    */
    ) {
        System.out.println("aaa//" + aaa);
        String title = "122334";
        String content = "2244555";
        System.out.println(title + "//" + content);
        //등록하기
        Map<String, Object> a_map = new HashMap<>();
        a_map.put("title", title);
        a_map.put("content", content);

        int result_int = tbboardService.create(a_map);
        /*
        Tbboard tbboard = Tbboard.of("제목 예시", "내용 예시");
        tbboard = tbboardRepository.save(tbboard);
        */
        return result_int;
    }

    @GetMapping({"/update"})
    public int updateTbboard(
    ) {
        Map<String, Object> a_map = new HashMap<>();
        a_map.put("id", "a29d2abd-7df2-4e3c-acbd-61c84545c52a");
        a_map.put("title", "updated");
        int result_int = tbboardService.update(a_map);
        return result_int;
    }
}
