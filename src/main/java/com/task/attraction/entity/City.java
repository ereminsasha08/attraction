package com.task.attraction.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Persistable;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Table(name = "city")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class City implements Persistable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @Length(min = 2, message = "Названия города не может быть короче двух букв")
    @NotNull
    private String name;

    @Column(name = "population")
    @Min(value = 5000, message = "Насселения города не может быть меньше 5000 тысяч человек")
    @NotNull
    private Integer population;

    @Column(name = "underground")
    @NotNull(message = "Необходимо указать наличие/отсутствие метро")
    private Boolean underground;

    @Column(name = "country")
    @Length(min = 2, message = "Названия страны не может быть короче двух букв")
    @NotNull
    private String country;

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
