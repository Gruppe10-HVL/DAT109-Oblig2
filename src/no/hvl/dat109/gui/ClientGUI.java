package no.hvl.dat109.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import no.hvl.dat109.controllers.RentalControllerImpl;
import no.hvl.dat109.models.Company;

public class ClientGUI extends JFrame implements ActionListener, WindowListener {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private RentalControllerImpl controller;
    CardLayout layout;
    JPanel clientPanel;
    JPanel searchPanel;
    JPanel reservationPanel;

    /**
     * 
     */
    public ClientGUI() {
        this.controller = new RentalControllerImpl();
        
        initComponents();

        generateFrame();
        
        generateButtons();
    }

    private void initComponents() {
        layout = new CardLayout();

        clientPanel = new JPanel(layout);
        searchPanel = new JPanel();
        reservationPanel = new JPanel();
    }

    private void generateFrame() {
        this.setTitle("Rental");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);

        this.addWindowListener(this);

        setDefaultLookAndFeelDecorated(true);
    }

    private void generateButtons() {

        //JButton generateOfficeButton = new JButton("Generate new office");
        //JButton createNewVehicleButton = new JButton("Create a new vehicle");
        JButton searchButton = new JButton("Search vehicles");
        JButton bookButton = new JButton("Book");

        JButton searchAndBookButton = new JButton("Search and book");

        JButton pickUpVehicleButton = new JButton("Pick up a vehicle");
        JButton returnVehicleButton = new JButton("Return a vehicle");

        //generateOfficeButton.setBounds(0, 0, 200, 40);
        //createNewVehicleButton.setBounds(0, 50, 200, 40);
        searchButton.setBounds(0, 100, 200, 40);
        bookButton.setBounds(0, 150, 200, 40);
        searchAndBookButton.setBounds(0, 200, 200, 40);
        pickUpVehicleButton.setBounds(0, 250, 200, 40);
        returnVehicleButton.setBounds(0, 300, 200, 40);

        //generateOfficeButton.setActionCommand("generateOffice");
        //generateOfficeButton.addActionListener(this);

        //createNewVehicleButton.setActionCommand("createNewVehicle");
        //createNewVehicleButton.addActionListener(this);
    
        searchButton.setActionCommand("search");
        searchButton.addActionListener(this);

        bookButton.setActionCommand("book");
        bookButton.addActionListener(this);

        searchAndBookButton.setActionCommand("searchAndBook");
        searchAndBookButton.addActionListener(this);

        pickUpVehicleButton.setActionCommand("pickUpVehicle");
        pickUpVehicleButton.addActionListener(this);
    
        returnVehicleButton.setActionCommand("returnVehicle");
        returnVehicleButton.addActionListener(this);

        //add(generateOfficeButton);
        //add(createNewVehicleButton);
        add(searchButton);
        add(bookButton);
        add(searchAndBookButton);
        add(pickUpVehicleButton);
        add(returnVehicleButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("createNewVehicle".equals(e.getActionCommand())) {

        }
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Exiting system.");
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}


        
}
