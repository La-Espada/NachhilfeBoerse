package at.spengergasse.maturakolleg2022.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "appointment")
public class Appointment extends AbstractPersistable<Long> {

    private LocalDate date;
    @NotBlank
    private String location;
    @Enumerated(EnumType.STRING)
    private AppointmentState appointmentState;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne()
    @JoinColumn(name = "offer_id", referencedColumnName ="id")
    private Offer offer;
}
