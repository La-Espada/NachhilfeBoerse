package at.spengergasse.maturakolleg2022.service;


import at.spengergasse.maturakolleg2022.domain.Appointment;
import at.spengergasse.maturakolleg2022.domain.AppointmentState;
import at.spengergasse.maturakolleg2022.domain.Offer;
import at.spengergasse.maturakolleg2022.domain.Student;
import at.spengergasse.maturakolleg2022.persistence.AppointmentRepository;
import at.spengergasse.maturakolleg2022.persistence.OfferRepository;
import at.spengergasse.maturakolleg2022.persistence.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class NachhilfeService {


    @Autowired
    StudentRepository studentRepository;
    @Autowired
    OfferRepository offerRepository;
    @Autowired
    AppointmentRepository appointmentRepository;

    public boolean askForAppointment(Long offerId, Long studentId, LocalDate date){
        boolean passed = false;
        Offer offer = null;
        Student student = null;
        Appointment appointment = null;

        var offerTemp = offerRepository.findById(offerId);
        var studentTemp = studentRepository.findById(studentId);

        if(offerTemp.isPresent() && studentTemp.isPresent()){
            offer = offerTemp.get();
            student = studentTemp.get();
            if(date.isBefore(offer.getDateTo())&& date.isAfter(offer.getDateFrom())&& date.isEqual(offer.getDateFrom()) && date.isEqual(offer.getDateTo())){
             appointment = Appointment.builder().appointmentState(AppointmentState.AskedFor).date(date).location("Bibiliothek").offer(offer).student(student).build();
             offer.getAppointmentList().add(appointment);

             appointmentRepository.save(appointment);
             passed = true;
             return passed;
            }
        }
        return passed;
    }

    private boolean ConfirmAppointment(Long appointmentId){
        boolean passed = false;
        Appointment appointment = null;

        var appointmentTemp = appointmentRepository.findById(appointmentId);
        if(appointmentTemp.isPresent()){
            appointment = appointmentTemp.get();
            if(appointment.getAppointmentState().equals(AppointmentState.Confirmed) || appointment.getAppointmentState().equals(AppointmentState.Cancelled) || appointment.getAppointmentState().equals(AppointmentState.TookPlace)){
                return passed;
            }
            appointment.setAppointmentState(AppointmentState.Confirmed);
            appointmentRepository.save(appointment);
            passed = true;
            return passed;
        }
        // returns false
       return passed;
    }

    private boolean CancelAppointment(Long appointmentId, Long studentId){
        boolean passed = false;

        Appointment appointment = null;
        Student student = null;

        var studentTemp = studentRepository.findById(studentId);
        var appointmentTemp = appointmentRepository.findById(appointmentId);
        if(appointmentTemp.isPresent() && studentTemp.isPresent()){
            appointment = appointmentTemp.get();
            student = studentTemp.get();
            if(studentId == appointment.getOffer().getTeacher().getId()){
                if(appointment.getAppointmentState().equals(AppointmentState.AskedFor) || appointment.getAppointmentState().equals(AppointmentState.Confirmed)){
                    appointment.setAppointmentState(AppointmentState.Cancelled);
                    appointmentRepository.save(appointment);
                    passed = true;
                    return passed;
                }
            }
            else{
                if(appointment.getAppointmentState().equals(AppointmentState.AskedFor)){
                    appointment.setAppointmentState(AppointmentState.Cancelled);
                    appointmentRepository.save(appointment);
                    passed = true;
                    return passed;
                }
            }
        }
        return passed;
    }

}
