import java.util.ArrayList;

public abstract class Pieza {

    boolean color;
    boolean regresar;
    boolean viva;
    int noCasillas;
    int posicionx;
    int posiciony;
    boolean movimiento;
    boolean selected;
    String icon;
    ArrayList<int[]> movValidos=new ArrayList<int[]>();
    int n, m;
    public int[] mov = new int[2];
    static public boolean valido;
    boolean chocaxp, chocayp, chocaxn, chocayn,chocadxp, chocadxn, chocadyp, chocadyn;




    public abstract void movimiento();


}





