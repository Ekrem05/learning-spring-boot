package ekrem.spring.boot.demo.demo.rest;

import ekrem.spring.boot.demo.demo.Coach;
import org.springframework.stereotype.Component;

@Component
public class GymCoach implements Coach {

    public String getDailyWorkout() {
        return "4 sets of bench press";
    }
}
