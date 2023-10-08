package com.airy.ecom.ordersservice.model.dto.inventory;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventoryResponse {
    String productName;
    boolean inStock;
}
