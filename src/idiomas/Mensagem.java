package idiomas;

import java.util.ArrayList;

import app.EstadoAtendimento;

public interface Mensagem {
    public ArrayList<String> getPerguntasAtendimento();
    public String getEstado(EstadoAtendimento estado);
    public String getModeloAtestado();
    public String getModeloDiferencaDatas();
    public String getInfomeNomeEspecialidade();
    public String getContinuarCadastro();
    public String getCaracterConfirmacao();
    public String getInformarDataNascimento();
    public String getCabecalhoEspecialidades();
    public String getInformeEspecialdiadeMedico();
    public String menu();
    public String getCabecalhoListaAtendimentos();
    public String getModeloAtendimento();
    public String getNenhumAtendimentoEsperandoConsulta();
    public String getCabecalhoGerarAtestado();
    public String getInformeCID();
    public String getInformeDataInicial();
    public String getInformeDataFinal();
    public String getCabecalhoMedicos();
    public String getInformeMedico();
    public String continuas();
} 
