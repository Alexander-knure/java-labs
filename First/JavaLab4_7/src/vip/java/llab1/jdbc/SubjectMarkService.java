package vip.java.llab1.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
public class SubjectMarkService {
private SubjectMarkDAOMySQL subjectMarkDAO;
public SubjectMarkService(SubjectMarkDAOMySQL subjectMarkDAO) {
this.subjectMarkDAO = subjectMarkDAO;
}
public void createSubjectMark(SubjectMark subjectMark) throws SQLException {
Connection connection = ConnectionFactory.getConnection();
try {
subjectMarkDAO.create(connection, subjectMark);
connection.commit();
} catch (SQLException e) {
connection.rollback();
throw e;
}
}
public void updateSubjectMark(SubjectMark subjectMark) throws SQLException {
Connection connection = ConnectionFactory.getConnection();
try {
subjectMarkDAO.update(connection, subjectMark);
connection.commit();
} catch (SQLException e) {
connection.rollback();
throw e;
}
}
public List<SubjectMark> getSubjectMarkByStudentId(int studentId) throws
SQLException {

Connection connection = ConnectionFactory.getConnection();
try {
List<SubjectMark> subjectMarks =
subjectMarkDAO.getByStudentId(connection, studentId);

connection.commit();
return subjectMarks;
} catch (SQLException e) {
connection.rollback();
throw e;
}
}
}