package Mohamad2237234F4;
public class Mouse extends Device {  
    private String Type;
    public Mouse(){};
    public Mouse(String Company,String Type,String DeviceCode){
        super(Company,DeviceCode);
        this.Type = Type;
    }
    public void setType(String Type){
        this.Type = Type;
    }
    public String getType(){
        return Type;
    }
    public String toString(){
        return ("Company :"+Company+" Mouse Type: "+Type);
    }
}
