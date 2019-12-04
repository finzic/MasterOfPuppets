package it.finzicontini.simpleapp.screenobjects;

import androidx.test.espresso.ViewInteraction;

import it.finzicontini.simpleapp.R;
import it.finzicontini.simpleapp.SecondActivity;
import it.finzicontini.simpleapp.ThirdActivity;
import it.finzicontini.simpleapp.util.condition.ActivityInstruction;
import it.finzicontini.simpleapp.util.condition.ConditionWatcher;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static it.finzicontini.simpleapp.util.Utils.getActivityInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class SecondActObject extends BaseScreenObject {

    public SecondActObject(){
        super();
        assertThat(getActivityInstance(), instanceOf(SecondActivity.class));
        validate_ui();
    }

    @Override
    public void validate_ui(){
        onView(withId(R.id.textView2)).check(matches(isDisplayed()));
        onView(withId(R.id.toggleButton)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonBackTo1)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonTo3rd)).check(matches(isDisplayed()));
    }

    public SecondActObject clickOnToggle(){
        onView(withId(R.id.toggleButton)).perform(click());
        return this;
    }

    public ThirdActObject clickOnButtonTo3rd() throws Exception {
        onView(withId(R.id.buttonTo3rd)).perform(click());
        ConditionWatcher.waitForCondition(new ActivityInstruction(ThirdActivity.class));
        return new ThirdActObject();

    }
}
