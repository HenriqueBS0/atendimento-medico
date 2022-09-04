package idiomas;

import java.util.ArrayList;

import app.EstadoAtendimento;

public class PortuguesMensagem implements Mensagem {

    public String getNomeIdioma() {
        return "Português";
    }

    public String getCabecalhoCadastroEspecialidades() {
        return "----{Cadastro de Especialidades}----";
    }

    public String getCabecalhoCadastroMedicos() {
        return "----{Cadastro de Medicos}----";
    }

    public ArrayList<String> getPerguntasAtendimento() {
        ArrayList<String> perguntas = new ArrayList<String>();

        perguntas.add("Inconciente? (s/n): ");
        perguntas.add("Dificuldade para respirar? (s/n): ");
        perguntas.add("Vomita? (s/n): ");
        perguntas.add("Inchada? (s/n): ");
        perguntas.add("Sente dor? (s/n): ");

        return perguntas;
    };
    public String getEstado(EstadoAtendimento estado) {
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
    };
    public String getModeloAtestado() {
        String conteudo = "-----{Atestado}-------";
        
        conteudo+="\nPaciente: %s";
        conteudo+="\nMédico: %s";
        conteudo+="\nData Inicial: %s";
        conteudo+="\nData Final: %s";
        conteudo+="\nCID: %d";

        return conteudo;
    };
    public String getModeloDiferencaDatas() {
        return "%d Dias %d Horas %d Minutos";
    };
    public String getInfomeNomeEspecialidade() {
        return "Informe o nome da especialidade: ";
    };
    public String getContinuarCadastro() {
        return "Continuar cadastrando (s/n): ";
    };
    public String getCaracterConfirmacao() {
        return "s";
    };
    public String getInformarDataNascimento() {
        return "Informe a data de Nascimento: ";
    };
    public String getInformeNome() {
        return "Informe o nome: ";
    };
    public String getCabecalhoEspecialidades() {
        return "-----{Especialidades}------";
    };
    public String getInformeEspecialdiadeMedico() {
        return "Informe a Especialidade: ";
    };
    public String menu() {
        return "1 - Lista de Atendimento | 2 - Nova Consulta | 3 - Novo Antedimento | 4 - Finalizar: ";
    };
    public String getCabecalhoListaAtendimentos() {
        return "-----{Lista de Atendimentos}-------";
    };
    public String getModeloAtendimento() {
        return "Prioridade: %d | Situação: %s | Paciente: %s";
    };
    public String getNenhumAtendimentoEsperandoConsulta() {
        return "Nenhum Atendimento esperando consulta";
    };
    public String getCabecalhoGerarAtestado() {
        return "----{Gerar Atestado}----";
    };
    public String getInformeCID() {
        return "Informe o cid: ";
    };
    public String getInformeDataInicial() {
        return "Informe a data Inicial: ";
    };
    public String getInformeDataFinal() {
        return "Informe a data Data final: ";
    };
    public String getCabecalhoMedicos() {
        return "-----{Médicos}------";
    };
    public String getInformeMedico() {
        return "Informe o medico: ";
    };
    public String continuar() {
        return "Precione qualquer tecla para continuar\n";
    };
}
