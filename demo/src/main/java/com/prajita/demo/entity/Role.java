package com.prajita.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Table
    @Getter
    @Setter
    public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String name;
    }
