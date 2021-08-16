package mk.ukim.finki.icareapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DiaryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    private LocalDate dateTime;

    private Feelings_diary feeling;

    private Activity_diary activity;

    @Lob
    @Column
    private String day_description;

    private int water;

    private int meals;

    private int fresh_air;

    private boolean vitamins;

    private boolean meditation;

    private boolean yoga;

    private boolean good_sleep;

    public DiaryRecord(User user, LocalDate dateTime, Feelings_diary feeling, Activity_diary activity, String day_description, int water, int meals, int fresh_air, boolean vitamins, boolean meditation, boolean yoga, boolean good_sleep) {
        this.user = user;
        this.dateTime = dateTime;
        this.feeling = feeling;
        this.activity = activity;
        this.day_description = day_description;
        this.water = water;
        this.meals = meals;
        this.fresh_air = fresh_air;
        this.vitamins = vitamins;
        this.meditation = meditation;
        this.yoga = yoga;
        this.good_sleep = good_sleep;
    }
}
