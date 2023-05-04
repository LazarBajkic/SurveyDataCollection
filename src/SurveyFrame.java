import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class SurveyFrame extends JFrame implements ActionListener{

    JLabel hello = new JLabel("Hello and thank you for taking this survey,your opinion matters");
    JLabel question1 = new JLabel("Which topic is the most appealing to you?");
    ButtonGroup groupSurvey = new ButtonGroup();
    JRadioButton r1 = new JRadioButton("Animals");
    JRadioButton r2 = new JRadioButton("Sports");
    JRadioButton r3 = new JRadioButton("Video games");
    JRadioButton r4 = new JRadioButton("Anime");
    
    SurveyFrame(){
        this.setSize(530,200);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        hello.setLocation(10, 10);
        hello.setSize(500, 30);
        hello.setFont(new Font("Arial",Font.PLAIN,18));

        question1.setLocation(10, 50);
        question1.setSize(500, 30);
        question1.setFont(new Font("Arial",Font.PLAIN,18));

        r1.setLocation(30, 100);
        r1.setSize(80, 30);
        r1.setFocusable(false);
        r1.addActionListener(this);

        r2.setLocation(110, 100);
        r2.setSize(80, 30);
        r2.setFocusable(false);
        r2.addActionListener(this);

        r3.setLocation(190, 100);
        r3.setSize(100, 30);
        r3.setFocusable(false);
        r3.addActionListener(this);
        
        r4.setLocation(300, 100);
        r4.setSize(80, 30);
        r4.setFocusable(false);
        r4.addActionListener(this);

        groupSurvey.add(r1);
        groupSurvey.add(r2);
        groupSurvey.add(r3);
        groupSurvey.add(r4);
        this.add(r1);
        this.add(r2);
        this.add(r3);
        this.add(r4);
        this.add(hello);
        this.add(question1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(r1.isSelected()){
            AnimalSurvey AS = new AnimalSurvey();
            this.dispose();
        }
        else if (r2.isSelected()){
            SportsSurvey SS = new SportsSurvey();
            this.dispose();
        }
    }
}
