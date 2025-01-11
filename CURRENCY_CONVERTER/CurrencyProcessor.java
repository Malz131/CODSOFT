
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyProcessor {
    private static Scanner scan;
    public CurrencyProcessor(){
        CurrencyProcessor.scan=new Scanner(System.in);

    }

    public static void main_display(){
        System.out.println("");
        System.out.println("``CURRENCY CONVERTER``");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("NOTE:ENTER \"!\" AS CURRENCY CODE INPUT TO STOP.");


    }
    public static String currecncyFormat(Double amount,String currencycode){
        String country_code=currencycode.substring(0,2);
        Locale local = new Locale("en",country_code);    
        String money=NumberFormat.getCurrencyInstance(local).format(amount);
        // System.out.println(num);
        // Currency cur=Currency.getInstance("ZAR");
        // System.out.println(cur.getCurrencyCode());
        return money;
        
    }
    public static String input(){
        String input =scan.nextLine();
        return input;
    }
    public static Double amount(){
        System.out.print("ENTER THE AMOUNT: ");
        Double safe=0.0;
        try{
        Double amount=Double.valueOf(input());
        return amount;}
        catch(NumberFormatException err){
        System.out.println("ERROR:AMOUNT SHOULD BE A NUMBER.");
            return safe;
        }
    }
    
    public static void currTo_display(){
        System.out.print("ENTER THE TARGET CURRENCY CODE CONVERTING|REQUIRED: ISO 4217 STANDARD: ");
    }
    public static void currFrom_display(){
        System.out.print("ENTER THE BASE CURRENCY CODE(default USD)|REQUIRED: ISO 4217 STANDARD: ");
    }
    public static String currency_validations(String currencycode){
        String  err="";
        try {
            @SuppressWarnings("unused")
            Currency currency=Currency.getInstance(currencycode);
            return err;

        } catch (Exception e) {
            System.out.println("ERROR:INVALID CURRENCY CODE.(REQUIRED: ISO 4217 STANDARD)");
            err="ERROR";
            return err;

        }
    }
    public void operation(){

        boolean operate=true;
        while (operate==true){

        String curfromcode="";
        String curtocode="";

        main_display();
        currFrom_display();
        curfromcode=input();
        
        if (curfromcode.equals("")){curfromcode="USD";}
        if (curfromcode.equals("!")){break;}

        if (curfromcode.length()==3){
                //Further validations:
            
            if (currency_validations(curfromcode).equals("ERROR")){}
            else{
            //THIS IS DUE TO THE  API KEY AND URL OBTAINED ONLINE AND ITS RESTRICTIONS:
            if (curfromcode.equals("USD") || curfromcode.equals("")){
                CurrencyRates currRates=new CurrencyRates("USD");
                currTo_display();
                curtocode=input();
                if (curtocode.equals("!")){break;}
                
                if (curtocode.length()==3){
                        //Further validations:
                    if (currency_validations(curtocode).equals("ERROR")){}
                    else{
                        Double rate=currRates.exchange_rate(curtocode);
                        Double amount=amount();//make it so the amount inputed has a currency symbol.
                        Double amount_converted=amount*rate;
                        String target_money=currecncyFormat(amount_converted, curtocode);
                        System.out.println("TARGET MONEY IS: "+target_money);
                        }

                    }
                else{
                    System.out.println("ERROR:INVALID CURRENCY CODE.(REQUIRED: ISO 4217 STANDARD)");
                }
            }
            else{
            System.out.println("ERROR:INVALID BASE CURRENCY CODE.ONLY USD CAN BE SELECTED.");
            }}
        }
        else{
        System.out.println("ERROR:INVALID CURRENCY CODE.(REQUIRED: ISO 4217 STANDARD)");
            }
        }
        System.out.println("THANK YOU FOR USING THE SOFTWARE.");

    }
    public static void main(String[] args) {
        
    }
}
