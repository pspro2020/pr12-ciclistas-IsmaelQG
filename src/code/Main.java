package code;

import java.util.concurrent.CyclicBarrier;

public class Main {

	private static final int CYCLISTS = 10;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CYCLISTS, new OpenedBarrierAction());
        for (int i = 0; i < CYCLISTS; i++) {
            new Thread(new Cyclist("Cyclist " + i, cyclicBarrier), "Cyclist " + i).start();
        }
    }

}
