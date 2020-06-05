package io.maya.jobs.service;

import io.maya.jobs.model.Vacant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class VacantServiceImp implements IVacantService {

    private final Logger logger = LoggerFactory.getLogger(VacantServiceImp.class);
    private List<Vacant> vacantList;

    public VacantServiceImp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        vacantList = new LinkedList<>();
        try {
            Vacant vacant1 = new Vacant();
            vacant1.setId(1);
            vacant1.setName("Game designer");
            vacant1.setDescription("Game designer to produce new games");
            vacant1.setSalary(1000.0);
            vacant1.setPublicationDate(simpleDateFormat.parse("03-06-2020"));
            vacant1.setActive(Boolean.TRUE);
            vacant1.setHighlighted(1);
            vacant1.setImage("empresa1.png");

            Vacant vacant2 = new Vacant();
            vacant2.setId(2);
            vacant2.setName("C++ game developer");
            vacant2.setDescription("Game programer with OpenGL experience");
            vacant2.setSalary(2000.0);
            vacant2.setPublicationDate(simpleDateFormat.parse("02-06-2020"));
            vacant2.setActive(Boolean.TRUE);
            vacant2.setHighlighted(0);
            vacant2.setImage("empresa2.png");

            Vacant vacant3 = new Vacant();
            vacant3.setId(3);
            vacant3.setName("Character designer");
            vacant3.setDescription("Game designer to produce new characters");
            vacant3.setSalary(3000.0);
            vacant3.setPublicationDate(simpleDateFormat.parse("01-06-2020"));
            vacant3.setActive(Boolean.TRUE);
            vacant3.setHighlighted(1);

            vacantList.add(vacant1);
            vacantList.add(vacant2);
            vacantList.add(vacant3);
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }

    }

    @Override
    public List<Vacant> getAll() {
        return vacantList;
    }

}
