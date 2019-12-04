package it.finzicontini.simpleapp.screenobjects;

import it.finzicontini.simpleapp.FourthActivity;
import it.finzicontini.simpleapp.R;
import it.finzicontini.simpleapp.SecondActivity;
import it.finzicontini.simpleapp.ThirdActivity;
import it.finzicontini.simpleapp.util.condition.ActivityInstruction;
import it.finzicontini.simpleapp.util.condition.ConditionWatcher;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static it.finzicontini.simpleapp.util.Utils.getActivityInstance;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class ThirdActObject extends BaseScreenObject {

    public ThirdActObject() {
        super();
        assertThat(getActivityInstance(), instanceOf(ThirdActivity.class));
        validate_ui();
    }

    @Override
    public void validate_ui(){
        onView(withId(R.id.buttonToSecondActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.button2)).check(matches(isDisplayed()));
        onView(withId(R.id.switch1)).check(matches(isDisplayed()));
    }

    public FourthActObject clickOnButtonToFinalActivity() throws Exception {
        onView(withId(R.id.button2)).perform(click());
        ConditionWatcher.waitForCondition(new ActivityInstruction(FourthActivity.class));
        return new FourthActObject();
    }

    public SecondActObject clickOnButtonToSecondActivity() throws Exception {
        onView(withId(R.id.buttonToSecondActivity)).perform(click());
        ConditionWatcher.waitForCondition(new ActivityInstruction(SecondActivity.class));
        return new SecondActObject();
    }

    public ThirdActObject clickOnSwitch(){
        onView(withId(R.id.switch1)).perform(click());
        return this;
    }
}
