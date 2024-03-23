package Attendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jdbc.JDBCProgram;

public class AttendanceDAO {
    private static DataSource dataSource = JDBCProgram.getInstance();

    public static void createAttendance(int studentId, int classroomId, LocalDate date, Status status) {
        String sql = "INSERT INTO Attendance (Student_ID, Classroom_ID, Date, Status) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, classroomId);
            stmt.setDate(3, java.sql.Date.valueOf(date));
            stmt.setString(4, status.toString());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Attendance> getAllAttendances() {
        List<Attendance> attendances = new ArrayList<>();
        String sql = "SELECT * FROM Attendance";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                int attendanceId = resultSet.getInt("Attendance_ID");
                int studentId = resultSet.getInt("Student_ID");
                int classroomId = resultSet.getInt("Classroom_ID");
                LocalDate date = resultSet.getDate("Date").toLocalDate();
                Status status = Status.valueOf(resultSet.getString("Status"));
                Attendance attendance = new Attendance(studentId, classroomId, date, status);
                attendances.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendances;
    }

    public static void updateAttendance(int attendanceId, int studentId, int classroomId, LocalDate date, Status status) {
        String sql = "UPDATE Attendance SET Student_ID = ?, Classroom_ID = ?, Date = ?, Status = ? WHERE Attendance_ID = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, classroomId);
            stmt.setDate(3, java.sql.Date.valueOf(date));
            stmt.setString(4, status.toString());
            stmt.setInt(5, attendanceId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAttendance(int attendanceId) {
        String sql = "DELETE FROM Attendance WHERE Attendance_ID = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, attendanceId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
