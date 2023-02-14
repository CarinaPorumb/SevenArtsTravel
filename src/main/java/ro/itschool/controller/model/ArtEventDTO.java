package ro.itschool.controller.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.itschool.enums.Category;
import ro.itschool.enums.Style;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArtEventDTO {

    private String name;
    private String imageLink;
    private String location;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Style movement;
    private LocalDateTime eventTime;
    private Boolean isTemporary;

}