import java.util.ArrayList;

public class Tablero {
    static int tamaño=8;

    public Pieza[][] tab;
    static int posx;
    static int posy;

    public Tablero(){
        tab= new Pieza[tamaño+2][tamaño];
        for(posx=0;posx<tamaño; posx++){
            for(posy=0;posy<tamaño; posy++){
                if((posx==0 && posy==0)||(posx==0 && posy==7)||(posx==7 && posy==0) ||(posx==7 && posy==7))
                    tab[posx][posy]= new  Torre();
                else if((posx==0 && posy==1)||(posx==7 && posy==1)||(posx==0 && posy==6) ||(posx==7 && posy==6))
                    tab[posx][posy]= new  Caballo();
                else if((posx==0 && posy==2)||(posx==7 && posy==2)||(posx==0 && posy==5) ||(posx==7 && posy==5))
                    tab[posx][posy]= new  Alfil();
                else if((posx==0 && posy==4)||(posx==7 && posy==4))
                    tab[posx][posy]= new  Rey();
                else if((posx==0 && posy==3)||(posx==7 && posy==3))
                    tab[posx][posy]= new  Reina();
                else if ((posx == 1 || posx == 6))
                    tab[posx][posy] = new Peon();
                }
            }
        }


        public void imprimirTablero(){
            for (int i=0; i<tamaño;i++){
                for (int j=0; j<tamaño; j++){
                    try{
                        if (tab[i][j].selected){
                            if (i % 2 == 0){
                                if (j % 2 == 0)
                                    System.out.print("\033[0;107m" + "\u001B[33m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                                else
                                    System.out.print("\033[40m" + "\u001B[33m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                            }else{
                                if(j%2==1)
                                    System.out.print("\033[0;107m" + "\u001B[33m" + " "  + tab[i][j].icon + " " + "\u001B[0m");
                                else
                                    System.out.print("\033[40m" + "\u001B[33m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                            }
                        }
                        else if(tab[i][j].color) {
                            if (i % 2 == 0) {
                                if (j % 2 == 0)
                                    System.out.print("\033[0;107m" + "\u001B[36m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                                else
                                    System.out.print("\033[40m" + "\u001B[36m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                            } else {
                                if (j % 2 == 1)
                                    System.out.print("\033[0;107m" + "\u001B[36m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                                else
                                    System.out.print("\033[40m" + "\u001B[36m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                            }
                        }
                        else {
                            if (i % 2 == 0) {
                                if (j % 2 == 0)
                                    System.out.print("\033[0;107m" + "\u001B[35m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                                else
                                    System.out.print("\033[40m" + "\u001B[35m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                            }
                            else{
                                if (j % 2 == 1)
                                    System.out.print("\033[0;107m" + "\u001B[35m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                                else
                                    System.out.print("\033[40m" + "\u001B[35m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                            }
                        }
                    } catch (Exception e){
                        if (i % 2 == 0) {
                            if (j % 2 == 0)
                                System.out.print("\033[0;107m" + " " + "\u2001" + " " + "\u001B[0m");
                            else
                                System.out.print("\033[40m" + " " + "\u2001" + " " + "\u001B[0m");
                        } else {
                            if (j % 2 == 1)
                                System.out.print("\033[0;107m" + " " + "\u2001" + " " + "\u001B[0m");
                            else
                                System.out.print("\033[40m" + " " + "\u2001" + " " + "\u001B[0m");
                        }
                    }
                }
                //System.out.print("|");
                System.out.println();
            }
        }
       /* public void MoverPieza(int coordx, int coordy){

        Pieza pieza = Juego.tablero.tab[coordy][coordx];
        pieza.movimiento();


        }*/
}