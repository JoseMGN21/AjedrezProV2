public class Caballo extends Pieza {

    public Caballo(){
        super();
        viva=true;
        icon="♞";

        if (Tablero.posx==0)
            color=false;
        else
            color=true;

        regresar=true;
        posicionx=Tablero.posx;
        posiciony=Tablero.posy;
    }

    @Override
    public void movimiento() {
        for (n = 1; n <= 2; n++) {
            for (m = 2; m >= 1; m--) {
                if (m == n)
                    continue;
                try {
                    if (Juego.tablero.tab[posicionx + n][posiciony + m] == null) {
                        if (posicionx + n <= 7) {
                            mov[0] = posicionx + n;
                            mov[1] = posiciony + m;
                            movValidos.add(mov.clone());
                        }
                    } else if ((Juego.tablero.tab[posicionx + n][posiciony + m].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx + n;
                        mov[1] = posiciony + m;
                        movValidos.add(mov.clone());
                    }
                } catch (Exception e) {
                }
                try {
                    if (Juego.tablero.tab[posicionx - n][posiciony + m] == null) {
                        mov[0] = posicionx - n;
                        mov[1] = posiciony + m;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[posicionx - n][posiciony + m].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx - n;
                        mov[1] = posiciony + m;
                        movValidos.add(mov.clone());
                    }
                } catch (Exception e) {
                }
                try {
                    if (Juego.tablero.tab[posicionx + n][posiciony - m] == null) {
                        if (posicionx + n <= 7) {
                            mov[0] = posicionx + n;
                            mov[1] = posiciony - m;
                            movValidos.add(mov.clone());
                        }
                    } else if ((Juego.tablero.tab[posicionx + n][posiciony - m].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx + n;
                        mov[1] = posiciony - m;
                        movValidos.add(mov.clone());
                    }
                } catch (Exception e) {
                }
                try {
                    if (Juego.tablero.tab[posicionx - n][posiciony - m] == null) {
                        mov[0] = posicionx - n;
                        mov[1] = posiciony - m;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[posicionx - n][posiciony - m].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx - n;
                        mov[1] = posiciony - m;
                        movValidos.add(mov.clone());
                    }
                } catch (Exception e) {
                }
            }
        }

        if (movValidos.size() == 0) {
            System.out.println("No hay movimientos válidos para esa pieza.");
            System.out.println("Seleccione otra pieza.");
            valido = false;
            Juego.tablero.tab[posicionx][posiciony].selected = false;
        } else {
            System.out.println("Movimientos válidos:");
            for (int[] elemento : movValidos) {

                System.out.println("[" + elemento[0] + "," + elemento[1] + "]");
            }
            valido = true;
        }
        if(movValidos.size() == 0){
            System.out.println("No existen movimientos válidos para esta pieza, elige otra.");
            this.selected = false;
            valido = false;
        }
    }
}
