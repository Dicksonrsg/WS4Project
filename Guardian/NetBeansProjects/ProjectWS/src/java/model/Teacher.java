
package model;

import java.util.List;

public class Teacher {
    
    private int id;
    private String name, phone, language;
    private List<String> days;

    public Teacher() {
    }

    public Teacher(int id, String name, String phone, String language, List<String> days) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.language = language;
        this.days = days;
    }

    public Teacher(String name, String phone, String language, List<String> days) {
        this.name = name;
        this.phone = phone;
        this.language = language;
        this.days = days;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Teacher)obj).id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }
     
}
