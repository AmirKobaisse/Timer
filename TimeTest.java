import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * TimerApp is a simple Swing application that measures elapsed time
 * between the "Start" and "Stop" button presses.
 */
public class TimeTest extends JFrame {
    private JLabel timeLabel;
    private JButton startButton, stopButton;
    private long startTime;
    private long elapsedTime;
    private boolean running = true;

    /**
     * Constructor to set up the GUI components and layout.
     */
    public TimeTest() {
        // Set up the frame
        setTitle("Elapsed Time Timer");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        // Create and set up components
        timeLabel = new JLabel("Elapsed Time: 0 seconds");
        timeLabel.setBounds(50, 20, 200, 30);
        add(timeLabel);
        
        startButton = new JButton("Start");
        startButton.setBounds(50, 60, 80, 30);
        add(startButton);
        
        stopButton = new JButton("Stop");
        stopButton.setBounds(150, 60, 80, 30);
        add(stopButton);

        // Button actions
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                if (!running) {
                    startTime = System.currentTimeMillis(); // Record start time
                    running = true;
                    timeLabel.setText("Timer started");
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (running) {
                    elapsedTime = System.currentTimeMillis() - startTime; // Calculate elapsed time
                    // Show elapsed time in a pop-up window
                    JOptionPane.showMessageDialog(null, 
                        "Elapsed Time: " + elapsedTime + " milliseconds", 
                        "Time Report", 
                        JOptionPane.INFORMATION_MESSAGE);
                    timeLabel.setText("Elapsed Time: " + (elapsedTime / 1000) + " seconds");
                    running = false;
                }
            }
        });
    }

    /**
     * @author: Amir Kobaisse
     * Course: CST8284
     * Term: Spring2024
     * Assignment: Assignment 1
     * Date: Date of the final version of this source code
     * Purpose: Represents a location identified by its postal code prefix and includes a method to calculate distance between 2 locations.
     */
    public static void main(String[] args) {
        TimeTest app = new TimeTest();
        app.setVisible(true);
    }
}
