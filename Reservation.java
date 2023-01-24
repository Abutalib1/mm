package f4_2237234_p1;
// Mohamad Abutalib F4 2237234
import java.util.*;
public class Reservation {
    private String ReservationCode;
    private String PickUpLocation;
    private String DropOfLocation;
    private Date PickUp;
    private Date DropOf;
    private Date DateOfReservation;
    private Customer customer;
    private Car car;
    private Service AdditionalServ;
    public Reservation (String PickUpLocation,String DropOfLocation,Date PickUp,Date DropOf,Customer customer,Car car){
        this.PickUpLocation = PickUpLocation;
        this.DropOfLocation = DropOfLocation;
        this.PickUp = PickUp;
        this.DropOf = DropOf;
        this.customer = customer;
        this.car = car;
    }
    public void setReservationCode(String ReservationCode){
        this.ReservationCode = ReservationCode;
    }
    public String getReservationCode(){
        return ReservationCode;
    }
    public void setPickUpLocation(String PickUpLocation){
        this.PickUpLocation = PickUpLocation;
    }
    public String getPickUpLocation(){
        return PickUpLocation;
    }
    public void setDropOfLocation(String DropOfLocation){
        this.DropOfLocation = DropOfLocation;
    }
    public String getDropofLocation(){
        return DropOfLocation;
    }
    public void AddService (Service AdditionalServ){
        this.AdditionalServ = AdditionalServ;
    }
    public Service  getServices(){
        return AdditionalServ;
    }
    public void setPickUp(Date PickUp){
        this.PickUp = PickUp;
    }
    public Date getPickUp(){
        return PickUp;
    }
    public void setDropOf(Date DropOf){
        this.DropOf = DropOf;
    }
    public Date getDropOf(){
        return DropOf;
    }
    public Date getDateOfReservation(){
        return DateOfReservation;
    }
    public Customer getCustomer(){
        return customer;
    }
    public void setCar (Car car){
        this.car = car;
    }
    public Car getCar(){
        return car;
    }
}
