package it.finzicontini.simpleapp;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import it.finzicontini.simpleapp.screenobjects.FirstActObject;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NavigationTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void firstTest() throws Exception{
        FirstActObject fao = new FirstActObject();
        fao.clickOnBtnSecondActivity()
           .clickOnToggle()
        .clickOnButtonTo3rd()
                .clickOnButtonToSecondActivity()
                .clickOnToggle()
                .clickOnButtonTo3rd()
                .clickOnSwitch()
                .clickOnButtonToFinalActivity()
                .clickOnBtnToFirstAct();

    }

}
