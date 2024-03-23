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
	private static CardLayout menuCardLayout;
	private JPanel beforeLoginPanel;
	private StudentMenuPanel studentMenuPanel;
	private TeacherMenuPanel teacherMenuPanel;
	
	private static JPanel mainCardPanel;
    private static CardLayout mainCardLayout;
    private LoginPanel loginPanel;
    private SignUpPanel signUpPanel;
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
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuCardLayout = new CardLayout();
        mainCardLayout = new CardLayout();
        menuCardPanel = new JPanel(menuCardLayout);
        mainCardPanel = new JPanel(mainCardLayout);

        // 메뉴 카드 레이아웃
        beforeLoginPanel = new BeforeLoginPanel();
        studentMenuPanel = new StudentMenuPanel();
        teacherMenuPanel = new TeacherMenuPanel();
        
        menuCardPanel.add(beforeLoginPanel, "before");
        menuCardPanel.add(studentMenuPanel, "studentMenu");
        menuCardPanel.add(teacherMenuPanel, "teacherMenu");
        
        getContentPane().add(menuCardPanel, BorderLayout.NORTH);
        
        // 메인 카드 레이아웃
        loginPanel = new LoginPanel();
        signUpPanel = new SignUpPanel();
        studentMainPanel = new StudentMainPanel();
        teacherMainPanel = new TeacherMainPanel();

        mainCardPanel.add(loginPanel, "login");
        mainCardPanel.add(signUpPanel, "signup");
        mainCardPanel.add(studentMainPanel, "student");
        mainCardPanel.add(teacherMainPanel, "teacher");

        getContentPane().add(mainCardPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void showMainCard(String cardName) {
        mainCardLayout.show(mainCardPanel, cardName);
    }
    
    public static void showMenuCard(String cardName) {
        menuCardLayout.show(menuCardPanel, cardName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentAttendanceMenuGUI());
    }
}

class LoginPanel extends JPanel {
    public LoginPanel() {
        setLayout(null);

        JLabel titleLabel = new JLabel("로그인");
        titleLabel.setBounds(220, 30, 150, 30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);

        JLabel idLabel = new JLabel("ID: ");
        idLabel.setBounds(100, 100, 80, 25);
        add(idLabel);

        JTextField idText = new JTextField();
        idText.setBounds(180, 100, 160, 25);
        add(idText);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(100, 150, 80, 25);
        add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(180, 150, 160, 25);
        add(passwordText);
        JButton loginButton = new JButton("로그인");
        loginButton.setBounds(250, 200, 100, 30);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idText.getText();
                String password = new String(passwordText.getPassword());

        		for (User elem : StudentAttendanceMenuGUI.userService.getAllUsers()) {
        			if (elem.getId().equals(id) && elem.getPassword().equals(password)) {
        				System.out.println(id + "님 로그인 완료");
        				StudentAttendanceMenuGUI.loginId = id;
        				StudentAttendanceMenuGUI.loginType = elem.getType();
        			}
        		}
                if (StudentAttendanceMenuGUI.loginType != null && StudentAttendanceMenuGUI.loginType.toString().equals("TEACHER")) {
					// 선생님 메뉴
					// 1. 학생 출결 확인, 2. 나의 정보, 3. 로그아웃
                	StudentAttendanceMenuGUI.showMenuCard("teacherMenu");
                	StudentAttendanceMenuGUI.showMainCard("teacher");
				} else if (StudentAttendanceMenuGUI.loginType != null && StudentAttendanceMenuGUI.loginType.toString().equals("STUDENT")) {
					// 학생 메뉴
					// 1. 출석하기, 2. 나의 출석현황, 3. 나의 정보, 4. 로그아웃
					StudentAttendanceMenuGUI.showMenuCard("studentMenu");
					StudentAttendanceMenuGUI.showMainCard("student");
				}
            }
        });
    }
}


class SignUpPanel extends JPanel {
    public SignUpPanel() {
        setLayout(null);

        JLabel titleLabel = new JLabel("회원가입");
        titleLabel.setBounds(220, 30, 150, 30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);

        JLabel idLabel = new JLabel("ID: ");
        idLabel.setBounds(100, 100, 80, 25);
        add(idLabel);

        JTextField idText = new JTextField();
        idText.setBounds(180, 100, 160, 25);
        add(idText);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(100, 150, 80, 25);
        add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(180, 150, 160, 25);
        add(passwordText);
    }
}


class StudentMainPanel extends JPanel {
    public StudentMainPanel() {
        setLayout(null);

        JLabel titleLabel = new JLabel("학생 메뉴");
        titleLabel.setBounds(220, 30, 150, 30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);
    }
}

class TeacherMainPanel extends JPanel {
    public TeacherMainPanel() {
        setLayout(null);

        JLabel titleLabel = new JLabel("선생님 메뉴");
        titleLabel.setBounds(220, 30, 150, 30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);
    }
}

class BeforeLoginPanel extends JPanel {
    public BeforeLoginPanel() {
        JButton mainButton = new JButton("메인");
        JButton signUpButton = new JButton("회원가입");
        JButton loginButton = new JButton("로그인");
        JButton exitButton = new JButton("종료");

        add(mainButton);
        add(signUpButton);
        add(loginButton);
        add(exitButton);

        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentAttendanceMenuGUI.showMainCard("login");
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentAttendanceMenuGUI.showMainCard("login");
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentAttendanceMenuGUI.showMainCard("signup");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(BeforeLoginPanel.this, "프로그램을 종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}
class StudentMenuPanel extends JPanel {
    public StudentMenuPanel() {
        JButton attendanceButton = new JButton("출석하기");
        JButton myAttendanceButton = new JButton("나의 출석현황");
        JButton myInfoButton = new JButton("나의 정보");
        JButton logoutButton = new JButton("로그아웃");

        add(attendanceButton);
        add(myAttendanceButton);
        add(myInfoButton);
        add(logoutButton);

        attendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        myAttendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        myInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}

class TeacherMenuPanel extends JPanel {
    public TeacherMenuPanel() {
        JButton checkAttendanceButton = new JButton("학생 출결 확인");
        JButton myInfoButton = new JButton("나의 정보");
        JButton logoutButton = new JButton("로그아웃");

        add(checkAttendanceButton);
        add(myInfoButton);
        add(logoutButton);

        checkAttendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        myInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}

