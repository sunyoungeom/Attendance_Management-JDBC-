package Swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

public class TeacherSignUpPanel extends JPanel {

	private StudentAttendanceMenuGUI frame;

	public TeacherSignUpPanel(StudentAttendanceMenuGUI frame) {
		setBackground(Color.WHITE);
		setSize(600, 500);
		this.frame = frame;
        setLayout(null);

        JLabel titleLabel = new JLabel("선생님 가입메뉴");
		titleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		titleLabel.setBounds(303, 120, 178, 30);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel);

		JLabel idLabel = new JLabel("이름: ");
		idLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		idLabel.setBounds(270, 180, 80, 25);
		add(idLabel);

		JTextField idText = new JTextField();
		idText.setBorder(new LineBorder(new Color(126, 126, 126)));
		idText.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		idText.setBounds(360, 180, 160, 25);
		add(idText);

		JLabel passwordLabel = new JLabel("학년/반: ");
		passwordLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		passwordLabel.setBounds(270, 224, 80, 25);
		add(passwordLabel);
		JButton loginButton = new JButton("확인");
		loginButton.setBackground(new Color(153, 204, 255));
		loginButton.setOpaque(true);
		loginButton.setBorderPainted(false);
		loginButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		loginButton.setBounds(270, 319, 250, 44);
		add(loginButton);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(LoginPanel.class.getResource("/Swing/free-icon-student-2784410.png")));
		lblNewLabel.setBounds(85, 120, 160, 250);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("돌아가기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 가입취소 확인 메시지
				frame.showMainCard("signUp");
			}
		});
		btnNewButton.setBounds(270, 272, 250, 30);
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBox.setBounds(356, 225, 169, 27);
		add(comboBox);

	}
}
