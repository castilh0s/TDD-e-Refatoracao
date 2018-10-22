
public abstract class Preco {
	abstract public int getPreco();

	abstract public double getValor(int diasAluguel);

	public int getPontos(int diasAluguel) {
		return 1;
	}
}

class PrecoNormal extends Preco {
	@Override
	public int getPreco() {
		return Filme.NORMAL;
	}

	@Override
	public double getValor(int diasAluguel) {
		double valor = 1.5;
		if (diasAluguel > 3)
			valor += (diasAluguel - 3) * 1.5;
		return valor;
	}
}

class PrecoInfantil extends Preco {
	@Override
	public int getPreco() {
		return Filme.INFANTIL;
	}

	@Override
	public double getValor(int diasAluguel) {
		double valor = 2;
		if (diasAluguel > 2)
			valor += (diasAluguel - 2) * 1.5;
		return valor;
	}
}

class PrecoLancamento extends Preco {
	@Override
	public int getPreco() {
		return Filme.LANCAMENTO;
	}

	@Override
	public double getValor(int diasAluguel) {
		return diasAluguel * 3;
	}

	@Override
	public int getPontos(int diasAluguel) {
		if (diasAluguel > 1)
			return 2;
		else
			return super.getPontos(diasAluguel);
	}
}