package Swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentMainPanel extends JPanel {
	private StudentAttendanceMenuGUI frame;

	public StudentMainPanel(StudentAttendanceMenuGUI frame) {
		setBackground(Color.WHITE);
		setSize(600, 500);
		this.frame = frame;
		setLayout(null);

		JLabel titleLabel = new JLabel("학생 메뉴");
		titleLabel.setBounds(220, 30, 150, 30);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel);

		JButton btnNewButton = new JButton("출석하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(220, 136, 130, 30);
		setButtonGUI(btnNewButton);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("나의 출석현황");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(220, 219, 130, 30);
		setButtonGUI(btnNewButton_1);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("나의 정보");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(220, 293, 130, 30);
		setButtonGUI(btnNewButton_2);
		add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("로그아웃");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.loginId = "";
				frame.loginType = null;
				frame.showMainCard("login");
			}
		});
		btnNewButton_3.setBounds(220, 377, 130, 30);
		setButtonGUI(btnNewButton_3);
		add(btnNewButton_3);
	}

	private void setButtonGUI(JButton btn) {
		btn.setBackground(new Color(204, 204, 204));
		btn.setOpaque(true);
		btn.setBorderPainted(false);
		btn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	}
}