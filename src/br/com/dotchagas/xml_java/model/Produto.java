package br.com.dotchagas.xml_java.model;

public class Produto {

	private String nome;
    private double preco;

    public Produto(String nome,double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Produto() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

    @Override
    public String toString() {
        return "Nome:"+ this.nome + "\n Preço:" + this.preco +"\n";
    }

	public void setNome(String string) {
		// TODO Auto-generated method stub
		nome = string;
		
	}

	public void setPreco(double parseDouble) {
		// TODO Auto-generated method stub
		preco = parseDouble;
	}
}
