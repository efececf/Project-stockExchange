import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

//import org.springframework.data.domain.Window;

public class LoginandRegister extends JFrame {
    final private Font mainFont = new Font("Segoe print",Font.BOLD,18);
    JTextField tfName;
    private Admin admin;

    public void setAdmin(Admin admin){
        this.admin=admin;
    }
    public void initialize(){
        
        

        JLabel login=new JLabel("Login",SwingConstants.CENTER);
        login.setFont(mainFont);

        JLabel name=new JLabel("Name Surname");
        name.setFont(mainFont);

        
        tfName=new JTextField();
        tfName.setFont(mainFont);


        JLabel password=new JLabel("password");
        password.setFont(mainFont);

        JPasswordField pfPassword=new JPasswordField();
        pfPassword.setFont(mainFont);

        JPanel formPanel=new JPanel();
        formPanel.setLayout(new GridLayout(0,1,10,10));
        formPanel.add(login);
        formPanel.add(name);
        formPanel.add(tfName);
        formPanel.add(password);
        formPanel.add(pfPassword);


        JButton btnLogin=new JButton("Login");
        btnLogin.setFont(mainFont);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String name=tfName.getText();
                String password=String.valueOf(pfPassword.getPassword());
                boolean condition=authenticateUser(name,password);
                if(condition==true){
                    
                    initialize();
                    dispose();

                }
                else{
                    JOptionPane.showMessageDialog(LoginandRegister.this, "Email or password wrong","Try again",JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        


        



    }
    public boolean authenticateUser(String name,String password){
            for(User p_user:this.admin.users){
                if(p_user.getName().equals((name))){
                    if(p_user.getPassword().equals(password)){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
    
            }
            return false;

        }
    
}
