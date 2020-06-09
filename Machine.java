import javax.jnlp.IntegrationService;

public class Machine extends Person  {

    private Integer power;
    private Integer height;
    private String color;



    public Machine(Integer power, Integer height,String color) {
        super();

        this.power=power;
        this.height=height;
        this.color= color;
        System.out.println("Machine power:" + power + "%"+ "  Machine height:" + height +" meters" + "  Machine color:" + color);
    }

    public String getName() {
        return color;
    }
    public Integer getPower() {
        return power;
    }
    public Integer getHeight() {
        return height;
    }
    public String getColor() {
        return color;
    }


}

