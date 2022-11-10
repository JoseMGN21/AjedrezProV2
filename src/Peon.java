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
        } else {
            for (int n = 1; n <= 2 - l &&  posicionx - n > 0; n++) {
                if (Juego.tablero.tab[posicionx - n][posiciony] == null) {
                    mov[0] =  posicionx - n;
                    mov[1] = posiciony;
                    movValidos.add(mov.clone());
                } else break;
            }
        }
        if (movValidos.size() == 0) {
            System.out.println("No hay movimientos válidos para esa pieza.");
            System.out.println("Seleccione otra pieza.");
            this.moved=false;
            valido = false;
            Juego.tablero.tab[posicionx][posiciony].selected = false;
        } else {
            System.out.println("Movimientos válidos:");
            for (int[] elemento : movValidos) {

                System.out.println("[" + elemento[0] + "," + elemento[1] + "]");
            }
            valido = true;
            this.moved=true;
        }
        if(movValidos.size() == 0){
            System.out.println("No existen movimientos válidos para esta pieza, elige otra.");
            this.selected = false;
            this.moved = false;
            valido = false;
        }
    }
}
