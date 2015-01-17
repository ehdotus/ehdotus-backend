package ehdotus.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Difficulty extends AbstractPersistable<Long> {

    private LocalDateTime enteredTime;
    private int estimatedDifficulty;
    private int realDifficulty;

    public Difficulty() {
        this.enteredTime = LocalDateTime.now();
    }

    public LocalDateTime getEnteredTime() {
        return enteredTime;
    }

    public void setEnteredTime(LocalDateTime enteredTime) {
        this.enteredTime = enteredTime;
    }

    public int getEstimatedDifficulty() {
        return estimatedDifficulty;
    }

    public void setEstimatedDifficulty(int estimatedDifficulty) {
        this.estimatedDifficulty = estimatedDifficulty;
    }

    public int getRealDifficulty() {
        return realDifficulty;
    }

    public void setRealDifficulty(int realDifficulty) {
        this.realDifficulty = realDifficulty;
    }

}
