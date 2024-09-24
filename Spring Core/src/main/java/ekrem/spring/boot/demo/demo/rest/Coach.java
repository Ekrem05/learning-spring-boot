package ekrem.spring.boot.demo.demo.rest;

import ekrem.spring.boot.demo.demo.ICoach;
import org.springframework.stereotype.Component;

@Component
public class Coach implements ICoach {

    public String getDailyWorkout() {
        return "4 sets of bench press";
    }
}
