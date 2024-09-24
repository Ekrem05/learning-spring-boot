package ekrem.spring.boot.demo.demo.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${greeting.name}")
    private String username;

    @GetMapping("/")
    public String HelloWorld() {
        return "Hello %s".formatted(username);
    }
}
