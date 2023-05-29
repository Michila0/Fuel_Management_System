public class Passenger {
    private String fname;
    private String lname;
    private String vehicleNo;


    private int noOfLiters;

    public Passenger(String fname, String lname, String vehicleNo,int noOfLiters) { //creating constructor for Passenger Class
        this.fname = fname;
        this.lname = lname;
        this.vehicleNo = vehicleNo;
        this.noOfLiters = noOfLiters;

    }

    public Passenger () {

    }

    //getter start
    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public int getNoOfLiters() {return noOfLiters;}

    //setter start
    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public void setNoOfLiters(int noOfLiters) {
        this.noOfLiters = noOfLiters;
    }
}
