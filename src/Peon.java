import java.util.ArrayList;

public class Peon extends Pieza {
    boolean moved;
    boolean promote;

    public Peon(int posx, int posy){
        super();
        promote = false;
        viva = true;
        moved=false;
        icon="♙";
        if(posx==1){
            color=false;
        }
        else{
            color=true;
        }
            regresar=true;
            posicionx = posx;
            posiciony = posy;
    }

    @Override
    public void movimiento() {
        int l;
        if (!moved)
            l = 0;
        else l = 1;
        if (!color) {
            for (int n = 1; n <= 2 - l &&  posicionx + n < 7; n++) {
                if (Juego.tablero.tab[ posicionx + n][posiciony] == null) {
                    mov[0] =  posicionx + n;
                    mov[1] =  posiciony;
                    movValidos.add(mov.clone());
                } else break;
            }
            if(posicionx + 1 <= 7 && posiciony + 1 <= 7) {
                if (Juego.tablero.tab[posicionx + 1][posiciony + 1] != null) {
                    if (Juego.tablero.tab[posicionx + 1][posiciony + 1].color != this.color) {
                        mov[0] = posicionx + 1;
                        mov[1] = posiciony + 1;
                        movValidos.add(mov.clone());
                    }
                }
            }
            if(posicionx + 1 <= 7 && posiciony - 1 >= 0) {
                if (Juego.tablero.tab[posicionx + 1][posiciony - 1] != null) {
                    if (Juego.tablero.tab[posicionx + 1][posiciony - 1].color != this.color) {
                        mov[0] = posicionx + 1;
                        mov[1] = posiciony - 1;
                        movValidos.add(mov.clone());
                    }
                }
            }
        } else {
            for (int n = 1; n <= 2 - l && posicionx - n >= 0; n++) {
                if (Juego.tablero.tab[posicionx - n][posiciony] == null) {
                    mov[0] = posicionx - n;
                    mov[1] = posiciony;
                    movValidos.add(mov.clone());
                } else break;
            }
            if(posicionx - 1 >= 0 && posiciony + 1 <= 7) {
                if (Juego.tablero.tab[posicionx - 1][posiciony + 1] != null) {
                    if (Juego.tablero.tab[posicionx - 1][posiciony + 1].color != this.color) {
                        mov[0] = posicionx - 1;
                        mov[1] = posiciony + 1;
                        movValidos.add(mov.clone());
                    }
                }
            }
            if (posicionx - 1 >= 0 && posiciony - 1 >= 0) {
                if (Juego.tablero.tab[posicionx - 1][posiciony - 1] != null) {
                    if (Juego.tablero.tab[posicionx - 1][posiciony - 1].color != this.color) {
                        mov[0] = posicionx - 1;
                        mov[1] = posiciony - 1;
                        movValidos.add(mov.clone());
                    }
                }
            }
        }
        posPieza[0] = this.posicionx;
        posPieza[1] = this.posiciony;
        buscarRey(posPieza);
        try {
            if(Juego.jaqueBlanco || Juego.jaqueNegro)
                movValidos = compararListas(movValidos, Juego.piezaJaque.movAmenaza);
            movValidos = compararListas(movValidos, Juego.piezaBloqueada.movAmenaza);
        }
        catch(Exception e){}
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
            this.moved = true;
        }
    }
    @Override
    public void amenaza(Pieza rey){
            ame[0] = this.posicionx;
            ame[1] = this.posiciony;
            movAmenaza.add(ame.clone());
    }

    public ArrayList<int[]> compararListas(ArrayList<int[]> movValidos, ArrayList<int[]> movAmenaza) {
        ArrayList<int[]> movimientos = new ArrayList<int[]>();
        for (int[] elemento : movValidos) {
            for (int[] elemento2 : movAmenaza) {
                if (elemento[0] == elemento2[0] && elemento[1] == elemento2[1])
                    movimientos.add(elemento);
            }
        }
        return movimientos;
    }
}
