package it.finzicontini.simpleapp.util.condition;


public class ConditionWatcher {
    public static final int CONDITION_NOT_MET = 0;
    public static final int CONDITION_MET = 1;
    public static final int TIMEOUT = 2;

    public static final int DEFAULT_TIMEOUT_LIMIT = 1000 * 60;
    public static final int DEFAULT_INTERVAL = 50 ;

    private int timeoutLimit = DEFAULT_TIMEOUT_LIMIT;
    private int watchInterval = DEFAULT_INTERVAL;

    private static ConditionWatcher conditionWatcher;

    private ConditionWatcher() {
        super();
    }

    public static ConditionWatcher getInstance() {
        if (conditionWatcher == null) {
            conditionWatcher = new ConditionWatcher();
        }
        return conditionWatcher;
    }

    public static void waitForCondition(Instruction instruction) throws Exception {
        int status = CONDITION_NOT_MET;
        int elapsedTime = 0;

        do {
            if (instruction.checkCondition()) {
                status = CONDITION_MET;
            } else {
                elapsedTime += getInstance().watchInterval;
                //Dbg.d("ConditionWatcher","Condition is " + instruction.getDescription() + "; elapsedTime = " + elapsedTime);
                Thread.sleep(getInstance().watchInterval);
            }

            if (elapsedTime >= getInstance().timeoutLimit) {
                status = TIMEOUT;
                break;
            }
        } while (status != CONDITION_MET);

        if (status == TIMEOUT)
            throw new Exception(instruction.getDescription() + " - took more than " + getInstance().timeoutLimit/1000 + " seconds. Test stopped.");
    }

    public static void setWatchInterval(int watchInterval) {
        getInstance().watchInterval = watchInterval;
    }

    public static void setTimeoutLimit(int ms) {
        getInstance().timeoutLimit = ms;
    }
}
