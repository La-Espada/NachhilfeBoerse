package at.spengergasse.maturakolleg2022.persistence;

import at.spengergasse.maturakolleg2022.domain.Coach;
import at.spengergasse.maturakolleg2022.domain.Offer;
import at.spengergasse.maturakolleg2022.domain.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class OfferRepositoryTest {

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    CoachRepository coachRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Test
    void addOfferSuccessTest(){
        Subject subject = Subject.builder()
                .name("Deutsch")
                .term(2)
                .educationType("HTL")
                .build();
        subjectRepository.save(subject);

        Coach coach = new Coach("x","cemil","aslan","cemi@gmail.com","4435435435353");
        coachRepository.save(coach);

        Offer offer = Offer.builder()
                .teacher(coach)
                .dateFrom(LocalDate.now())
                .dateTo(LocalDate.of(2023,5,14))
                .subject(subject)
                .build();


        var saved = offerRepository.save(offer);
        var find = offerRepository.findBySubjectName("Deutsch");

        assertThat(find).isEqualTo(saved);


    }

}
