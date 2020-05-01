package vip.java.llab1.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Statement;
public class SubjectMarkDAOMySQL {
private static final String SQL_UPDATE_SUBJECT_MARK = "UPDATE subject_mark SET id_students = ?, subject_name = ?, "

+ "mark = ?, WHERE id = ? ";

private static final String SQL_INSERT_INTO_SUBJECT_MARK = "INSERT INTO subject_mark (id_students, subject_name, mark)"
+ " VALUES (?,?,?)";

private static final String SQL_SELECET_BY_STUDENT_ID = "SELECT * FROM subject_mark WHERE id_students = ?";
public void create(Connection connection, SubjectMark subjectMark) throws
SQLException {

PreparedStatement prStatement =

connection.prepareStatement(SQL_INSERT_INTO_SUBJECT_MARK,
Statement.RETURN_GENERATED_KEYS);

setInsertStatementParameters(subjectMark, prStatement);
prStatement.executeUpdate();
prStatement.close();
}
public void update(Connection connection, SubjectMark subjectMark) throws
SQLException {

PreparedStatement prStatement =
connection.prepareStatement(SQL_UPDATE_SUBJECT_MARK);

setUpdateStatementParameters(subjectMark, prStatement);
prStatement.executeUpdate();
prStatement.close();
}
public List<SubjectMark> getByStudentId(Connection connection, int studentId)
throws SQLException {

PreparedStatement prStatement =

connection.prepareStatement(SQL_SELECET_BY_STUDENT_ID);

prStatement.setInt(1, studentId);
ResultSet rs = prStatement.executeQuery();
List<SubjectMark> subjectMarks = getStudents(rs);
prStatement.close();
return subjectMarks;
}
private List<SubjectMark> getStudents(ResultSet rs) throws SQLException {
List<SubjectMark> students = new ArrayList<SubjectMark>();
while (rs.next())
students.add(getSubjectMark(rs));
return students;
}
private SubjectMark getSubjectMark(ResultSet rs) throws SQLException {
SubjectMark subjectMark = new SubjectMark();
subjectMark.setId(rs.getInt("id"));
subjectMark.setStudentId(rs.getInt("id_students"));
subjectMark.setSubjectName(rs.getString("subject_name"));
subjectMark.setMark(rs.getInt("mark"));
return subjectMark;
}
private void setUpdateStatementParameters(SubjectMark subjectMark,
PreparedStatement prStatement) throws SQLException {

int k = 1;
prStatement.setInt(k++, subjectMark.getStudentId());
prStatement.setString(k++, subjectMark.getSubjectName());
prStatement.setInt(k++, subjectMark.getMark());
prStatement.setInt(k++, subjectMark.getId());
}
private void setInsertStatementParameters(SubjectMark subjectMark,
PreparedStatement prStatement) throws SQLException {

int k = 1;
prStatement.setInt(k++, subjectMark.getStudentId());

prStatement.setString(k++, subjectMark.getSubjectName());
prStatement.setInt(k++, subjectMark.getMark());
}
}