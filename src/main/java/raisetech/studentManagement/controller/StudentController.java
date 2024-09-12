package raisetech.studentManagement.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.studentManagement.controller.converter.StudentConverter;
import raisetech.studentManagement.data.Student;
import raisetech.studentManagement.data.Students_Courses;
import raisetech.studentManagement.domain.StudentDetail;
import raisetech.studentManagement.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter=converter;
  }



  @GetMapping("/studentList")
  public List<StudentDetail> getStudentList(){
    List<Student> students = service.searchStudentList();
    List<Students_Courses> studentsCourses = service.searchStudentsCourseList();

    return converter.convertStudentDetails(students, studentsCourses);
  }



  @GetMapping("/studentsCourseList")
  public List<Students_Courses> getStudentCourseList(){
    return service.searchStudentsCourseList();
  }

}
