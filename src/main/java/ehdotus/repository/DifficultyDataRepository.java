package ehdotus.repository;

import ehdotus.domain.DifficultyData;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DifficultyDataRepository extends JpaRepository<DifficultyData, Long> {

    List<DifficultyData> findByUserId(String userId);
}
