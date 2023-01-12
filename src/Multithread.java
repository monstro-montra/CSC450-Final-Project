public class Multithread extends Thread{

    @Override
    public void run(){
        for (int i = 0; i <= 20; i++){
            try{
                Thread.sleep(250);
            } catch (InterruptedException e){
            }
        }
    }

}
