 public class Engine extends Machine {

    private Integer power;

    public Engine(Integer power, Integer height,String color) {
        super(power,height,color);

        //this.power=power;
        System.out.println("Engine power:"+ power + "%");
    }

    public Integer getPower() {
        return power;
    }
}
