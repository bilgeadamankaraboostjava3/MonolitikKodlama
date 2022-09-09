package com.boostjava2.MonolitikKodlama.utility;

import com.boostjava2.MonolitikKodlama.repository.entity.Musteri;
import com.boostjava2.MonolitikKodlama.repository.entity.Satis;
import com.boostjava2.MonolitikKodlama.repository.entity.Urun;

import java.util.ArrayList;
import java.util.List;

public class Datas {

    private List<Musteri> musteriList;

    public List<Musteri> getMusteriList() {
        musteriList = new ArrayList<>();
        musteriList.add(Musteri.builder()
                .ad("Ali")
                .adres("Ankara")
                .telefon("123456789")
                .soyad("Yılmaz")
                        .createddate(1662556017000l)
                .email("muhammet@gmail.com").build());
        musteriList.add(Musteri.builder()
                .ad("Deniz")
                .adres("İstanbul")
                .telefon("545456665")
                .soyad("Yılmaz")
                .createddate(1662469617000l)
                .email("deniz@gmail.com").build());
        musteriList.add(Musteri.builder()
                .ad("Bahar")
                .adres("Ankara")
                .telefon("77455512")
                .soyad("Yılmaz")
                .createddate(1662458817000l)
                .email("bahar@gmail.com").build());
        musteriList.add(Musteri.builder()
                .ad("Gülşen")
                .adres("İzmir")
                .telefon("5454654")
                .soyad("Yılmaz")
                .createddate(1662458817000l)
                .email("gulsen@gmail.com").build());
        return musteriList;
    }

    private List<Urun> urunList;

    public List<Urun> getUrunList(){
        urunList = new ArrayList<>();
        urunList.add(Urun.builder()
                .ad("Bilgisayar")
                .fiyat(1000.0)
                .marka("Asus")
                .model("X555")
                .stok(10)
                .state(1)
                .createddate(1662556017000l)
                .build());
        urunList.add(Urun.builder()
                .ad("Bilgisayar")
                .fiyat(2000.0)
                .marka("Asus")
                .model("X322")
                .stok(10)
                .state(1)
                .createddate(1662556017000l)
                .build());
        urunList.add(Urun.builder()
                .ad("Bilgisayar")
                .fiyat(3000.0)
                .marka("Asus")
                .model("CX33")
                .stok(10)
                .state(1)
                .createddate(1662556017000l)
                .build());
        return urunList;
    }

    private List<Satis> satisList;

    public List<Satis> getSatisList(){
        satisList = new ArrayList<>();
        satisList.add(Satis.builder()
                .adet(1)
                .fiyat(1000.0)
                .musteriid(105l)
                .urunid(1l)
                .state(1)
                .createddate(1662556017000l)
                .build());
        satisList.add(Satis.builder()
                .adet(1)
                .fiyat(2000.0)
                .musteriid(115l)
                .urunid(2l)
                .state(1)
                .createddate(1662556017000l)
                .build());
        satisList.add(Satis.builder()
                .adet(1)
                .fiyat(3000.0)
                .musteriid(119l)
                .urunid(3l)
                .state(1)
                .createddate(1662556017000l)
                .build());
        satisList.add(Satis.builder()
                .adet(1)
                .fiyat(3000.0)
                .musteriid(119l)
                .urunid(2l)
                .state(1)
                .createddate(1662556017000l)
                .build());
        satisList.add(Satis.builder()
                .adet(1)
                .fiyat(3000.0)
                .musteriid(101l)
                .urunid(3l)
                .state(1)
                .createddate(1662556017000l)
                .build());
        return satisList;
    }

}
