public class Number{
    public static int number;
    public static int tries;
    public static int score;
    public Number(int tries){
        this.tries=tries;
    }

    public String checker(int user_num){
        if (user_num<number){
             return "Wrong nummber.The number is too low than the actual value.";
        }
        else if (user_num>number){
            return "Wrong nummber.The number is too high than the actual value.";
        }
        return "Right number!!";}

    public static Integer rand_num(){
        while (true){
        number=Integer.parseInt(Long.toString(Math.round(Math.random()*100)));
        System.out.println(Integer.toString(number));
        if (number!=0){return number;};}
    }
}