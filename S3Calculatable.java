public interface S3Calculatable {
    void addStorageGB(int userId, int amount);
    void  addGetRequests(int userId, int number);
    void  addPutRequests(int userId, int number);
    Invoice createInvoice(int userId);
}
