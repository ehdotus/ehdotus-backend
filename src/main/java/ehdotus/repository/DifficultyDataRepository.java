package ehdotus.repository;

import ehdotus.domain.DifficultyData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DifficultyDataRepository extends JpaRepository<DifficultyData, Long> {

}
