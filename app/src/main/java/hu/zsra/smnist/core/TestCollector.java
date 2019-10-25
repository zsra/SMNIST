package hu.zsra.smnist.core;

/***
 * This class collect the tests, which measured one time.
 */
public class TestCollector {

    /***
     * Counter of the Group of the Test to write out into json.
     */
    private static int idCounter = 1;
    /***
     * This variable help to put test into {@link TestCollector#Tests}.
     */
    private static int Index = 0;

    /***
     * The Tests id.
     */
    private int Id;
    /***
     * How old the dog is.
     */
    private int DogAgeInMonth;
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
     * @param dogAgeInMonth Dog age in month.
     * @param numberOfTest The test length.
     */
    public TestCollector(int dogAgeInMonth, int numberOfTest) {
        this.Id = idCounter;
        this.DogAgeInMonth = dogAgeInMonth;
        this.NumberOfTest = numberOfTest;
        this.Tests = new Test[this.NumberOfTest];

        idCounter++;
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
     * @return Return with a collector Id.
     */
    public int getId() {
        return Id;
    }

    /***
     *
     * @return Return with a dog ange in month.
     */
    public int getDogAgeInMonth() {
        return DogAgeInMonth;
    }

    /***
     * Set the dog age.
     *
     * @param dogAgeInMonth Dog age in month.
     */
    public void setDogAgeInMonth(int dogAgeInMonth) {
        DogAgeInMonth = dogAgeInMonth;
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

    /***
     * Set number of test.
     *
     * @param numberOfTest The test length.
     */
    public void setNumberOfTest(int numberOfTest) {
        NumberOfTest = numberOfTest;
    }
}
