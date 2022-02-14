package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //mapping 된 게 없을 경우 웰컴 페이지 호출
    @GetMapping("/")
    public String home(){
        return "home"; //home.html 호출
    }

}
