package com.airy.ecom.inventoryservice.model.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class InventoryReqRes {
    private Long id;
    private String productName;
    private Integer inventory;

}
