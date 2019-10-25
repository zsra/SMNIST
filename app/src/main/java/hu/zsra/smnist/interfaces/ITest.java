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
    double calcPercentage(TestCollector testCollector);

    /***
     * Generate a number between 1 - 6 to get a resource file.
     *
     * @return a number between 1 - 6.
     */
    int getRandomAmountOfSnacks();



}
