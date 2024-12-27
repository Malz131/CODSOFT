public class Number{
    //Declarations of instance variables:
    public static int number;
    public static int tries;
    public static int score;
    public Number(int tries){
        //get the number of tries the player want to have if they guess the wrong number:
        Number.tries=tries;
    }

    public String checker(int user_num){
        /*This method validates the number being guessed.*/
        if (user_num<number){
             return "Wrong nummber.The number is too low than the actual value.";
        }
        else if (user_num>number){
            return "Wrong nummber.The number is too high than the actual value.";
        }
        return "Right number!!";}

    public static Integer rand_num(){
        /*This method generates the random number */
        while (true){
        number=Integer.parseInt(Long.toString(Math.round(Math.random()*100)));
        if (number!=0){return number;};}
    }
}