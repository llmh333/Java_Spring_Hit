package com.hit.week4.service.impl;

import com.hit.week4.dto.request.ClassesRequest;
import com.hit.week4.dto.response.ClassesResponse;
import com.hit.week4.model.Classes;
import com.hit.week4.repository.ClassesRepository;
import com.hit.week4.response.ApiResponse;
import com.hit.week4.service.IClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ClassesService implements IClasses {

    @Autowired
    private ClassesRepository classesRepository;

    @Override
    public ClassesResponse addClass(Classes classes) {
        try {
            Classes newClasses = classesRepository.save(classes);
            ClassesResponse classesResponse = ClassesResponse.builder()
                    .id(newClasses.getId())
                    .name(newClasses.getName())
                    .subject(newClasses.getSubject())
                    .build();
            return classesResponse;
        } catch (DataIntegrityViolationException e) {
            throw  new DataIntegrityViolationException("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean removeClassesById(int idClasses) {
        if (classesRepository.existsById(idClasses)) {
            try {
                classesRepository.deleteById(idClasses);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }

    }

}
