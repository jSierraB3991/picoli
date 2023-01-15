package com.mycompany.app.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@ToString
public class LazyDataResponse {
    private Long id;
    private String name;
    private LocalDateTime creationDate;

    public LazyDataResponse() {
    }

    public LazyDataResponse(Long id, String name, LocalDateTime creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
