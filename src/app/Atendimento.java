package app;
import java.util.ArrayList;
import java.util.Date;

public class Atendimento extends Operacao {
    private Paciente paciente;
    private Medico medico;

    private int prioridade;

    private EstadoAtendimento estado;
    
    public Atendimento(Paciente paciente, ArrayList<Boolean> respostas) {
        super(new Date());
        this.paciente = paciente;
        estado = EstadoAtendimento.ESPERANDO_TRIAGEM;
        this.calculaPrioridade(respostas);
        this.estado = EstadoAtendimento.ESPERANDO_CONSULTA;
    }

    public void calculaPrioridade(ArrayList<Boolean> respostas) {
        this.estado = EstadoAtendimento.EM_TRIAGEM;

        for (Boolean resposta : respostas) {
            if(resposta) {
                this.prioridade++;
            }
        }
    }

    public void consulta(Medico medico) {
        this.estado = EstadoAtendimento.EM_CONSULTA;
        this.medico = medico;
        this.estado = EstadoAtendimento.ATENDIDO;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public EstadoAtendimento getEstado() {
        return estado;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }
}
