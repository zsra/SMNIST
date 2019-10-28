package hu.zsra.smnist.core;

import java.util.Random;

import hu.zsra.smnist.interfaces.ITest;

public class TestService implements ITest {

    /***
     * Percentage of how many times choose the more snacks.
     *
     * @param testCollector An instance of  {@link TestCollector}.
     * @return Return with a percentage.
     */
    @Override
    public float calcPercentage(TestCollector testCollector) {
        return ((float)getAllTestsBigger(testCollector) / (float)testCollector.getNumberOfTest()) * 100;
    }

    /***
     * Generate a number between 1 - 6 to get a resource file.
     *
     * @return a number between 1 - 6.
     */
    @Override
    public int getRandomAmountOfSnacks() {
        Random rnd = new Random();
        int max = 6;
        int min = 1;

        return rnd.nextInt((max-min) + 1) + min;
    }

    /***
     * Collect all true value from Test array from collector and count.
     *
     * @param collector This collector will be show in Result.
     * @return How many times dog chosen more snacks.
     */
    @Override
    public int getAllTestsBigger(TestCollector collector) {
        int result = 0;
        for(Test t : collector.getTests()) {
            if(t.isChooseBigger()) {
                result++;
            }
        }

        return result;
    }
}
