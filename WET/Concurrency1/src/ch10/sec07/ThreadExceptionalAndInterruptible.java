package ch10.sec07;

public class ThreadExceptionalAndInterruptible {

	public static void main(String[] args) throws InterruptedException {
		int sleepTime = (int) Math.floor(Math.random() * 10000);

		Runnable interruptibleTask = () -> {
			System.out.print("\nInterruptible: ");
			try {
				for (int i = 1; i <= 100; i++) {
					System.out.println(i + " ");
					if (i == 70)
						throw new IllegalStateException();
					Thread.sleep(100);
				}
			} catch (InterruptedException ex) {
				System.out.println("Interrupted!");
			}
		};

		Thread thread = new Thread(interruptibleTask);
		thread.setUncaughtExceptionHandler((t, ex) -> System.out.println("Exception caught!"));
		thread.start();
		Thread.sleep(sleepTime);
		thread.interrupt();
		thread.join();

	}
}
