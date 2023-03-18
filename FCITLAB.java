package Mohamad2237234F4;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class FCITLAB {
    // *** YOU CAN FIND ALL THE WRITING METHODS AFTER THE MAIN METHOD
    public static ArrayList<Device> All_Devices = new ArrayList<Device>(); // An array for All Devices
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Computer> Computers = new ArrayList<Computer>(); // An array for Computers only
        ArrayList<Printer> Printers = new ArrayList<Printer>(); // An array for Printers only
        ArrayList<Mouse> Mouses = new ArrayList<Mouse>(); // An array for Mouses only
        ArrayList<Software> Softwares = new ArrayList<Software>(); // An array for Softwares only
        File FcitInput = new File ("fcitInput.txt");
        // Cheaking if the file exsist
        if (FcitInput.exists() == false){
            System.out.println("File Do not exsist");
            System.exit(0);
        }
        Scanner FcitSc = new Scanner(FcitInput); // getting information and commands from fcitInput.txt
        File FcitOutput = new File ("fcitOutPutLab.txt");
        PrintWriter FcitPen = new PrintWriter(FcitOutput); // writing information and commands on fcitOutPutLab.txt
        File FcitReport = new File ("fcitReportLab.txt");
        PrintWriter ReportPen = new PrintWriter(FcitReport); // writing information and commands on fcitReportLab.txt
        FcitPen.println("Welcome to the FCIT Lab  System."); 
        SimpleDateFormat Date = new SimpleDateFormat("E MMM dd HH:ss z YYYY");
        Date.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        FcitPen.println("Today Date is "+Date.format(new Date()));
        int countAll = 0,countComputer = 0,countPrinter = 0,countMouse = 0,countSoftware = 0; // Counters for the arrays
        //
        // Start Implmenting Comamnds from fcitInput.txt on fcitOutPutLab.txt and fcitReportLab.txt
        while (true){
           String Comand = FcitSc.next(); // geting The Command needed
           //
           // for The Add_Computer Command
           if (Comand.equalsIgnoreCase("Add_Computer")){
               All_Devices.add(new Computer(FcitSc.next(),FcitSc.nextDouble(),FcitSc.next(),FcitSc.next()));
               Computers.add((Computer) All_Devices.get(countAll) );
               // Using The Writing Method to write on fcitOutPutLab.txt
               WriteComputer(All_Devices,Computers,FcitInput,FcitSc,FcitOutput,FcitPen,Comand,countComputer);
               //
               countComputer++;
           }
           //
           // for The Add_Printer Command
           if (Comand.equalsIgnoreCase("Add_Printer")){
               All_Devices.add(new Printer(FcitSc.next(),FcitSc.next(),FcitSc.nextBoolean(),FcitSc.next()));
               Printers.add((Printer) All_Devices.get(countAll));
               // Using The Writing Method to write on fcitOutPutLab.txt
               WritePrinter(All_Devices,Printers,FcitInput,FcitSc,FcitOutput,FcitPen,Comand,countPrinter);
               //
               countPrinter++;
           }
           //
           // for The Add_Mouse Command
           if (Comand.equalsIgnoreCase("Add_Mouse")){
               All_Devices.add(new Mouse(FcitSc.next(),FcitSc.next(),FcitSc.next()));
               Mouses.add((Mouse) All_Devices.get(countAll));
               // Using The Writing Method to write on fcitOutPutLab.txt
               WriteMouse(All_Devices,Mouses,FcitInput,FcitSc,FcitOutput,FcitPen,Comand,countMouse);
               //
               countMouse++;
           }
           //
           // for the Add_Software Command
           if (Comand.equalsIgnoreCase("Add_Software")){
               All_Devices.add(new Software(FcitSc.next(),FcitSc.nextDouble(),FcitSc.next()));
               Softwares.add((Software) All_Devices.get(countAll));
               // Using The Writing Method to write on fcitOutPutLab.txt
               WriteSoftware(All_Devices,Softwares,FcitInput,FcitSc,FcitOutput,FcitPen,Comand,countSoftware);
               //
               countSoftware++;
           }
           // for the Install_SW Command
           if (Comand.equalsIgnoreCase("Install_SW")){
               FcitPen.println("**************************************************************************************************************");
               FcitPen.println("Command: "+Comand+"\n");
               String ComputerCodeTemp = FcitSc.next(); // saving The Computer code
               String SoftwareCodeTemp = FcitSc.next(); // saving The Software code
               Computer ComputerTemp = new Computer(); // an object that will change to the needed computer everytime
               Software SoftwareTemp = new Software(); // an object that will change to the needed software everytime
               // Searching for the needed Computer in All_Devices ArrayList
               for (int i=0;i<All_Devices.size();i++){
                   if (All_Devices.get(i).getCode().equalsIgnoreCase(ComputerCodeTemp)){
                       ComputerTemp = (Computer) All_Devices.get(i);
                   }}
               //
               // Searching for the needed Software in All_Devices ArrayList
               for (int i=0;i<All_Devices.size();i++){
                   if (All_Devices.get(i).getCode().equalsIgnoreCase(SoftwareCodeTemp)){
                       SoftwareTemp = (Software) All_Devices.get(i);
                   }}
               //
               // Cheaking if the The Sofware is Installed before or not 
               boolean AlraedyInstalled = false;
               for (int i=0;i<ComputerTemp.Softwares.size();i++){
                   if (ComputerTemp.Softwares.get(i).equals(SoftwareTemp))
                       AlraedyInstalled = true;
               }
               //
               // Making sure that a computer does not have more the 5 softwares
               if (ComputerTemp.Softwares.size() >= 5 ){
                   FcitPen.println("Sorry, You cannot install more than 5 Sofwares");
               }
               //
               // Adding The Sofware if it's not already installed and The computers does not have more than 5 softwares
               else if (AlraedyInstalled == false) {
                   ComputerTemp.setSoftware(SoftwareTemp);
                   FcitPen.println("The S/W "+SoftwareTemp.getName()+"  has been installed in the The computer  Company : "+ComputerTemp.getCompany()+"  Model: "+ComputerTemp.getModelName());
               }
               //
               // if The Sofware is Already Installed
               else {
                   FcitPen.println("The computer  Company : "+ComputerTemp.getCompany()+"  Model: "+ComputerTemp.getModelName());
                   FcitPen.println("has already S/W "+SoftwareTemp.getName()+"  installed..");
               }
               //
           }
           // 
           // for The Install_printer Command
           if (Comand.equalsIgnoreCase("Install_printer")){
               FcitPen.println("**************************************************************************************************************");
               FcitPen.println("Command: "+Comand+"\n");
               String ComputerCodeTemp = FcitSc.next(); // saving the computer code 
               String PrinterCodeTemp = FcitSc.next(); // saving the printer code
               Computer ComputerTemp = new Computer(); // an object that will change to the needed computer everytime
               Printer PrinterTemp = new Printer(); // an object that will change to the needed printer everytime
               // Searching for the needed Computer in All_Devices ArrayList
               for (int i=0;i<All_Devices.size();i++){
                   if (All_Devices.get(i).getCode().equalsIgnoreCase(ComputerCodeTemp)){
                       ComputerTemp = (Computer) All_Devices.get(i);
                   }}
               //
               // Searching for the needed Printer in All_Devices ArrayList
               for (int i=0;i<All_Devices.size();i++){
                   if (All_Devices.get(i).getCode().equalsIgnoreCase(PrinterCodeTemp)){
                       PrinterTemp = (Printer) All_Devices.get(i);
                   }}
               //
               // Creating an object to avoid null erros
               if (ComputerTemp.havePrinter() == false){
                   ComputerTemp.setPrinter(new Printer());
               }
               // 
               // if The Printer Already Added To the Computer
               if (ComputerTemp.getPrinter().equals(PrinterTemp)){
                   FcitPen.println("The computer  Company : "+ComputerTemp.getCompany()+"  Model: "+ComputerTemp.getModelName());
                   FcitPen.println("has already attached to Printer "+ComputerTemp.getPrinter().getCompany()+"  Printer Type :"+ComputerTemp.getPrinter().getType());
               }
               //
               // Adding The printer if it's not already added
               else {
                   ComputerTemp.setPrinter(PrinterTemp);
                   FcitPen.println("The Printer "+PrinterTemp.getCompany()+"  Printer Type :"+PrinterTemp.getType()+"  has been attached to the The computer  Company : "+ComputerTemp.getCompany()+"  Model: "+ComputerTemp.getModelName());
               }
           } 
           // 
           // for The Add_Mouse Command
           if (Comand.equalsIgnoreCase("Install_mouse")){
               FcitPen.println("**************************************************************************************************************");
               FcitPen.println("Command: "+Comand+"\n");
               String ComputerCodeTemp = FcitSc.next(); // saving the computer code
               String MouseCodeTemp = FcitSc.next(); // saving the mouse code
               Computer ComputerTemp = new Computer(); // an object that will change to the needed computer everytime
               Mouse MouseTemp = new Mouse(); // an object that will change to the needed Mouse everytime
               // Searching for the needed Computer in All_Devices ArrayList
               for (int i=0;i<All_Devices.size();i++){
                   if (All_Devices.get(i).getCode().equalsIgnoreCase(ComputerCodeTemp)){
                       ComputerTemp = (Computer) All_Devices.get(i); // Casting to get The computer Methods
                   }}
               //
               // Searching for the needed Mouse in All_Devices ArrayList
               for (int i=0;i<All_Devices.size();i++){
                   if (All_Devices.get(i).getCode().equalsIgnoreCase(MouseCodeTemp)){
                       MouseTemp = (Mouse) All_Devices.get(i); // Casting to get The Mouse Methods
                   }
               }
               //
               // Creating an object to avoid null erros
               if (ComputerTemp.haveMouse() == false){
                    ComputerTemp.setMouse(new Mouse());
               }
               //
               // if The mouse is Already Added To the Computer
               if (ComputerTemp.getMouse().equals(MouseTemp)){
                   FcitPen.println("The computer  Company : "+ComputerTemp.getCompany()+"  Model: "+ComputerTemp.getModelName());
                   FcitPen.println("has already attached to Mouse "+ComputerTemp.getMouse().getCompany()+"  "+ComputerTemp.getMouse().getType());
               }
               //
               // Adding The mouse if it's not already added
               else {
                   ComputerTemp.setMouse(MouseTemp);
                   FcitPen.println("The Mouse "+MouseTemp.getCompany()+"  "+MouseTemp.getType()+"  has been attached to the The computer  Company : "+ComputerTemp.getCompany()+"  Model: "+ComputerTemp.getModelName());
               }
               //
           }
           //
           // for The UnInstall_SW Command
           if (Comand.equalsIgnoreCase("UnInstall_SW")){
               FcitPen.println("**************************************************************************************************************");
               FcitPen.println("Command: "+Comand+"\n");
               String ComputerCodeTemp = FcitSc.next(); // saving the computer code
               String SoftwareCodeTemp = FcitSc.next(); // saving the software code
               Computer ComputerTemp = new Computer(); // an object that will change to the needed computer everytime
               Software SoftwareTemp = new Software(); // an object that will change to the needed software everytime
               // Searching for the needed Computer in All_Devices ArrayList
               for (int i=0;i<All_Devices.size();i++){
                   if (All_Devices.get(i).getCode().equalsIgnoreCase(ComputerCodeTemp)){
                       ComputerTemp = (Computer) All_Devices.get(i);
                   }}
               //
               // Searching for the needed Software in All_Devices ArrayList
               for (int i=0;i<All_Devices.size();i++){
                   if (All_Devices.get(i).getCode().equalsIgnoreCase(SoftwareCodeTemp)){
                       SoftwareTemp = (Software) All_Devices.get(i);
                   }}
               //
               // Searching for The Software in The Computer Software ArrayList
               boolean isInstalled = false;
               int SoftwareIndex = 0; // To set the Software that will be removed
               for (int i=0;i<ComputerTemp.Softwares.size();i++){
                   if (ComputerTemp.Softwares.get(i).equals(SoftwareTemp)){
                       isInstalled = true;
                       SoftwareIndex = i;
                   }}
               // 
               // Reamoving the Software if it's Installed
               if (isInstalled){
                   ComputerTemp.Softwares.remove(SoftwareIndex);
                   FcitPen.println("The S/W "+SoftwareTemp.getName()+"  has been uninstalled from the The computer  Company : "+ComputerTemp.getCompany()+"  Model: "+ComputerTemp.getModelName());
               }
               // Printing the massage no not installed if it's not installed
               else {
                   FcitPen.println("The Software : "+SoftwareTemp.getName()+"  is not installed ");
                   FcitPen.println("in The computer  Company : "+ComputerTemp.getCompany()+"  Model: "+ComputerTemp.getModelName());
               }
           }
           // 
           // for The List_All_Computer_Configuration
           if (Comand.equalsIgnoreCase("List_All_Computer_Configuration")){
               // Using The Method WriteAllComputers To Print On fcitReportLab.txt
               WriteAllComputers (Computers,Softwares,ReportPen,Comand);
               // 
           }
           if (Comand.equalsIgnoreCase("List_Computer_With_SW")){
               String SoftwareName = FcitSc.next(); // Saving The Software Name
               Software SoftwareTemp = new Software(); // an object that will change to the needed software everytime
               ReportPen.println("**************************************************************************************************************");
               ReportPen.println("Command: List_Computer_With_"+SoftwareName+"\n");
               // Searching For the Sofware
               for (int i=0;i<Softwares.size();i++){
                   if (Softwares.get(i).getName().equalsIgnoreCase(SoftwareName)){
                       SoftwareTemp = Softwares.get(i);
                   }
               }
               //
               // Printing all The Computers That have The Software
               for (int i=0;i<Computers.size();i++){
                   if (Computers.get(i).haveSoftware()){
                       for (int j=0;j<Computers.get(i).Softwares.size();j++){
                           if (Computers.get(i).Softwares.get(j).equals(SoftwareTemp)){
                               ReportPen.println("");
                               ReportPen.println("---------Computer No "+(i+1)+" ---------\n");
                               ReportPen.println(Computers.get(i).toString());    
                           }
                       }
                   }
               }
           }
           // 
           // For The List_Computer_Speed_> Command
           if (Comand.equalsIgnoreCase("List_Computer_Speed_>")){
               double speed = FcitSc.nextDouble(); // saving the Speed
               ReportPen.println("**************************************************************************************************************");
               ReportPen.println("Command: List_Computer_With_Speed_above_"+speed+"\n");
               // Printing All the computers that are greater than the speed given
               for (int i=0;i<Computers.size();i++){
                   if (Computers.get(i).getSpeed() > speed){
                       ReportPen.println("");
                       ReportPen.println("---------Computer No "+(i+1)+" ---------\n");
                       ReportPen.println(Computers.get(i).toString());
                   }
               }
               
           }
           //
           // for the Compare_Computer_Speed Command
           if (Comand.equalsIgnoreCase("Compare_Computer_Speed")){
               ReportPen.println("**************************************************************************************************************");
               ReportPen.println("Command: "+Comand+"\n");
               String ComputerNo1Code = FcitSc.next(); // Saving the first Computer code 
               String ComputerNo2Code = FcitSc.next(); // Saving the second Computer code
               Computer ComputerNo1 = new Computer(); // an object that will change to the needed computer everytime
               Computer ComputerNo2 = new Computer(); // an object that will change to the needed computer everytime
               // Searcing for both Computers
               for (int i=0;i<Computers.size();i++){
                   if (Computers.get(i).getCode().equalsIgnoreCase(ComputerNo1Code))
                       ComputerNo1 = Computers.get(i);
                   if (Computers.get(i).getCode().equalsIgnoreCase(ComputerNo2Code))
                       ComputerNo2 = Computers.get(i);
               }
               //
               // Using the Interface Compareble Method Called comperTo
               int Compare = ComputerNo1.compareTo(ComputerNo2); 
               if (Compare == 1){
                    ReportPen.print("( "+ComputerNo1.getCompany()+" , "+ComputerNo1.getModelName()+","+ComputerNo1.getSpeed()+" )");
                    ReportPen.print(" ****** Faster**** than ");
                    ReportPen.print("( "+ComputerNo2.getCompany()+" , "+ComputerNo2.getModelName()+","+ComputerNo2.getSpeed()+" )\n\n");
               }
               else if (Compare == 0){
                   ReportPen.print("( "+ComputerNo1.getCompany()+" , "+ComputerNo1.getModelName()+","+ComputerNo1.getSpeed()+" )");
                   ReportPen.print(" ****** Equal****  ");
                   ReportPen.print("( "+ComputerNo2.getCompany()+" , "+ComputerNo2.getModelName()+","+ComputerNo2.getSpeed()+" )\n\n");
               }
               else {
                   ReportPen.print("( "+ComputerNo2.getCompany()+" , "+ComputerNo2.getModelName()+","+ComputerNo2.getSpeed()+" )");
                   ReportPen.print(" ****** Faster**** than ");
                   ReportPen.print("( "+ComputerNo1.getCompany()+" , "+ComputerNo1.getModelName()+","+ComputerNo1.getSpeed()+" )\n\n");
               }
           }
           if (Comand.equalsIgnoreCase("Quit")){
               FcitSc.close();
               break;
           }
           countAll++;
        }
        FcitPen.close();
        ReportPen.close();
        
    }
    
    ///////////////////////////////////////////////////////////////
    // All The Writing Methods Are Here
    public static void WriteComputer(ArrayList<Device> All_Devices,ArrayList<Computer> Computers,File FcitInput,Scanner FcitSc,File FcitOutput,PrintWriter FcitPen,String Comand,int countComputer){
        FcitPen.println("**************************************************************************************************************");
        FcitPen.println("Command: "+Comand+"\n\n");
        FcitPen.println("Computer Details\n");
        FcitPen.println(Computers.get(countComputer));
        FcitPen.println("-- Following Softwares are Installed in the Machine ---");
        FcitPen.println(" No Software has been installed");
        FcitPen.println("--- Following  Peripheral are  attached in the Machine ---");
        FcitPen.println(" No Pripheral has been attached\n");
        FcitPen.println(" has been added to the FCIT Lab. Database.");
    }
    public static void WritePrinter(ArrayList<Device> All_Devices,ArrayList<Printer> Printers,File FcitInput,Scanner FcitSc,File FcitOutput,PrintWriter FcitPen,String Comand,int countPrinter){
        FcitPen.println("**************************************************************************************************************");
        FcitPen.println("Command: "+Comand+"\n\n");
        FcitPen.println("Printer Details \n");
        FcitPen.println(Printers.get(countPrinter).toString()+"\n");
        FcitPen.println(" has been added to the FCIT Lab. Database.");
    }
    public static void WriteMouse(ArrayList<Device> All_Devices,ArrayList<Mouse> Mouses,File FcitInput,Scanner FcitSc,File FcitOutput,PrintWriter FcitPen,String Comand,int countMouse){
        FcitPen.println("**************************************************************************************************************");
        FcitPen.println("Command: "+Comand+"\n\n");
        FcitPen.println("Mouse Details\n");
        FcitPen.println(Mouses.get(countMouse).toString()+"\n");
        FcitPen.println(" has been added to the FCIT Lab. Database.");
    }
    public static void WriteSoftware(ArrayList<Device> All_Devices,ArrayList<Software> Softwares,File FcitInput,Scanner FcitSc,File FcitOutput,PrintWriter FcitPen,String Comand,int countSoftware){
        FcitPen.println("**************************************************************************************************************");
        FcitPen.println("Command: "+Comand+"\n\n");
        FcitPen.println("Software Details \n");
        FcitPen.println(Softwares.get(countSoftware).toString()+"\n");
        FcitPen.println(" has been added to the FCIT Lab. Database.");
    }
    public static void WriteAllComputers (ArrayList<Computer> Computers,ArrayList<Software> Softwares,PrintWriter ReportPen,String Comand){
               ReportPen.println("**************************************************************************************************************");    
               ReportPen.println("Command: "+Comand+"\n");
               // Printing All The Computers
               for (int i=0;i<Computers.size();i++){
                   ReportPen.println("---------Computer No "+(i+1)+" ---------\n\n");
                   ReportPen.println("Computer Details ");
                   ReportPen.println(Computers.get(i).toString());
                   ReportPen.println("-- Following Softwares are Installed in the Machine ---");
                   // Checking if Computer have Sofwares And printing Them
                   if (Computers.get(i).haveSoftware()){
                       for (int j=0;j<Computers.get(i).Softwares.size();j++){
                           ReportPen.println("");
                           ReportPen.println("Software Details \n");
                           ReportPen.println(Softwares.get(j).toString());
                       }
                       ReportPen.println("");
                   }
                   else {
                       ReportPen.println(" No Software has been installed\n");
                   }
                   //
                   ReportPen.println("--- Following  Peripheral are  attached in the Machine ---");
                   // Cheaking if There is any Devices Added to The Computer and Adding Them
                   if (Computers.get(i).haveMouse() == false && Computers.get(i).havePrinter() == false){
                       ReportPen.println(" No Pripheral has been attached\n\n");
                   }
                   if (Computers.get(i).haveMouse() || Computers.get(i).havePrinter()){
                       if (Computers.get(i).haveMouse()){
                           ReportPen.println("");
                           ReportPen.println("Mouse Details \n");
                           ReportPen.println(Computers.get(i).getMouse().toString());
                       }
                       ReportPen.println("");
                       if (Computers.get(i).havePrinter()){
                           ReportPen.println("");
                           ReportPen.println("Printer Details \n");
                           ReportPen.print(Computers.get(i).getPrinter().toString()+"\n\n");   
                       }
                       
                   }
                   
               }
    }
}
