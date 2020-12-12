// Name: Pujan Pathak
//Partner: Rohan Patel

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.util.Arrays;


class ChoreBookRunner extends JFrame implements ActionListener
{
    private Container window;
    private JLabel title;
    private JButton deletePage;
    private JButton addPage;
    private JTextField theTask;
    private JComboBox<String> monthDropdown;
    private JComboBox<String> dayDropdown;
    private JComboBox<String> yearDropdown;
    private JComboBox<String> importanceDropDown;
    private JComboBox<String> categoryDropDown;
    private JTextArea extraInfo;
    private JButton saveButton;
    private JButton editButton;
    private JButton previousPage;
    private JButton nextPage;
    private JLabel thePageNumber;
    /***
     * The array of the chore book always has 2 pages
     * You can't delete any pages when the array has just 2 pages remaining
     */
    private ChoreBook[] theChoresBook = new ChoreBook[2];
    private String[] monthArray;
    private String[] dayArray;
    private String[] yearArray;
    private String[] importanceArray;
    private String[] categoryArray;

    //to keep track of how many pages their are
    private int lengthOfBook = 1;
    // to keep track of were we are in the array
    private int index = 0;

    /***
     * This will create a brand new ChoreBook page in the theChoresBook array when the add method is called
     */
    public void createPageForBook()
    {
        for (int i = 0; i < theChoresBook.length; i++)
        {
            theChoresBook[i] = new ChoreBook();
        }
    }

    /***
     * This is the ChoreBookRunner
     * The Constructor
     */
    public ChoreBookRunner()  //constructor
    {
        setupWindow();
        createPageForBook();
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
        deletePage.setEnabled(false);

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
        theTask.setText("Type You Chore");
        theTask.setEditable(false);

        // enter in all the drop down menus
        monthArray = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        monthDropdown = new JComboBox(monthArray);
        monthDropdown.addActionListener(this);
        window.add(monthDropdown);
        monthDropdown.setEnabled(false);
        monthDropdown.setBounds(40,240,80,40);

        dayArray =  new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" ,"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        dayDropdown = new JComboBox(dayArray);
        dayDropdown.addActionListener(this);
        window.add(dayDropdown);
        dayDropdown.setEnabled(false);
        dayDropdown.setBounds(160,240,80,40);

        yearArray = new String[]{"2020", "2021", "2022", "2023", "2024", "2025"};
        yearDropdown = new JComboBox(yearArray);
        yearDropdown.addActionListener(this);
        window.add(yearDropdown);
        yearDropdown.setEnabled(false);
        yearDropdown.setBounds(280,240,80,40);

        importanceArray = new String[]{"Urgent and Important", "Urgent and Not Important", "Not Urgent and Important", "Not Urgent and Not Important"};
        importanceDropDown = new JComboBox(importanceArray);
        importanceDropDown.addActionListener(this);
        window.add(importanceDropDown);
        importanceDropDown.setEnabled(false);
        importanceDropDown.setBounds(40,320,640,40);

        categoryArray = new String[]{"Work", "School", "Personal"};
        categoryDropDown = new JComboBox(categoryArray);
        categoryDropDown.addActionListener(this);
        window.add(categoryDropDown);
        categoryDropDown.setEnabled(false);
        categoryDropDown.setBounds(40,400,280,80);

        extraInfo = new JTextArea();
        extraInfo.setBounds(400,400,280,200);
        extraInfo.setFont(new Font("Arial", Font.BOLD,30));
        extraInfo.setBackground(Color.white);
        extraInfo.setEnabled(false);
        extraInfo.setLineWrap(true);
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

        thePageNumber = new JLabel();
        thePageNumber.setBounds(440,640,200,40);
        thePageNumber.setText("Page #: 1");
        thePageNumber.setFont(new Font("Arial", Font.BOLD,30));
        thePageNumber.setOpaque(true);
        thePageNumber.setBackground(Color.WHITE);
        window.add(thePageNumber);

    }

    /***
     * Every time the edit button is clicked this method runs
     * This methods calls the enableAndDisable Method
     * @param e: This is the action listener so we can tell what button the user clicked
     */
    public void edit(ActionEvent e)
    {
        if(e.getSource() instanceof  JButton)
        {
            JButton clicked = (JButton)e.getSource();
            if(clicked.equals(editButton))
            {
                enableAndDisable(true);
            }
        }
    }

    /***
     *  This method will save all the values on the screen to the theChoresBook array when save button is clicked
     * @param e: This is the action listener so we can tell what button the user clicked
     */
    public void save(ActionEvent e)
    {
        if(e.getSource() instanceof  JButton)
        {
            JButton clicked = (JButton)e.getSource();
            if(clicked.equals(saveButton))
            {
                enableAndDisable(false);
                theChoresBook[index].setTheTask(theTask.getText());
                theChoresBook[index].setDay(String.valueOf(dayDropdown.getSelectedItem()));
                theChoresBook[index].setCategory(String.valueOf(categoryDropDown.getSelectedItem()));
                theChoresBook[index].setMonth(String.valueOf(monthDropdown.getSelectedItem()));
                theChoresBook[index].setYear(String.valueOf(yearDropdown.getSelectedItem()));
                theChoresBook[index].setImportance(String.valueOf(importanceDropDown.getSelectedItem()));
                theChoresBook[index].setExtraInfo(extraInfo.getText());
            }
        }
    }

