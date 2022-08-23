import java.util.Date;

abstract public class Operacao {

    Date inicio;
    Date fim;

    public Operacao(Date inicio) {
        this.inicio = inicio;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public String tempoTotal() {
        if(fim == null) return "Nenhuma data de fim foi setada";

        return UtilsDate.diferencaDatas(inicio, fim);
    }
}
