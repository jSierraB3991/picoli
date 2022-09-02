package com.mycompany.app.response;

import io.bretty.console.table.ColumnFormatter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColumnTable<T> {
    private String header;
    private T[] data;
    private ColumnFormatter<T> formatter;
}
