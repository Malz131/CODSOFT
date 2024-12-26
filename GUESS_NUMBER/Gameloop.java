import java.util.Scanner;
public class Gameloop{
    private static Number number;private static int player_num;
    public Gameloop(Number number){
        this.number=number;
    }
    public static void gameloop(){
        Scanner StdIn=new Scanner(System.in);
        while (number.tries!=0){
            System.out.println("##################");
            System.out.println("Score: "+Integer.toString(number.score));
            System.out.println("##################");
            System.out.print("Enter the guess for generated number: ");
            int input=Integer.parseInt(StdIn.nextLine());
            String outcome=number.checker(input);
            if (outcome=="Right number!!"){
             System.out.println(outcome); 
            number.score=number.score+1;}
            else{
            System.out.print("Try again?(yes/no): ");
            String input0=StdIn.nextLine().split("")[0];      
            if (("no".equals(input0))){return;}
            else if ("yes".equals(input0)){
            number.tries=number.tries-1;}
            System.out.println(number.tries);
        }}
    }
//TODO:CHECK THE STANDARD INPUT OBJECT 
//AS TO WHY IT NOT WORKING.->DONE
    public static void main(String[] args){
        Number num=new Number(4);
        num.rand_num();
        System.out.println(num.number);
        Gameloop game=new Gameloop(num);
        game.gameloop();
    }
}