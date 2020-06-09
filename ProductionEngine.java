public class ProductionEngine extends Engine {
    private Integer power;

    public ProductionEngine(Integer power, Integer height, String color) {
        super(power, height, color);

        //this.power=power;
        System.out.println("ProductionEngine power:"+ power + "%");
    }

    public Integer getPower() {
        return power;
    }
}


