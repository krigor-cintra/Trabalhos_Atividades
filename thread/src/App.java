import java.util.concurrent.Semaphore;

public class App {
  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(1);
    Thread chrigor = new Thread(new CountThread("Chrigor", semaphore));
    Thread jefferson = new Thread(new CountThread("Jefferson", semaphore));
    Thread lucas = new Thread(new CountThread("Lucas", semaphore));
    Thread rogerio = new Thread(new CountThread("Rogerio", semaphore));

    chrigor.start();
    jefferson.start();
    lucas.start();
    rogerio.start();
  }
}

class CountThread implements Runnable {
  private String name;
  private Semaphore semaphore;

  public CountThread(String name, Semaphore semaphore) {
    this.name = name;
    this.semaphore = semaphore;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i <= 100; i++) {
        semaphore.acquire();
        System.out.println(name + " - " + i);
        semaphore.release();
        Thread.sleep(100);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
