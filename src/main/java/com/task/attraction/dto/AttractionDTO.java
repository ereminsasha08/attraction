package com.task.attraction.dto;

import com.task.attraction.entity.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AttractionDTO {

    @Length(min = 2, message = "Названия достопримечательности не может быть короче двух букв")
    @NotNull
    private String name;

    @NotNull
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateConstruction;

    @NotNull
    @Length(min = 20, message = "Описание должно содержать минимум 20 символов")
    private String description;

    @NotNull
    private Type type;

    @NotNull
    private Integer city_id;


}
