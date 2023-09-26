import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class FortuneTellerFrame extends JFrame {

    JPanel mainPnl;
    JPanel iconPnl;
    JPanel displayPnl;
    JPanel controlPnl;
    JLabel iconLbl;
    ImageIcon FTIcon;

    JScrollPane scroller;
    JTextArea fortuneTA;

    JButton quitBtn;
    JButton FortuneBtn;
    ArrayList<String> fortunes = new ArrayList<>();

    public FortuneTellerFrame()
    {
        FTIcon = new ImageIcon("src/Clover.jpg");
        setIconImage(FTIcon.getImage());

        //Adding fortunes
        fortunes.add("You will soon find something lost long ago.");
        fortunes.add("Your future is looking bright.");
        fortunes.add("A great adventure awaits you.");
        fortunes.add("You will make a wise decision.");
        fortunes.add("Your talents will be recognized and rewarded.");
        fortunes.add("You will find great wealth");
        fortunes.add("You will travel to many exotic places.");
        fortunes.add("Your hard work will soon pay off.");
        fortunes.add("You will live a long and healthy life.");
        fortunes.add("You will have a very comfortable old age.");
        fortunes.add("Your love life will soon be happy and harmonious.");
        fortunes.add("You will be successful in your work.");



        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());


        createIconPanel();
        createDisplayPanel();
        createControlPanel();


        mainPnl.add(iconPnl, BorderLayout.NORTH);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
        mainPnl.add(controlPnl, BorderLayout.SOUTH);
        add(mainPnl);
        pack();
    }

    private void createControlPanel()
    {
        controlPnl = new JPanel();

        //Making a fortune button perform functionally
        FortuneBtn = new JButton("Read My Fortune!");
        FortuneBtn.addActionListener(e -> {
            int lastIndex = -1;
            int index;
            Random rand = new Random();

            index = rand.nextInt(fortunes.size());
            lastIndex = index;

            do {
                index = rand.nextInt(fortunes.size());
            } while (index == lastIndex);

            fortuneTA.append(fortunes.get(index) + "\n");
        });

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener(e -> System.exit(0));


        controlPnl.setLayout(new GridLayout(1, 2));


        controlPnl.add(FortuneBtn);
        controlPnl.add(quitBtn);
    }

    private void createDisplayPanel() {
        displayPnl = new JPanel();
        //create text area
        fortuneTA = new JTextArea(10, 40);
        fortuneTA.setFont(new Font("Arial", Font.PLAIN, 20));
        //only readable
        fortuneTA.setEditable(false);

        scroller = new JScrollPane(fortuneTA);
        displayPnl.add(scroller);
    }

    private void createIconPanel() {
        //Create iconPanel
        FTIcon = new ImageIcon("src/Clover.png");
        iconPnl = new JPanel();

        Image img = FTIcon.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING);
        FTIcon = new ImageIcon(img);

        iconLbl = new JLabel("Fortune Teller", FTIcon, SwingConstants.CENTER);
        iconLbl.setFont(new Font("Serif", Font.PLAIN, 48));
        iconPnl.add(iconLbl);
    }
}
