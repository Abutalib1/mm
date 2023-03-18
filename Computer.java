package Mohamad2237234F4;
import java.util.*;
public class Computer extends Device implements Comparable<Computer> {
    private double Speed;
    private String ModelName;
    ArrayList<Software> Softwares = new ArrayList<Software>();
    private Mouse mouse;
    private Printer printer;
    private static int totalSoftware;
    private boolean haveSoftware;
    private boolean havePrinter;
    private boolean haveMouse;
    public Computer(){};
    public Computer (String Company,double Speed,String ModelName,String DeviceCode){
        super(Company,DeviceCode);
        this.ModelName = ModelName;
        this.Speed = Speed;
    }
    public void setSpeed(double Speed){
        this.Speed = Speed;
    }
    public double getSpeed(){
        return Speed;
    }
    public void setModelName(String ModelName){
        this.ModelName = ModelName;
    }
    public String getModelName(){
        return ModelName;
    }
    public void setSoftware(Software software){
        Softwares.add(software);
        this.haveSoftware = true;
        totalSoftware++;
    }
    public ArrayList getSoftware(){
        return Softwares;
    }
    public void setMouse(Mouse mouse){
        this.mouse = mouse;
        this.haveMouse = true;
    }
    public Mouse getMouse(){
        return mouse;
    }
    public void setPrinter(Printer printer){
        this.printer = printer;
        this.havePrinter = true;
    }
    public Printer getPrinter(){
        return printer;
    }
    public int getNumSoftware(){
        return totalSoftware;
    }
    public boolean haveSoftware(){
        return haveSoftware;
    }
    public boolean havePrinter(){
        return havePrinter;
    }
    public boolean haveMouse(){
        return haveMouse;
    }
    public String toString(){
        return ("Company :"+Company+"  Model: "+ModelName+"  Speed: "+Speed+" GHz");
    }
    public int compareTo(Computer o){
        int num = 0;
        if (this.getSpeed() == o.getSpeed()){
            num = 0;
        }
        else if (this.getSpeed() > o.getSpeed()){
            num = 1;
        }
        else {
            num = -1;
        }
        return num;
    }


}
