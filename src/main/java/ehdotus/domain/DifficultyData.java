package ehdotus.domain;

import java.time.LocalDateTime;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class DifficultyData extends AbstractPersistable<Long> {

    private LocalDateTime enteredTime;
    private Integer estimatedDifficulty;
    private Integer realDifficulty;
    private String userId;
    private String course;
    private String exercise;

    @ElementCollection
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    @CollectionTable(name = "attributes", joinColumns = @JoinColumn(name = "difficultydata_id"))
    private Map<String, String> content;

    public LocalDateTime getEnteredTime() {
        return enteredTime;
    }

    public void setEnteredTime(LocalDateTime enteredTime) {
        this.enteredTime = enteredTime;
    }

    public Integer getEstimatedDifficulty() {
        return estimatedDifficulty;
    }

    public void setEstimatedDifficulty(Integer estimatedDifficulty) {
        this.estimatedDifficulty = estimatedDifficulty;
    }

    public Integer getRealDifficulty() {
        return realDifficulty;
    }

    public void setRealDifficulty(Integer realDifficulty) {
        this.realDifficulty = realDifficulty;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public Map<String, String> getContent() {
        return content;
    }

    public void setContent(Map<String, String> content) {
        this.content = content;
    }

}
