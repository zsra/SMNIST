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
    public double calcPercentage(TestCollector testCollector) {
        int counterOfTrue = 0;
        for (Test test: testCollector.getTests()) {
            if(test.isChooseBigger() == true) {
                counterOfTrue++;
            }
        }
        int result = (counterOfTrue / testCollector.getNumberOfTest()) * 100;

        return result;
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

        int result = rnd.nextInt((max-min) + 1) + min;

        return result;
    }
}
