package vip.java.llab1.jdbc;
public class SubjectMark {
private int id;
private int studentId;
private String subjectName;
private int mark;
public int getId() {

return id;
}
public void setId(int id) {
this.id = id;
}
public int getStudentId() {
return studentId;
}
public void setStudentId(int studentId) {
this.studentId = studentId;
}
public String getSubjectName() {
return subjectName;
}
public void setSubjectName(String subjectName) {
this.subjectName = subjectName;
}
public int getMark() {
return mark;
}
public void setMark(int mark) {
this.mark = mark;
}
@Override
public String toString() {
return "SubjectMark [id=" + id + ", studentId=" + studentId + ",subjectName=" 
+ subjectName + ", mark=" + mark + "]";
}
}