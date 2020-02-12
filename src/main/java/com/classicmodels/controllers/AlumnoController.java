package com.classicmodels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/alumno")
public class AlumnoController {


    @GetMapping("")
    public String goAlumno(){
        return "Alumno";
    }
}
