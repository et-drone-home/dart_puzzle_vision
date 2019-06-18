/**
 * The front end provides a list of these specifying the requested filters
 */
class FilterMetadata {
    final String columnHeader;
    final String value;

    public FilterMetadata(String columnHeader, String value) {
        this.columnHeader = columnHeader;
        this.value = value;
    }
}