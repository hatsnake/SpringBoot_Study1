package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
// localhost:8090/api
@RequestMapping("/api")
public class GetController {

    // localhost:8090/api/getMethod
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest() {
        return "Hi getMethod";
    }

    // localhost:8090/api/getParameter?id=aa&password=bb
    @GetMapping("/getParameter")
    public String getParameter(@RequestParam(name = "id") String id,
                               @RequestParam(name = "password") String password) {
        return id+password;
    }

    // localhost:8090/api/multiParameter?account=aa&email=hatsnake@naver.com&page=1
    @GetMapping("/multiParameter")
    public SearchParam multiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return searchParam;
    }
}
