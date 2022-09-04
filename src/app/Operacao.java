package app;
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
        return UtilsDate.diferencaDatas(inicio, fim);
    }
}
