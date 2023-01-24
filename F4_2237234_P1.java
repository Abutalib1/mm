package f4_2237234_p1;
import java.util.*;
import java.io.*;
// Mohamad Abutalib F4 2237234
public class F4_2237234_P1 {
    public static void main(String[] args) throws FileNotFoundException {
        // Reading from inputCar.txt
        File in = new File ("inputCar.txt");
        if (in.exists() == false){
            System.out.println("File Does not exist");
            System.exit(0);
        }
        Scanner sc = new Scanner(in);
        int CarNumOfTypes =0;
        int NumOfAvailableCars = 0;
        int NumOfAvailableServices;
        int CarNum =0;
        int ServiceNum = 0;
        CarNumOfTypes = sc.nextInt();
        String CarTypes [] = new String[CarNumOfTypes];
        for (int i = 0; i < CarTypes.length; i++) {
            CarTypes[i] = sc.next();
        }
        NumOfAvailableCars = sc.nextInt();
        Car AvailableCars[] = new Car[NumOfAvailableCars]; // array for cars
        NumOfAvailableServices = sc.nextInt();
        Service AvailableServices[] = new Service[NumOfAvailableServices]; // array for Service
        int Analysis [][] = new int[AvailableServices.length][CarTypes.length]; // for the Final analysis
        CarNum =0;
        ServiceNum = 0;
        // Start adding the cars and services from the comand and put it in arrays of objects
        while (true){
            String comand = sc.next();
            if (comand.equals("AddCar")){
                AvailableCars [CarNum] = new Car(sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextBoolean(),sc.next(),sc.nextBoolean());
                CarNum++;
            }
            if (comand.equals("AddService")){
                AvailableServices [ServiceNum] = new Service(sc.next(),sc.nextDouble());
                ServiceNum++;
            }
            if (comand.equals("Quit")){
                sc.close();
                break;
            }}
        //Finish Reading from inputCar.txt
        //
        // Start Writing the into from inputCar.txt to CarsInfo.txt
        File CarsInfo = new File("CarsInfo.txt");
        PrintWriter pen = new PrintWriter(CarsInfo);
        pen.println("--------------- Welcome to Car Renting  Data Base ---------------");
        pen.println("");
        pen.println("");
        pen.println("");
        pen.println("");
        for (int i=0;i<AvailableCars.length;i++){
            pen.print("The car Type: "+AvailableCars[i].getBrand()+" "+AvailableCars[i].getCarType()+", Year: "+AvailableCars[i].getYearOfConstruction()+", Transmission: ");
            if (AvailableCars[i].Transmission() == true)
                pen.print("Manual");
            else 
                pen.print("Automatic");
            if (AvailableCars[i].IsConvertible() == true)
                pen.print(" and Convertible");
            pen.println("");
            pen.println("------------------------------------------------------");   
        }
        pen.close();
       //Finish writing on CarsInfo.txt
       //
       //Start geting the Reservation from Reservationinput.txt and Writing on ReservationStatus.txt
       File ResIn = new File ("Reservationinput.txt");
       Scanner ResSc = new Scanner (ResIn);
       File ResOut = new File ("ReservationStatus.txt");
       PrintWriter ResPen = new PrintWriter(ResOut);
       ResPen.println("--------------- Welcome to Car Renting  Management System ---------------");
       ResPen.println("");
       ResPen.println("");
       ResPen.println("");
       ResPen.println("");
       ResPen.println("--------------- Display All System Procedures ---------------");
       ResPen.println("");
       ResPen.println("");
       ResPen.println("");
       ResPen.println("");
       int NumOfRes = ResSc.nextInt();
       Reservation Res [] = new Reservation[NumOfRes]; // array for Reservation
       int ResNum = 0;
       // impleminting the comands
       while (true){
           String comand2 = ResSc.next();
           if (comand2.equals("Reserve")){
                  String CarTS = ResSc.next();
                  String TransS = ResSc.next();
                  String ConvertableS = ResSc.next();
                  Car ResCar = new Car();
                  boolean Trans = false;
                  boolean cheak = false;
                  boolean Convertable = false;
                  boolean IsAvilable = false;
                  if (TransS.equals("Manual"))
                      Trans = true;
                  if (ConvertableS.equals("Convertible"))
                      Convertable = true;
                  for (int i=0;i<AvailableCars.length;i++){
                      if (AvailableCars[i].getCarType().equals(CarTS) && AvailableCars[i].IsConvertible() == Convertable && AvailableCars[i].Transmission() == Trans){
                          IsAvilable = true;
                          ResCar = AvailableCars[i];
                      }
                  }
                  if (IsAvilable){
                      Res[ResNum] = new Reservation(ResSc.next(),ResSc.next(),new Date(ResSc.nextInt(),ResSc.nextInt(),ResSc.nextInt()),new Date(ResSc.nextInt(),ResSc.nextInt(),ResSc.nextInt()),new Customer (ResSc.next(),ResSc.next(),ResSc.next(),ResSc.nextLong(),ResSc.nextInt()),ResCar);
                      String AddServ = ResSc.next();
                      if (AddServ.equals("submit") == false){
                          cheak = true;
                          for (int i=0;i<AvailableServices.length;i++){
                              if (AvailableServices[i].getType().equals(AddServ)){
                                  Res[ResNum].AddService(AvailableServices[i]);
                              }
                          }
                      }
                      ResPen.println("DONE: The reservation is completed");
                      Res[ResNum].setReservationCode(Res[ResNum].getCustomer().getFirstName().charAt(0)+""+Res[ResNum].getCustomer().getLastName().charAt(0)+"_"+((int)(Math.random()*1000))+"_"+Res[ResNum].getCar().getYearOfConstruction());
                      ResPen.println("******Reservation Refrence number : "+Res[ResNum].getReservationCode());
                      ResPen.println("******Customer information : Customer Name: "+Res[ResNum].getCustomer().getFirstName()+" "+Res[ResNum].getCustomer().getLastName()+", Email: "+Res[ResNum].getCustomer().getEmail()+", Code: "+Res[ResNum].getCustomer().getDisCode());
                      ResPen.println("******Pick up location : "+Res[ResNum].getPickUpLocation()+"	******Drop of location : "+Res[ResNum].getDropofLocation());
                      ResPen.println("******Pick up date : "+Res[ResNum].getPickUp().getDate()+"-"+Res[ResNum].getPickUp().getMonth()+"-"+Res[ResNum].getPickUp().getYear()+" ******Drop of date : "+Res[ResNum].getDropOf().getDate()+"-"+Res[ResNum].getDropOf().getMonth()+"-"+Res[ResNum].getDropOf().getYear());
                      ResPen.print("******Car information : The car Type: "+Res[ResNum].getCar().getBrand()+" "+Res[ResNum].getCar().getCarType()+", Year: "+Res[ResNum].getCar().getYearOfConstruction()+", Transmission: ");
                      if (Res[ResNum].getCar().Transmission() == true){
                          ResPen.print("Manual");
                      }
                      else 
                          ResPen.print("Automatic");
                      if (Res[ResNum].getCar().IsConvertible() == true)
                          ResPen.print(" and Convertible");
                      ResPen.println("");
                      ResPen.print("******Additional services :");
                      if (cheak == true){
                          ResPen.print(" Service "+Res[ResNum].getServices().getType());
                      }
                      ResPen.println("");
                      ResPen.println("--------------- Invoice Details ---------------");
                      int NumOfResDays = (int) (Res[ResNum].getDropOf().getTime() - Res[ResNum].getPickUp().getTime()) / (1000*60*60*24);
                      double IntialTotal = Res[ResNum].getCar().getCarRate() * NumOfResDays;
                      if (Res[ResNum].getCar().getCarType().equals("Luxury")){
                          IntialTotal = ( (Res[ResNum].getCar().getCarRate()*0.10) + Res[ResNum].getCar().getCarRate()  )* NumOfResDays;
                      }
                      ResPen.println(" Number of reserved days: "+NumOfResDays);
                      ResPen.println(" Intial Total: "+IntialTotal);
                      double AfterServ = IntialTotal;
                      if (cheak == true){
                          ResPen.println("--------------- Additional Services Price ---------------");
                          AfterServ += Res[ResNum].getServices().getPrice();
                          ResPen.println("Total After additional Services  : "+AfterServ);
                      }
                      ResPen.println("--------------- Final Payment after Discount ---------------");
                      double FinalTotal = AfterServ;
                      int discount = Res[ResNum].getCustomer().getDisCode() / 100;
                      if (discount == 9 || discount == 8 || discount == 7)
                          FinalTotal -= FinalTotal*0.20;
                      if (discount == 6 || discount == 5 || discount == 4)
                          FinalTotal -= FinalTotal*0.15;
                      if (discount == 3 || discount == 2 || discount == 1 || discount == 0 )
                          FinalTotal -= FinalTotal*0.10;
                      ResPen.println(" Final Total  : "+FinalTotal);
                      ResPen.println("");
                      ResPen.println("");
                      ResPen.println("");
                      ResPen.println("");
                      // puting values for the Final Analysis
                      if (IsAvilable && cheak){
                          for (int i=0;i<Analysis.length;i++){
                          for (int j=0;j<Analysis[i].length;j++){
                              if (Res[ResNum].getCar().getCarType().equals(CarTypes[j]) && Res[ResNum].getServices().getType().equals(AvailableServices[i].getType()))
                                  Analysis [i][j]++;
                          }       
                      }
                      }
                  }
                  else {
                      ResPen.println("SORRY: The reservation is NOT completed");
                      ResPen.println("There is no available Car");
                      ResPen.println("");
                      ResPen.println("");
                      ResPen.println("");
                      ResPen.println("");
                  }
                  ResNum++;
           }
           if (comand2.equals("submit"))
               continue;
           if (comand2.equals("Quit")){
               ResSc.close();
               break;
           }
       }
       // Finish Reading and writing on Reservationinput.txt and ReservationStatus.txt
       //
       // Start Writing on AnalysisReport.txt
       ResPen.close();
       File AnalysisReport = new File("AnalysisReport.txt");
       PrintWriter APen = new PrintWriter(AnalysisReport);
       APen.println("-------------- Analysis Report ---------------");
       APen.println("");
       APen.println("");
       APen.println("");
       APen.print("             CarType     	");
       for (int i=0;i<CarTypes.length;i++){
           APen.print(CarTypes[i]+"         ");
       }
       APen.println("");
       APen.println("       Services ");
       APen.println("        -----------------------------------------------------");
       for (int i=0;i<Analysis.length;i++){
           APen.print("       "+AvailableServices[i].getType()+"     ");
           for (int j=0;j<Analysis[i].length;j++){
               APen.print("     	   "+Analysis[i][j]);
           }
           APen.println("");
       }
       APen.close();
       // Finish Writing on AnalysisReport.txt
       
    }
    
}
