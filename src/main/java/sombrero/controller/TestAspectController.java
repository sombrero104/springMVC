package sombrero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sombrero.service.TestService;

@RestController
@RequestMapping("/test")
public class TestAspectController {

    @Autowired
    TestService testService;

    @GetMapping("/test_aspect")
    public String test_aspect(Model model) {
        testService.test_aspect();
        return "test_aspect";
    }

}
