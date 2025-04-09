package controller;

import org.springframework.web.bind.annotation.GetMapping;

public class IntroductionController {

    @GetMapping("/")
    public String introduction() {
        return "index";
    }
}
