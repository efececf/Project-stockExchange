public class Pair{
    private Stock stock;
    private UserPortfolio port;
    private int pieces;
    private Order order;
    public Pair(Order order,UserPortfolio port,int pieces){
        this.order=order;
        this.port=port;
        this.pieces=pieces;
    }
    public Order getOrder(){
        return this.order;
    }
    public void setOrder(Order myorder){
        this.order=myorder;

    }
    public UserPortfolio getUSerPortfolio(){
        return this.port;
    }

    public int getPieces() {
        return this.pieces;
    }
    public void setPieces(int pieces1){
        this.pieces=pieces1;
    }
}