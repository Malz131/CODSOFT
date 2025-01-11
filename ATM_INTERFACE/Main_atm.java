public class Main_atm{
    public static void main(String[] args) {
        Double balance=Double.parseDouble("0");
        Account account=new Account(balance);
        ATM atm=new ATM(account);
        Interface interface0=new Interface(atm);
        interface0.machine();
    }
}
