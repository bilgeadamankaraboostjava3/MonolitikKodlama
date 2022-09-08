package com.boostjava2.MonolitikKodlama.utility;

import com.boostjava2.MonolitikKodlama.repository.entity.Musteri;

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
}
