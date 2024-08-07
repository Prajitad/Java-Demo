package com.prajita.demo.repo;

import com.prajita.demo.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface AddressRepo extends JpaRepository<AddressEntity, Integer> {
    List<AddressEntity> findByDistrict(String district);

    @Query(
            nativeQuery = true,
            value = "select * from addr where addr_district = ?1"
    )
    List<AddressEntity> getByDis(String dist);
}
