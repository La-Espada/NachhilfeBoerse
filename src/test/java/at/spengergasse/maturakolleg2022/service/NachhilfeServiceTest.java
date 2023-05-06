package at.spengergasse.maturakolleg2022.service;


import at.spengergasse.maturakolleg2022.domain.*;
import at.spengergasse.maturakolleg2022.persistence.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class NachhilfeServiceTest {

    @Autowired
    NachhilfeService nachhilfeService;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CoachRepository coachRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    OfferRepository offerRepository;
    @Autowired
    SubjectRepository subjectRepository;





    @Test
    void askForAppointmentSuccessTest(){
        Subject subject = Subject.builder()
                .name("Deutsch")
                .educationType("HTL")
                .term(2)
                .build();
        subjectRepository.save(subject);
        Coach coach = new Coach("x","Cemil","Aslan","asdsad@gmail.com","a34823104832");
        coachRepository.save(coach);
        Student student = Student.builder()
                .firstName("Cemil")
                .lastName("Aslan")
                .email("asl19418@spengergasse.at")
                .userName("ASL19418")
                .build();
        studentRepository.save(student);
        Offer offer = Offer.builder()
                .teacher(coach)
                .dateFrom(LocalDate.now())
                .dateTo(LocalDate.of(2023,5,14))
                .subject(subject)
                .build();
        offerRepository.save(offer);


       boolean passed = nachhilfeService.askForAppointment(offer.getId(),student.getId(),LocalDate.of(2023,5,10));
        assertThat(passed).isEqualTo(true);

    }

    @Test
    void askForAppointmentReturnsFalseIfNoOfferExists(){

    }


    @Test
    void askForAppointmentReturnsFalseIfOutOfDate(){

    }

    @Test

    void confirmAppointmentSuccessTest(){

    }

    @Test
    void confirmAppointmentReturnsFalseIfStateIsInvalid(){

    }

    @Test

    void cancelAppointmentStudentSuccessTest(){


    }

    @Test

    void cancelAppointmentCoachSuccessTest(){

    }

    @Test
    void confirmAppointmentStudentReturnsFalseIfStateIsInvalid(){

    }

    @Test
    void confirmAppointmentCoachReturnsFalseIfStateIsInvalid(){


    }

}
