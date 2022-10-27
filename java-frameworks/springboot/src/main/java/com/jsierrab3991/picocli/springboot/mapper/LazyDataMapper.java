package com.jsierrab3991.picocli.springboot.mapper;

import com.jsierrab3991.picocli.springboot.model.LazyData;
import com.jsierrab3991.picocli.springboot.response.LazyDataResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LazyDataMapper {

    LazyDataResponse toResponse(LazyData client);

    List<LazyDataResponse> toResponse(List<LazyData> client);
}