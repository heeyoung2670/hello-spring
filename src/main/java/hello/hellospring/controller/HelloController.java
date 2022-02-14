package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http body 부분에 데이터를 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //"hello spring" 데이터를 그대로 출력, view 없음
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체 리턴, default = json 형태
    }

    static class Hello{
        private String name;

        //generate -> getter and setter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
