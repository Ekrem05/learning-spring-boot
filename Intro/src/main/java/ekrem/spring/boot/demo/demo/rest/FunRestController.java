package ekrem.spring.boot.demo.demo.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {


    @GetMapping("/")
    public String HelloWorld() {
        return "Hello World";
    }
}
