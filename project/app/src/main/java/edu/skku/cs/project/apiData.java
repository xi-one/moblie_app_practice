package edu.skku.cs.project;

public class apiData {
    private apiData COOKRCP01;
    private String total_count;
    private Recipe[] row;

    public apiData getCOOKRCP01() {
        return COOKRCP01;
    }

    public void setCOOKRCP01(apiData COOKRCP01) {
        this.COOKRCP01 = COOKRCP01;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public Recipe[] getRow() {
        return row;
    }

    public void setRow(Recipe[] row) {
        this.row = row;
    }
}
