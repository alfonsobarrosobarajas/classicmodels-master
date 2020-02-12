package com.classicmodels.services;
import com.classicmodels.models.Alumno;
import com.classicmodels.repositories.AlumnoRepository;
import com.classicmodels.repositories.ICRUD;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlumnoServices implements ICRUD<Alumno>{


    AlumnoRepository alumnoRepository;

    public AlumnoServices(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public List<Alumno> getAll() throws Exception {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno getById(int id) throws Exception {
        return null;
    }

    @Override
    public void save(Alumno obj) throws Exception {
      alumnoRepository.save(obj);

    }

    @Override
    public void update(Alumno obj, int id) throws Exception {

    }

    @Override
    public void deleteById(int id) throws Exception {

    }
}
