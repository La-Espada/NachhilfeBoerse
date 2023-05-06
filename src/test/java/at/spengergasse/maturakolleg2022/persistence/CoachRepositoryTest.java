package at.spengergasse.maturakolleg2022.persistence;

import at.spengergasse.maturakolleg2022.domain.Coach;
import at.spengergasse.maturakolleg2022.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class CoachRepositoryTest {

    @Autowired
    private CoachRepository coachRepository;


    @Test
    void addCoachSuccessTest(){
        Coach coach = new Coach("x","Cemil","Aslan","asdsad@gmail.com","a34823104832");


        var saved = coachRepository.save(coach);
        var find = coachRepository.findByFirstNameAndLastName("Cemil", "Aslan");
        assertThat(find).isEqualTo(saved);

    }
}
