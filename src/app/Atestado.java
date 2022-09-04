package app;
import java.util.Date;
public class Atestado extends Operacao {
    private int cid;

    public Atestado(int cid, Date dataInicio, Date dataFim) {
        super(dataInicio);
        this.setFim(dataFim);
        this.cid = cid;
    }

    public String emitir(Atendimento atendimento) {
        String conteudo = "-----{Atestado}-------";
        
        conteudo.concat(String.format("\nPaciente: %s", atendimento.getPaciente().getNome()));
        conteudo.concat(String.format("\nMédico: %s", atendimento.getMedico().getNome()));
        conteudo.concat(String.format("\nData Inicial: %s", UtilsDate.dateToString(inicio)));
        conteudo.concat(String.format("\nData Final: %s", UtilsDate.dateToString(fim)));
        conteudo.concat(String.format("\nCID: %d", cid));

        return conteudo;
    }
}
