import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class HorseTest {

    PaginatedTable testTable = new PaginatedTable(getSampleHeaders(), getSampleTableData(), 3);
    Horse horse = new Horse();

    @Test
    public void whenHorseDataIsPassedInABlankTableIsReturned(){
        PaginatedTable blankTable = new PaginatedTable(new ArrayList<>(), new ArrayList<>(), 0);

        assertEquals(blankTable, horse.FilterSortPaginateTable(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new SortMetadata("",""), new PaginationMetadata(0,0)));
    }

    @Test
    public void whenIFilterByBreedIOnlySeeThatBreedInTheTable() {
        PaginatedTable horseTable = horse.filterTable("Thoroughbred", testTable);
        String filteredBreed = horseTable.tableData.get(0).get(0);

        assertEquals("Thoroughbred", filteredBreed);
    }

    @Test
    public void whenIFilterByAgeIOnlySeeThatAgeInTheTable() {
        PaginatedTable horseTable = horse.filterTable("2", testTable);
        String ageFiltered = horseTable.tableData.get(0).get(1);

        assertEquals("2", ageFiltered);
    }

    @Test
    public void whenIFilterByBreedOnlyHorsesOfThatBreedArePopulated() {
        PaginatedTable horseTable = horse.filterTable("Thoroughbred", testTable);

        assertEquals(2, horseTable.tableData.size());
    }

    @Test
    public void whenSortingByAgeAscendingAgeOneIsAtTheFirstRow() {
        PaginatedTable horseTable = horse.sortTable("Age","Ascending",testTable);
        String sortedAge = horseTable.tableData.get(0).get(1);

        assertEquals("1", sortedAge);
    }

    @Test
    public void whenSortingByAgeAscendingAgeThreeIsInTheThirdRow() {
        PaginatedTable horseTable = horse.sortTable("Age","Ascending",testTable);
        String sortedAge = horseTable.tableData.get(2).get(1);

        assertEquals("3", sortedAge);
    }

    @Test
    @Ignore
    public void filterSortPaginate()
    {
        List<String> headers = SampleHorseData.GetSampleHeaders();
        List<List<String>> tableData = SampleHorseData.GetSampleTableData();
        List<FilterMetadata> filters = SampleHorseData.GetSampleFilters();
        SortMetadata sortMetadata = SampleHorseData.GetSampleSortMetadata();
        PaginationMetadata paginationMetadata = SampleHorseData.GetSamplePaginationMetadata();

        PaginatedTable table = Horse.FilterSortPaginateTable(headers, tableData, filters, sortMetadata, paginationMetadata);

        assertEquals(headers, table.headers);
        assertEquals(2, table.totalRows);
        assertEquals(Arrays.asList(Arrays.asList("Thoroughbred", "Bay", "1.6", "3", "true"),
                Arrays.asList("Thoroughbred", "Grey", "1.55", "3", "true")), table.tableData);
    }


    private List<List<String>> getSampleTableData() {
        return Arrays.asList(
                Arrays.asList("Thoroughbred", "3"),
                Arrays.asList("Arabian horse", "2"),
                Arrays.asList("Thoroughbred", "1")

        );
    }

    private List<String> getSampleHeaders() {
        return Arrays.asList("Breed", "Age");
    }

}
