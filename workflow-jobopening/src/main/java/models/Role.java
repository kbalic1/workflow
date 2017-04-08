package models;

import javax.persistence.*;

/**
 * Created by tile on 4/8/2017.
 */

@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "stageId", referencedColumnName = "Id")
    private Stage stage;

    @ManyToOne
    @JoinColumn (name = "jobOfferId", referencedColumnName = "Id")
    private JobOffer jobOffer;

    @ManyToOne
    @JoinColumn (name = "userId", referencedColumnName = "Id")
    private User user;

    public Role() {
    }

    public Role(Stage stage, JobOffer jobOffer, User user) {
        this.stage = stage;
        this.jobOffer = jobOffer;
        this.user = user;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public JobOffer getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOffer jobOffer) {
        this.jobOffer = jobOffer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
