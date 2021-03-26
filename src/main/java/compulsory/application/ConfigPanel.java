package compulsory.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.regex.Pattern;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    int size = 0;
    int sides = 0;
    Color color;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //set layout
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
        //set border for config panel
        this.setBorder(BorderFactory.createLineBorder(Color.black));


        //create size label and input box table
        var sizeLabel = new JLabel("Size:");
        sizeLabel.setFont(new Font("Arial ", Font.PLAIN, 20));

        var sizeInputField = new JTextField("Enter size here", 10);
        sizeInputField.setBorder(BorderFactory.createLineBorder(Color.black));


        //create the label and the spinner
        var sidesLabel = new JLabel("Number of sides:");
        sidesLabel.setFont(new Font("Arial ", Font.PLAIN, 20));

        var sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 10, 1));
        sidesField.setValue(3); //default number of sides
        sidesField.setFont(new Font("Arial", Font.PLAIN, 15));


        //create colors label and combo box containing the values: Random and Black
        var colorLabel = new JLabel("Color of the shape:");
        colorLabel.setFont(new Font("Arial ", Font.PLAIN, 20));

        String[] colors = {"Random", "Black"};
        JComboBox<String> colorCombo = new JComboBox<>(colors);
        colorCombo.setSelectedIndex(0);

        //add set button
        JButton saveBtn = new JButton("Start Drawing");
        saveBtn.addActionListener(e -> {
            if (Pattern.matches("[1-9][0-9]?[0-9]?", sizeInputField.getText()))
                frame.configPanel.size = Integer.parseInt(sizeInputField.getText());
            else {
                frame.configPanel.size = 0;
            }

            frame.configPanel.sides = (int) sidesField.getValue();

            var colors1 = colorCombo.getSelectedObjects();

            if (colors1[0].equals("Black")) {
                frame.configPanel.color = Color.black;
            } else {
                frame.configPanel.color = null;
            }
        });


        //add components to the config panel
        add(sizeLabel);
        add(sizeInputField);

        add(sidesLabel);
        add(sidesField);

        add(colorLabel);
        add(colorCombo);

        add(saveBtn);
    }

}
