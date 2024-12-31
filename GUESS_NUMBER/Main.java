public class Main{
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        //TITLE:
        System.out.println("GUESS THE NUMBER GAME");
        System.out.println("~~~~~~~~~~~~~~~~~");
        System.out.println("~LETS BEGIN!!!!!");
        //tries is 4
        Number num=new Number(6);
        num.rand_num();//generates the first random number.
        Gameloop game=new Gameloop(num);
        game.gameloop();//playes executes the gameloop.
    }
}
