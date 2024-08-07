package com.prajita.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="stu")


public class StudentEntity {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
@Column(name = "stu_name",length=200,nullable = false)
private String name;

@Column(name = "stu_class",length=200,nullable = false)
private String stuClass;
@ManyToOne
@JoinColumn(name="stu_addr",referencedColumnName = "id",
        foreignKey= @ForeignKey(name="FK_STU_ADDR"))
private AddressEntity address;


}
