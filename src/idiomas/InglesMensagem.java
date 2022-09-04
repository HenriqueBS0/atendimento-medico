package idiomas;

import java.util.ArrayList;

import app.EstadoAtendimento;

public class InglesMensagem implements Mensagem {
    public String getNomeIdioma() {
        return "Inglês";
    }

    public String getCabecalhoCadastroEspecialidades() {
        return "----{Registration of Specialties}----";
    }

    public String getCabecalhoCadastroMedicos() {
        return "----{Physicians Registration}----";
    }

    public ArrayList<String> getPerguntasAtendimento() {
        ArrayList<String> perguntas = new ArrayList<String>();

        perguntas.add("Unconscious? (y/n):");
        perguntas.add("Difficulty breathing? (y/n): ");
        perguntas.add("Vomit? (y/n):");
        perguntas.add("Swollen? (y/n):");
        perguntas.add("Feel pain? (y/n):");

        return perguntas;
    };
    public String getEstado(EstadoAtendimento estado) {
        switch (estado) {
            case ESPERANDO_TRIAGEM:
                return "Waiting for Screening";
            case EM_TRIAGEM:
                return "In Triage";
            case ESPERANDO_CONSULTA:
                return "Waiting for Consultation";
            case EM_CONSULTA:
                return "In Consultation";
            case ATENDIDO:
                return "Attended";
        }

        return "";
    };
    public String getModeloAtestado() {
        String conteudo = "-----{Certificate}-------";
        
        conteudo+="\nPatient: %s";
        conteudo+="\nDoctor: %s";
        conteudo+="\nInitial date: %s";
        conteudo+="\nFinal date: %s";
        conteudo+="\nCID: %d";

        return conteudo;
    };
    public String getModeloDiferencaDatas() {
        return "%d Days %d Hours %d Minutes";
    };
    public String getInfomeNomeEspecialidade() {
        return "Enter the name of the specialty: ";
    };
    public String getContinuarCadastro() {
        return "Continue registering (y/n):";
    };
    public String getCaracterConfirmacao() {
        return "y";
    };
    public String getInformarDataNascimento() {
        return "Enter date of birth: ";
    };
    public String getInformeNome() {
        return "Inform the name: ";
    };
    public String getCabecalhoEspecialidades() {
        return "-----{Specialties}------";
    };
    public String getInformeEspecialdiadeMedico() {
        return "Inform the Specialty: ";
    };
    public String menu() {
        return "1 - Service List | 2 - New Query | 3 - New Anticipation | 4 - Finish: ";
    };
    public String getCabecalhoListaAtendimentos() {
        return "-----{List of Calls}-------";
    };
    public String getModeloAtendimento() {
        return "Priority: %d | Status: %s | Patient: %s";
    };
    public String getNenhumAtendimentoEsperandoConsulta() {
        return "No Service waiting for consultation";
    };
    public String getCabecalhoGerarAtestado() {
        return "----{Generate Certificate}----";
    };
    public String getInformeCID() {
        return "Inform the cid: ";
    };
    public String getInformeDataInicial() {
        return "Enter the Start date: ";
    };
    public String getInformeDataFinal() {
        return "Enter the date End date: ";
    };
    public String getCabecalhoMedicos() {
        return "-----{Doctors}-----";
    };
    public String getInformeMedico() {
        return "Inform the doctor: ";
    };
    public String continuar() {
        return "Press any key to continue\n";
    };
}
