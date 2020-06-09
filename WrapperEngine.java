public class WrapperEngine extends HeatManager{
    private Integer wrappingPower;

    public WrapperEngine(Integer power, Integer height, String color,Integer temperature) {
        super(power, height, color,temperature);
        System.out.println("WrapperEngine power:" + power + "%");
    }


    //public WrapperEngine(Integer wrappingPower) {
      // this.wrappingPower=wrappingPower;
    //}
    //public Integer getWrappingPower() {
      //  return wrappingPower;
   // }

}
