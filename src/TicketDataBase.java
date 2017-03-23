import java.io.*;
import java.util.Scanner;

/**
 * Created by alex on 12/02/2017.
 */
public class TicketDataBase {

    private Ticket driverWriteInfo;
    private Driver DriverInfo;
    private Scanner driverfile;
    private int intDriverID;
    private Driver driverDetails;

    TicketDataBase() throws IOException {
        driverWriteInfo = new Ticket();
    }

    public void saveDrivers() throws IOException {
        driverDetails = new Driver();
        PrintWriter driverFile = new PrintWriter(new BufferedWriter(new FileWriter("Drivers.txt", true)));
        getDriverID();
        setDriverID();
        driverWriteInfo.setDriverJudgment();
        driverFile.println("Driver ID: " + intDriverID + "\n" + driverDetails.getDriverObject().toString() + "\n" + driverWriteInfo.getDriverJudgment() + " \n");
        driverFile.flush();
        driverFile.close();
    }
    public int getDriverID() throws FileNotFoundException {
        boolean line;
        File file = new File("DriversID.txt");
        Scanner readIn = new Scanner(file);
        if (intDriverID <= 0){
            intDriverID++;
        }
            while (readIn.hasNextLine() && (line = readIn.nextLine() != null)) {
                intDriverID++;
                System.out.println(intDriverID);
            }
        return intDriverID;
    }
    public void setDriverID() throws IOException {
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("DriversID.txt", true)));
        outfile.println("ID " + intDriverID );
        outfile.flush();
        outfile.close();
    }

    }
