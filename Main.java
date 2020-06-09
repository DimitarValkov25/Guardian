import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ProductionEngine productionEngine = new ProductionEngine(78, 20, "RED");
        HeatEngine heatEngine = new HeatEngine(78, 20, "RED",98);
        WrapperEngine wrapperEngine = new WrapperEngine( 78, 20, "RED",98);

    }

}

