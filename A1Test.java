import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class A1 extends JFrame
{
Container c;
JLabel lblName,lblCourses;
JTextField txtName;
JCheckBox cbPython,cbJava,cbJs,cbDjango,cbGo,cbMysql,cbAndroid;
JButton btnSave;

A1()
{
	c=getContentPane();
	c.setLayout(null);
	Font f=new Font("Arial",Font.BOLD,30);	

	lblName=new JLabel("Enter name");
	lblName.setBounds(20,20,300,30);
	lblName.setFont(f);
	txtName=new JTextField(20);
	txtName.setFont(f);
	txtName.setBounds(260,20,300,36);
	lblCourses=new JLabel("Select the courses you know");
	lblCourses.setBounds(20,100,500,30);
	lblCourses.setFont(f);
	
	cbJava=new JCheckBox("Java");
	cbJava.setFont(f);
	cbJava.setBounds(30,150,500,30);

	cbPython=new JCheckBox("Python");
	cbPython.setFont(f);
	cbPython.setBounds(30,200,500,30);

	cbJs=new JCheckBox("Js");
	cbJs.setFont(f);
	cbJs.setBounds(30,250,500,30);

	cbDjango=new JCheckBox("Django");
	cbDjango.setFont(f);
	cbDjango.setBounds(30,300,500,30);

	cbGo=new JCheckBox("GoLang");
	cbGo.setFont(f);
	cbGo.setBounds(30,350,500,30);

	cbMysql=new JCheckBox("MySQL");	
	cbMysql.setFont(f);
	cbMysql.setBounds(30,400,500,30);

	cbAndroid=new JCheckBox("Android");
	cbAndroid.setFont(f);
	cbAndroid.setBounds(30,450,500,30);

	btnSave=new JButton("Save");
	btnSave.setFont(f);
	btnSave.setBounds(50,500,500,40);
	
	c.add(lblName);
	c.add(txtName);
	c.add(lblCourses);
	c.add(cbJava);	
	c.add(cbPython);
	c.add(cbJs);
	c.add(cbDjango);
	c.add(cbGo);
	c.add(cbMysql);
	c.add(cbAndroid);
	c.add(btnSave);

	ActionListener a1=(ae)->{

		try
		{
			String name=txtName.getText();
			if(!name.matches("[a-zA-Z ]+"))
				throw new Exception("invalid name");
			String courses="";
			if(cbJava.isSelected())			courses+=" Java ";
			if(cbPython.isSelected())		courses+=" Python ";
			if(cbJs.isSelected())			courses+=" JS ";
			if(cbDjango.isSelected())		courses+=" Django ";
			if(cbGo.isSelected())			courses+=" GoLang ";
			if(cbMysql.isSelected())		courses+=" MySQL ";
			if(cbAndroid.isSelected())		courses+=" Android ";
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kc_2feb23","root","abc456");	
			String sql="insert into courses values(?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,name);
			pst.setString(2,courses);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(c,"thank you!");
		}catch(SQLException e){
			JOptionPane.showMessageDialog(c,"Issue: "+e.getMessage());
			txtName.setText("");
			txtName.requestFocus();
		}catch(Exception e){
			JOptionPane.showMessageDialog(c,"Issue: "+e.getMessage());
			txtName.setText("");
			txtName.requestFocus();
		}
		txtName.setText("");
		txtName.requestFocus();
	};
	btnSave.addActionListener(a1);
	setTitle("Tech you know");
	setSize(600,700);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setVisible(true);
}
}

class A1Test
{
public static void main(String[] args){
A1 a=new A1();
}
}