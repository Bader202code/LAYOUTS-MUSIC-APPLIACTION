import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationLayouts {

    // ----Instance Variable-----
    JFrame BorderFrame;

    // -----Constructor: Initializes the frame------
    public ApplicationLayouts() {
        this.prepareBoderFrame();
    }

    // -----Method: Creates layouts-------
    public JFrame prepareBoderFrame () {

        // -------Creating the main Frame----------
        JFrame BorderFrame = new JFrame("My Music");

        // ------Displaying the frame-------------
        BorderFrame.setVisible(true);
        BorderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderFrame.setSize(600,400);



        // --------Creating North layout----------
        JLabel northLabel = new JLabel("My Music Catalogue", JLabel.CENTER);

        // --------Bold Font--------------
        northLabel.setFont(new Font("Serif",Font.BOLD,50));
        BorderFrame.add(northLabel,BorderLayout.NORTH);

        // ---------Creating South layout-------------
        JPanel southPanel = new JPanel();

        // ---------Aligning buttons horizontally--------
        southPanel.setLayout(new FlowLayout());

        // -------- Creating buttons--------------
        JButton submitButton = new JButton("Submit");
        JButton exitButton = new JButton("Exit");
        southPanel.add(submitButton);
        southPanel.add(exitButton);
        BorderFrame.add(southPanel, BorderLayout.SOUTH);

        // ---------Creating West layout-----------
        String[] categories = {"Rap", "Reggae", "Ballads"};

        // ---------Creating a list------------------
        JList<String> categoryList = new JList<>(categories);
        categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // ----------Add with scroll-------------------
        BorderFrame.add(new JScrollPane(categoryList), BorderLayout.WEST);

        // ----------Creating Center layout-------------
        JPanel centerPanel = new JPanel();

        // ----------Creating rows, columns, and gaps-----------------
        centerPanel.setLayout(new GridLayout(4,2,5,5));

        // ----------Artist Field------------------------
        centerPanel.add(new JLabel("Artist Name"));
        JTextField artistField = new JTextField();
        centerPanel.add(artistField);

        // --------------Recording Studio Field-------------------
        centerPanel.add(new JLabel("Recording Studio"));
        JTextField studioField = new JTextField();
        centerPanel.add(studioField);

        //--------------Category Field------------------------
        centerPanel.add(new JLabel("Category"));
        JComboBox<String> categoryDropdown = new JComboBox<>(categories);
        centerPanel.add(categoryDropdown);

        // ------------Available CheckBox--------------
        centerPanel.add(new JLabel("Available"));
        JCheckBox availbaleCheckBox = new JCheckBox();
        centerPanel.add(availbaleCheckBox);
        BorderFrame.add(centerPanel, BorderLayout.CENTER);


        // -----------Functionalities---------------------
        // ----------Submit button: Print details to the console-----------------
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String artist = artistField.getText();
                String studio = studioField.getText();
                String category = (String) categoryDropdown.getSelectedItem();
                boolean isAvailable = availbaleCheckBox.isSelected();

                // ------------Printing details to the console------------------
                System.out.println("Artist Name: " + artist);
                System.out.println("Recording Studio: " + studio);
                System.out.println("Category: " + category);
                System.out.println("Available: " + (isAvailable ? "yes" : "No"));

            }
        }); {
            // --------------Exit Button: Close the Application--------------
            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Exit the application
                    System.exit(0);
                }
            });

        }

        return BorderFrame;
    }

}
