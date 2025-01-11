import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class CurrencyRates {
    private static String link;
        private static String api_id;
        private static String base_currency;
        public CurrencyRates(String base_cur){
            CurrencyRates.base_currency=base_cur;
            CurrencyRates.api_id="547a6bcb1ad347718cbd83614ed3fe9d";
            CurrencyRates.link="https://openexchangerates.org/api/latest.json?app_id=" + api_id+"&base="+base_currency;
           //CurrencyRates.link="http://data.fixer.io/api/latest?access_key="+ CurrencyRates.api_id+"&base="+base_currency+"&callback=MY_FUNCTION";
        }
    @SuppressWarnings("CallToPrintStackTrace")
        public Double exchange_rate(String to_currency){
            URL url;
            Double safe=0.0;
            try {
                url = new URL(link);
                HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int response_code=connection.getResponseCode();
                if (response_code==HttpURLConnection.HTTP_OK){
                    InputStream response_stream=connection.getInputStream();
                    InputStreamReader response_streamread=new InputStreamReader(response_stream);
                    BufferedReader bufferedReader=new BufferedReader(response_streamread);
                    while (bufferedReader.ready()){
                        String input=bufferedReader.readLine();
                        String[] arr_input=input.split(":");
                        String currency=arr_input[0].strip();
                        if (currency.equals("\""+to_currency+"\"")){
                            String[] rate_string=arr_input[1].split(",");
                            Double rate =Double.valueOf(rate_string[0]);
                            return rate;
                        }

                    }
                    System.out.print("ERROR:INVALID CURRENCY CODE.(REQUIRED: ISO 4217 STANDARD)");
                    return safe;
                }
                else{
                    System.out.println("ERROR IN RESPONSE: "+Integer.toString(response_code)+"(Response code)");
                    return safe;
                }

            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
                return safe;
            }

            
    }
   public static void main(String[] args) {
    
} 
}
