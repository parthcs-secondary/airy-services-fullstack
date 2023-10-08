package com.airy.ecom.inventoryservice.model.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class InventoryResponse {
    String productName;
    boolean inStock;
}
