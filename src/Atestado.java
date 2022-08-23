import java.sql.Date;

public class Atestado extends Operacao {
    private int cid;

    public Atestado(int cid, Date dataInicio, Date dataFim) {
        super(dataInicio);
        this.setFim(dataFim);
        this.cid = cid;
    }

    public void emitir(Atendimento atendimento) {
        System.out.println("-----{Atestado}-------");
        System.out.println("Paciente: " + atendimento.getPaciente().getNome());
        System.out.println("Médico: " + atendimento.getMedico().getNome());
        System.out.println("Data Inicial: " + UtilsDate.dateToString(inicio));
        System.out.println("Data Final: " + UtilsDate.dateToString(fim));
        System.out.println("Cid: " + cid);
    }
}
