package com.example.CoffeeShop.DTO;

import com.example.CoffeeShop.Entity.Store;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class StoreDto {
    private Long id;
    private String name;
    private String location;

    public Store toEntity() {
        return new Store(id, name, location);
    }
}
