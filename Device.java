package Mohamad2237234F4;
public class Device { 
    protected String Company;
    protected String DeviceCode;
    public Device(){};
    public Device(String DeviceCode){
        this.DeviceCode = DeviceCode;
    }
    public Device(String Company,String DeviceCode){
        this.Company = Company;
        this.DeviceCode = DeviceCode;
    }
    public void setCompany (String Company){
        this.Company = Company;
    }
    public String getCompany(){
        return Company;
    }
    public void setCode(String DeviceCode){
        this.DeviceCode = DeviceCode;
    }
    public String getCode(){
        return DeviceCode;
    }
}
