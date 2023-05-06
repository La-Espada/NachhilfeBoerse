package at.spengergasse.maturakolleg2022.persistence;

import at.spengergasse.maturakolleg2022.domain.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach,Long> {
    Coach findByFirstNameAndLastName(String firstName, String lastName);
}
