package parser.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.*;
import parser.model.Record;
import parser.services.MetallService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@ShellComponent
public class MetallCommands {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final LinkedHashMap<String, Object> header = new LinkedHashMap<>();

    static {
        header.put("id", "id");
        header.put("date", "date");
        header.put("code", "code");
        header.put("buy", "buy");
        header.put("sell", "sell");
    }

    @Autowired
    private MetallService metallService;

    @ShellMethod("Price list for precious metal [FROM DATE] [TO DATE]. Required date format: dd/MM/yyyy")
    public Table metallrecords(String fromDate, String toDate) {
        List<Record> records = metallService.getListMetallRecord(fromDate, toDate);

        TableModel tableModel = new BeanListTableModel<>(records, header);

        return new TableBuilder(tableModel)
                .addFullBorder(BorderStyle.fancy_heavy)
                .build();
    }

    @ShellMethod("Price list for precious metal for today.")
    public Table pricemetalltoday() {
        LocalDate localDate = LocalDate.now();

        String fromDate = localDate.format(formatter);
        String toDate = localDate.plusDays(1).format(formatter);

        List<Record> records = metallService.getListMetallRecord(fromDate, toDate);

        TableModel tableModel = new BeanListTableModel<>(records, header);

        return new TableBuilder(tableModel)
                .addFullBorder(BorderStyle.fancy_heavy)
                .build();
    }
}
