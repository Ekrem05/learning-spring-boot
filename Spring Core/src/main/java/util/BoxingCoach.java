package util;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BoxingCoach implements Coach {

    public BoxingCoach() {
        System.out.println("BoxingCoach initialized");
    }
    @Override
    public String getDailyWorkout() {
        return "Shadow box for 15 minutes";
    }
}
