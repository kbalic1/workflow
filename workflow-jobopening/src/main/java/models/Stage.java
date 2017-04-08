package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by tile on 4/8/2017.
 */
@Entity
public class Stage {


    @Id
    @GeneratedValue
    private Long Id;

    private String name;

    public Stage() {
    }

    public Stage(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
