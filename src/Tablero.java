import java.util.ArrayList;

public class Tablero {
    static int tamaño = 8;

    public Pieza[][] tab;
    int posx, posy;
    String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h"};
    String[] numeros = {"8", "7", "6", "5", "4", "3", "2", "1"};

    public Tablero() {
        tab = new Pieza[tamaño][tamaño];
        tab[0][0] = new Torre(0,0);
        tab[0][7] = new Torre(0,7);
        tab[7][0] = new Torre(7,0);
        tab[7][7] = new Torre(7,7);

        tab[0][1] = new Caballo(0,1);
        tab[0][6] = new Caballo(0,6);
        tab[7][1] = new Caballo(7,1);
        tab[7][6] = new Caballo(7,6);

        tab[0][2] = new Alfil(0,2);
        tab[0][5] = new Alfil(0,5);
        tab[7][2] = new Alfil(7,2);
        tab[7][5] = new Alfil(7,5);

        tab[0][4] = new Rey(0,4);
        tab[7][4] = new Rey(7,4);

        tab[0][3] = new Reina(0,3);
        tab[7][3] = new Reina(7,3);

        for (int i = 0; i < tamaño; i++) {
            tab[1][i] = new Peon(1,i);
            tab[6][i] = new Peon(6,i);
        }
        /*
        for (posx = 0; posx < tamaño; posx++) {
            for (posy = 0; posy < tamaño; posy++) {
                if ((posx == 0 && posy == 0) || (posx == 0 && posy == 7) || (posx == 7 && posy == 0) || (posx == 7 && posy == 7))
                    tab[posx][posy] = new Torre();
                else if ((posx == 0 && posy == 1) || (posx == 7 && posy == 1) || (posx == 0 && posy == 6) || (posx == 7 && posy == 6))
                    tab[posx][posy] = new Caballo();
                else if ((posx == 0 && posy == 2) || (posx == 7 && posy == 2) || (posx == 0 && posy == 5) || (posx == 7 && posy == 5))
                    tab[posx][posy] = new Alfil();
                else if ((posx == 0 && posy == 4) || (posx == 7 && posy == 4))
                    tab[posx][posy] = new Rey();
                else if ((posx == 0 && posy == 3) || (posx == 7 && posy == 3))
                    tab[posx][posy] = new Reina();
                else if ((posx == 1  || posx == 6) )
                    tab[posx][posy] = new Peon();

            }
        }*/
    }


    public void imprimirTablero() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                try {
                    if (tab[i][j].selected) {
                        if (i % 2 == 0) {
                            if (j % 2 == 0)
                                System.out.print("\033[0;107m" + "\u001B[33m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                            else
                                System.out.print("\033[40m" + "\u001B[33m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                        } else {
                            if (j % 2 == 1)
                                System.out.print("\033[0;107m" + "\u001B[33m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                            else
                                System.out.print("\033[40m" + "\u001B[33m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                        }
                    } else if (tab[i][j].color) {
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
                    } else {
                        if (i % 2 == 0) {

                            if (j % 2 == 0)
                                System.out.print("\033[0;107m" + "\u001B[35m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                            else
                                System.out.print("\033[40m" + "\u001B[35m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                        } else {
                            if (j % 2 == 1)
                                System.out.print("\033[0;107m" + "\u001B[35m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                            else
                                System.out.print("\033[40m" + "\u001B[35m" + " " + tab[i][j].icon + " " + "\u001B[0m");
                        }
                    }
                } catch (Exception e) {
                    if (i == tamaño) {
                        if (j == tamaño)
                            System.out.print("\033[0;104m" + " dddd");
                        else
                            System.out.print("\033[0;104m" + " dddd");
                    }
                    if (i % 2 == 0 && i < 9) {
                        if (j % 2 == 0 && j < 9)
                            System.out.print("\033[0;107m" + " " + "\u2001" + " " + "\u001B[0m");
                        else
                            System.out.print("\033[40m" + " " + "\u2001" + " " + "\u001B[0m");
                    } else {
                        if (j % 2 == 1 && j < 9)
                            System.out.print("\033[0;107m" + " " + "\u2001" + " " + "\u001B[0m");
                        else
                            System.out.print("\033[40m" + " " + "\u2001" + " " + "\u001B[0m");
                    }
                }
            }
            System.out.println("\033[0;103m" + "\u001B[30m" + " " + numeros[(numeros.length - 1) - i] + " " + "\u001B[0m");
            //System.out.print("|");

        }
        for (int l = 0; l < letras.length; l++) {
            System.out.print("\u001b[0;103m" + "\u001B[33;33;33m"+ "   " +"\u001b[30m"+ letras[l] + " " + "\u001b[0m");
        }
        System.out.println("");

    }
}