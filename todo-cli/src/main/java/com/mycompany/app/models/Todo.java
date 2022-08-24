package com.mycompany.app.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Todo implements Serializable {

    private static final long serialVersionUID = 4663044935291053899L;

    private Long id;
    private String message;
    private Status status;
    private LocalDate createOn;
    private LocalDate updateOn;

    public Todo() {
      super();
    }

    public Todo(Long id, String message, LocalDate createOn, LocalDate updateOn) {
      super();
      this.id = id;
      this.message = message;
      this.status = status;
      this.createOn = createOn;
      this.updateOn = updateOn;
    }

    public Long getId() {
      return this.id;
    }
    public void setId(Long id) {
      this.id = id;
    }

    public String getMessage() {
      return this.message;
    }
    public void setMessage(String message) {
      this.message = message;
    }

    public Status getStatus() {
      return this.status;
    }
    public void setStatus(Status status) {
      this.status = status;
    }

    public LocalDate getCreateOn() {
      return this.createOn;
    }
    public void setCreateOn(LocalDate createOn) {
      this.createOn = createOn;
    }

    public LocalDate getUpdateOn() {
      return this.createOn;
    }
    public void setUpdateOn(LocalDate updateOn) {
      this.updateOn = updateOn;
    }
}
