
public class Filme {
	public static final int NORMAL = 0;
	public static final int INFANTIL = 1;
	public static final int LANCAMENTO = 3;

	private String titulo;
	private int preco;

	public Filme(String titulo, int preco) {
		this.titulo = titulo;
		this.preco = preco;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public String getTitulo() {
		return titulo;
	}
}
