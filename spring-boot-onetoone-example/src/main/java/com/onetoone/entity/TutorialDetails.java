package com.onetoone.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tutorial_details")
public class TutorialDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String createdBy;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "tutorial_id")
  private Tutorial tutorial;

  public TutorialDetails() {
  }

  public TutorialDetails(String createdBy) {
    this.createdBy = createdBy;
  }  

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Tutorial getTutorial() {
    return tutorial;
  }

  public void setTutorial(Tutorial tutorial) {
    this.tutorial = tutorial;
  }

}
