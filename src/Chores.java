// Name: Rohan Patel
//Partner: Pujan Pathak



import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

class ChoreBookRunner extends JFrame implements ActionListener
{
    private Container window;
    private JLabel title;
    private JButton deletePage;
    private JButton addPage;
    private JTextField theTask;
    private JComboBox<String> monthDropdown;
    private JComboBox<Integer> dayDropdown;
    private JComboBox<Integer> yearDropdown;
    private JComboBox<String> importanceDropDown;
    private JComboBox<String> categoryDropDown;
    private JTextArea extraInfo;
    private JButton saveButton;
    private JButton editButton;
    private JButton previousPage;
    private JButton nextPage;


    public ChoreBookRunner()  //constructor
    {
        setupWindow();
        setupWindow();
        addThingsToWindow();
    }

    /**
     * setting up the window
     */
    public void setupWindow()
    {
        window = getContentPane();
        window.setLayout(null);
        window.setBackground(Color.darkGray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(740, 740);
        setTitle("Chores Task Book");
        setResizable(false);
    }

    /***
     * Adding things to the video
     * Tic-Tac-Toe Gui
     */
    public void addThingsToWindow()
    {
        title = new JLabel();
        title.setBounds(160,0,400,80);
        title.setText("Chore Book");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 60));
        window.add(title);


        deletePage = new JButton();
        deletePage.setBounds(0, 0, 80  , 80);
        window.add(deletePage);
        deletePage.setText("-");
        deletePage.setFont(new Font("Arial", Font.BOLD,70));
        deletePage.setBackground(Color.WHITE);
        deletePage.addActionListener(this);

        addPage = new JButton();
        addPage.setBounds(640, 0, 80, 80);
        addPage.setFont(new Font("Arial", Font.BOLD,50));
        addPage.setText("+");
        addPage.setBackground(Color.white);
        addPage.addActionListener(this);
        window.add(addPage);


        theTask = new JTextField();
        theTask.setBounds(40,120,640,80);
        window.add(theTask);
        theTask.setFont(new Font("Arial", Font.BOLD,40));
        theTask.setBackground(Color.white);
        theTask.addActionListener(this);

        // enter in all the drop down menus
        String[] monthArray = {"January", "February", "March","April", "May", "June", "July", "August", "September", "October", "November", "December"};
        monthDropdown = new JComboBox(monthArray);
        monthDropdown.addActionListener(this);
        window.add(monthDropdown);
        monthDropdown.setBounds(40,240,80,40);

        Integer[] dayArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 ,21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        dayDropdown = new JComboBox(dayArray);
        dayDropdown.addActionListener(this);
        window.add(dayDropdown);
        dayDropdown.setBounds(160,240,80,40);

        Integer[] yearArray = {2020, 2021, 2022, 2023, 2024, 2025};
        yearDropdown = new JComboBox(dayArray);
        yearDropdown.addActionListener(this);
        window.add(yearDropdown);
        yearDropdown.setBounds(280,240,80,40);

        String[] importance = {"Urgent and Important", "Urgent and Not Important", "Not Urgent and Important", "Not Urgent and Not Important"};
        importanceDropDown = new JComboBox(dayArray);
        importanceDropDown.addActionListener(this);
        window.add(importanceDropDown);
        importanceDropDown.setBounds(40,320,640,40);

        String[] category = {"Work", "School", "Personal"};
        categoryDropDown = new JComboBox(dayArray);
        categoryDropDown.addActionListener(this);
        window.add(categoryDropDown);
        categoryDropDown.setBounds(40,400,280,80);

        extraInfo = new JTextArea();
        extraInfo.setBounds(400,400,280,280);
        extraInfo.setFont(new Font("Arial", Font.BOLD,30));
        extraInfo.setBackground(Color.white);
        window.add(extraInfo);

        saveButton = new JButton();
        saveButton.setBounds(40,560,120,40);
        saveButton.setText("Save");
        saveButton.setFont(new Font("Arial", Font.BOLD,20));
        saveButton.setBackground(Color.white);
        saveButton.addActionListener(this);
        window.add(saveButton);


        editButton = new JButton();
        editButton.setBounds(200,560,120,40);
        editButton.setFont(new Font("Arial", Font.BOLD,20));
        editButton.setText("Edit");
        editButton.setBackground(Color.white);
        editButton.addActionListener(this);
        window.add(editButton);


        previousPage = new JButton();
        previousPage.setBounds(40,640,120,40);
        previousPage.setFont(new Font("Arial", Font.BOLD,30));
        previousPage.setText("<--");
        previousPage.setBackground(Color.white);
        previousPage.addActionListener(this);
        window.add(previousPage);

        nextPage = new JButton();
        nextPage.setBounds(200,640,120,40);
        nextPage.setFont(new Font("Arial", Font.BOLD,30));
        nextPage.setText("-->");
        nextPage.setBackground(Color.white);
        nextPage.addActionListener(this);
        window.add(nextPage);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args)
    {
        ChoreBookRunner program = new ChoreBookRunner();
        program.setVisible(true);
    }
}