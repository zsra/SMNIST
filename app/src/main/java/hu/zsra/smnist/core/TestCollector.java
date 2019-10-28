package hu.zsra.smnist.core;

/***
 * This class collect the tests, which measured one time.
 */
public class TestCollector {

    /***
     * This variable help to put test into {@link TestCollector#Tests}.
     */
    private int Index;

    /***
     * This array contains the group of the tests.
     */
    private Test[] Tests;
    /***
     * How many test solved.
     */
    private int NumberOfTest;

    /***
     * This constructor create instance of the class.
     *
     * @param numberOfTest The test length.
     */
    public TestCollector(int numberOfTest) {
        this.NumberOfTest = numberOfTest;
        this.Tests = new Test[this.NumberOfTest];
        this.Index = 0;
    }

    /***
     * Add a test into {@link TestCollector#Tests}.
     *
     * @param test A new test.
     */
    public void AddTestToCollector(Test test) {
        if(Index < NumberOfTest) {
            this.Tests[Index] = test;
            Index++;
        }
    }

    /***
     *
     * @return Get all test from the collection.
     */
    public Test[] getTests() {
        return Tests;
    }

    /***
     *
     * @return Get number of test.
     */
    public int getNumberOfTest() {
        return NumberOfTest;
    }


}
