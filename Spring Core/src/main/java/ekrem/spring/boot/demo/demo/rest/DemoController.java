package ekrem.spring.boot.demo.demo.rest;


import ekrem.spring.boot.demo.demo.ICoach;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${greeting.name}")
    private String username;

    private ICoach coach;

    public DemoController(ICoach coach) {
        this.coach = coach;
    }
    @GetMapping("/")
    public String HelloWorld() {
        return "Hello %s".formatted(username);
    }
    @GetMapping("/workout")
    public String Workout() {
        return coach.getDailyWorkout();
    }
}
