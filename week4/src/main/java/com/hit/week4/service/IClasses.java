package com.hit.week4.service;

import com.hit.week4.dto.request.ClassesRequest;
import com.hit.week4.dto.response.ClassesResponse;
import com.hit.week4.model.Classes;

public interface IClasses {
    public ClassesResponse addClass(Classes classes);

    public boolean removeClassesById(int idClasses);
}
