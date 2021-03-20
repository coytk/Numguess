public class App {
    public static void main(String[] args) throws Exception {
        while(true){
            int number = (int) (Math.random() * 2);
            System.out.println("first: "+number);
            int a;
            a=0%3;
            System.out.println(a);


            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
            }
        }
        
    }
}
