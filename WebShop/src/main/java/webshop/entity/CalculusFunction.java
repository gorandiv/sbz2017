package webshop.entity;

public enum CalculusFunction {

	TOTAL_2_PERCENT("TOTAL_2_PERCENT"), TOTAL_5_PERCENT("TOTAL_5_PERCENT"), TOTAL_10_PERCENT("TOTAL_10_PERCENT"), TOTAL_15_PERCENT("TOTAL_15_PERCENT"), TOTAL_20_PERCENT("TOTAL_20_PERCENT");
	
	private final String name; 
	
    private CalculusFunction(String s) {
        name = s;
    }

    public String toString() {
       return this.name;
    }
	
}
