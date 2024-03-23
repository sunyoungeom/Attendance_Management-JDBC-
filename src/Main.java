import java.util.Scanner;

import User.User;
import User.UserDAO;
import User.UserService;
import User.UserType;

public class Main {
	public static void main(String[] args) {
		UserService service = new UserService();
//		dao.readUserById("asdf");
//		dao.updateUser("asdf", "asdf", UserType.TEACHER);
//		dao.readUserById("asdf");
//		User u = new User("d", "d", UserType.STUDENT);
//		System.out.println(u.getId());
		Scanner scanner = new Scanner(System.in);
		
		// 사용자로부터 입력 받기
        System.out.print("사용자 ID를 입력하세요: ");
        String id = scanner.nextLine();

        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.nextLine();

        System.out.print("사용자 유형을 입력하세요 (STUDENT 또는 TEACHER): ");
        String userTypeStr = scanner.nextLine();
        UserType userType = UserType.valueOf(userTypeStr.toUpperCase());

        service.createUser(id, password, userType);

//        scanner.close();
	}
}
