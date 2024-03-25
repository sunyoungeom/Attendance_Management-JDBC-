package Swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TeacherMainPanel extends JPanel {
    private StudentAttendanceMenuGUI frame;

	public TeacherMainPanel(StudentAttendanceMenuGUI frame) {
    	setBackground(Color.WHITE);
		setSize(600, 500);
		this.frame = frame;
        setLayout(null);

        JLabel titleLabel = new JLabel("선생님 메뉴");
        titleLabel.setBounds(220, 30, 150, 30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);
        
        JButton btnNewButton = new JButton("학생 출결확인");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBounds(220, 136, 130, 30);
        setButtonGUI(btnNewButton);
        add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("나의 정보");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1.setBounds(220, 219, 130, 30);
        setButtonGUI(btnNewButton_1);
        add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("로그아웃");
        btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.loginId = "";
				frame.loginType = null;
				frame.showMainCard("login");
			}
		});
        btnNewButton_2.setBounds(220, 293, 130, 30);
        setButtonGUI(btnNewButton_2);
        add(btnNewButton_2);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(16, 16, 61, 16);
        add(lblNewLabel);
    }
	
	private void setButtonGUI(JButton btn) {
		btn.setBackground(new Color(204, 204, 204));
		btn.setOpaque(true);
		btn.setBorderPainted(false);
		btn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	}
}