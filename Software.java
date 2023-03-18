package Mohamad2237234F4;
public class Software extends Device {
    private String Name;
    private double version;
    public Software (){};
    public Software (String Name,double version,String DeviceCode){
        super (DeviceCode);
        this.Name = Name;
        this.version = version;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public String getName(){
        return Name;
    }
    public void setVersion(double version){
        this.version = version;
    }
    public double getVersion(){
        return version;
    }
    public String toString(){
        return ("S/W name: "+Name+" S/W version: "+version);
    }
}
