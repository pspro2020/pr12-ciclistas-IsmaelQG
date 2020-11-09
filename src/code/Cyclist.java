package code;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Cyclist implements Runnable{
	
	private final String name;
	private final CyclicBarrier cyclicBarrier;
	private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	public Cyclist(String name, CyclicBarrier cyclicBarrier) {
		this.name = name;
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		try {
			quedarGasolinera();
		}
		catch(InterruptedException e) {
			return;
		}
		try {
			cyclicBarrier.await();
		}
		catch(InterruptedException e) {
			return;
		}
		catch(BrokenBarrierException e) {
			
		}
		try {
			llegarVenta();
		}
		catch(InterruptedException e) {
			return;
		}
		try {
			cyclicBarrier.await();
		}
		catch(InterruptedException e) {
			return;
		}
		catch(BrokenBarrierException e) {
			
		}
		try {
			vueltaGasolinera();
		}
		catch(InterruptedException e) {
			return;
		}
		try {
			cyclicBarrier.await();
		}
		catch(InterruptedException e) {
			return;
		}
		catch(BrokenBarrierException e) {
			
		}
		try {
			vueltaCasa();
		}
		catch(InterruptedException e) {
			return;
		}
		
	}
	
	private void quedarGasolinera() throws InterruptedException{
		System.out.printf("%s -> %s sale de casa\n",
                LocalTime.now().format(dateTimeFormatter), name);
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3 + 1));
        System.out.printf("%s -> %s ha llegado a la gasolinera\n",
                LocalTime.now().format(dateTimeFormatter), name);
	}
	
	private void llegarVenta() throws InterruptedException{
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5, 10 + 1));
        System.out.printf("%s -> %s ha llegado a la venta\n",
                LocalTime.now().format(dateTimeFormatter), name);
	}
	
	private void vueltaGasolinera() throws InterruptedException{
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5, 10 + 1));
        System.out.printf("%s -> %s ha llegado a la gasolinera de vuelta\n",
                LocalTime.now().format(dateTimeFormatter), name);
	}
	
	private void vueltaCasa() throws InterruptedException{
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3 + 1));
        System.out.printf("%s -> %s ha llegado a su casa\n",
                LocalTime.now().format(dateTimeFormatter), name);
	}


}
