import java.util.Scanner;

/**
 * Created by Alex on 08/02/2017.
 */
public class IssueTicket {
    public IssueTicket() {
    }
    private String message;
    private String driverFileWite;
    private static String driverInfo;

    public void setDriverInfo() {
        this.driverInfo = driverFileWite;
    }
    public String getDriverInfo() {
        return IssueTicket.driverInfo ;
    }


    public void speedCheck(int driversSpeed, int roadSpeed, String driverName, String roadType, int driverID) {
        int ticketThershold = roadSpeed + (roadSpeed * 10 / 100 + 2);
        int countDateThershold = ticketThershold + (ticketThershold  *46 / 100);
        if (driversSpeed > roadSpeed && driversSpeed < ticketThershold){
            message = "DriverAndVehicle was over the speed limit but within reason, issue a warning." + driversSpeed;
            }else if(driversSpeed >= ticketThershold && driversSpeed < countDateThershold){
            message = "Issuing Ticket for the speed of:  " + driversSpeed ;
        }else if (driversSpeed >= countDateThershold ) {
            message = "DriverAndVehicle exceeded the Speed limit by: " + (driversSpeed - roadSpeed) + " \nDriverAndVehicle will be issued a ticket and count date";
        }else{
            message = "DriverAndVehicle is under the Speed limit. \nNo action will be taken";
        }
        driverFileWite = "Name: "+ driverName + "\nSpeed logged: " + driversSpeed + "\nType of Road: " + roadType + "\nAction Required: " + message;
    }
}



