import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SportsSurvey extends JFrame implements ActionListener {
    
    JLabel question1 = new JLabel("1.Do you play sports?");
    JLabel question2 = new JLabel("2.How much do you like to play sports?");
    JLabel question3 = new JLabel("3.Who is your favorite athlete?");
    JLabel question4 = new JLabel("4.Which sport is your favorite?");

    JRadioButton sportlR1 = new JRadioButton("Yes");
    JRadioButton sportlR2 = new JRadioButton("No");

    JRadioButton sportlR3 = new JRadioButton("1");
    JRadioButton sportlR4 = new JRadioButton("2");
    JRadioButton sportlR5 = new JRadioButton("3");
    JRadioButton sportlR6 = new JRadioButton("4");
    JRadioButton sportlR7 = new JRadioButton("5");

    JTextField favoriteSport = new RoundTextField(15);
    JTextField favoriteAthlete = new RoundTextField(15);

    ButtonGroup group1 = new ButtonGroup();
    ButtonGroup group2 = new ButtonGroup();

    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();

    JButton submit = new JButton("Submit");
    Font oswald = new Font("Oswald", Font.PLAIN, 18);
    Font kanit = new Font("Kanit", Font.PLAIN, 18);

    Color color = new Color(123, 191, 204);
    Color color2 = new Color(0, 230, 218);
    Color color3 = new Color(0, 152, 179);

    SportsSurvey(){
        this.setSize(525, 550);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        question1.setLocation(10, 10);
        question1.setSize(200, 30);
        question1.setFont(kanit);

        question2.setLocation(10, 100);
        question2.setSize(300, 30);
        question2.setFont(kanit);

        question3.setLocation(10, 190);
        question3.setSize(250, 30);
        question3.setFont(kanit);

        question4.setLocation(10, 280);
        question4.setSize(250, 30);
        question4.setFont(kanit);

        panel.setSize(470,470);
        panel.setLocation(20, 20);
        panel.setBackground(color);
        panel.setLayout(null);
        panel.setFont(kanit);

        panel2.setSize(530,550);
        panel2.setLocation(0, 0);
        panel2.setBackground(color3);
        panel2.setLayout(null);
        panel2.setFont(kanit);

        group1.add(sportlR1);
        group1.add(sportlR2);

        group2.add(sportlR3);
        group2.add(sportlR4);
        group2.add(sportlR5);
        group2.add(sportlR6);
        group2.add(sportlR7);

        sportlR1.setSize(60, 30);
        sportlR1.setLocation(10, 50);
        sportlR1.setFocusable(false);
        sportlR1.addActionListener(this);
        sportlR1.setBackground(color);
        sportlR1.setActionCommand("Yes");
        sportlR1.setFont(oswald);

        sportlR2.setSize(50, 30);
        sportlR2.setLocation(100, 50);
        sportlR2.setFocusable(false);
        sportlR2.addActionListener(this);
        sportlR2.setBackground(color);
        sportlR2.setActionCommand("No");
        sportlR2.setFont(oswald);

        sportlR3.setSize(75, 30);
        sportlR3.setLocation(10, 140);
        sportlR3.setFocusable(false);
        sportlR3.addActionListener(this);
        sportlR3.setBackground(color);
        sportlR3.setActionCommand("1");
        sportlR3.setFont(oswald);

        sportlR4.setSize(75, 30);
        sportlR4.setLocation(80, 140);
        sportlR4.setFocusable(false);
        sportlR4.setBackground(color);
        sportlR4.addActionListener(this);
        sportlR4.setActionCommand("2");
        sportlR4.setFont(oswald);

        sportlR5.setSize(75, 30);
        sportlR5.setLocation(150, 140);
        sportlR5.setFocusable(false);
        sportlR5.setBackground(color);
        sportlR5.addActionListener(this);
        sportlR5.setActionCommand("3");
        sportlR5.setFont(oswald);

        sportlR6.setSize(75, 30);
        sportlR6.setLocation(230, 140);
        sportlR6.setFocusable(false);
        sportlR6.setBackground(color);
        sportlR6.addActionListener(this);
        sportlR6.setActionCommand("4");
        sportlR6.setFont(oswald);

        sportlR7.setSize(100, 30);
        sportlR7.setLocation(310, 140);
        sportlR7.setFocusable(false);
        sportlR7.setBackground(color);
        sportlR7.addActionListener(this);
        sportlR7.setActionCommand("5");
        sportlR7.setFont(oswald);

        favoriteAthlete.setSize(250, 30);
        favoriteAthlete.setLocation(10, 330);
        favoriteAthlete.setBorder(null);
        favoriteAthlete.setFont(kanit);

        favoriteSport.setSize(250, 30);
        favoriteSport.setLocation(10, 240);
        favoriteSport.setBorder(null);
        favoriteSport.setFont(kanit);

        submit.setLocation(190, 400);
        submit.setSize(100, 40);
        submit.setBackground(color2);
        submit.setFocusable(false);
        submit.addActionListener(this);

        this.add(panel2);
        panel2.add(panel);
        panel.add(submit);
        panel.add(question1);
        panel.add(question2);
        panel.add(question3);
        panel.add(question4);
        panel.add(favoriteSport);
        panel.add(favoriteAthlete);
        panel.add(sportlR1);
        panel.add(sportlR2);
        panel.add(sportlR3);
        panel.add(sportlR4);
        panel.add(sportlR5);
        panel.add(sportlR6);
        panel.add(sportlR7);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==submit){
            String answer1= group1.getSelection().getActionCommand();
            String answer2= group2.getSelection().getActionCommand();
            String answer3= favoriteAthlete.getText();
            String answer4 =favoriteSport.getText();
            try {
                AddToTable(answer1, answer2, answer3, answer4);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
           }           
    }
    public static void AddToTable(String answer1,String answer2,String answer3,String answer4) throws SQLException{
        String uname="root";
        String url="jdbc:mysql://localhost:3306/SurveyData";
        String password="Ceramida";
        String query="Insert into SportsSurvey (PlaySports,LikeToPlay,FavoriteSport,FavoriteAthlete) Values('"+answer1+"','"+answer2+"','"+answer3+"','"+answer4+"')";
        Connection con=DriverManager.getConnection(url,uname,password);
        Statement statement=con.createStatement();
        statement.executeUpdate(query);
    }

}
