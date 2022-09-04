package app;
import java.util.Date;

import idiomas.Mensagem;
public class Atestado extends Operacao {

    public static Mensagem mensagem;
    
    private int cid;

    public Atestado(int cid, Date dataInicio, Date dataFim) {
        super(dataInicio);
        this.setFim(dataFim);
        this.cid = cid;
    }

    public String emitir(Atendimento atendimento) {

        return String.format(
            mensagem.getModeloAtestado(), 
            atendimento.getPaciente().getNome(),
            atendimento.getMedico().getNome(),
            UtilsDate.dateToString(inicio),
            UtilsDate.dateToString(fim),
            cid
        );
    }
}
