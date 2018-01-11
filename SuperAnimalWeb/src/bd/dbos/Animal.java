package bd.dbos;

import javax.xml.bind.annotation.XmlRootElement;

//SEMPRE utilizar @XmlRootElement antes do public class
@XmlRootElement
public class Animal {

	/* DADOS TABELA ANIMAL */
	private String cliente_cpf;
	private String nome;
	private String sobrenome;
	private String nascimento;
	private String sexo;
	private String especie;
	private String raca;
	private String pelagem;

	public String getCliente_cpf() {
		return cliente_cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public String getEspecie() {
		return especie;
	}
	
	public String getRaca() {
		return raca;
	}
	
	public String getPelagem() {
		return pelagem;
	}
		
	public void setCliente_cpf(String cliente_cpf) {
		this.cliente_cpf = cliente_cpf;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setPelagem(String pelagem) {
		this.pelagem = pelagem;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public Animal (String cliente_cpf, String nome, String sobrenome, String nascimento, String sexo,
    String especie, String raca, String pelagem) throws Exception{
			  
		  this.setCliente_cpf(cliente_cpf);
		   
		  this.setNome(nome);	  
		  
		  this.setSobrenome(sobrenome);	   
		  
		  this.setNascimento(nascimento);
		  
		  this.setSexo(sexo);
		  
		  this.setEspecie(especie);
		  
		  this.setRaca(raca);
		  
		  this.setPelagem(pelagem);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente_cpf == null) ? 0 : cliente_cpf.hashCode());
		result = prime * result + ((especie == null) ? 0 : especie.hashCode());
		result = prime * result + ((nascimento == null) ? 0 : nascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pelagem == null) ? 0 : pelagem.hashCode());
		result = prime * result + ((raca == null) ? 0 : raca.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (cliente_cpf == null) {
			if (other.cliente_cpf != null)
				return false;
		} else if (!cliente_cpf.equals(other.cliente_cpf))
			return false;
		if (especie == null) {
			if (other.especie != null)
				return false;
		} else if (!especie.equals(other.especie))
			return false;
		if (nascimento == null) {
			if (other.nascimento != null)
				return false;
		} else if (!nascimento.equals(other.nascimento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pelagem == null) {
			if (other.pelagem != null)
				return false;
		} else if (!pelagem.equals(other.pelagem))
			return false;
		if (raca == null) {
			if (other.raca != null)
				return false;
		} else if (!raca.equals(other.raca))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Animal [cliente_cpf=" + cliente_cpf + ", nome=" + nome + ", sobrenome=" + sobrenome + ", nascimento="
				+ nascimento + ", sexo=" + sexo + ", especie=" + especie + ", raca=" + raca + ", pelagem=" + pelagem
				+ "]";
	}
}