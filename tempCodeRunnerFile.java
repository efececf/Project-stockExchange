import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map;
import java.util.Iterator;

//import org.hibernate.mapping.Map;
//import org.hibernate.query.Order;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
/*
public class Admin {
    private User user;
    protected ArrayList<User> users;
    protected ArrayList<Stock> stocks;
    protected HashMap<Stock,UserPortfolio> buy_orders;
    protected HashMap<Stock,UserPortfolio> sell_orders;
    //private HashMap<Stock,Order> orders;
    public Admin(User user){
        this.user=user;
        ArrayList<User> users=new ArrayList<User>();
        ArrayList<Stock> stocks=new ArrayList<Stock>();
        HashMap<Stock,UserPortfolio> buy_orders=new HashMap<>();
        HashMap<Stock,UserPortfolio> sell_orders=new HashMap<>();
    }
    public void registerUser(User user){
        users.add(user);
    }
    public void delUSer(User user){
        users.remove(user);
        user=null;
    }
    public void changeAdminPassword(String newPass){
        this.user.setPassword(newPass);
    }
    public void publicOffer(Stock stock){
        stocks.add(stock);
    }
    public void collapse(Stock stock){
        stocks.remove(stock);
    }
    public void takeOrder(UserPortfolio port){
        for(Map.Entry<Order,Stock> set:port.orderPut.entrySet()){
            if(set.getKey().getOrderType()=="buy"||set.getKey().getOrderType()=="BUY"){
                buy_orders.put(set.getValue(),port);
            }
            else if(set.getKey().getOrderType()=="sell"||set.getKey().getOrderType()=="SELL"){
                sell_orders.put(set.getValue(),port);
            }
        }
        
    }
    
    public void trade() {
        Iterator<Map.Entry<Stock, UserPortfolio>> buyIterator = buy_orders.entrySet().iterator();
        while (buyIterator.hasNext()) {
            Map.Entry<Stock, UserPortfolio> buy = buyIterator.next();

            Iterator<Map.Entry<Stock, UserPortfolio>> sellIterator = sell_orders.entrySet().iterator();
            while (sellIterator.hasNext()) {
                Map.Entry<Stock, UserPortfolio> sell = sellIterator.next();

                if (buy.getKey().equals(sell.getKey())) {
                    // Perform the trade
                    buy.getValue().userStocks.add(buy.getKey());
                    sell.getValue().userStocks.remove(sell.getKey());

                    // Remove entries from the order lists
                    buyIterator.remove();
                    sellIterator.remove();
                }
            }
        }
    }

    
}
*/