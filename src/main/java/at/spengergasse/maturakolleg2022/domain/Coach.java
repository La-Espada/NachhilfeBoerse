package at.spengergasse.maturakolleg2022.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coach")
public class Coach extends Student{
    @NotNull
    private String phoneNumber;

    public Coach(String username, String firstname,String lastname,String email, String phoneNumber){
        super(firstname,lastname,email,username);
        this.phoneNumber = phoneNumber;
    }
}
