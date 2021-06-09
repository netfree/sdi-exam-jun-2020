package ro.ubb.exam.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SensorsDataDto {
    private List<SensorDataDto> sensorsData;

    @Override
    public String toString() {
        return "SensorsDataDto{" +
                sensorsData.stream().map(e -> "\n\t" + e.toString()).reduce("", String::concat)
                + " }";
    }
}
