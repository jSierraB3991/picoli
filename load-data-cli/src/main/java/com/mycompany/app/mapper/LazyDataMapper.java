package com.mycompany.app.mapper;

import com.mycompany.app.model.LazyData;
import com.mycompany.app.response.LazyDataResponse;

import java.util.List;
import java.util.stream.Collectors;

public class LazyDataMapper {

    public static LazyDataMapper INSTANCE = new LazyDataMapper();

    public LazyDataResponse toResponse(LazyData data){
        return LazyDataResponse.builder()
                .name(data.getName())
                .creationDate(data.getCreationDate())
                .id(data.getId())
                .build();
    }

    public List<LazyDataResponse> toResponse(List<LazyData> data) {
        return data.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
