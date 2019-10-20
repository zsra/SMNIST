package hu.zsra.smnist.core;

import java.util.Random;

public class Test implements ITest {

    private int ChossedMoreSnackNumber;

    public Test(){
        this.ChossedMoreSnackNumber = 0;
    }

    @Override
    public double calcPercentage() {
        return 0;
    }

    @Override
    public int getRandomAmountOfSnacks() {
        Random rnd = new Random();
        int max = 6;
        int min = 1;

        int result = rnd.nextInt((max - min) + 1) + min;

        return result;
    }

    public void setChossedMoreSnackNumber(int chossedMoreSnackNumber) {
        ChossedMoreSnackNumber = chossedMoreSnackNumber;
    }

    public int getChossedMoreSnackNumber(){
        return this.ChossedMoreSnackNumber;
    }
}
