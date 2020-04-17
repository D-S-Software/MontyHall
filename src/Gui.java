import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame
{
    JPanel inputPanel = new JPanel();
    JLabel title = new JLabel(), switchPercentLabel = new JLabel(), stayPercentLabel = new JLabel(), iterationsLabel = new JLabel(), doorsLabel = new JLabel(), stayResultLabel = new JLabel(), switchResultLabel = new JLabel();
    JTextField inputTextIt = new JTextField(7), inputTextDoor = new JTextField(7);
    JButton inputButtonOne = new JButton("Enter"), inputButtonTwo = new JButton("Enter"), startCalcButton = new JButton("Run"), closeButton = new JButton("Close");
    ProcessGame test;
    int iterations, doorCount;
    static CreateFile x = new CreateFile();

    /**Sets up the GUI for teh program
     *
     */
    public Gui()
    {
        setTitle("Gui");
        setSize(320, 225);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        title.setText("   ~~~~~   Monty Hall Problem Simulation   ~~~~~   ");
        inputPanel.add(title);

        iterationsLabel.setText("Iterations:");
        inputPanel.add(iterationsLabel);

        inputPanel.add(inputTextIt);

        inputTextIt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = inputTextIt.getText();
                iterations = Integer.parseInt(input);
            }
        });

        inputPanel.add(inputButtonOne);
        inputButtonOne.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = inputTextIt.getText();
                iterations = Integer.parseInt(input);
            }
        });

        doorsLabel.setText("Number of Doors:");
        inputPanel.add(doorsLabel);

        inputPanel.add(inputTextDoor);

        inputTextDoor.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = inputTextDoor.getText();
                doorCount = Integer.parseInt(input);
            }
        });

        inputPanel.add(inputButtonTwo);
        inputButtonTwo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = inputTextDoor.getText();
                doorCount = Integer.parseInt(input);
            }
        });

        stayResultLabel.setText("Staying at the door success rate:");
        stayResultLabel.setBounds(100, 200, 200, 50);
        inputPanel.add(stayResultLabel);
        inputPanel.add(stayPercentLabel);
        switchResultLabel.setText("Switching to the other door success rate:");
        switchResultLabel.setBounds(100, 260, 200, 50);
        inputPanel.add(switchResultLabel);
        inputPanel.add(switchPercentLabel);

        inputPanel.add(startCalcButton);
        startCalcButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.CEILING);

                test = new ProcessGame(iterations, doorCount);

                Double stayTag = test.calculatePercent(test.countCars(test.getStayResults()));
                Double switchTag = test.calculatePercent(test.countCars(test.getSwitchResults()));

                stayPercentLabel.setText(df.format(stayTag) + "%");
                switchPercentLabel.setText(df.format(switchTag) + "%");

                x.addSpace();
            }
        });

        inputPanel.add(closeButton);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                x.closeFile();
                System.exit(0);
            }
        });

        add(inputPanel);
        setVisible(true);
    }

    public static CreateFile getCreateFile()
    {
        return x;
    }

    public static void main(String[] args)
    {
        Gui monty = new Gui();
        x.openFile();
    }
}