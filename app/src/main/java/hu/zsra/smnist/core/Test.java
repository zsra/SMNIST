package hu.zsra.smnist.core;

/***
 * Test class represent one test, where dog must choose between two pile of dog snacks.
 * If the dog choose more snack, that mean the dog could understand what see and the theory is true
 * It will choose the more snacks.
 */
public class Test {

    /***
     * This variable contains how many snacks on the top part of screen.
     */
    private int top_number;
    /***
     * This variable contains how many snacks on the bot part of screen.
     */
    private int bot_number;
    /***
     * If the dog choose more pile of snacks it will true, else it will false.
     */
    private boolean isChooseBigger;

    /***
     * Create a Test Instance without {@link Test#isChooseBigger}.
     *
     * @param top_number generated with {@link TestService#getRandomAmountOfSnacks()}.
     * @param bot_number generated with {@link TestService#getRandomAmountOfSnacks()}.
     */
    public Test(int top_number, int bot_number) {
        this.top_number = top_number;
        this.bot_number = bot_number;
    }

    /***
     *
     * @return Return with number of snacks on the top screen.
     */
    public int getTop_number() {
        return top_number;
    }

    /***
     *
     * @return Return with number of snacks on the bot screen.
     */
    public int getBot_number() {
        return bot_number;
    }

    /***
     *
     * @return If the dog choose more snacks return with true, else false.
     */
    public boolean isChooseBigger() {
        return isChooseBigger;
    }

    /***
     * Set the dog "answer".
     *
     * @param chooseBigger If the dog choose more snacks set true, else false.
     */
    public void setChooseBigger(boolean chooseBigger) {
        isChooseBigger = chooseBigger;
    }

}
