package conversion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI extends JFrame {
    private JTextField celsiusTextField;
    private JLabel fahrenheitLabel;

    public TemperatureConverterGUI() {
        createUI();
    }

    private void createUI() {
        // Setting up the JFrame
        setTitle("Celsius to Fahrenheit Converter");
        setSize(400, 100); // Window size
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating components
        celsiusTextField = new JTextField(10);
        JButton convertButton = new JButton("Convert");
        fahrenheitLabel = new JLabel("Fahrenheit: ");

        // Layout
        setLayout(new FlowLayout());
        add(new JLabel("Celsius: "));
        add(celsiusTextField);
        add(convertButton);
        add(fahrenheitLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        // Get the Celsius temperature from the text field
        String celsiusText = celsiusTextField.getText();
        try {
            double celsius = Double.parseDouble(celsiusText);
            double fahrenheit = (celsius * 9 / 5) + 32;
            fahrenheitLabel.setText(String.format("Fahrenheit: %.2f", fahrenheit));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TemperatureConverterGUI().setVisible(true);
            }
        });
    }
}
