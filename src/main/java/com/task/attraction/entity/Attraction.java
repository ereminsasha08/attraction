package com.task.attraction.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Persistable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Table(name = "attraction")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Attraction implements Persistable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "name")
    @Length(min = 2, message = "Названия достопримечательности не может быть короче двух букв")
    @NotNull
    private String name;

    @Column(name = "date_construction")
    @NotNull
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateConstruction;

    @Column(name = "description")
    @NotNull
    @Length(min = 20, message = "Описание должно содержать минимум 20 символов")
    private String description;

    @Column(name = "type")
    @Enumerated
    @Fetch(FetchMode.JOIN)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties(value = "attraction")
    private City city;

    @Override
    public Integer getId() {
        Assert.notNull(id, "Entity must have id");
        return id;
    }

    @Override
    public boolean isNew() {
        return id != null;
    }
}
