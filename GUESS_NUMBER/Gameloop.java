import java.util.Scanner;
public class Gameloop{
    private static Number number;private static String outcome;
    private static String input;private static String input0;
    public Gameloop(Number number){
        Gameloop.number=number;
        Gameloop.outcome="";
        Gameloop.input="";
        Gameloop.input0="";

    }

    @SuppressWarnings("static-access")//this suppress any static access warnings 
    public static void gameloop(){
        /*This method loops through the game until the there are 
        no tries for a player to continue
        or a player decided not to continue playing.*/

        //this supress any resource leakage warnings from StdIn object:
        @SuppressWarnings("resource")
        Scanner StdIn=new Scanner(System.in);
        boolean iscontinue=true;
        boolean iscontinue0=true;
        while (number.tries!=0){

            if (iscontinue==true && iscontinue0==true){
            //check the actual value of the number being guessed.(debugging purposes)
            System.out.println("");
        
            // System.out.println("The random number is "+Integer.toString(number.number)+" (this is for debugging purposes)");

            System.out.println("##################");
            System.out.print("Score: "+Integer.toString(number.score)+" ");
            System.out.print("Tries: "+Integer.toString(number.tries));
            System.out.println("");
            System.out.println("##################");
            System.out.print("Enter the guess for generated number: ");}
            try{
            if (iscontinue==true && iscontinue0==true){
            int input=Integer.parseInt(StdIn.nextLine());
            if (0>input || input>100){
            System.out.println("ERROR:Input has to be a Integer value in the range 1-100");
            iscontinue=false;
            }
            else{outcome=number.checker(input);}
            }

            //when the number guessed is the right number:
            if (outcome=="Right number!!" || iscontinue0==false){
            if (iscontinue0==true){System.out.println(outcome);}

            System.out.println("Continue?(yes/no): ");
            String input0=StdIn.nextLine(); 
            //FIX TRY AGAIN BUG.
            if (("no".equals(input0))){
            number.score=number.score+1;   
                break;}
            else if ("yes".equals(input0)){
            number.rand_num();
            System.out.println("Tries left: "+Integer.toString(number.tries));
            number.score=number.score+1;   
            iscontinue0=true;}
            else{
            System.out.println("ERROR:Input can only be either yes/no");
            iscontinue0=false;
            }
}

            //when the number guessed is the wrong number:
            else{
            if (iscontinue==true){System.out.println(outcome);}
            System.out.println("Try again?(yes/no): ");
            String input0=StdIn.nextLine();      
            if (("no".equals(input0))){
                break;}
            else if ("yes".equals(input0)){
            number.tries=number.tries-1;
            iscontinue=true;
            System.out.println("Tries left: "+Integer.toString(number.tries));}
            else{
            System.out.println("ERROR:Input can only be either yes/no");
            iscontinue=false;
            }
        }}
        catch(Exception e){
            System.out.println("ERROR:Input has to be a Integer value in the range 1-100");
        }
    }
        if(number.tries==0){
            System.out.println("Out of tries. Game over!");
        }
        else{
            System.out.println("Game over!");
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