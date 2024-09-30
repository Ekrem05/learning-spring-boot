package util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BoxingCoach implements Coach {

    public BoxingCoach() {
        System.out.println("BoxingCoach initialized");
    }
    @Override
    public String getDailyWorkout() {
        return "Shadow box for 15 minutes";
    }

    @PostConstruct
    public void init() {
        System.out.println("BoxingCoach postConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("BoxingCoach preDestroy");
    }
}
