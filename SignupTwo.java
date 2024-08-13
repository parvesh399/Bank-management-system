import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener{

    JTextField panTextField, aadharTextField;
    JButton next;
    JRadioButton syes,sno,yes,no;
    JComboBox religion,category,income,education,occupation;
    String formno;

    SignupTwo(String formno){
        this.formno =formno;
        setLayout(null);

setTitle("New Account Application Form- Page 2");



JLabel additionalDetails = new JLabel("Page 2: Additional Details");
additionalDetails.setFont(new Font("raleway",Font.BOLD,30));
additionalDetails.setBounds(290,80,400,30);
add(additionalDetails);

JLabel Religion = new JLabel("Religion:");
Religion.setFont(new Font("raleway",Font.BOLD,20));
Religion.setBounds(100,140,100,30);
add(Religion);
String valReligion[]={"Hindu","Muslim","Sikh","Other"};
 religion =new JComboBox(valReligion);
religion.setBounds(300,140,400,30);
religion.setBackground(Color.WHITE);
add(religion);



JLabel Category = new JLabel("Category:");
Category.setFont(new Font("raleway",Font.BOLD,20));
Category.setBounds(100,190,200,30);
add(Category);
String valCategory[]={"General","OBC","SC","ST","Other"};
category =new JComboBox(valCategory);
category.setBounds(300,190,400,30);
category.setBackground(Color.WHITE);
add(category);

JLabel Income = new JLabel("Income:");
Income.setFont(new Font("raleway",Font.BOLD,20));
Income.setBounds(100,240,200,30);
add(Income);
String valIncome[]={"Null","<1.5 lakh","<2.5 lakh","<5 lakh","upto 10 lakh"};
income =new JComboBox(valIncome);
income.setBounds(300,240,400,30);
income.setBackground(Color.WHITE);
add(income);

JLabel Education = new JLabel("Educational");
Education.setFont(new Font("raleway",Font.BOLD,20));
Education.setBounds(100,290,200,30);
add(Education);

JLabel qualification = new JLabel("Qualification:");
qualification.setFont(new Font("raleway",Font.BOLD,20));
qualification.setBounds(100,315,200,30);
add(qualification);
String valEducation[]={"Non Graduate","Graduaton","Post Graduation","Diploma","Other"};
education =new JComboBox(valEducation);
education.setBounds(300,315,400,30);
education.setBackground(Color.WHITE);
add(education);


JLabel occupationn = new JLabel("Occupation:");
occupationn.setFont(new Font("raleway",Font.BOLD,20));
occupationn.setBounds(100,390,200,30);
add(occupationn);
String valOccupation[]={"Student","Government job","Private Sector","Bussinessman","Farmer","other"};
 occupation =new JComboBox(valOccupation);
occupation.setBounds(300,390,400,30);
occupation.setBackground(Color.WHITE);
add(occupation);





JLabel pan = new JLabel("Pan Number:");
pan.setFont(new Font("raleway",Font.BOLD,20));
pan.setBounds(100,440,200,30);
add(pan);

panTextField=new JTextField();
panTextField.setFont(new Font("Raleway",Font.BOLD,14));
panTextField.setBounds(300,440,400,30);
add(panTextField);

JLabel city = new JLabel("Aadhar Number:");
city.setFont(new Font("raleway",Font.BOLD,20));
city.setBounds(100,490,200,30);
add(city);

 aadharTextField=new JTextField();
 aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
 aadharTextField.setBounds(300,490,400,30);
add(aadharTextField);

JLabel senior = new JLabel("Senior Citizen");
senior.setFont(new Font("raleway",Font.BOLD,20));
senior.setBounds(100,540,200,30);
add(senior);

syes= new JRadioButton("Yes");
syes.setBounds(300,540,100,30);
syes.setBackground(Color.WHITE);
add(syes);
sno= new JRadioButton("No");
sno.setBounds(450,540,100,30);
sno.setBackground(Color.WHITE);
add(sno);
ButtonGroup seniorgroup=new ButtonGroup();
seniorgroup.add(syes);
seniorgroup.add(sno);


JLabel exist = new JLabel("Existing Account:");
exist.setFont(new Font("raleway",Font.BOLD,20));
exist.setBounds(100,590,200,30);
add(exist);

yes= new JRadioButton("Yes");
yes.setBounds(300,590,100,30);
yes.setBackground(Color.WHITE);
add(yes);
no= new JRadioButton("No");
no.setBounds(450,590,100,30);
no.setBackground(Color.WHITE);
add(no);
ButtonGroup existinggroup=new ButtonGroup();
existinggroup.add(yes);
existinggroup.add(no);

next= new JButton("Next");
next.setBackground(Color.BLACK);
next.setForeground(Color.WHITE);
next.setFont(new Font("Raleway",Font.BOLD,14));
next.setBounds(620,660,80,30);
next.addActionListener(this);
add(next);


getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae){
        
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();

        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }
        else if(sno.isSelected()){
            seniorcitizen="No";

        }
        String existingaccount=null;
        if(yes.isSelected()){
            existingaccount="Yes";
        }
        else if(no.isSelected()){
            existingaccount="No";

        }
    
        String span= panTextField.getText();
        String saadhar=aadharTextField.getText();
    
        try {
          
            Conn c=new Conn();
            String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
           c.s.executeUpdate(query);
           setVisible(false);
           new Signupthree(formno).setVisible(true);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
            
            
    public static void main(String args[]){
        new SignupTwo("");
    }
}
