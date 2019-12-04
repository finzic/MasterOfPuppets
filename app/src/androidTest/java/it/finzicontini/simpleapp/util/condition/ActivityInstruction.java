package it.finzicontini.simpleapp.util.condition;

import android.app.Activity;

import it.finzicontini.simpleapp.util.Utils;

public class ActivityInstruction extends Instruction {

    private Class<?> mAct;

    public ActivityInstruction (final Class<?> a) {
        this.mAct = a;
    }
    @Override
    public String getDescription() {
        return "The present activity is not of type" + mAct.getName();
    }

    @Override
    public boolean checkCondition() {
        Activity activity = Utils.getActivityInstance();
        if (activity == null) return false;
        return mAct.isInstance(activity);
    }
}