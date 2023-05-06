package at.spengergasse.maturakolleg2022.persistence;

import at.spengergasse.maturakolleg2022.domain.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class SubjectRepositoryTest {

    @Autowired
    SubjectRepository subjectRepository;

    @Test
    void addSubjectSuccessTest(){
        Subject subject = Subject.builder()
                .name("Deutsch")
                .educationType("HTL")
                .term(2)
                .build();


        var saved = subjectRepository.save(subject);
        var find = subjectRepository.findByNameAndEducationTypeAndTerm("Deutsch","HTL",2);
        assertThat(find).isEqualTo(saved);

    }






}
