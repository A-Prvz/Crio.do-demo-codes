 class Thread1 extends Thread{
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Inside 1st thread "+Thread.currentThread().getId()+" print " +i);

        }
    }
}

 class Thread2 extends Thread{
     @Override
     public void run(){
         for(int i=0;i<5;i++){
             System.out.println("Inside 2nd thread "+Thread.currentThread().getId()+" print " +i);

         }
     }
 }
public class ThreadTester{
    public static void main(String[] args){
        System.out.println("Main Started ");
        Thread Thread1=new Thread1();
        Thread Thread2=new Thread2();
        Thread2.setDaemon(true);
        Thread1.start();
        Thread2.start();
        System.out.println("Main Executed and Finished ");
    }
}
