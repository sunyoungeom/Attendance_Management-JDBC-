package Swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import User.User;
import User.UserType;

import javax.swing.JComboBox;

public class SignUpPanel extends JPanel {
	private StudentAttendanceMenuGUI frame;

	public SignUpPanel(StudentAttendanceMenuGUI frame) {
		setBackground(Color.WHITE);
		setSize(600, 500);
		this.frame = frame;
		setLayout(null);

		JLabel titleLabel = new JLabel("회원가입");
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
		JButton loginButton = new JButton("회원가입");
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

		JButton btnNewButton_1 = new JButton("돌아가기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.showMainCard("login");
			}
		});
		btnNewButton_1.setBounds(403, 334, 117, 29);
		btnNewButton_1.setBackground(new Color(204, 204, 204));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		add(btnNewButton_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBox.setBounds(270, 334, 126, 30);
		comboBox.addItem("선택하세요");
		comboBox.addItem("사용자 유형"); // 기본 출력 텍스트
		comboBox.addItem("---------"); // 인덱스 1에 "------" 추가
		comboBox.addItem("선생님");
		comboBox.addItem("학생");

		comboBox.setSelectedIndex(0);
		add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 1 || comboBox.getSelectedIndex() == 2) {
					comboBox.setSelectedIndex(0);
				}
			}
		});

		 loginButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String id = idText.getText();
	                String password = new String(passwordText.getPassword());

	                if (id.isEmpty() || password.isEmpty()) {
	                    JOptionPane.showMessageDialog(SignUpPanel.this, "아이디와 비밀번호를 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	                    return;
	                }

	                if (!isUserIdExists(id)) {
	                    JOptionPane.showMessageDialog(SignUpPanel.this, "이미 존재하는 아이디입니다.", "알림", JOptionPane.WARNING_MESSAGE);
	                } else {
	                    if (comboBox.getSelectedIndex() == 0 || comboBox.getSelectedIndex() == 1 || comboBox.getSelectedIndex() == 2) {
	                        JOptionPane.showMessageDialog(SignUpPanel.this, "사용자 유형을 선택하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	                        return;
	                    } else if (comboBox.getSelectedIndex() == 3) {
	                        frame.userService.createUser(id, password, UserType.TEACHER);
	                        JOptionPane.showMessageDialog(SignUpPanel.this, id + "님 환영합니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
	                        frame.showMainCard("teacherSignUp");
	                    } else if (comboBox.getSelectedIndex() == 4) {
	                        frame.userService.createUser(id, password, UserType.STUDENT);
	                        JOptionPane.showMessageDialog(SignUpPanel.this, id + "님 환영합니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
	                        frame.showMainCard("studentSignUp");
	                    }
	                }
	            }


			private boolean isUserIdExists(String id) {
				for (User elem : frame.userService.getAllUsers()) {
					if (elem.getId().equals(id)) {
						return false; // 아이디 존재
					}
				}
				return true;
			}
		});
	}
}