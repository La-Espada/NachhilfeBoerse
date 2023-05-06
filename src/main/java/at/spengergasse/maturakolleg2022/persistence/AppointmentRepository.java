package at.spengergasse.maturakolleg2022.persistence;

import at.spengergasse.maturakolleg2022.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
