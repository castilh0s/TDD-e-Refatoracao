import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private List<Aluguel> alugueis;

	public Cliente(String nome) {
		this.nome = nome;
		this.alugueis = new ArrayList<Aluguel>();
	}

	public void addAluguel(Aluguel aluguel) {
		this.alugueis.add(aluguel);
	}

	public String getNome() {
		return nome;
	}

	public String exibirRegistroAlugueis() {
		double valorTotal = 0;
		int pontos = 0;

		StringBuilder dados = new StringBuilder();
		dados.append("Registro de alugu�is do cliente: " + getNome() + "\n");

		for (Aluguel aluguel : this.alugueis) {
			double valor = 0;

//			Calcula o valor do aluguel
			switch (aluguel.getFilme().getPreco()) {
			case Filme.NORMAL:
				valor += 1.5;
				if (aluguel.getDiasAluguel() > 3)
					valor += (aluguel.getDiasAluguel() - 3) * 1.5;
				break;
			case Filme.INFANTIL:
				valor += 2;
				if (aluguel.getDiasAluguel() > 3)
					valor += (aluguel.getDiasAluguel() - 3) * 1.5;
				break;
			case Filme.LANCAMENTO:
				valor += aluguel.getDiasAluguel() * 3;
				break;
			}

//			Adiciona um ponto
			pontos++;

//			B�nus para mais de dois dias com um lan�amento
			if (aluguel.getFilme().getPreco() == Filme.LANCAMENTO && aluguel.getDiasAluguel() > 1) {
				pontos++;
			}

//			Adiciona os dados dessa aluguel
			dados.append("\t" + aluguel.getFilme().getTitulo() + "\t");
			dados.append(" = R$" + String.valueOf(valor) + "\n");

			valorTotal += valor;
		}

//		Rodap�
		dados.append("Total gasto com alugu�is: R$" + String.valueOf(valorTotal) + "\n");
		dados.append("Pontos ganhos: " + String.valueOf(pontos));

		return dados.toString();
	}
}
