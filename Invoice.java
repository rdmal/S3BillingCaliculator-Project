import java.text.NumberFormat;
import java.util.Locale;

public  class Invoice  {
    private int userId = 0;
    private float costStorage = 0.00f;
    private float costGetRequests = 0.00f;
    private float costPutRequests = 0.00f;
    public Invoice (int userId, float costStorage, float costGetRequests, float costPutRequests) {
        this .userId = userId;
        this.costStorage = costStorage;
        this.costGetRequests = costGetRequests;
        this.costPutRequests = costPutRequests;
    }
   private String currencyConverter (float amount) {
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(amount);
    }
    @Override
    public String toString() {
        String str;
        float totalCost = costStorage + costGetRequests + costPutRequests ;

         str = '\n' + "UserId:" + userId + '\n'
                 + "Storage:" + currencyConverter(costStorage) + '\n'
                 + "Get Requests:" + currencyConverter(costGetRequests)  + '\n'
                 + "Put Requests:" + currencyConverter(costPutRequests) + '\n'
                 + "Total Cost:" + currencyConverter(totalCost);
        return str;
    }
}
