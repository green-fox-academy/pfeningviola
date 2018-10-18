public class ConditionalVariableMutation {
    public static void main(String[] args) {

        //Ex. 1
        double a = 24;
        int out = 0;

        if(a % 2 == 0){
            out++;
        }
        System.out.println(out);

        //Ex. 2
        int b = 13;
        String out2 = "";
        if(b > 20){
            out2 = "More!";
        }else if(b < 10){
            out2 = "Less!";
        }else{
            out2 = "Sweet!";
        }
        System.out.println(out2);

        //Ex. 3
        int c = 123;
        int credits = 100;
        boolean isBonus = false;

        if((credits >= 50) && isBonus == false){
            c -= 2;
        }else if((credits < 50) && isBonus == false){
            c --;
        }
        System.out.println(c);

        //Ex. 4
        int d = 8;
        int time = 120;
        String out3 = "";
        if((d % 4 == 0) && (time <= 200)){
            out3 = "check";
        }else if(time > 200){
            out3 = "Time out";
        }else{
            out3 = "Run Forest run!";
        }
        System.out.println(out3);

    }
}
