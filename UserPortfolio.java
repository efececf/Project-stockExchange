import java.lang.reflect.Array;

//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


//import org.springframework.data.util.Predicates;

import java.util.Scanner;

//import org.hibernate.query.Order;

public class UserPortfolio {
    private Admin admin;
    private User user;
    private Order order;
    private Pair pair;
    private double balance=0;
    protected ArrayList<Stock> userStocks;
    protected int[] StockCounts;
    protected ArrayList<Pair> orderPut;
    protected ArrayList<Order> orderHappened;
    public UserPortfolio(User user){
        this.user=user;
        int[] StockCounts=new int[100];
        ArrayList<Stock> userStocks=new ArrayList<Stock>();
        //HashMap<Order,Stock> orderPut=new HashMap<>();
        ArrayList<Pair> orderPut=new ArrayList<>();
        //HashMap<Order,Stock> orderHappened=new HashMap<>();
        ArrayList<Order> orderHappened=new ArrayList<>();

    }
    public void setAdmin(Admin admin){
        this.admin=admin;
    }
    public void showStocksOwned(){
        for(Stock mystock:userStocks){
            System.out.println(mystock);
        }
    }
    public void putOrder(Order order,int pieces){
        //if(order.getOrderType.equals)
        Pair pair=new Pair(order,UserPortfolio.this,pieces);
        orderPut.add(pair);
    }
    public void orderHappen(Order order){
        orderHappened.add(order);
    }
    public double showBalance(){
        return balance;
    }
    public void updateBalance(double newBalance){
        balance=newBalance;
    } 
    // public Order getOrder(){
    //     JFrame f=new JFrame();//creating instance of JFrame  
    //     JButton a = new JButton("Buy");// creating instance of JButton
    //     a.setBounds(130, 100, 100, 40);// x axis, y axis, width, height
    //     a.addActionListener(new ActionListener(){
    //         public void actionPerformed(ActionEvent e){
    //             System.out.println("Which Stock do you want to buy?");
    //         }
    //     });

    //     JButton c = new JButton("Sell");// creating instance of JButton
    //     c.setBounds(130, 100, 100, 40);// x axis, y axis, width, height
    //      a.addActionListener(new ActionListener(){
    //         public void actionPerformed(ActionEvent e){
    //             System.out.println("Which Stock of yours do you want to sell?");
    //         }
    //     });


    //     f.add(a);
    //     f.add(c);



    // }
    Scanner s=new Scanner(System.in);
    public void createMenu() {
        JFrame frame = new JFrame("User Portfolio Menu");

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu portfolioMenu = new JMenu("Portfolio");
        menuBar.add(portfolioMenu);

        JMenuItem buyMenuItem = new JMenuItem("Place Buy Order");
        buyMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to handle the "Place Buy Order" menu item
                handleBuyOrder();
                //System.out.println("Which Stock Do you want to buy");

            }
        });
        portfolioMenu.add(buyMenuItem);

        JMenuItem showStocksMenuItem = new JMenuItem("Show Owned Stocks");
        showStocksMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to handle the "Show Owned Stocks" menu item
                showStocksOwned();
            }
        });
        portfolioMenu.add(showStocksMenuItem);

        // Add more menu items as needed

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void handleBuyOrder() {
        // Display a list of available stocks
        StringBuilder stockOptions = new StringBuilder("Available Stocks:\n");
        for (Stock futureStock : this.admin.stocks) {
            stockOptions.append(futureStock.getName()).append("\n");
        }
        String selectedStockSymbol = JOptionPane.showInputDialog(null, stockOptions.toString(),
                "Select a Stock to Buy", JOptionPane.PLAIN_MESSAGE);

        // Find the selected stock
        Stock selectedStock = null;
        for (Stock mystock : this.admin.stocks) {
            if (mystock.getName().equals(selectedStockSymbol)) {
                selectedStock = mystock;
                break;
            }
        }

        if (selectedStock != null) {
            // Prompt for the quantity
            String quantityStr = JOptionPane.showInputDialog(null, "Enter Quantity to Buy:",
                    "Buy Order", JOptionPane.PLAIN_MESSAGE);

            try {
                int quantity = Integer.parseInt(quantityStr);
                // Create a buy order (You may want to handle balance and other details)
                Order buyOrder = new Order("buy",selectedStock);
                putOrder(buyOrder,quantity);
                JOptionPane.showMessageDialog(null, "Buy Order Placed Successfully!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Quantity Format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    
}
