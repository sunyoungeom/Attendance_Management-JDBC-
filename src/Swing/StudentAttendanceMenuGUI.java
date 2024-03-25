package Swing;
import javax.swing.*;

import Attendance.AttendanceService;
import Classroom.ClassroomService;
import User.User;
import User.UserService;
import User.UserType;
import User.Student.StudentService;
import User.Teacher.TeacherService;

import java.awt.*;
import java.awt.event.*;

public class StudentAttendanceMenuGUI extends JFrame {
	private static JPanel menuCardPanel;
//	private StudentMenuPanel studentMenuPanel;
//	private TeacherMenuPanel teacherMenuPanel;
	
	private static JPanel mainCardPanel;
    private static CardLayout mainCardLayout;
    private LoginPanel loginPanel;
    private SignUpPanel signUpPanel;
    private TeacherSignUpPanel teacherSignUpPanel;
    private StudentSignUpPanel studentSignUpPanel;
    private StudentMainPanel studentMainPanel;
    private TeacherMainPanel teacherMainPanel;
    
    public static UserService userService = new UserService();
	public static TeacherService teaService = new TeacherService();
	public static StudentService stuService = new StudentService();
	public static ClassroomService classService = new ClassroomService();
	public static AttendanceService attendService = new AttendanceService();

	public static String loginId = "";
	public static UserType loginType = null;

    public StudentAttendanceMenuGUI() {
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainCardLayout = new CardLayout();
        mainCardPanel = new JPanel(mainCardLayout);

        // 메인 카드 레이아웃
        loginPanel = new LoginPanel(StudentAttendanceMenuGUI.this);
        signUpPanel = new SignUpPanel(StudentAttendanceMenuGUI.this);
        teacherSignUpPanel = new TeacherSignUpPanel(StudentAttendanceMenuGUI.this);
        studentSignUpPanel = new StudentSignUpPanel(StudentAttendanceMenuGUI.this);
        studentMainPanel = new StudentMainPanel(StudentAttendanceMenuGUI.this);
        teacherMainPanel = new TeacherMainPanel(StudentAttendanceMenuGUI.this);

        mainCardPanel.add(loginPanel, "login");
        mainCardPanel.add(signUpPanel, "signUp");
        mainCardPanel.add(teacherSignUpPanel, "teacherSignUp");
        mainCardPanel.add(studentSignUpPanel, "studentSignUp");
        mainCardPanel.add(studentMainPanel, "student");
        mainCardPanel.add(teacherMainPanel, "teacher");

        getContentPane().add(mainCardPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void showMainCard(String cardName) {
        mainCardLayout.show(mainCardPanel, cardName);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentAttendanceMenuGUI());
    }
}








//class BeforeLoginPanel extends JPanel {
//    public BeforeLoginPanel() {
//        JButton mainButton = new JButton("메인");
//        JButton signUpButton = new JButton("회원가입");
//        JButton loginButton = new JButton("로그인");
//        JButton exitButton = new JButton("종료");
//
//        add(mainButton);
//        add(signUpButton);
//        add(loginButton);
//        add(exitButton);
//
//        mainButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                StudentAttendanceMenuGUI.showMainCard("login");
//            }
//        });
//
//        loginButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                StudentAttendanceMenuGUI.showMainCard("login");
//            }
//        });
//
//        signUpButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                StudentAttendanceMenuGUI.showMainCard("signup");
//            }
//        });
//
//        exitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int result = JOptionPane.showConfirmDialog(BeforeLoginPanel.this, "프로그램을 종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
//                if (result == JOptionPane.YES_OPTION) {
//                    System.exit(0);
//                }
//            }
//        });
//    }
//}
//class StudentMenuPanel extends JPanel {
//    public StudentMenuPanel() {
//        JButton attendanceButton = new JButton("출석하기");
//        JButton myAttendanceButton = new JButton("나의 출석현황");
//        JButton myInfoButton = new JButton("나의 정보");
//        JButton logoutButton = new JButton("로그아웃");
//
//        add(attendanceButton);
//        add(myAttendanceButton);
//        add(myInfoButton);
//        add(logoutButton);
//
//        attendanceButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
//
//        myAttendanceButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
//
//        myInfoButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
//
//        logoutButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
//    }
//}
//
//class TeacherMenuPanel extends JPanel {
//    public TeacherMenuPanel() {
//        JButton checkAttendanceButton = new JButton("학생 출결 확인");
//        JButton myInfoButton = new JButton("나의 정보");
//        JButton logoutButton = new JButton("로그아웃");
//
//        add(checkAttendanceButton);
//        add(myInfoButton);
//        add(logoutButton);
//
//        checkAttendanceButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
//
//        myInfoButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
//
//        logoutButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
//    }
//}
//
