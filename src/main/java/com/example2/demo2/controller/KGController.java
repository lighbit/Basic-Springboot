package com.example2.demo2.controller;

import com.example2.demo2.model.Golongan;
import com.example2.demo2.model.Karyawan;
import com.example2.demo2.service.KGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class KGController {

    private KGService kgService;

    @Autowired
    public void setKgService(KGService kgService) {
        this.kgService = kgService;
    }

    // TODO: Membuat data /kgtabel/karyawanorgolongan Terbaca
    @RequestMapping(value = "/kgtabel/karyawan")
    public String karyawanList (Model model){
        model.addAttribute("karyawan", kgService.listKaryawan());
        return "karyawan";
    }
    @RequestMapping(value = "/kgtabel/golongan")
    public String golonganList (Model model){
        model.addAttribute("golongan", kgService.listGolongan());
        return "golongan";
    }

    // TODO: Menampilkan Marquee data di Edit section eukaryawan
    @RequestMapping(value = "/kgtabel/newkaryawan")
    public String karyawanLists (Model model){
        model.addAttribute("karyawan", kgService.listKaryawan());
        return "eukaryawan";
    }
    @RequestMapping(value = "/kgtabel/newgolongan")
    public String golonganLists (Model model){
        model.addAttribute("golongan", kgService.listGolongan());
        return "eugolongan";
    }


    // TODO: Membuat data /kgtabel/new. . terbaca
    @RequestMapping(value = "/kgtabel/newkaryawan", method = RequestMethod.GET)
    public String tampilkanNewKaryawan(Model model){
        model.addAttribute("karyawan", new Karyawan());
        return "eukaryawan";
    }

    @RequestMapping(value = "/kgtabel/newgolongan", method = RequestMethod.GET)
    public String tampilkanNewGolongan(Model model){
        model.addAttribute("golongan", new Golongan());
        return "eugolongan";
    }


    // TODO: Membuat redirect setelah save data kgtable/new. . ke /kgtable/karaywanorgolongan
    @RequestMapping(value = "/kgtabel/newkaryawan", method = RequestMethod.POST)
    public String simpanDataKaryawan(Model model, Karyawan karyawan){
        model.addAttribute("karyawan", kgService.saveOrUpdate(karyawan));
        return "redirect:/kgtabel/karyawan";
    }

    @RequestMapping(value = "/kgtabel/newgolongan", method = RequestMethod.POST)
    public String simpanDataGolongan(Model model, Golongan golongan){
        model.addAttribute("golongan", kgService.saveOrUpdate2(golongan));
        return "redirect:/kgtabel/golongan";
    }


    // TODO: Membuat EDIT dan Update dan return eukaryawan
    @RequestMapping(value = "/kgtabel/editkaryawan/{id}", method = RequestMethod.GET)
    public String editDataKaryawan(@PathVariable Integer id, Model model){
        model.addAttribute("karyawan", kgService.getIDKaryawan(id));
        return "eukaryawan";
    }

    @RequestMapping(value = "/kgtabel/editgolongan/{id}", method = RequestMethod.GET)
    public String editDataGolongan(@PathVariable Integer id, Model model) {
        model.addAttribute("golongan", kgService.getIDGolongan(id));
        return "eugolongan";
    }


    // TODO: Membuat Remove Data dan redirect ke /kgtable/karyawanorgolongan
    @RequestMapping(value = "/kgtabel/removekaryawan/{id}")
    public String hapusKaryawan (@PathVariable Integer id){
        kgService.hapusKaryawan(id);
        return "redirect:/kgtabel/karyawan";
    }

    @RequestMapping(value = "/kgtabel/removegolongan/{id}")
    public String hapusGolongan (@PathVariable Integer id){
        kgService.hapusGolongan(id);
        return "redirect:/kgtabel/golongan";
    }

}
