package at.spengergasse.maturakolleg2022.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "offer")
public class Offer extends AbstractPersistable<Long> {
    @NotNull
    private LocalDate dateFrom;
    @NotNull
    private LocalDate dateTo;

    @OneToMany(mappedBy = "offer", cascade =CascadeType.REMOVE)
    private List<Appointment> appointmentList;


    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "coach_id", referencedColumnName = "id")
    private Coach teacher;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

}
