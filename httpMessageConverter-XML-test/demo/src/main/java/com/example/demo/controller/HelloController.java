package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.annotation.XmlRootElement;

@Controller
public class HelloController {

    @GetMapping("hello-mvc") //스프링 컨테이너의 컨트롤러가 뷰리졸버에게 모델과 반환값을 보낸다. 뷰리졸버가 템플릿엔진에 연결시켜준다.
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    //기본 json
    @GetMapping("hello-api")
    @ResponseBody //@ResponseBody 를 사용하면 뷰 리졸버( viewResolver )를 사용하지 않음. 대신에 HTTP의 BODY에 문자 내용을 직접 반환
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); //객체를 반환해보자~
        hello.setName(name);
        return hello;
    }

    //OXM(Object XML Mapping) XML 데이터의 객체 맵핑을 다루는 개념. 특정 데이터를 XML 형태로 만드는 것을 마샬링(mashalling)이라고 한다.
    //XML 특정 노드의 루트라는 것을 뜻합니다. name을 사용하여 root를 명시
    //@XmlRootElement(name="Hello")
    //com.fasterxml.jackson.dataformat:jackson-dataformat-xml 라이브러리만 추가해도 xml로 바뀐다?!?!?!?!?!?
    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //문자열을 그대로 반환해보자~
    }
}