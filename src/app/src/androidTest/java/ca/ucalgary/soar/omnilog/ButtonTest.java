package ca.ucalgary.soar.omnilog;




import org.junit.Test;
import org.junit.Rule;

import android.content.Intent;
import android.widget.Button;
import static org.junit.Assert.*;
import android.support.test.rule.ActivityTestRule;
import org.junit.runner.*;
import android.support.test.runner.AndroidJUnit4;


/**
 * Created by Alex Hamilton on 2017-06-12.
 * University of Calgary
 * alexander.hamilton@ucalgary.ca
 */



@RunWith(AndroidJUnit4.class)
public class ButtonTest {

    @Rule
    public ActivityTestRule<HomeScreenActivity> mActivityRule = new ActivityTestRule<>(
            HomeScreenActivity.class);



    @Test
    //Test that the activity begins not logging
    public void TestNot_Logging() throws Exception {
        Intent intent = new Intent(Intent.ACTION_PICK);
        HomeScreenActivity A = mActivityRule.launchActivity(intent);

        assertFalse(A.is_logging());
    }

    @Test
    //Test that the activity can begin logging
    public void TestStart_Logging() throws Exception {
        Intent intent = new Intent(Intent.ACTION_PICK);
        HomeScreenActivity A = mActivityRule.launchActivity(intent);

        A.startLogging();
        assertTrue(A.is_logging());
    }

    @Test
    //Test that logging can be halted
    public void TestStop_Logging() throws Exception {
        Intent intent = new Intent(Intent.ACTION_PICK);
        HomeScreenActivity A = mActivityRule.launchActivity(intent);

        A.startLogging();
        assertTrue(A.is_logging());
        A.stopLogging();
        assertFalse(A.is_logging());

    }



    @Test
    // Begins logging upon Button press
    public void Test_PressButton(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        HomeScreenActivity mActivity = mActivityRule.launchActivity(intent);
        Button button = (Button) mActivity.findViewById(R.id.button);

        button.callOnClick();
        assertTrue(mActivity.is_logging());
    }


    @Test
    //Stops logging upon second Button press
    public void Test_2PressButton(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        HomeScreenActivity mActivity = mActivityRule.launchActivity(intent);
        Button button = (Button) mActivity.findViewById(R.id.button);

        button.callOnClick();
        button.callOnClick();
        assertFalse(mActivity.is_logging());

    }

}



