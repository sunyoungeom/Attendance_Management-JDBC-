package Attendance;

import java.time.LocalDate;
import java.util.List;

public class AttendanceService {

    public void createAttendance(int studentId, int classroomId, LocalDate date, Status status) {
        AttendanceDAO.createAttendance(studentId, classroomId, date, status);
    }

    public List<Attendance> getAllAttendances() {
        return AttendanceDAO.getAllAttendances();
    }

    public void updateAttendance(int attendanceId, int studentId, int classroomId, LocalDate date, Status status) {
        AttendanceDAO.updateAttendance(attendanceId, studentId, classroomId, date, status);
    }

    public void deleteAttendance(int attendanceId) {
        AttendanceDAO.deleteAttendance(attendanceId);
    }
}
