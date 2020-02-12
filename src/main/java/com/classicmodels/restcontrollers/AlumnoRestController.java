package com.classicmodels.restcontrollers;

import com.classicmodels.models.Alumno;
import com.classicmodels.services.AlumnoServices;
import com.classicmodels.utility.Messages;
import com.classicmodels.utility.UrlConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlConstants.ALUMNO_URL)
public class AlumnoRestController {


    @Autowired
    AlumnoServices alumnoServices;


    @GetMapping(UrlConstants.LIST_ALL)
    public List<Alumno> findAll() throws Exception {
        try {
            return alumnoServices.getAll();
        } catch (Exception e) {
            throw new Exception(Messages.NO_CUSTOMERS);
        }

    }

    @PostMapping(UrlConstants.SAVE)
    public void save(@RequestBody Alumno alumno) throws Exception {

        try {

            alumnoServices.save(alumno);
        } catch (Exception e) {
            throw new Exception(Messages.CUSTOMER_SAVED_ERROR);
        }
    }


    @PutMapping(UrlConstants.UPDATE)
    public void update(@RequestBody Alumno alumno, int id){
        try {
            alumnoServices.update(alumno, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @DeleteMapping(UrlConstants.DELETE_BY_ID)
    public void delete(@PathVariable int id){
        try {
            alumnoServices.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
