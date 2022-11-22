package com.jsierrab3991.picocli.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person  extends PanacheEntity {
    public String name;
    public LocalDate birth;
    @Enumerated(EnumType.STRING)
    public Status status;
}