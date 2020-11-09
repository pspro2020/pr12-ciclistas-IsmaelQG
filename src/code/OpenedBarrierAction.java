package code;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class OpenedBarrierAction implements Runnable{

	private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	private final String[] phase = {"Comienza la etapa", "De vuelta a casa", "Etapa finalizada"};
	private int count = 0;

    @Override
    public void run() {
        System.out.printf("%s -> %s (executed in %s)\n",
                LocalTime.now().format(dateTimeFormatter),
                phase[count],
                Thread.currentThread().getName());
        count++;
    }

}
