package it.finzicontini.simpleapp.screenobjects;

import it.finzicontini.simpleapp.MainActivity;
import it.finzicontini.simpleapp.R;
import it.finzicontini.simpleapp.SecondActivity;
import it.finzicontini.simpleapp.util.condition.ActivityInstruction;
import it.finzicontini.simpleapp.util.condition.ConditionWatcher;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static it.finzicontini.simpleapp.util.Utils.getActivityInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class FirstActObject extends BaseScreenObject {

    public FirstActObject() {
        super();
        assertThat(getActivityInstance(), instanceOf(MainActivity.class));
        validate_ui();
    }

    @Override
    protected void validate_ui() {
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
                .check(matches(withText("Hello World!")));
        onView(withId(R.id.StartActivity)).check(matches(isDisplayed()))
                .check(matches(withText("Name")));
        onView(withId(R.id.btnSecondActivity)).check(matches(isDisplayed()))
                .check(matches(isEnabled()));
    }

    public SecondActObject clickOnBtnSecondActivity() throws Exception {
        onView(withId(R.id.btnSecondActivity)).perform(click());
        ConditionWatcher.waitForCondition(new ActivityInstruction(SecondActivity.class));
        return new SecondActObject();
    }
}
