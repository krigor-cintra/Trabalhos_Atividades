public class ThreadMonitor {
    public static void main(String[] args) {
        Object monitor = new Object();

        Thread chrigor = new Thread(new NumerosRunnable(monitor, "Chrigor"));
        Thread lucas = new Thread(new NumerosRunnable(monitor, "Lucas"));
        Thread rogerio = new Thread(new NumerosRunnable(monitor, "Rogerio"));
        Thread jefferson = new Thread(new NumerosRunnable(monitor, "Jefferson"));

        chrigor.start();
        lucas.start();
        rogerio.start();
        jefferson.start();
    }
}

class NumerosRunnable implements Runnable {
    private final Object monitor;
    private final String nome;

    public NumerosRunnable(Object monitor, String nome) {
        this.monitor = monitor;
        this.nome = nome;
    }

    public void run() {
        synchronized (monitor) {
            for (int i = 0; i <= 100; i++) {
                System.out.println(nome + ": " + i);
            }
        }
    }
}
