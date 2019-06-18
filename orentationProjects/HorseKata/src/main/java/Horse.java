import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Horse {

    /**
     * This method is called by the front end when it wants to display a page of horse data.
     */
    public static PaginatedTable FilterSortPaginateTable(List<String> headers, List<List<String>> tableData,
            List<FilterMetadata> filters, SortMetadata sortMetadata, PaginationMetadata paginationMetadata) {
        PaginatedTable filteredSortedHorseTable = new PaginatedTable(headers, tableData, 0);
        // TODO: filter horse table using filters

        // TODO: sort horse table using sortMetadata

        // TODO: paginate horse table using paginationMetadata

        return filteredSortedHorseTable;
    }


    public PaginatedTable filterTable(String filterBy, PaginatedTable paginatedTable) {
        PaginatedTable table = new PaginatedTable(new ArrayList<>(), new ArrayList<>(), 0);
        for(List<String> row: paginatedTable.tableData){
            for(int x =0; x < row.size(); x++){
                if(row.get(x).equals(filterBy)){
                    table.tableData.add(row);
                }
            }
        }
        return table;
    }

    public PaginatedTable sortTable(String column, String order, PaginatedTable paginatedTable) {
        PaginatedTable table = new PaginatedTable(new ArrayList<>(), new ArrayList<>(), 0);

        paginatedTable.tableData.stream().sorted().collect(Collectors.toList());
        return table;
    }
}
