import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
    
    public Atendimento(Paciente paciente) {
        super(new Date());
        this.paciente = paciente;
        estado = Estado.ESPERANDO_TRIAGEM;
        this.calculaPrioridade(getRespostaPrioridade());
        estado = Estado.EM_TRIAGEM;
    }

    private ArrayList<Boolean> getRespostaPrioridade() {
        ArrayList<Boolean> respostas = new ArrayList<Boolean>();

        Scanner entrada = new Scanner(System.in);

        System.out.print("Inconciente? (S/N): ");
        respostas.add(entrada.nextLine().equals("S"));

        System.out.print("Dificuldade para respirar? (S/N): ");
        respostas.add(entrada.nextLine().equals("S"));

        System.out.print("Vomita? (S/N): ");
        respostas.add(entrada.nextLine().equals("S"));

        System.out.print("Inchada? (S/N): ");
        respostas.add(entrada.nextLine().equals("S"));

        System.out.print("Sente dor? (S/N): ");
        respostas.add(entrada.nextLine().equals("S"));

        entrada.close();

        return respostas;
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
        this.medico = medico;
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
                return "Esperando Consulta";
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
