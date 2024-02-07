public class Run {
    public static void main(String[] args) throws InterruptedException {
        thread1 loading = new thread1();
        thread2 home = new thread2();
        Thread t1 = new Thread(loading);
        Thread t2 = new Thread(home);
        t1.start();
        t1.join();
        t2.start();
    }
}