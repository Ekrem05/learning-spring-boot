package util;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class GymCoach implements Coach {

    public GymCoach() {
        System.out.println("Gym Coach initialized");
    }
    public String getDailyWorkout() {
        return "4 sets of bench press";
    }
}
