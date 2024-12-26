public class Main{
    public static void main(String[] args) {
        Number num=new Number(4);
        num.rand_num();
        System.out.println(num.number);
        Gameloop game=new Gameloop(num);
        game.gameloop();
    }
}
