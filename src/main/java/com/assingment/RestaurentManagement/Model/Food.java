package com.assingment.RestaurentManagement.Model;
import com.assingment.RestaurentManagement.Model.Enums.FoodType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodId;
    private Long foodPrice;
    private FoodType foodType;
    private String foodDesc;
    private String foodTitle;

}
