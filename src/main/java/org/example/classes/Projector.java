package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Projector {
    private String name;
    private Integer year;
    private Double price;
    private String manufacturer;

    @Override
    public String toString() {
        return "Проектор{" +
                "название='" + name + '\'' +
                ", год выпуска=" + year +
                ", цена=" + price +
                ", производитель='" + manufacturer + '\'' +
                '}';
    }
}
