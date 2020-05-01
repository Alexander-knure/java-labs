package vip.java.llab1.jdbc;
import java.sql.SQLException;
import java.util.List;
public class Demo {
	/*
public static void main(String[] args) throws SQLException {
/////Student Test////
System.out.println("Student test");
StudentDAOMySQL studentDAO = new StudentDAOMySQL();
StudentService studentService = new StudentService(studentDAO);
Student student1 = new Student();
student1.setFname("Petro");
student1.setLname("Gorbenko");
student1.setGroup("KI-12-3");
student1.setAge(19);
Student student2 = new Student();
student2.setFname("Ivan");
student2.setLname("Ivanov");
student2.setGroup("KI-12-4");
student2.setAge(21);
studentService.createStudent(student1);
studentService.createStudent(student2);

List<Student> studentsByGroup = studentService.getStudentsByGroup("KI-12-4");

System.out.println("Student with group KI-12-4: " + studentsByGroup);
studentsByGroup = studentService.getStudentsByGroup("KI-12-3");
student1 = studentsByGroup.get(0);
student1.setGroup("KI-12-4");
studentService.updateStudent(student1);
studentsByGroup = studentService.getStudentsByGroup("KI-12-4");
System.out.println("Student with group KI-12-4: " + studentsByGroup);
/////SubjectMark Test////
System.out.println();
System.out.println("SubjectMark test");
SubjectMarkDAOMySQL subjectMarkDAO = new SubjectMarkDAOMySQL();
SubjectMarkService markService = new SubjectMarkService(subjectMarkDAO);
SubjectMark subjectMark1 = new SubjectMark();
subjectMark1.setStudentId(student1.getId());
subjectMark1.setSubjectName("Java");
subjectMark1.setMark(5);
markService.createSubjectMark(subjectMark1);
List<SubjectMark> subjectMarksByStudentId =
markService.getSubjectMarkByStudentId(student1.getId());

System.out.println("Subjects and marks for student " +

student1.getFname() + ":" + subjectMarksByStudentId);
}*/
}