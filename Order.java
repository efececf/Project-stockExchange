public class Order {
    private String orderStatus="Waiting";
    private Stock stock;
    private String orderType;
    public Order(String orderType,Stock stock){
        this.orderType=orderType;
        this.stock=stock;
        
    }
    public String getOrderType(){
        return this.orderType;
    }
    public Stock getOrderedStock(){
        return this.stock;
    }
    public void setOrderStatus(String stat){
        orderStatus=stat;
    }
}
