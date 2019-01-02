package com.example2.demo2.model;

import javax.persistence.*;

// TODO: Entity nama Table nya
@Entity

// TODO: Pakai Table merubah nama table dari mahasiswa jadi mahas
@Table (name = "KaryawanSpring")
public class Karyawan {

    // TODO: Buat Primary key
    @Id
    // TODO: Buat Generete Value auto maksudnya auto increment
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // TODO: merubah nama jadi namas (bisa yang lain dengan column)
    //@Column (name="Namas")
    private String nama;
    private String golongan;
    private String umur;

    // TODO: Membuat update dengan Version
    @Version
    @Column(name = "optVersion", columnDefinition = "integer DEFAULT 0")
    private Integer version;

    // TODO: Getter and Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGolongan() {
        return golongan;
    }

    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
