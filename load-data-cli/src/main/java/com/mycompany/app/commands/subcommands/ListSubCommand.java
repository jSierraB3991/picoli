package com.mycompany.app.commands.subcommands;

import com.google.inject.Guice;
import com.mycompany.app.config.ApplicationConfig;
import com.mycompany.app.response.ClientResponse;
import com.mycompany.app.response.ColumnTable;
import com.mycompany.app.response.LazyDataResponse;
import com.mycompany.app.response.TypeList;
import com.mycompany.app.service.ClientService;
import io.bretty.console.table.Alignment;
import io.bretty.console.table.ColumnFormatter;
import io.bretty.console.table.Precision;
import io.bretty.console.table.Table;
import picocli.CommandLine;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "ls", aliases = { "show", "list" },
        version = "1.0.0",
        mixinStandardHelpOptions = true,
        requiredOptionMarker = '*',
        description = "This is a Command for view load data",
        header = "List Command",
        footerHeading = "%nCopyright %n",
        footer = "\tDeveloped by Juan David Sierra",
        optionListHeading = "%nOptions are%n")
public class ListSubCommand implements Callable<Integer> {

    @CommandLine.Option(
            names = { "-t", "--type" },
            required = false,
            description = "Show data loaded files is {FILES}, show loaded data is {CLIENTS}, The value default is {CLIENTS}",
            defaultValue = "CLIENTS"
    )
    TypeList type;


    @CommandLine.Option(
            names = { "-n", "--numbers" },
            required = false,
            description = "Show {n} number of data of client loaded, default value is 5",
            defaultValue = "5"
    )
    int dataNumber;

    private final ClientService service;

    public ListSubCommand() {
        var injector = Guice.createInjector(new ApplicationConfig());
        this.service = injector.getInstance(ClientService.class);
    }

    @Override
    public Integer call() {
        switch (type) {
            case CLIENTS:
                showClients();
                break;
            case FILES:
                showDataOfFiles();
                break;
        }
        return 1;
    }

    private void showDataOfFiles() {
        var data = service.findAllLazyData();
        var structure = getDataFilesForTable(data);
        printTable(structure);
    }

    private void showClients() {
        var data = service.findAll(dataNumber);
        var structure = getDataClientForTable(data);
        printTable(structure);
    }

    private List<ColumnTable> getDataClientForTable(List<ClientResponse> data) {
        ColumnFormatter<Number> idFormatter = ColumnFormatter.number(Alignment.RIGHT, 3, Precision.ZERO);
        ColumnFormatter<String> nameFormatter = ColumnFormatter.text(Alignment.LEFT, 35);
        ColumnFormatter<String> emailFormatter = ColumnFormatter.text(Alignment.LEFT, 40);

        List<ColumnTable> columns = new ArrayList<>();
        columns.add(new ColumnTable<>("Id", data.stream().parallel().map(ClientResponse::getId).toArray(Long[]::new), idFormatter));
        columns.add(new ColumnTable<>("Name Of Client", data.stream().parallel().map(ClientResponse::getName).toArray(String[]::new), nameFormatter));
        columns.add(new ColumnTable<>("Email Of Clients", data.stream().parallel().map(ClientResponse::getEmail).toArray(String[]::new), emailFormatter));
        columns.add(new ColumnTable<>("Country Of Client", data.stream().parallel().map(ClientResponse::getCountry).toArray(String[]::new), nameFormatter));
        return columns;
    }

    private void printTable( List<ColumnTable> columnTables) {
        var table = addColumns(columnTables).build();
        System.out.println(table); // NOTICE: table.toString() is called implicitly
    }

    private  List<ColumnTable> getDataFilesForTable(List<LazyDataResponse> data) {
        // define a formatter for each column
        ColumnFormatter<Number> idFormatter = ColumnFormatter.number(Alignment.RIGHT, 3, Precision.ZERO);
        ColumnFormatter<String> nameFormatter = ColumnFormatter.text(Alignment.LEFT, 50);
        ColumnFormatter<Date> dateFormatter = ColumnFormatter.dateTime(Alignment.RIGHT, 15, DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.getDefault()));


        List<ColumnTable> columns = new ArrayList<>();
        columns.add(new ColumnTable<>("Id", data.stream().map(LazyDataResponse::getId).toArray(Long[]::new), idFormatter));
        columns.add(new ColumnTable<>("Name Of File", data.stream().map(LazyDataResponse::getName).toArray(String[]::new), nameFormatter));
        columns.add(new ColumnTable<>("Creation Date", data.stream().map(LazyDataResponse::getCreationDate).map(this::getDate).toArray(Date[]::new), dateFormatter));
        return columns;
    }

    private Table.Builder addColumns(List<ColumnTable> data) {
        var builder = new Table.Builder("", new String[]{ "" }, ColumnFormatter.text(Alignment.RIGHT, 0));
        data.forEach(d -> {
            builder.addColumn(d.getHeader(), d.getData(), d.getFormatter());
        });
        return builder;
    }

    private Date getDate(LocalDateTime localTime) {
        return Date.from(localTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
