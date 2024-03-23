import java.util.List;
import java.util.Scanner;

import Attendance.AttendanceService;
import Classroom.ClassroomService;
import User.User;
import User.UserDAO;
import User.UserService;
import User.UserType;
import User.Student.StudentDAO;
import User.Student.StudentService;
import User.Teacher.Teacher;
import User.Teacher.TeacherService;

public class Main {
	public static Scanner scan = new Scanner(System.in);
	public static UserService userService = new UserService();
	public static TeacherService teaService = new TeacherService();
	public static StudentService stuService = new StudentService();
	public static ClassroomService classService = new ClassroomService();
	public static AttendanceService attendService = new AttendanceService();

	public static String loginId = "";
	public static UserType loginType = null;
	static boolean mainMenu = true;

	public static void main(String[] args) {

		while (true) {
			printStartMenu();
			String input = scan.next();

			// 메인메뉴 출력
			// 1. 회원가입, 2. 로그인, 3. 종료
			switch (input) {
			case "1":
				printSignUpMenu();
				break;
			case "2":
				printLoginMenu();
				// 사용자 유형에 따른 메뉴 출력
				if (loginType != null && loginType.toString().equals("TEACHER")) {
					// 선생님 메뉴
					// 1. 학생 출결 확인, 2. 나의 정보, 3. 로그아웃
					printTeacherLoginMenu();
				} else if (loginType != null && loginType.toString().equals("STUDENT")) {
					// 학생 메뉴
					// 1. 출석하기, 2. 나의 출석현황, 3. 나의 정보, 4. 로그아웃
					printStudentLoginMenu();
				}
				break;
			case "3":
				return;
			default:
				System.out.println("올바른 숫자를 입력하세요.");
			}
		}
	}

	private static void printStudentLoginMenu() {
		boolean studentMenu = true;
		while (studentMenu) {
			printStudentMenu();
			String loginInput = scan.next();

			// 학생 메뉴
			// 1. 출석하기, 2. 나의 출석현황, 3. 나의 정보, 4. 로그아웃
			switch (loginInput) {
			case "1":
				attendService.createAttendance(loginId);
				System.out.println("출석 완료되었습니다.");
				break;
			case "2":
				System.out.println(attendService.getAttendanceById(loginId).toString());
				break;
			case "3":
				System.out.println(stuService.getStudentInfo(loginId));
				break;
			case "4":
				loginId = "";
				studentMenu = false;
				break;
			default:
				System.out.println("올바른 숫자를 입력하세요.");

			}
		}
	}

	private static void printTeacherLoginMenu() {
		boolean teacherMenu = true;
		while (teacherMenu) {
			printTeacherMenu();
			String loginInput = scan.next();

			// 선생님 메뉴
			// 1. 학생 출결 확인, 2. 나의 정보, 3. 로그아웃
			switch (loginInput) {
			case "1":
				System.out.println(attendService.getAllAttendances(loginId).toString());
				break;
			case "2":
				Teacher t = teaService.getTeacherInfo(loginId);
				System.out.println(t.toString());
				break;
			case "3":
				loginId = "";
				teacherMenu = false;
				break;
			default:
				System.out.println("올바른 숫자를 입력하세요.");

			}
		}
	}

	// 메인메뉴 출력
	// 1. 회원가입, 2. 로그인, 3. 종료
	private static void printStartMenu() {
		System.out.println("[ 메뉴 ]");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 종료");
	}

	// 학생 메뉴
	// 1. 출석하기, 2. 나의 출석현황, 3. 나의 정보, 4. 로그아웃
	private static void printStudentMenu() {
		System.out.println("[ 메뉴 ]");
		System.out.println("1. 출석하기");
		System.out.println("2. 나의 출석현황");
		System.out.println("3. 나의 정보");
		System.out.println("4. 로그아웃");
	}

	// 선생님 메뉴
	// 1. 학생 출결 확인, 2. 나의 정보, 3. 돌아가기
	private static void printTeacherMenu() {
		System.out.println("[ 메뉴 ]");
		System.out.println("1. 학생 출결 확인");
		System.out.println("2. 나의 정보");
		System.out.println("3. 로그아웃");
	}

	private static void printLoginMenu() {
		System.out.print("ID: ");
		String id = scan.next();

		System.out.print("Password: ");
		String password = scan.next();

		for (User elem : userService.getAllUsers()) {
			if (elem.getId().equals(id) && elem.getPassword().equals(password)) {
				System.out.println(id + "님 로그인 완료");
				loginId = id;
				loginType = elem.getType();
				mainMenu = false;
			}
		}
	}

	private static void printSignUpMenu() {
		System.out.print("ID: ");
		String id = scan.next();

		System.out.print("Password: ");
		String password = scan.next();

		System.out.print("UserType[STUDENT/TEACHER]: ");
		String userTypeStr = scan.next();
		UserType userType = UserType.valueOf(userTypeStr.toUpperCase());

		userService.createUser(id, password, userType);
		System.out.println("회원가입이 완료되었습니다.");
	}
}
