import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

/**
 * Created by alex on 11/02/2017.
 */
public class GUI {
    private JLabel lblSpeed, lblRoadType, lblDriversFirstName,lblDriversLastName, lblPicture;
    private JTextField txtSpeed, txtDriversFirstName;
    private JButton btnResidentialRoad, btnMainRoad, btnSchoolZone, btnSingleCarriageway, btnDualCarriageway, btnSubmit, btnExit;
    private JPanel panel;
    private JFrame frame;
    private int roadSpeed;
    private String driverName;
    private String driversSpeed;
    private String roadType;

    IssueTicket CheckingSpeed = new  IssueTicket();
    TicketDataBase writingToFile = new  TicketDataBase();

    public GUI(){
        createForm();
        addFields();
        addButtons();

        frame.add(panel);
        frame.setVisible(true);
    }

    public void createForm(){
        frame = new JFrame();
        frame.setTitle("DVLA Ticket Program");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
    }


    public void addFields(){
        lblDriversFirstName = new JLabel("Drivers First Name");
        lblDriversFirstName.setBounds(20, 380, 100, 20);
        panel.add(lblDriversFirstName);

        txtDriversFirstName = new JTextField(null);
        txtDriversFirstName.setBounds(120, 380, 150, 20);
        panel.add(txtDriversFirstName);

        lblDriversLastName = new JLabel("Drivers Last Name");
        lblDriversLastName.setBounds(20, 380, 100, 20);

        panel.add(lblDriversLastName);

        txtDriversFirstName = new JTextField(null);
        txtDriversFirstName.setBounds(120, 380, 150, 20);
        panel.add(txtDriversFirstName);

        lblRoadType = new JLabel("Road Type");
        lblRoadType.setBounds(20, 430, 100, 20);
        panel.add(lblRoadType);

        lblSpeed = new JLabel("Drivers Speed");
        lblSpeed.setBounds(20, 405, 100, 20);
        panel.add(lblSpeed);

        txtSpeed = new JTextField(null);
        txtSpeed.setBounds(120, 405, 150, 20);
        panel.add(txtSpeed);

        ImageIcon image = new ImageIcon("DVLA.jpg");
        lblPicture = new JLabel(image);
        lblPicture.setBounds(200, 100, 400, 200);
        panel.add(lblPicture);
        }

    public void addButtons(){
        btnSchoolZone = new JButton("SchoolZone");
        btnSchoolZone.setBounds(120, 430, 120, 20);
        btnSchoolZone.addActionListener(new SchoolZoneHandler());
        panel.add(btnSchoolZone);

        btnResidentialRoad = new JButton("Residential");
        btnResidentialRoad.setBounds(240, 430, 100, 20);
        btnResidentialRoad.addActionListener(new ResidentialRoadHandler());
        panel.add(btnResidentialRoad);

        btnMainRoad = new JButton("MainRoad");
        btnMainRoad.setBounds(340, 430, 100, 20);
        btnMainRoad.addActionListener(new MainRoadHandler());
        panel.add(btnMainRoad);

        btnSingleCarriageway = new JButton("SingleCarriageway");
        btnSingleCarriageway.setBounds(440, 430, 160, 20);
        btnSingleCarriageway.addActionListener(new SingleCarriagewayHandler());
        panel.add(btnSingleCarriageway);

        btnDualCarriageway = new JButton("DualCarriageway");
        btnDualCarriageway.setBounds(600, 430, 160, 20);
        btnDualCarriageway.addActionListener(new DualCarriagewayHandler());
        panel.add(btnDualCarriageway);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(22, 525, 100, 20);
        btnSubmit.addActionListener(new SubmitHandler());
        panel.add(btnSubmit);

        btnExit = new JButton("Exit");
        btnExit.setBounds(650, 525, 100, 20);
        btnExit.addActionListener(new ExitHandler());
        panel.add(btnExit);
    }




    class SchoolZoneHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event ) {
            roadSpeed = 20;
            roadType = "School Zone";
        }
    }

    class ResidentialRoadHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            roadSpeed = 20;
            roadType = "Residential Road";
        }
    }
    class MainRoadHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            roadSpeed = 30;
            roadType = "Main Road";
        }
    }
    class SingleCarriagewayHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            roadSpeed = 60;
            roadType = "Single Carriageway";
        }
    }
    class DualCarriagewayHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            roadSpeed = 70;
            roadType = "Dual Carriageway";

        }
    }
    class SubmitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            driverName = txtDriversFirstName.getText();
            driversSpeed = txtSpeed.getText();
            int driversSpeedInt = 0;
            if (driverName.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please Enter the Drivers Name", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else if (driversSpeed.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please Enter the Drivers Speed", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else if (roadSpeed == 0){
                JOptionPane.showMessageDialog(frame, "Please Enter select the road type", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else
                driversSpeedInt = Integer.parseInt(driversSpeed);
                CheckingSpeed.speedCheck(driversSpeedInt,roadSpeed,driverName,roadType );
            CheckingSpeed.setDriverInfo();
            JOptionPane.showMessageDialog(frame, CheckingSpeed.getDriverInfo());
            try {
                writingToFile.saveDrivers();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    class ExitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }
    public static void main(String[] args){
        new GUI();
    }
}

//http://stackoverflow.com/questions/3480102/java-jframe-setlocationrelativetonull-not-centering-the-window-on-ubuntu-10-0 - Help with setting the Container to open in the middle of the screen (1).