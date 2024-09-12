package raisetech.studentManagement.controller.converter;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import raisetech.studentManagement.data.Student;
import raisetech.studentManagement.data.Students_Courses;
import raisetech.studentManagement.domain.StudentDetail;

@Component
public class StudentConverter {

  public  List<StudentDetail> convertStudentDetails(List<Student> students,
      List<Students_Courses> studentsCourses) {
    List<StudentDetail> studentDetails=new ArrayList<>();
    students.forEach(student -> {
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudent(student);

      List<Students_Courses> convertStudentCourse = studentsCourses.stream()
          .filter(studentCourse -> student.getId().equals(studentCourse.getStudentId()))
          .collect(Collectors.toList());

      studentDetail.setStudentsCourses(convertStudentCourse);
      studentDetails.add(studentDetail);
    });
    return studentDetails;
  }

}
