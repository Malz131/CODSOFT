import java.util.Scanner;

public class Interface {
    private static ATM atm;
    static boolean back=false;
        Interface(ATM atm0){
            Interface.atm=atm0;
            
        }
    @SuppressWarnings("resource")
    public static String input(){
        System.out.print("| Enter Input:  ");
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();
        return input;
    }
    public static Double amount_input(){
        Double num=Double.valueOf("0");
        System.out.print("| Enter Amount(ENTER '#' for back):  ");
        @SuppressWarnings("resource")
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();
        if (input.equals("#")){
            Interface.back=true;
            return num;
    }
    try{
        Double amount=Double.valueOf(input);
        return amount;
    }
    catch (Exception e){
    System.out.println("| ERROR: Input must be a value.");
    System.out.println("| Try again.");
    }
    ;
    return num;
}
public static String limits(Double amount){
    double balance=atm.checkBalance();
    
    if (amount>balance){
        return "Not enough money in account for withdrawal.";
    }
    else if (0.0>=amount){
        return "Invalid amount to withdraw.";
    }
    else{
        return "Transaction success!!";
    }
}
public static String limits_dep(Double amount){
    if (0.0>=amount){
        return "Invalid amount to deposit.";
    }
    else{
        return "Transaction success!!";
    }
}


//DISPLAY METHODS:
public static void withdraw_display(){
    System.out.println("------------------------------------");
    System.out.println("|            WITHDRAWAL            |");
    System.out.println("------------------------------------");
    System.out.println("|       Enter withdraw amount:     |");
    System.out.println("|       ~~~~~~~~~~~~~~~~~~~~~~     |");
    System.out.println("------------------------------------");

}
public static void checkBalance_display(){
    System.out.println("------------------------------------");
    System.out.println("|         ACCOUNT BALANCE:         |");
    System.out.println("|         ~~~~~~~~~~~~~~~~         |");
    System.out.println("------------------------------------");

}
public static void deposit_display(){
    System.out.println("------------------------------------");
    System.out.println("|            DEPOSIT               |");
    System.out.println("------------------------------------");
    System.out.println("|         Enter deposit:           |");
    System.out.println("|         ~~~~~~~~~~~~~            |");
    System.out.println("------------------------------------");

}
public static void main_display(){
    System.out.println("------------------------------------");
    System.out.println("|               ATM                |");
    System.out.println("|              ~~~~~               |");
    System.out.println("------------------------------------");
    System.out.println("|             ########             |");
    System.out.println("|             OPTIONS:             |");
    System.out.println("|             ########             |");
    System.out.println("|                                  |");
    System.out.println("| A)Withdraw             B)Deposit |");
    System.out.println("|          C)Check Balance         |");
    System.out.println("|          D)DONE                  |");
    System.out.println("|                                  |");
    System.out.println("------------------------------------");
    System.out.println("|      ENTER INPUT(A/B/C/D):       |");
    System.out.println("------------------------------------");

}

//Interfaces:
public static void withdraw_interface(){
    boolean x=true;
    while(x==true){
        
        withdraw_display();
        Double amount=amount_input();
        if (Interface.back==true){break;}
        if (amount!=0.0){
        String limit=limits(amount);
        if (limit.equals("Transaction success!!")){
            atm.withdraw(amount);
            System.out.println("|"+limit);
            break;
        }
        else{
            System.out.println("|Transaction failed:");
            System.out.println("|"+limit);
            break;
        }}
        else{
            System.out.println("|"+limits(amount));
        }

    }
}
public static void deposit_interface(){
    boolean x=true;

    while (x==true){
        
        deposit_display();
        Double amount=amount_input();
        if (Interface.back==true){break;}
        if (amount!=0.0){
        String limit=limits_dep(amount);
        if (limit.equals("Transaction success!!")){
            atm.deposit(amount);
            System.out.println(limit);
            break;
        }
        else{
            System.out.println(limit);
            break;
        }}
        else{
            System.out.println("|"+limits(amount));
        }


        
    }
}
public static void checkBalance_interface(){
    checkBalance_display();
    System.out.print("| Amount: ");
    System.out.println(atm.checkBalance());
}

public void machine(){
    boolean x=true;
    main_display();
    while(x==true){

        String input=input();
        if (input.equals("D")){
            System.out.println("| Thank you for using our services! ");
            break;
        }
        else if (input.equals("A")){
            withdraw_interface();
            main_display();
            Interface.back=false;
        }
        else if (input.equals("B")){
            deposit_interface();
            main_display();
            Interface.back=false;

        }
        else if (input.equals("C")){
            checkBalance_interface();
            main_display();
            Interface.back=false;

        }
        else{
            System.out.println("| ERROR: INPUT CAN ONLY BE A/B/C/D.");
            System.out.println("| Try again.");


        }



    }

}
// public static void main(String[] args){
//     machine();

// }
}
