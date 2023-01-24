package f4_2237234_p1;
// Mohamad Abutalib F4 2237234
public class Service {
        private String ServiceType;
        private double ServicePrice;
        public Service (String ServiceType,double ServicePrice){
            this.ServiceType = ServiceType;
            this.ServicePrice = ServicePrice;
        }
        public void setType(String ServiceType){
            this.ServiceType = ServiceType;
        }
        public String getType (){
            return ServiceType;
        }
        public void setPrice(double ServicePrice){
            this.ServicePrice = ServicePrice;
        }
        public double getPrice (){
            return ServicePrice;
        }
}
