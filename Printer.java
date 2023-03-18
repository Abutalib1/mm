package Mohamad2237234F4;
public class Printer extends Device {
    private String Type;
    private boolean isColor;
    private String Color;
    public Printer(){};
    public Printer (String Company,String Type,boolean isColor,String DeviceCode){
        super(Company,DeviceCode);
        this.Type = Type;
        this.isColor = isColor;
        if (this.isColor){Color = "Colored";}
        else {Color = "Black&white";}
    }
    public void setType(String Type){
        this.Type = Type;
    }
    public String getType(){
        return Type;
    }
    public void setIsColor(boolean isColor){
        this.isColor = isColor;
        if (this.isColor){Color = "Colored";}
        else {Color = "Black&white";}
    }
    public boolean getIsColor(){
        return isColor;
    }
    public String toString(){
        return ("Company :"+Company+" Color Type: "+Color+"  Printer Type :"+Type);
    }
}
