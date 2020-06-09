public class HeatManager extends Engine{
    public int temperature;

    public HeatManager(Integer power, Integer height, String color,int temperature) {
        super(power, height, color);
        this.temperature=temperature;
        System.out.println("HeatManager temperature: "+ temperature +"C");
    }
}
