import java.util.Scanner;
class timegap{
    void tmgp(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in=new Scanner(System.in);// 手动输入
        timegap gp=new timegap();
        while(true){
            int targetnum;
            String[] presmem={"AI(Nor)","AI(Spe1)","AI(Spe2)"};
            int[] range={0,1000};
            int centernum=0;
            String[] updngroup={"over","under"};
            String updn;
            String winner="Nobody";
            int difference;
            int resultnum;
            int rdposition;
            int[] rdseq;
            rdseq=new int[10];
            //int memseq;

            targetnum=(int) (Math.random() * 1000);
            System.out.println("The target number is "+targetnum);
            gp.tmgp();

            // 另一种实现循环member的方法
            // for (int memseq = 0; memseq < presmem.length; memseq++) {
            //     try{
            //         Thread.sleep(500);
            //     }catch(InterruptedException e){
            //     }
            //     System.out.println("memseq= "+memseq);
            //     if (memseq==presmem.length-1){
            //         memseq=-1;
            //     }
            // }


            int memstart = (int) (Math.random()*presmem.length);
            System.out.println("Judge: Guess the number from "+range[0]+" to "+range[1]);
            gp.tmgp();
            System.out.println("Judge: Let's start from "+presmem[memstart]);
            gp.tmgp();

            for (int memseq=memstart; memseq <= presmem.length; memseq++) {//一上来随机某个对象开始
                if (memseq==presmem.length){
                    memseq=0;
                }
                centernum=(range[0]+range[1])/2;
                difference=range[1]-range[0];
                




                if(difference<=10){
                    //System.out.println("difference = "+difference);
                    for (int i = 0; i < difference; i++) {
                        rdseq[i]=range[0]+i;
                        //System.out.println(rdseq[i]);
                    }
                    while(true){
                        rdposition=(int) (Math.random()*difference);
                        resultnum=rdseq[rdposition];
                        System.out.println(presmem[memseq]+": Is the target number "+resultnum+"?");
                        
                        gp.tmgp();
                        if (resultnum==targetnum) {
                            winner=presmem[memseq];
                            break;
                        }
                        System.out.println("Judge: No");
                        gp.tmgp();

                        rdseq[rdposition]=rdseq[difference-1];
                        difference--;

                    }
                    break;

                }


                updn=updngroup[(int) (Math.random()*2)];
                System.out.println(presmem[memseq]+": Is the number "+updn+" "+centernum);
                gp.tmgp();

                if(targetnum>=centernum){
                    if(updn=="over"){
                        System.out.println("Judge: Yes");
                    }
                    if(updn=="under"){
                        System.out.println("Judge: No");
                    }
                    range[0]=centernum;                   
                }

                if(targetnum<centernum){
                    if(updn=="over"){
                        System.out.println("Judge: No");
                    }
                    if(updn=="under"){
                        System.out.println("Judge: Yes");
                    }
                    range[1]=centernum;     
                }

                //System.out.println("memseq= "+memseq);
                

                gp.tmgp();
            }
            System.out.println("Judge: We have a winner: "+winner);

            gp.tmgp();

            System.out.println("Continue? (Yes/No)");  
            String inword=in.next();
            
            if(inword.equals("yes")){
                System.out.println("Judge: Let's start again");
            }
            
            else{
                break;
            }
            
            gp.tmgp();

            
        }
        in.close();
        //System.out.println("Result: ");
        
    }
}
