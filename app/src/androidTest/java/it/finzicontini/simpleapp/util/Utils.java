package it.finzicontini.simpleapp.util;

import android.app.Activity;

import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;

import java.util.Collection;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

public final class Utils {
    public static Activity getActivityInstance(){
        final Activity[] currentActivity = new Activity[1];
        currentActivity[0] = null;
        getInstrumentation().runOnMainSync(new Runnable() {
            public void run() {
                Collection<Activity> resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
                for (Activity act: resumedActivities){
                    //Log.d("getActivityInstance: ", act.getClass().getId());
                    currentActivity[0] = act;
                    break;
                }
            }
        });
        return currentActivity[0];
    }

}
