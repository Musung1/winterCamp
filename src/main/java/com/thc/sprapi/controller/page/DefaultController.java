package com.thc.sprapi.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("")
@Controller //페이지를 보여주는 컨트롤러
public class DefaultController {
    @GetMapping({"", "/", "/index"})
    public String getIndex() {
        return "index";
    }

    @GetMapping({"/test"}) //어떤 url과 연결할 것인가
    public String getTest() {
        return "test";
        //리턴으로 정한 "test"를 파일명으로 갖는 test.html 을 templates 폴더 밑에서 찾아서 뿌려줌
    }

    @GetMapping({"/write"})
    public String getWrite() {
        return "write";
    }

    @GetMapping({"/params"})
    public String getParams(
            @RequestParam(value = "tbcrew_title", required = false) String tbcrew_title
            //,
           // HttpServletRequest request
    ) {
        System.out.println(tbcrew_title);
        return "params";
    }

    @GetMapping({"/create"})
    public String getCreate(
    ) {
        System.out.println("111111");
        return "create";
    }

}
