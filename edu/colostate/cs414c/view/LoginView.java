package edu.colostate.cs414c.view;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavithra
 */
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginView extends JFrame {
	
	private JLabel welcomeLabel = new JLabel("Pizza Ordering");
	private JLabel userLabel = new JLabel("UserId");
	private JTextField userField = new JTextField(35);
	private JLabel pwdLabel = new JLabel("Password");
	private JPasswordField pwdField = new JPasswordField(35);
	private JButton loginButton = new JButton("Login");
	private String errorMsg = "Invalid Login Details";
	
	public LoginView(){
		JPanel panel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,700);
		this.add(panel);
		panel.setLayout(null);
		setBounds();
		addtoPanel(panel);
		this.setVisible(true);
	}

	public void addtoPanel(JPanel panel){
		panel.add(welcomeLabel);
		panel.add(userLabel);
		panel.add(userField);
		panel.add(pwdLabel);
		panel.add(pwdField);
		panel.add(loginButton);
	}
	public void setBounds(){
		welcomeLabel.setBounds(215,150, 300,25);
		userLabel.setBounds(200, 200, 100,25);
		userField.setBounds(300, 200, 100,25);
		pwdLabel.setBounds(200,240,100,25);
		pwdField.setBounds(300,240, 100,25);
		loginButton.setBounds(250, 290, 100,25);
	}
	public String getUserField() {
		return userField.getText();
	}

	@SuppressWarnings("deprecation")
	public String getPwdField() {
		return pwdField.getText();
	}
	
	public void ButtonListner(ActionListener l){
		loginButton.addActionListener(l);
	}
	
	public void errorMsg(){
		JOptionPane.showMessageDialog(this,errorMsg);
	}

}


