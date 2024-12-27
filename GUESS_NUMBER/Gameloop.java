import java.util.Scanner;
public class Gameloop{
    private static Number number;private static int player_num;
    public Gameloop(Number number){
        Gameloop.number=number;
    }

    @SuppressWarnings("static-access")//this suppress any static access warnings 
    public static void gameloop(){
        /*This method loops through the game until the there are 
        no tries for a player to continue
        or a player decided not to continue playing.*/

        //this supress any resource leakage warnings from StdIn object:
        @SuppressWarnings("resource")
        Scanner StdIn=new Scanner(System.in);
        while (number.tries!=0){
            //check the actual value of the number being guessed.(debugging purposes)
            System.out.println("The random number is "+Integer.toString(number.number)+" (this is for debugging purposes)");

            System.out.println("##################");
            System.out.println("Score: "+Integer.toString(number.score));
            System.out.println("##################");
            System.out.print("Enter the guess for generated number: ");
            int input=Integer.parseInt(StdIn.nextLine());
            String outcome=number.checker(input);

            //when the number guessed is the right number:
            if (outcome=="Right number!!"){
            System.out.println(outcome);
            System.out.println("Continue?(yes/no): ");
            String input0=StdIn.nextLine();   
            number.score=number.score+1;   
            if (("no".equals(input0))){break;}
            else if ("yes".equals(input0)){
            number.rand_num();}
            System.out.println("Tries left: "+Integer.toString(number.tries)); 
}

            //when the number guessed is the wrong number:
            else{
            System.out.println(outcome); 
            System.out.println("Try again?(yes/no): ");
            String input0=StdIn.nextLine();      
            if (("no".equals(input0))){

                break;}
            else if ("yes".equals(input0)){
            number.tries=number.tries-1;}
            System.out.println(number.tries);
        }}
        if(number.tries==0){
            System.out.println("Out of tries.Game ends");
        }
        else{
            System.out.println("Game ends");
            System.out.println("Final score: "+Integer.toString(number.score));

        }
    }
//TODO:CHECK THE STANDARD INPUT OBJECT 
//AS TO WHY IT NOT WORKING.->DONE
    @SuppressWarnings("static-access")
    public static void main(String[] args){
        Number num=new Number(4);
        num.rand_num();
        System.out.println(num.number);
        Gameloop game=new Gameloop(num);
        game.gameloop();
    }
}