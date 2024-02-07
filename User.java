public class User {
    private String nameSurname;
    private String idNumber;
    private String password;
    
    public User(String nameSurname,String idNumber){
        this.nameSurname=nameSurname;
        this.idNumber=idNumber;
    }
    public String getName(){
        return this.nameSurname;
    }
    public void setName(String name){
        this.nameSurname=name;
    }
    public void setPassword(String key){
        this.password=key;
    }
    public String getPassword(){
        return this.password;
    }
}
