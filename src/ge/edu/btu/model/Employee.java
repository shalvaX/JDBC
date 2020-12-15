package ge.edu.btu.model;

import java.util.List;

public class Employee {
    private long id;
    private String name;
    private String surname;
    private String gender;
    private boolean alive;
    private String p_id;


    private Employee(){}

    public Employee(long id, String name, String surname, String gender, boolean alive, String p_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.alive = alive;
        this.p_id = p_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }


}
