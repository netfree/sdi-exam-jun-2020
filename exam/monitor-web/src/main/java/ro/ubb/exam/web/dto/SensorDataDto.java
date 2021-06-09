package ro.ubb.exam.web.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SensorDataDto extends BaseDto{
    private Long id;
    private String name;
    private int measurement;
    private Date timestamp;
}