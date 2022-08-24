import java.util.ArrayList;
import java.util.Date;

public class Atendimento extends Operacao {
    private Paciente paciente;
    private Medico medico;

    private int prioridade;

    enum Estado {
        ESPERANDO_TRIAGEM,
        EM_TRIAGEM,
        ESPERANDO_CONSULTA,
        EM_CONSULTA,
        ATENDIDO
    }

    private Estado estado;
    
    public Atendimento(Paciente paciente, ArrayList<Boolean> respostas) {
        super(new Date());
        this.paciente = paciente;
        estado = Estado.ESPERANDO_TRIAGEM;
        this.calculaPrioridade(respostas);
        this.estado = Estado.ESPERANDO_CONSULTA;
    }

    public static ArrayList<String> getPerguntas() {

        ArrayList<String> perguntas = new ArrayList<String>();

        perguntas.add("Inconciente? (S/N): ");
        perguntas.add("Dificuldade para respirar? (S/N): ");
        perguntas.add("Vomita? (S/N): ");
        perguntas.add("Inchada? (S/N): ");
        perguntas.add("Sente dor? (S/N): ");

        return perguntas;
    }

    public void calculaPrioridade(ArrayList<Boolean> respostas) {
        this.estado = Estado.EM_TRIAGEM;

        for (Boolean resposta : respostas) {
            if(resposta) {
                this.prioridade++;
            }
        }
    }

    public void consulta(Medico medico) {
        this.estado = Estado.EM_CONSULTA;
        this.medico = medico;
        this.estado = Estado.ATENDIDO;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getEstado() {
        switch (estado) {
            case ESPERANDO_TRIAGEM:
                return "Esperando Triagem";
            case EM_TRIAGEM:
                return "Em Triagem";
            case ESPERANDO_CONSULTA:
                return "Esperando Consulta";
            case EM_CONSULTA:
                return "Em Consulta";
            case ATENDIDO:
                return "Atendido";
        }

        return "";
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }
}
