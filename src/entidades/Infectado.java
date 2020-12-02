package entidades;
import armas.Arma;
import logica.Juego;

public abstract class Infectado extends Humano {
	
	protected static int cargaViralInicial = 100;
	protected boolean golpeo;
	
	public Infectado(Arma a,Juego juego, int x, int y, int vx, int vy) {
		super(a, juego, x, y, vx, vy);
		golpeo = false;
	}
	
	@Override
	public void actualizar() {
		super.actualizar();
		
		if (getCV() <= 0) {
			eliminar();
		}
	}
	
	public abstract void atacarMelee();

	public void setGolpeo(boolean v) {
		golpeo = v;
	}
	
}
