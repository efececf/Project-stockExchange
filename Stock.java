import java.util.ArrayList;

public class Stock {
    private String nameStock;
    private double price;
    //private ArrayList<Order> order;
    private int piecesStock;
    public Stock(String nameStock,double initialprice,int piecesStock){
        this.nameStock=nameStock;
        this.price=initialprice;
        this.piecesStock=piecesStock;
    }
    public int getPiece(){
        return this.piecesStock;
    }
    public String getName(){
        return this.nameStock;
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(double newPrice){
        this.price=newPrice;
    }
    
    
}
