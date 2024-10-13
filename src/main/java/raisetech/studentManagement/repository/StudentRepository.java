package raisetech.studentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import raisetech.studentManagement.data.Student;
import raisetech.studentManagement.data.StudentsCourses;



@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> searchCourses();




  @Insert(
      "INSERT INTO students(name,kana_name,nick_name,email,area,age,sex,remark,isDeleted)"
      + " VALUES(#{name},#{kanaName},#{nickName},#{email},#{area},#{age},#{sex},#{remark},false)")
  @Options(useGeneratedKeys = true,keyProperty = "id")
  void registerStudent(Student student);



}
