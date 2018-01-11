package mobile.app.superanimal;

/**
 * Created by Talita on 28/11/2017.
 */

public class Agendamento {

    private String id_agendamento;
    private String cpf_cliente;
    private String data;
    private String horario;
    private String animal;
    private String banho, tosa, hidratacao, unhas, dentes, ouvidos;
    private String total;

    public void setId_agendamento(String id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setBanho(String banho) {
        this.banho = banho;
    }

    public void setTosa(String tosa) {
        this.tosa = tosa;
    }

    public void setHidratacao(String hidratacao) {
        this.hidratacao = hidratacao;
    }

    public void setUnhas(String unhas) {
        this.unhas = unhas;
    }

    public void setDentes(String dentes) {
        this.dentes = dentes;
    }

    public void setOuvidos(String ouvidos) {
        this.ouvidos = ouvidos;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getId_agendamento() {
        return id_agendamento;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public String getAnimal() {
        return animal;
    }

    public String getBanho() {
        return banho;
    }

    public String getTosa() {
        return tosa;
    }

    public String getHidratacao() {
        return hidratacao;
    }

    public String getUnhas() {
        return unhas;
    }

    public String getDentes() {
        return dentes;
    }

    public String getOuvidos() {
        return ouvidos;
    }

    public String getTotal() {
        return total;
    }

    public Agendamento () throws Exception {

        this.setId_agendamento(id_agendamento);
        this.setCpf_cliente(cpf_cliente);
        this.setData(data);
        this.setHorario(horario);
        this.setAnimal(animal);
        this.setBanho(banho);
        this.setTosa(tosa);
        this.setHidratacao(hidratacao);
        this.setUnhas(unhas);
        this.setDentes(dentes);
        this.setOuvidos(ouvidos);
        this.setTotal(total);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((animal == null) ? 0 : animal.hashCode());
        result = prime * result + ((banho == null) ? 0 : banho.hashCode());
        result = prime * result + ((cpf_cliente == null) ? 0 : cpf_cliente.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((dentes == null) ? 0 : dentes.hashCode());
        result = prime * result + ((hidratacao == null) ? 0 : hidratacao.hashCode());
        result = prime * result + ((horario == null) ? 0 : horario.hashCode());
        result = prime * result + ((id_agendamento == null) ? 0 : id_agendamento.hashCode());
        result = prime * result + ((ouvidos == null) ? 0 : ouvidos.hashCode());
        result = prime * result + ((tosa == null) ? 0 : tosa.hashCode());
        result = prime * result + ((total == null) ? 0 : total.hashCode());
        result = prime * result + ((unhas == null) ? 0 : unhas.hashCode());
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
        Agendamento other = (Agendamento) obj;
        if (animal == null) {
            if (other.animal != null)
                return false;
        } else if (!animal.equals(other.animal))
            return false;
        if (banho == null) {
            if (other.banho != null)
                return false;
        } else if (!banho.equals(other.banho))
            return false;
        if (cpf_cliente == null) {
            if (other.cpf_cliente != null)
                return false;
        } else if (!cpf_cliente.equals(other.cpf_cliente))
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (dentes == null) {
            if (other.dentes != null)
                return false;
        } else if (!dentes.equals(other.dentes))
            return false;
        if (hidratacao == null) {
            if (other.hidratacao != null)
                return false;
        } else if (!hidratacao.equals(other.hidratacao))
            return false;
        if (horario == null) {
            if (other.horario != null)
                return false;
        } else if (!horario.equals(other.horario))
            return false;
        if (id_agendamento == null) {
            if (other.id_agendamento != null)
                return false;
        } else if (!id_agendamento.equals(other.id_agendamento))
            return false;
        if (ouvidos == null) {
            if (other.ouvidos != null)
                return false;
        } else if (!ouvidos.equals(other.ouvidos))
            return false;
        if (tosa == null) {
            if (other.tosa != null)
                return false;
        } else if (!tosa.equals(other.tosa))
            return false;
        if (total == null) {
            if (other.total != null)
                return false;
        } else if (!total.equals(other.total))
            return false;
        if (unhas == null) {
            if (other.unhas != null)
                return false;
        } else if (!unhas.equals(other.unhas))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Agendamento [id_agendamento=" + id_agendamento + ", cpf_cliente=" + cpf_cliente + ", data=" + data
                + ", horario=" + horario + ", animal=" + animal + ", banho=" + banho + ", tosa=" + tosa
                + ", hidratacao=" + hidratacao + ", unhas=" + unhas + ", dentes=" + dentes + ", ouvidos=" + ouvidos
                + ", total=" + total + "]";
    }

}
