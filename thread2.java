public class thread2 implements Runnable{

    @Override
    public void run() {
        new entry();
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
    
}
