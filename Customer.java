package f4_2237234_p1;
// Mohamad Abutalib F4 2237234
public class Customer {
    private String FirstName;
    private String LastName;
    private String email;
    private long Card;
    private int DiscountCode;
    public Customer (String FirstName,String LastName,String email,long Card,int DiscountCode){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.email = email;
        this.DiscountCode = DiscountCode;
    }
    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }
    public String getFirstName(){
        return FirstName;
    }
    public void setLastName(String LastName){
        this.LastName = LastName;
    }
    public String getLastName(){
        return LastName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setCard(long Card){
        this.Card = Card;
    }
    public long getCard(){
        return Card;
    }
    public int getDisCode(){
        return DiscountCode;
    }
}
