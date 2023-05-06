package at.spengergasse.maturakolleg2022.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "subject")
public class Subject extends AbstractPersistable<Long> {
    @NotNull
    private int term;
    @NotBlank
    private String name;
    @NotBlank
    private String educationType;
}
