import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AnimalSurvey extends JFrame implements ActionListener{
    
    JLabel question1 = new JLabel("1.Do you own a pet?");
    JLabel question2 = new JLabel("2.What is your favorite pet?");
    JLabel question3 = new JLabel("3.Is animal abuse okay?");
    JLabel question4 = new JLabel("4.Did you ever have a pet?");

    JRadioButton animalR1 = new JRadioButton("Yes");
    JRadioButton animalR2 = new JRadioButton("No");
    
    JRadioButton animalR3 = new JRadioButton("Cat");
    JRadioButton animalR4 = new JRadioButton("Dog");
    JRadioButton animalR5 = new JRadioButton("Hamster");
    JRadioButton animalR6 = new JRadioButton("Bird");
    JRadioButton animalR7 = new JRadioButton("Reptile");

    JRadioButton animalR8 = new JRadioButton("Yes");
    JRadioButton animalR9 = new JRadioButton("No");

    ButtonGroup group1 = new ButtonGroup();
    ButtonGroup group2 = new ButtonGroup();
    ButtonGroup group3 = new ButtonGroup();

    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    
    JTextField petInput = new RoundTextField(15);
    JButton submit = new JButton("Submit");
    Font oswald = new Font("Oswald", Font.PLAIN, 18);
    Font vina = new Font("Kanit", Font.PLAIN, 18);

    Color color = new Color(123, 191, 204);
    Color color2 = new Color(0, 230, 218);
    Color color3 = new Color(0, 152, 179);

    AnimalSurvey(){
        
        this.setSize(530, 550);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        question1.setLocation(10, 10);
        question1.setSize(200, 30);
        question1.setFont(vina);

        question2.setLocation(10, 100);
        question2.setSize(250, 30);
        question2.setFont(vina);

        question3.setLocation(10, 190);
        question3.setSize(250, 30);
        question3.setFont(vina);

        question4.setLocation(10, 280);
        question4.setSize(250, 30);
        question4.setFont(vina);

        panel.setSize(470,470);
        panel.setLocation(20, 20);
        panel.setBackground(color);
        panel.setLayout(null);
        panel.setFont(vina);

        panel2.setSize(530,550);
        panel2.setLocation(0, 0);
        panel2.setBackground(color3);
        panel2.setLayout(null);
        panel2.setFont(vina);

        group1.add(animalR1);
        group1.add(animalR2);

        group2.add(animalR3);
        group2.add(animalR4);
        group2.add(animalR5);
        group2.add(animalR6);
        group2.add(animalR7);

        group3.add(animalR8);
        group3.add(animalR9);

        animalR1.setSize(60, 30);
        animalR1.setLocation(10, 50);
        animalR1.setFocusable(false);
        animalR1.addActionListener(this);
        animalR1.setBackground(color);
        animalR1.setActionCommand("Yes");
        animalR1.setFont(oswald);

        animalR2.setSize(50, 30);
        animalR2.setLocation(100, 50);
        animalR2.setFocusable(false);
        animalR2.addActionListener(this);
        animalR2.setBackground(color);
        animalR2.setActionCommand("No");
        animalR2.setFont(oswald);

        animalR3.setSize(75, 30);
        animalR3.setLocation(10, 140);
        animalR3.setFocusable(false);
        animalR3.addActionListener(this);
        animalR3.setBackground(color);
        animalR3.setActionCommand("Cat");
        animalR3.setFont(oswald);

        animalR4.setSize(75, 30);
        animalR4.setLocation(80, 140);
        animalR4.setFocusable(false);
        animalR4.setBackground(color);
        animalR4.addActionListener(this);
        animalR4.setActionCommand("Dog");
        animalR4.setFont(oswald);

        animalR5.setSize(100, 30);
        animalR5.setLocation(150, 140);
        animalR5.setFocusable(false);
        animalR5.setBackground(color);
        animalR5.addActionListener(this);
        animalR5.setActionCommand("Hamster");
        animalR5.setFont(oswald);

        animalR6.setSize(75, 30);
        animalR6.setLocation(260, 140);
        animalR6.setFocusable(false);
        animalR6.setBackground(color);
        animalR6.addActionListener(this);
        animalR6.setActionCommand("Bird");
        animalR6.setFont(oswald);

        animalR7.setSize(100, 30);
        animalR7.setLocation(330, 140);
        animalR7.setFocusable(false);
        animalR7.setBackground(color);
        animalR7.addActionListener(this);
        animalR7.setActionCommand("Reptile");
        animalR7.setFont(oswald);

        animalR8.setSize(75, 30);
        animalR8.setLocation(10, 230);
        animalR8.setFocusable(false);
        animalR8.setBackground(color);
        animalR8.addActionListener(this);
        animalR8.setActionCommand("Yes");
        animalR8.setFont(oswald);

        animalR9.setSize(75, 30);
        animalR9.setLocation(100, 230);
        animalR9.setFocusable(false);
        animalR9.setBackground(color);
        animalR9.addActionListener(this);
        animalR9.setActionCommand("No");
        animalR9.setFont(oswald);

        petInput.setSize(250, 30);
        petInput.setLocation(10, 330);
        petInput.setBorder(null);
        petInput.setFont(vina);

        submit.setLocation(190, 400);
        submit.setSize(100, 40);
        submit.setBackground(color2);
        submit.addActionListener(this);

        this.add(panel2);
        panel2.add(panel);
        panel.add(submit);
        panel.add(question1);
        panel.add(question2);
        panel.add(question3);
        panel.add(question4);
        panel.add(petInput);
        panel.add(animalR1);
        panel.add(animalR2);
        panel.add(animalR3);
        panel.add(animalR4);
        panel.add(animalR5);
        panel.add(animalR6);
        panel.add(animalR7);
        panel.add(animalR8);
        panel.add(animalR9);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==submit){
        String answer1= group1.getSelection().getActionCommand();
        String answer2= group2.getSelection().getActionCommand();
        String answer3= group3.getSelection().getActionCommand();
        String answer4 = petInput.getText();
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
        String query="Insert into AnimalData (OwnPet,FavoritePet,Abuse,PetName) Values('"+answer1+"','"+answer2+"','"+answer3+"','"+answer4+"')";
        Connection con=DriverManager.getConnection(url,uname,password);
        Statement statement=con.createStatement();
        statement.executeUpdate(query);
    }

}
