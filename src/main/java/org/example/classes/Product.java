package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private String name;
    private String category;

    @Override
    public String toString() {
        return "Товар{" +
                "название='" + name + '\'' +
                ", категория='" + category + '\'' +
                '}';
    }
}
