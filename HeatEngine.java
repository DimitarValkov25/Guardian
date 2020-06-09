public class HeatEngine extends  HeatManager {
    private HeatManager heatManager;

    public HeatEngine(Integer power, Integer height, String color,Integer temperature) {
        super(power, height, color, temperature);
        System.out.println("HeatEngine power:" + power + "%" );
    }


    }


    //private Integer heatPower;
    //public HeatEngine( HeatManager heatManager) {
        //super();
        //this.heatManager=heatManager;
    //public HeatManager getHeatPower() {
       // return heatManager;
   // }





