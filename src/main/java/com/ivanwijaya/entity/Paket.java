package com.ivanwijaya.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "paket")
public class Paket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column( name = "firstName")
    private String firstName;


    @Column( name = "lastName")
    private String lastName;


    @Column(name ="email", unique = true)
    private String email;


    @Column(name ="phone_number", unique = true)
    private String phoneNumber;

    @NotNull(message = "please enter no resi")
    @Column(name ="no_resi",unique = true)
    private String noResi;

    @NotNull(message = "please enter tanggal pengiriman")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate tanggal;

    @NotNull(message = "please enter tanggal Diterima")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate tanggalDiterima;

    @NotEmpty(message = "Alamat")
    @Column(nullable = false, name = "alamat")
    private String alamat;

    @NotEmpty(message = "Nama Penerima")
    @Column(nullable = false, name = "nama_penerima")
    private String penerima;
}
