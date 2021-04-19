
package hotelmanagementsystem;

/**
 *
 * @author Pallavi
 */
import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{ 

    JLabel Gender;
	JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7;
        JComboBox c1;
         JRadioButton r1,r2;
        public AddEmployee(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.white);
            setTitle("ADD EMPLOYEE DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
			
            JLabel Name = new JLabel("NAME");
            Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
           Name.setBounds(60, 30, 150, 27);
            add(Name);
            
            textField = new JTextField();
            textField.setBounds(200, 30, 150, 27);
            add(textField);
			
            JButton Save = new JButton("SAVE");
            Save.setBounds(200, 470, 150, 30);
            Save.setBackground(Color.BLACK);
            Save.setForeground(Color.WHITE);
           Save.addActionListener(this);
            add(Save);
            
            
			
            JLabel Age = new JLabel("AGE");
            Age.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Age.setBounds(60, 80, 150, 27);
            add(Age);
			
            textField_1 = new JTextField();
            textField_1.setBounds(200, 80, 150, 27);
            add(textField_1);
            
             Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Gender.setBounds(60, 120, 150, 27);
            add(Gender);
		
             r1 = new JRadioButton("MALE");
            r1.setBackground(Color.WHITE);
            r1.setBounds(200, 120, 70, 27);
            add(r1);
	
             r2 = new JRadioButton("FEMALE");
            r2.setBackground(Color.WHITE);
            r2.setBounds(280, 120, 70, 27);
            add(r2);
            
            
            JLabel jobname = new JLabel("JOB NAME");
            jobname.setFont(new Font("Tahoma", Font.PLAIN, 17));
            jobname.setBounds(60, 170, 150, 27);
            add(jobname);
			
            String job[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            c1 = new JComboBox(job);
            c1.setBackground(Color.WHITE);
            c1.setBounds(200,170,150,30);
            add(c1);
            		
            JLabel Salary = new JLabel("SALARY");
            Salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Salary.setBounds(60, 220, 150, 27);
            add(Salary);
			
            textField_3 = new JTextField();
            textField_3.setBounds(200, 220, 150, 27);
            add(textField_3);
	
            JLabel Phone = new JLabel("PHONE");
            Phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Phone.setBounds(60, 270, 150, 27);
            add(Phone);
	
            textField_4 = new JTextField();
            textField_4.setBounds(200, 270, 150, 27);
            add(textField_4);
	
            JLabel aadhar = new JLabel("AADHAR");
            aadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
            aadhar.setBounds(60, 320, 150, 27);
            add(aadhar);
			
            textField_5 = new JTextField();
            textField_5.setBounds(200, 320, 150, 27);
            add(textField_5);
	
            
           
             JLabel email = new JLabel("EMAIL");
            email.setFont(new Font("Tahoma", Font.PLAIN, 17));
            email.setBounds(60, 370, 150, 27);
            add(email);
            
			
           textField_6 = new JTextField();
            textField_6.setBounds(200, 370, 150, 27);
            add(textField_6);
	
            setVisible(true);
	
            JLabel add = new JLabel("ADDRESS");
            add.setFont(new Font("Tahoma", Font.PLAIN, 17));
            add.setBounds(60, 420, 150, 27);
            add(add);
            
			
           textField_7 = new JTextField();
            textField_7.setBounds(200, 420, 150, 27);
            add(textField_7);
	
            setVisible(true);
            
            
            
            JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(450, 24, 442, 35);
            add(AddPassengers);
			
     
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/tenth.jpg"));
            Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(410,80,480,410);
            add(image);

                    //sql insertion
            
        }
        
        public void actionPerformed(ActionEvent ae) 
        {
             String Name = textField.getText();
                    String Age = textField_1.getText();
                    String Salary = textField_3.getText();
                    String Phone = textField_4.getText();
                    String aadhar = textField_5.getText();
                    String email = textField_6.getText();
                   String add=textField_7.getText();
                    String gender = null;
                    
                    if(r1.isSelected()){
                        gender = "male";
                    
                    }else if(r2.isSelected()){
                        gender = "female";
                    }

                            
                    String job1 = (String)c1.getSelectedItem();
                    conn connectionobj =new conn();
                    String str = "INSERT INTO employee values( '"+Name+"', '"+Age+"', '"+job1+"','"+gender+"', '"+Salary+"', '"+Phone+"','"+aadhar+"', '"+email+"','"+add+"')";
                        
                    try{
                        connectionobj.s.executeUpdate(str);
                         JOptionPane.showMessageDialog(null,"Employee Added Successfully");
                        setVisible(false);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    
        }
    public static void main(String[] args){
        new AddEmployee();
    }   
}