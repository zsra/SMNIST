package hu.zsra.smnist.interfaces;

import hu.zsra.smnist.core.TestCollector;

/***
 * Method declarations to create and analysing the test.
 */
public interface ITest {

    /***
     * Percentage of how many times choose the more snacks.
     *
     * @param testCollector An instance of  {@link TestCollector}.
     * @return Return with a percentage.
     */
    float calcPercentage(TestCollector testCollector);

    /***
     * Generate a number between 1 - 6 to get a resource file.
     *
     * @return a number between 1 - 6.
     */
    int getRandomAmountOfSnacks();

    /***
     * Collect all true value from Test array from collector and count.
     *
     * @param collector This collector will be show in Result.
     * @return How many times dog chosen more snacks.
     */
    int getAllTestsBigger(TestCollector collector);

}
