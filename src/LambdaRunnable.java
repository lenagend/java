public class LambdaRunnable {
    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("안녕하세요");
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                try{
                    //시가지연은 인터럽트를 발생할 수 있으므로 try-catch로 감싼다
                    Thread.sleep(2000);
                    System.out.println("김광민입니다");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        process(r1);
        process(r2);
        process(()->System.out.println("잘 부탁드립니다."));

    }
    public static void process(Runnable r){
        r.run();
    }
}
