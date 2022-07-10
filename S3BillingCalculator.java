import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class S3BillingCalculator implements S3Calculatable{
    private float pricePerGB = 0.00f;
    private float costPerGet = 0.00f;
    private float costPerPut = 0.00f;
    private Map<Integer, ArrayList<Integer>> itemList = new HashMap<Integer, ArrayList<Integer>>();
    public S3BillingCalculator(float pricePerGB, float costPerPut, float costPerGet) {
        // 1000 get for .50 and 1000 PUT for .25
        this.pricePerGB = pricePerGB;
        this.costPerPut = costPerPut/1000;
        this.costPerGet = costPerGet/1000;
    }
     public void addStorageGB(int userId, int amount) {
      //Index 0 for Storage in the ArrayList.
     if (! (itemList.containsKey(userId))) itemList.put(userId, new ArrayList<Integer>());
        itemList.get(userId).add(0,amount);
    }
    public void addGetRequests(int userId, int number) {
     //Index 1 for Get Requests in the ArrayList.
    if (! (itemList.containsKey(userId))) itemList.put(userId, new ArrayList<Integer>());
       itemList.get(userId).add(1,number);
}
    public void addPutRequests(int userId, int number) {
        //Index 2 for Put Requests in the ArrayList.
        if (! (itemList.containsKey(userId))) itemList.put(userId, new ArrayList<Integer>());
        itemList.get(userId).add(2,number);
}
    public Invoice createInvoice(int userId) {
        var costStorage = itemList.get(userId).get(0) * pricePerGB;
        var costGetRequests = itemList.get(userId).get(2) * costPerGet;
        var costPutRequests = itemList.get(userId).get(1) * costPerPut;
        var invoice = new Invoice(userId, costStorage, costGetRequests,costPutRequests);
        return invoice;
    }
}
