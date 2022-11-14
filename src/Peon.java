import java.util.ArrayList;

public class Peon extends Pieza {
    boolean moved;
    boolean promote;

    public Peon(){
        super();
        promote = false;
        viva = true;
        moved=false;
        if(Tablero.posx==1){
            color=false;
            icon="♙";
        }
        else{
            color=true;
            icon="♙";
        }
            regresar=true;
            posicionx=Tablero.posx;
            posiciony=Tablero.posy;
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
            for (int n = 1; n <= 2 - l && posicionx - n > 0; n++) {
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
        if(Juego.jaqueNegro){
            if(!comprobarBloqueoComer() && !comprobarMovimientoRey(Juego.tablero.tab[Juego.posReyN[0]][Juego.posReyN[1]])){
                Juego.jaqueMate = true;
                if(Juego.jaqueMate){
                    System.out.println("Jaque mate");
                    System.exit(0);}
                return;
            }
            movValidos = compararListas(movValidos, Juego.piezaJaque.movAmenaza);
        } else if (Juego.jaqueBlanco){
            if(!comprobarBloqueoComer() && !comprobarMovimientoRey(Juego.tablero.tab[Juego.posReyB[0]][Juego.posReyB[1]])){
                Juego.jaqueMate = true;
                if(Juego.jaqueMate){
                    System.out.println("Jaque mate");
                    System.exit(0);}
                return;
            }
            movValidos = compararListas(movValidos, Juego.piezaJaque.movAmenaza);
        }
        try {
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
