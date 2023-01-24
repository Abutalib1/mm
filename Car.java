package f4_2237234_p1;
// Mohamad Abutalib F4 2237234
public class Car { 
    private String brand;
    private String CarType;
    private int YearOfConstruction;
    private double CarRate;
    private boolean Transmisson;
    private boolean Convertible;
    public Car (){}
    public Car (String brand,int YearOfConstruction,double CarRate,boolean Transmisson,String CarType,boolean Convertible){
        this.brand = brand;
        this.YearOfConstruction = YearOfConstruction;
        this.CarRate = CarRate;
        this.Transmisson = Transmisson;
        this.CarType = CarType;
        this.Convertible = Convertible;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getBrand(){
        return brand;
    }
    public void setCarType(String CarType){
        this.CarType = CarType;
    }
    public String getCarType (){
        return CarType;
    }
    public void setYearOfConstruction(int YearOfConstruction){
        this.YearOfConstruction = YearOfConstruction;
    }
    public int getYearOfConstruction(){
        return YearOfConstruction;
    }
    public void setCarRate(double CarRate){
        this.CarRate = CarRate;
    }
    public double getCarRate (){
        return CarRate;
    }
    public void setTransmission(boolean Transmisson){
        this.Transmisson = Transmisson;
    }
    public boolean Transmission(){
        return Transmisson;
    }
    public void setConvertible(boolean Convertible){
        this.Convertible = Convertible;
    }
    public boolean IsConvertible(){
        return Convertible;
    }
}
