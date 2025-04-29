package Spring_data.dto;

import Spring_data.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class CourseDTO {
    private Integer id;
    private String name;
    private double price;
    private Integer duration;
    private LocalDateTime createdDate;
}
