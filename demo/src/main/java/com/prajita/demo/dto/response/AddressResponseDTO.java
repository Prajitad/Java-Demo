package com.prajita.demo.dto.response;

import com.prajita.demo.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class AddressResponseDTO {
    private Integer id;
    private String street;
    private String district;


    public  AddressResponseDTO(AddressEntity addressEntity) {

    this.id=addressEntity.getId();
    this.street=addressEntity.getStreet();
    this.district=addressEntity.getDistrict();
    }
}