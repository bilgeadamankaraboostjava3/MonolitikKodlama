package com.boostjava2.MonolitikKodlama.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.boostjava2.MonolitikKodlama.constants.Urls.*;
@RestController
@RequestMapping(VERSION+API+INFORMATIONS)
public class InformationController {

        @Value("${myapplication.benimuydurdugumbiralan.info}")
        private String info;

        //@Value("${myapplication.benimuydurdugumbiralan}")
        //private Map<String, String> map;
        @Value("${myapplication.benimuydurdugumbiralan.title}")
        private String title;

        @RequestMapping(INFO)
        public String info() {
            return info;
        }

        @RequestMapping(TITLE)
        public String title() {
            return title;
        }
}
