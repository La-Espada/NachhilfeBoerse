package at.spengergasse.maturakolleg2022.persistence;

import at.spengergasse.maturakolleg2022.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;



@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    void AddStudentSuccessTest(){
        Student student = Student.builder()
                .firstName("Cemil")
                .lastName("Aslan")
                .email("asl19418@spengergasse.at")
                .userName("ASL19418")
                .build();


        var saved = studentRepository.save(student);
        var find = studentRepository.findByFirstNameAndLastName("Cemil","Aslan");
        assertThat(find).isEqualTo(saved);
    }
}
