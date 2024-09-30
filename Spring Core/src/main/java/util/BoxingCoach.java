package util;

import org.springframework.stereotype.Component;

@Component
public class BoxingCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Shadow box for 15 minutes";
    }
}
