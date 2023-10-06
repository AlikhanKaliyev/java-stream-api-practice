package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Device {
    private String name;
    private Integer year;
    private Double price;
    private String color;
    private String type;

    @Override
    public String toString() {
        return "Устройство{" +
                "название='" + name + '\'' +
                ", год=" + year +
                ", цена=" + price +
                ", цвет='" + color + '\'' +
                ", тип='" + type + '\'' +
                '}';
    }
}
