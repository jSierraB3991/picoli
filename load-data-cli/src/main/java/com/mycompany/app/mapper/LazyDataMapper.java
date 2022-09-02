package com.mycompany.app.mapper;

import com.mycompany.app.model.LazyData;
import com.mycompany.app.response.LazyDataResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "jsr330")
public interface LazyDataMapper {

    LazyDataResponse toResponse(LazyData data);

    List<LazyDataResponse> toResponse(List<LazyData> data);
}
