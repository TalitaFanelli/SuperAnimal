package bd.dbos;

import javax.xml.bind.annotation.XmlRootElement;

//SEMPRE utilizar @XmlRootElement antes do public class
@XmlRootElement
public class Medico {

	/* DADOS TABELA MEDICO*/
	private String cpf;
	private String crmv;
	private String senha;

	/* DADOS TABELA DADOS_PESSOAIS*/
	private String nome;
	private String sobrenome;
	private String nascimento;
	private String genero;

	/* DADOS TABELA DADOS_RESIDENCIAIS*/
	private String cep;
	private String endereco;
	private String bairro;
	private String numero;
	private String complemento;
	private String cidade;
	private String estado;

	/* DADOS TABELA DADOS_CONTATO*/
	private String email;
	private String fixo;
	private String celular;


	public String getCpf() {
		return cpf;
	}

	public String getCrmv() {
		return crmv;
	}

	public String getSenha() {
		return senha;
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

	public String getGenero() {
		return genero;
	}

	public String getCep() {
		return cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getEmail() {
		return email;
	}

	public String getFixo() {
		return fixo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFixo(String fixo) {
		this.fixo = fixo;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Medico (String cpf, String crmv, String senha, String nome, String sobrenome, String nascimento, String genero,
			String cep, String endereco, String bairro, String numero, String complemento, String cidade, String estado, String email,
			String fixo, String celular) throws Exception{

		this.setCpf(cpf);

		this.setCrmv(crmv);

		this.setSenha(senha);

		this.setNome(nome);	   

		this.setSobrenome(sobrenome);	   

		this.setNascimento(nascimento);	   

		this.setGenero(genero);		   

		this.setCep(cep);	

		this.setEndereco(endereco);		   

		this.setBairro(bairro);

		this.setNumero(numero);		   

		this.setComplemento(complemento);		   

		this.setCidade(cidade);	   

		this.setEstado(estado);		   

		this.setEmail(email);		   

		this.setFixo(fixo);		   

		this.setCelular(celular);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((crmv == null) ? 0 : crmv.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fixo == null) ? 0 : fixo.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((nascimento == null) ? 0 : nascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Medico other = (Medico) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (crmv == null) {
			if (other.crmv != null)
				return false;
		} else if (!crmv.equals(other.crmv))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fixo == null) {
			if (other.fixo != null)
				return false;
		} else if (!fixo.equals(other.fixo))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
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
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
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
		return "Medico [cpf=" + cpf + ", crmv=" + crmv + ", senha=" + senha + ", nome=" + nome + ", sobrenome="
				+ sobrenome + ", nascimento=" + nascimento + ", genero=" + genero + ", cep=" + cep + ", endereco="
				+ endereco + ", bairro=" + bairro + ", numero=" + numero + ", complemento=" + complemento + ", cidade="
				+ cidade + ", estado=" + estado + ", email=" + email + ", fixo=" + fixo + ", celular=" + celular + "]";
	}
}