package ekrem.spring.boot.demo.demo.rest;


import org.springframework.beans.factory.annotation.Qualifier;
import util.Coach;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${greeting.name}")
    private String username;

    private final Coach coach;

    public DemoController(@Qualifier("boxingCoach") Coach coach) {
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