    /***
     * This will create a new array and copy all the things into that array from the theChoresBook array
     * This methods is suppose to create new pages in the theChoresBook array
     * @param e: This is the action listener so we can tell what button the user clicked
     */
    public void addPage(ActionEvent e)
    {
        if(e.getSource() instanceof JButton)
        {
            JButton clicked = (JButton)e.getSource();
            if(clicked.equals(addPage))
            {
                //create new array that is one greater than the previous one
                ChoreBook[] newBookWithNewPage = new ChoreBook[theChoresBook.length + 1];

                // for loop puts all old info into larger new-page array
                for (int i = 0; i < theChoresBook.length; i++)
                {
                    newBookWithNewPage[i] = theChoresBook[i];
                }

                // make the original array update to the new longer array with new page
                theChoresBook = newBookWithNewPage;
                lengthOfBook++;
                theChoresBook[lengthOfBook] = new ChoreBook();

                // make it so that we also create another page in the 'theChoreBook" class and array so we can create
                // room for this new page that we're making. Also helps us access it when we're flipping through it!



            }
        }

    }


    /***
     * This will move one page up in the theChoresBook array
     * and will call the newDisplay Method
     * @param e: This is the action listener so we can tell what button the user clicked
     */
    public void nextPageMethod(ActionEvent e)
    {
        if(e.getSource() instanceof JButton)
        {
            JButton clicked = (JButton) e.getSource();
            if (clicked.equals(nextPage))
            {
                //making sure you can't delete the first page
                if (theChoresBook.length > 1 && index != theChoresBook.length -1)
                {

                    index++;
                    newDisplay();
                    thePageNumber.setText("Page #:" + (index + 1));

                }

            }
        }
    }

    /***
     * This will delete the page the user wants to delete from theChoresBook array
     * Ypu can't delete any pages when their is only 2 pages remaining in theChoresBook Array
     * @param e: This is the action listener so we can tell what button the user clicked
     */
    public void deletePage(ActionEvent e)
    {
        if (e.getSource() instanceof JButton)
        {
            JButton clicked = (JButton) e.getSource();

            if (clicked.equals(deletePage) && theChoresBook.length > 2)
            {
                ChoreBook[] newBookWithoutNewPage = new ChoreBook[theChoresBook.length - 1];

                // copies all info from original array to new array
                int tracker = 0;            //to track how many times the if loop inside the for loop runs
                for (int i = 0; i < theChoresBook.length; i++)
                {
                    // if index is not equal to the page we want to delete
                    if (i != index)
                    {
                        if (i > tracker)
                            i--;
                        if (i == newBookWithoutNewPage.length)
                            newBookWithoutNewPage[i - 1] = theChoresBook[i];
                        else
                            newBookWithoutNewPage[i] = theChoresBook[i];
                        tracker++;
                    }
                }

                // make the original array update to the new longer array with new page
                theChoresBook = newBookWithoutNewPage;
                lengthOfBook--;
                // sets new index
                int newIndex = index - 1;
                index = newIndex;
                thePageNumber.setText("Page #: " + (index + 1));
                newDisplay();
            }

            else if (clicked.equals(deletePage) && theChoresBook.length == 2)
            {
                deletePage.setEnabled(false);
                System.out.println("Can't delete pages when their is only 2 pages remaining");
            }
        }
    }

    /**
     * Move back one value on theChoresBook array
     * call the newDisplay method
     * @param e: This is the action listener so we can tell what button the user clicked
     */
    public void previousPageMethod(ActionEvent e)
    {
        if(e.getSource() instanceof JButton)
        {
            JButton clicked = (JButton) e.getSource();
            if (clicked.equals(previousPage))
            {
                if (index != 0)
                {
                    index--;
                    newDisplay();
                    thePageNumber.setText("Page #:" + (index + 1));
                }

            }
        }
    }

    /***
     * This will put up all the info from theChoresBook array index up on the window
     */
    public void newDisplay()
    {
        theTask.setText(theChoresBook[index].getTheTask());
        monthDropdown.setSelectedItem(theChoresBook[index].getMonth());
        dayDropdown.setSelectedItem(theChoresBook[index].getDay());
        yearDropdown.setSelectedItem(theChoresBook[index].getYear());
        importanceDropDown.setSelectedItem(theChoresBook[index].getImportance());
        categoryDropDown.setSelectedItem(theChoresBook[index].getCategory());
        extraInfo.setText(theChoresBook[index].getExtraInfo());

    }

    /**
     * It makes them all the input areas in the Gui disable or Enable
     * @param on: Dictates whether buttons are on or off
     */
    public void enableAndDisable(boolean on)
    {
        theTask.setEditable(on);
        monthDropdown.setEnabled(on);
        dayDropdown.setEnabled(on);
        yearDropdown.setEnabled(on);
        importanceDropDown.setEnabled(on);
        categoryDropDown.setEnabled(on);
        extraInfo.setEnabled(on);

    }


    /**
     * This is were we pass the action listener into the methods
     * @param e This is the action listener so we can tell what button the user clicked
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {

        if(theChoresBook.length > 2)
        {
            deletePage.setEnabled(true);
            if(index == 0)
            {
                deletePage.setEnabled(false);
            }
        }
        else
            deletePage.setEnabled(false);

        edit(e);
        save(e);
        addPage(e);
        previousPageMethod(e);
        nextPageMethod(e);
        deletePage(e);
    }

    /**
     * This is the main method
     * @param args: I honestly don't know what this does
     */
    public static void main(String[] args)
    {

        ChoreBookRunner program = new ChoreBookRunner();
        program.setVisible(true);
    }
}
