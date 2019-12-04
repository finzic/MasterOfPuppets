package it.finzicontini.simpleapp.screenobjects;

import java.util.concurrent.locks.Condition;

import it.finzicontini.simpleapp.FourthActivity;
import it.finzicontini.simpleapp.MainActivity;
import it.finzicontini.simpleapp.R;
import it.finzicontini.simpleapp.ThirdActivity;
import it.finzicontini.simpleapp.util.condition.ActivityInstruction;
import it.finzicontini.simpleapp.util.condition.ConditionWatcher;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static it.finzicontini.simpleapp.util.Utils.getActivityInstance;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class FourthActObject extends BaseScreenObject {

    public FourthActObject(){
        super();
        assertThat(getActivityInstance(), instanceOf(FourthActivity.class));
        validate_ui();
    }

    @Override
    public void validate_ui(){
        onView(withId(R.id.finalText)).check(matches(isDisplayed()))
                .check(matches(withText("The End")));
        onView(withId(R.id.buttonToFirstAct)).check(matches(isDisplayed()));
    }

    public FirstActObject clickOnBtnToFirstAct() throws Exception {
        onView(withId(R.id.buttonToFirstAct)).perform(click());
        ConditionWatcher.waitForCondition(new ActivityInstruction(MainActivity.class));
        return new FirstActObject();
    }
}
