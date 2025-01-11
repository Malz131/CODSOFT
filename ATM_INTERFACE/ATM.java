public class ATM {
    private static Account account;
    ATM(Account account0){
        ATM.account=account0;
    }
    @SuppressWarnings("static-access")
    public void withdraw(Double amount){
        account.balance=account.balance -amount;

    }

    @SuppressWarnings("static-access")
    public void deposit(Double amount){
        account.balance=account.balance +amount;

    }
    @SuppressWarnings("static-access")
    public double checkBalance(){
        return account.balance;

    }      
}
//withdraw method
//deposit method
//checkBalance method



