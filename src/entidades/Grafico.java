package entidades;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Grafico extends JLabel {
	private static final long serialVersionUID = 1L;
	
	// cada Grafico conoce un unico mapeo de Strings a imagenes preinicializadas
	// Cuando se inicializa el grafico, solo se le indica que tipo de Entidad
	// tiene que representar y a partir de esa indicacion decide que imagen usar
	private static HashMap<String, ImageIcon> mapeoSprites;
	
	private ImageIcon imagen;
	private int x, y;	
	private String toString;
	
	public Grafico(String tipo, int x, int y) {
		if (mapeoSprites == null) {
			mapeoSprites = new HashMap<String, ImageIcon>();
			// Jugador
			mapeoSprites.put("JugadorDefault", new ImageIcon("img/jugador.PNG"));
			mapeoSprites.put("JugadorDefaultDisp", new ImageIcon("img/jugadorDisp.GIF"));
			mapeoSprites.put("JugadorDefaultIzq", new ImageIcon("img/jugadorIzq.GIF"));
			mapeoSprites.put("JugadorDefaultDer", new ImageIcon("img/jugadorDer.GIF"));
			mapeoSprites.put("JugadorSuper", new ImageIcon("img/jugadorSuper.PNG"));
			mapeoSprites.put("JugadorSuperDisp", new ImageIcon("img/jugadorSuperDisp.GIF"));
			mapeoSprites.put("JugadorSuperIzq", new ImageIcon("img/jugadorSuperIzq.GIF"));
			mapeoSprites.put("JugadorSuperDer", new ImageIcon("img/jugadorSuperDer.GIF"));
			mapeoSprites.put("JugadorRapida", new ImageIcon("img/jugadorRapida.PNG"));
			mapeoSprites.put("JugadorRapidaDisp", new ImageIcon("img/jugadorRapidaDisp.GIF"));
			mapeoSprites.put("JugadorRapidaIzq", new ImageIcon("img/jugadorRapidaIzq.GIF"));
			mapeoSprites.put("JugadorRapidaDer", new ImageIcon("img/jugadorRapidaDer.GIF"));
			mapeoSprites.put("Muerte", new ImageIcon("img/muerte.png"));
			// Infectados
			mapeoSprites.put("InfectadoAlfa", new ImageIcon("img/infectadoA.GIF"));
			mapeoSprites.put("InfectadoAlfa2", new ImageIcon("img/infectadoA2.GIF"));
			mapeoSprites.put("InfectadoBeta", new ImageIcon("img/infectadoB.GIF"));
			mapeoSprites.put("InfectadoBeta2", new ImageIcon("img/infectadoB2.GIF"));
			mapeoSprites.put("InfectadoAlfaS", new ImageIcon("img/infectadoAStill.png"));
			mapeoSprites.put("InfectadoAlfa2S", new ImageIcon("img/infectadoA2Still.png"));
			mapeoSprites.put("InfectadoBetaS", new ImageIcon("img/infectadoBStill.png"));
			mapeoSprites.put("InfectadoBeta2S", new ImageIcon("img/infectadoB2Still.png"));
			// Misc
			mapeoSprites.put("Bala", new ImageIcon("img/bala.png"));
			mapeoSprites.put("Infeccion", new ImageIcon("img/infeccion.png"));
			mapeoSprites.put("PowerUp", new ImageIcon("img/powerup.gif"));
			mapeoSprites.put("DeleteInfeccion", new ImageIcon("img/hitInfeccion.gif"));
			mapeoSprites.put("DeleteBala", new ImageIcon("img/healing.gif"));
			mapeoSprites.put("Melee", new ImageIcon("img/hit.gif"));
			mapeoSprites.put("Cargando", new ImageIcon("img/cargandolvl.gif"));
		}
		
		imagen = mapeoSprites.get(tipo);
		toString = tipo;
		setIcon(imagen);
		
		// Compensar por las dimensiones de la imagen
		// Relativo a la imagen, la coordenada (0,0) es la esquina
		// superior izquierda, y esto lo centra en la imagen.
		this.x = x - imagen.getIconWidth()/2;
		this.y = y - imagen.getIconHeight()/2;
		reposicionar();
	}
	
	private void reposicionar() {
		setBounds(this.x, this.y, imagen.getIconWidth(), imagen.getIconHeight());
	}
	
	public ImageIcon getImagen() {
		return imagen;
	}
	
	public void setImagen(String tipo) {
		if (tipo != toString) { // Evita que se vea feo al moverse el jugador
			imagen = mapeoSprites.get(tipo);
			toString = tipo;
			setIcon(imagen);
		}
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		reposicionar();
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
		reposicionar();
	}
	
	public int getAnchoImg() {
		return imagen.getIconWidth();
	}
	
	public int getAltoImg() {
		return imagen.getIconWidth();
	}

	public String toString() {
		return toString;
	}
	
}
