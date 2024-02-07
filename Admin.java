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

public class Admin {
    private User user;
    private Pair pair;
    protected ArrayList<User> users;
    protected ArrayList<Stock> stocks;
    protected ArrayList<Pair> buy_orders;
    protected ArrayList<Pair> sell_orders;
    //private HashMap<Stock,Order> orders;
    public Admin(User user){
        this.user=user;
        ArrayList<User> users=new ArrayList<User>();
        ArrayList<Stock> stocks=new ArrayList<Stock>();
        ArrayList<Pair> buy_orders=new ArrayList<>();
        ArrayList<Pair> sell_orders=new ArrayList<>();
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

    public void showStocks(){
        for(Stock mystocks:stocks){
            System.out.println(mystocks.getName().toString()+mystocks.getPrice());
        }
    }


    public void takeOrder(UserPortfolio port){
        for (Pair mypair: port.orderPut){
            if(mypair.getOrder().getOrderType().equals("buy")||mypair.getOrder().getOrderType().equals("Buy")){
                buy_orders.add(mypair);
            } else if (mypair.getOrder().getOrderType().equals("sell")||mypair.getOrder().getOrderType().equals("Sell")) {
                sell_orders.add(mypair);
            }
        }
        
    }
    // public void trade(){
    //     for(Map.Entry<Stock,UserPortfolio> buy:buy_orders.entrySet()){
    //         for(Map.Entry<Stock,UserPortfolio> sell:buy_orders.entrySet()){
    //             if(buy.getKey().equals(sell.getKey())){
    //                 buy.getValue().userStocks.add(buy.getKey());
    //                 sell.getValue().userStocks.remove(sell.getKey());
    //                 buy_orders.remove(buy.getKey());
    //                 sell_orders.remove(sell.getKey());
    //             }
    //         }
    //     }
    // } hashmapte for loopla degisiklik yapmaya calisirsam concurrentmodification hatasi vericek o yuzden iterator kullanmaliyim
    
    public void trade() {
        for (Pair buy : buy_orders) {
            for (Pair sell : sell_orders) {
                if (buy.getOrder().getOrderedStock().getName().equals(sell.getOrder().getOrderedStock().getName())) {
                    buy.getUSerPortfolio().userStocks.add(buy.getOrder().getOrderedStock());
                    buy.getUSerPortfolio().orderHappened.add(buy.getOrder());

                    sell.getUSerPortfolio().userStocks.remove(buy.getOrder().getOrderedStock());
                    sell.getUSerPortfolio().orderHappened.add(sell.getOrder());
                }
            }
        }

    }
}
