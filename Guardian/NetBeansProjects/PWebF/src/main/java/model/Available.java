package model;

import dao.PersistDB;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "tb_avalable")
public class Available implements PersistDB{
    @Id
    @GeneratedValue
    @Column(name = "ava_id")
    private int id;
    @OneToMany
    @JoinColumn(name = "ava_day_id")
    private List<Day> days;
    @OneToOne
    @JoinColumn(name = "ava_tea_id")
    private Teacher teacher;

    public Available() {
    }

    public Available(int id, List<Day> days, Teacher teacher) {
        this.id = id;
        this.days = days;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Available{" + "id=" + id + ", days=" + days + ", teacher=" + teacher + '}';
    }

}
