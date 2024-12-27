public class Main{
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Number num=new Number(4);
        num.rand_num();//generates the first random number.

        Gameloop game=new Gameloop(num);
        game.gameloop();//playes executes the gameloop.
    }
}
