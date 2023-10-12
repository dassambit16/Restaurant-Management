package com.assingment.RestaurentManagement.Model;
import com.assingment.RestaurentManagement.Model.Enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Integer oderQuantity;
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "fk_food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User customer;

}
