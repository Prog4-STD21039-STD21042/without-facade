package com.example.prog4.repository.cnaps.entity;

import com.example.prog4.repository.main.entity.enums.Csp;
import com.example.prog4.repository.main.entity.enums.Sex;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;
import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "\"employee\"")
public class Employee implements Serializable {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private String id;
  private String cin;
  private String image;
  private String address;
  private String lastName;
  private String firstName;
  private String personalEmail;
  private String professionalEmail;
  private String registrationNumber;

  private LocalDate birthDate;
  private LocalDate entranceDate;
  private LocalDate departureDate;

  private Integer childrenNumber;

  @Enumerated(EnumType.STRING)
  @ColumnTransformer(read = "CAST(sex AS varchar)", write = "CAST(? AS sex)")
  private Sex sex;
  @Enumerated(EnumType.STRING)
  @ColumnTransformer(read = "CAST(csp AS varchar)", write = "CAST(? AS csp)")
  private Csp csp;
  private String endToEndId;
  private String number;
}