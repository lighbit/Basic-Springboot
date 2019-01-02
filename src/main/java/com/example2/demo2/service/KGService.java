package com.example2.demo2.service;

import com.example2.demo2.model.Golongan;
import com.example2.demo2.model.Karyawan;

import java.util.List;

public interface KGService {
    // TODO: List Karyawan dan Golongan
    List<Karyawan> listKaryawan();
    Karyawan saveOrUpdate(Karyawan karyawan);

    List<Golongan> listGolongan();
    Golongan saveOrUpdate2(Golongan golongan);

    // TODO: proses update dan edit
    Karyawan getIDKaryawan(Integer id);
    Golongan getIDGolongan(Integer id);

    // TODO: Menghapus Data
    void hapusKaryawan (Integer id);
    void hapusGolongan (Integer id);
}
