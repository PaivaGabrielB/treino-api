package br.com.treino.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebApp {

    @GetMapping("/hello")
    @ResponseBody
    public String HelloWorld(){

        return "<h1>Hello world</h1>";
    }
}
