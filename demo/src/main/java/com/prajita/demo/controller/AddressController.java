package com.prajita.demo.controller;

import com.prajita.demo.dto.request.AddressCreationDTO;
import com.prajita.demo.dto.response.AddressResponseDTO;
import com.prajita.demo.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addr")
@RequiredArgsConstructor
@Tag(name="Address",description = "Address")
public class AddressController {
    private final AddressService addressService;

    @PostMapping("/save")
    public ResponseEntity<AddressResponseDTO> save(@RequestBody AddressCreationDTO request)
    {
        return ResponseEntity.ok(addressService.save(request));
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<AddressResponseDTO>> fetch() {
        return ResponseEntity.ok(addressService.findAllAddress());
    }

    @GetMapping("/get")
    public ResponseEntity<AddressResponseDTO> getAddress(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(addressService.findAddressById(id));
    }

    @PutMapping("/update")
    @Operation(
            summary = "update address",
            description = "this ai assists in updating the address",
            tags ={"address","update"}
    )
    public ResponseEntity<AddressResponseDTO> update(@RequestParam Integer id,
                                                     @RequestBody AddressCreationDTO
                                                             request) {
        return ResponseEntity.ok(addressService.updateAddres(id,request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(addressService.deleteAddressById(id));
    }











}