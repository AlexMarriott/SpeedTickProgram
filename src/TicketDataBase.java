import java.io.*;

/**
 * Created by alex on 12/02/2017.
 */
public class TicketDataBase {

    private Ticket driverWriteInfo;
    private int driverID;

    TicketDataBase()  throws IOException {
        driverWriteInfo = new Ticket();
    }

    public void saveDrivers() throws IOException
    {
        driverID = Driver.intDriverID;
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("Drivers.txt", true)));
        outfile.println("Driver ID: " + driverID + "\n"  + driverWriteInfo.getDriverInfo() + "\n[NEXT DRIVER] \n");
        outfile.flush();
        outfile.close();
    }



    /*public void readFile() throws FileNotFoundException {
        File empFile = new File("Employee.txt");
        Scanner fileScan = new Scanner(empFile);
        while (fileScan.hasNext()) {
            String readFile = fileScan.nextLine();
            System.out.println(readFile);
        }

    }
    public ArrayList setArray() throws FileNotFoundException {
        File empFile = new File("Employee.txt");
        Scanner fileScan = new Scanner(empFile);
        int i = 0;/
        while (fileScan.hasNext()) {
            empArray.add(fileScan.nextLine());
        }
        return empArray;
    }
    public ArrayList getArray() {
        return this.empArray;
    }
    public void arrayRead(){
        int i = 0;
        while(i < getArray().size()){
            System.out.println(getArray().get(i));
            i++;
        }

    }*/

}
