public class sem_semafaro {
    public static void main(String[] args) {
        Thread chrigor = new Thread(new CountThread("Chrigor"));
        Thread jefferson = new Thread(new CountThread("Jefferson"));
        Thread lucas = new Thread(new CountThread("Lucas"));
        Thread rogerio = new Thread(new CountThread("Rogerio"));
    
        chrigor.start();
        jefferson.start();
        lucas.start();
        rogerio.start();
      }
    }
    
    class CountThread implements Runnable {
      private String name;
    
    
      public CountThread(String name) {
        this.name = name;
 
      }
    
      @Override
      public void run() {
        try {
          for (int i = 0; i <= 100; i++) {
           
            System.out.println(name + " - " + i);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
