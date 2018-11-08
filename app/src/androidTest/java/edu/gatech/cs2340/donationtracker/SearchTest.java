package edu.gatech.cs2340.donationtracker;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
public class SearchTest {

    @Rule
    public ActivityTestRule<RegistrationActivity> mActivityRule =
            new ActivityTestRule<>(RegistrationActivity.class);


    @Test
    public void checkAllNull() {
        onView(withId(R.id.button_submit)).perform(click());
        onView(withText("One or more empty field(s)")).inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));
    }

    @Test
    public void checkAllTyped() {
        onView(withId(R.id.username_input)).perform(typeText("user"), closeSoftKeyboard());
        onView(withId(R.id.password_input)).perform(typeText("pass"), closeSoftKeyboard());
        onView(withId(R.id.email_input)).perform(typeText("user"), closeSoftKeyboard());
        onView(withId(R.id.button_submit)).perform(click());
    }

    @Test
    public void adminNoPermission() {
        onView(withId(R.id.username_input)).perform(typeText("user"), closeSoftKeyboard());
        onView(withId(R.id.password_input)).perform(typeText("pass"), closeSoftKeyboard());
        onView(withId(R.id.email_input)).perform(typeText("user"), closeSoftKeyboard());
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Admin"))).perform(click());

        //check toast
        onView(withText("Admin Permissions Not Granted")).inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));
    }

    @Test
    public void adminWithPermission() {
        onView(withId(R.id.username_input)).perform(typeText("user"), closeSoftKeyboard());
        onView(withId(R.id.password_input)).perform(typeText("Ez7R"), closeSoftKeyboard());
        onView(withId(R.id.email_input)).perform(typeText("user"), closeSoftKeyboard());
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Admin"))).perform(click());

        //check toast
        onView(withText("Authentication Failed")).inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));
    }



    /*
    @Test
    public void checkAdd() {
        //type 23 into the first edit box
        onView(withId(R.id.number1Field)).perform(typeText("23"), closeSoftKeyboard());
        //type 45 into the second edit box
        onView(withId(R.id.number2Field)).perform(typeText("45"), closeSoftKeyboard());
        //click on the spinner to select it
        onView(withId(R.id.spinner)).perform(click());
        //no access the adapter to look for the chosen item (+ in this case) and select it
        onData(allOf(is(instanceOf(String.class)), is("+"))).perform(click());
        //now click the execute button
        onView(withId(R.id.executeButton)).perform(click());
        //SystemClock.sleep(1000);
        /*
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        *
        //finally we grab the result text and make sure it matches our result
        onView(withId(R.id.resultText2)).check(matches(withText("68")));
        Espresso.pressBack();
    }
    */
}
