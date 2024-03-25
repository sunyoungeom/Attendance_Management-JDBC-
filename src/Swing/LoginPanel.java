package Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import User.User;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class LoginPanel extends JPanel {
	private StudentAttendanceMenuGUI frame;

	public LoginPanel(StudentAttendanceMenuGUI frame) {
		setBackground(Color.WHITE);
		setSize(600, 500);
		this.frame = frame;
		setLayout(null);

		JLabel titleLabel = new JLabel("로그인");
		titleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		titleLabel.setBounds(309, 120, 150, 30);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel);

		JLabel idLabel = new JLabel("ID: ");
		idLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		idLabel.setBounds(270, 180, 80, 25);
		add(idLabel);

		JTextField idText = new JTextField();
		idText.setBorder(new LineBorder(new Color(126, 126, 126)));
		idText.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		idText.setBounds(360, 180, 160, 25);
		add(idText);

		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		passwordLabel.setBounds(270, 224, 80, 25);
		add(passwordLabel);

		JPasswordField passwordText = new JPasswordField();
		passwordText.setBorder(new LineBorder(new Color(126, 126, 126)));
		passwordText.setBounds(360, 225, 160, 25);
		add(passwordText);
		JButton loginButton = new JButton("로그인");
		loginButton.setBackground(new Color(153, 204, 255));
		loginButton.setOpaque(true);
		loginButton.setBorderPainted(false);
		loginButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		loginButton.setBounds(270, 278, 250, 44);
		add(loginButton);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(LoginPanel.class.getResource("/Swing/free-icon-student-2784410.png")));
		lblNewLabel.setBounds(85, 120, 160, 250);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.showMainCard("signUp");
			}
		});
		btnNewButton.setBounds(270, 333, 117, 30);
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("아이디 찾기");
		btnNewButton_1.setBounds(403, 334, 117, 29);
		btnNewButton_1.setBackground(new Color(204, 204, 204));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		add(btnNewButton_1);

		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idText.getText();
				String password = new String(passwordText.getPassword());

				for (User elem : frame.userService.getAllUsers()) {
					if (elem.getId().equals(id) && elem.getPassword().equals(password)) {
						System.out.println(id + "님 로그인 완료");
						frame.loginId = id;
						frame.loginType = elem.getType();
					}
				}
				if (frame.loginType != null && frame.loginType.toString().equals("TEACHER")) {
					// 선생님 메뉴
					// 1. 학생 출결 확인, 2. 나의 정보, 3. 로그아웃
					frame.showMainCard("teacher");
				} else if (frame.loginType != null && frame.loginType.toString().equals("STUDENT")) {
					// 학생 메뉴
					// 1. 출석하기, 2. 나의 출석현황, 3. 나의 정보, 4. 로그아웃
					frame.showMainCard("student");
				}
			}
		});
	}
}