package ug.adamtrawinski.restejbjpa.view;

public class View {
    public interface LaptopSummary {}
    public interface LaptopOwners {}
    public interface LaptopSummaryWithRelations extends LaptopSummary {}
    public interface LaptopSummaryWithoutOwners extends LaptopSummary {}
    public interface PersonSummary {}
    public interface PersonSummaryWithRelations extends LaptopSummary, PersonSummary {}
}
