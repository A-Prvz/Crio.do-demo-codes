class Threadrunnable implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Inside thread by Runnable Interface "+Thread.currentThread().getId()+" print " +i);
        }
    }
}


public class ImplementingRunnable {
    public static void main(String[] args) {
        System.out.println("Main Started ");
        Thread Threadrunnable= new Thread( new Threadrunnable());
        Thread ThreadRunnableLambda=new Thread(()->{
              for(int i=0;i<5;i++){
                  System.out.println("Inside thread by Runnable Interface using Lambda exp "+Thread.currentThread().getName()+" "+Thread.currentThread().getId()+" print " +i);
              }
          }, "Threadx");
        Threadrunnable.start();
        ThreadRunnableLambda.start();
        System.out.println("Main Executed and Finished ");
    }
}
