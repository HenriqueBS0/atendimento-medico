import java.util.ArrayList;
import java.util.Scanner;

import app.Atendimento;
import app.Atestado;
import app.Especialidade;
import app.EstadoAtendimento;
import app.ListaAntedimento;
import app.Medico;
import app.Paciente;
import app.UtilsDate;
import idiomas.InglesMensagem;
import idiomas.Mensagem;
import idiomas.PortuguesMensagem;

public class App {

    public static Mensagem mensagem;

    private static Scanner entrada = new Scanner(System.in);

    private static ArrayList<Especialidade> especialidades = new ArrayList<Especialidade>();
    
    private static ArrayList<Medico> medicos = new ArrayList<Medico>();
    

    public static void main(String[] args) {
        definirIdioma();
        cadastrarEspecialiades();
        cadastrarMedicos();
        menuInicial();
    }

    public static void definirIdioma() {

        ArrayList<Mensagem> idiomas = new ArrayList<Mensagem>();
        idiomas.add(new PortuguesMensagem());
        idiomas.add(new InglesMensagem());
        

        System.out.println("-----{Selecione o Idioma}-----");
        for (int i = 0; i < idiomas.size(); i++) {
            System.out.println((i + 1) + " - " + idiomas.get(i).getNomeIdioma());
        }

        int opcao;

        do {
            opcao = getInt("Idioma: ");
        } while (opcao <= 0 || opcao > idiomas.size());

        Mensagem idioma = idiomas.get(opcao - 1);

        App.mensagem = idioma;
        UtilsDate.mensagem = idioma;
        Atestado.mensagem = idioma;

    }

    public static void cadastrarEspecialiades() {

        System.out.println(mensagem.getCabecalhoCadastroEspecialidades());

        do {
            especialidades.add(new Especialidade(getString(mensagem.getInfomeNomeEspecialidade())));
        } while (getString(mensagem.getContinuarCadastro()).equals(mensagem.getCaracterConfirmacao()));
    }

    public static void cadastrarMedicos() {

        System.out.println(mensagem.getCabecalhoCadastroMedicos());

        do {

            Medico medico = new Medico(getString(mensagem.getInformarDataNascimento()), getString(mensagem.getInformeNome()));
            
            for (Especialidade especialidade : getEspecialidades()) {
                medico.addEspecialidade(especialidade);
            }

            medicos.add(medico);
        } while (getString(mensagem.getContinuarCadastro()).equals(mensagem.getCaracterConfirmacao()));
    }


    public static ArrayList<Especialidade> getEspecialidades() {
        ArrayList<Especialidade> especialidades = new ArrayList<Especialidade>();

        do {
            especialidades.add(getEspecialidade());
        } while (getString(mensagem.getContinuarCadastro()).equals(mensagem.getCaracterConfirmacao()));

        return especialidades;
    }

    public static Especialidade getEspecialidade() {
        System.out.println(mensagem.getCabecalhoEspecialidades());
        for (int i = 0; i < especialidades.size(); i++) {
            System.out.println((i + 1) + " - " + especialidades.get(i).getDescricao());
        }

        int opcao;

        do {
            opcao = getInt(mensagem.getInfomeNomeEspecialidade());
        } while (opcao <= 0 || opcao > especialidades.size());

        return especialidades.get((opcao - 1));
    }

    public static void menuInicial() {
        
        int opcao;
        
        do {
            opcao = getInt(mensagem.menu());
        } while(opcao < 1 && opcao < 3);

        switch (opcao) {
            case 1:
               mostrarListaAtendimento();
                break;
            case 2:
                novaConsulta();
                break;
            case 3:
                novoAtendimento();
                break;
            case 4:
                return;
        }

        menuInicial();
    }

    public static void mostrarListaAtendimento() {
        System.out.println(mensagem.getCabecalhoListaAtendimentos());
        for (Atendimento atendimento : ListaAntedimento.mostrarLista()) {
            System.out.println(String.format(mensagem.getModeloAtendimento(), atendimento.getPrioridade(), mensagem.getEstado(atendimento.getEstado()), atendimento.getPaciente().getNome()));
        }
    }

    public static void novaConsulta() {
        Atendimento atendimento = getAtendimentoEsperandoConsulta();
        
        if(atendimento == null) {
            System.out.println(mensagem.getNenhumAtendimentoEsperandoConsulta());
            return;
        }

        atendimento.consulta(getMedico());
        
        System.out.println(mensagem.getCabecalhoGerarAtestado());


        Atestado atestado = new Atestado(
            getInt(mensagem.getInformeCID()), 
            UtilsDate.stringToDate(getString(mensagem.getInformeDataInicial())), 
            UtilsDate.stringToDate(getString((mensagem.getInformeDataFinal())))
        );

        System.out.println(atestado.emitir(atendimento));
    }

    public static Atendimento getAtendimentoEsperandoConsulta() {
        for (Atendimento atendimento : ListaAntedimento.mostrarLista()) {
            if(atendimento.getEstado() == EstadoAtendimento.ESPERANDO_CONSULTA) {
                return atendimento;
            }
        }

        return null;
    }

    public static Medico getMedico() {
        System.out.println(mensagem.getCabecalhoMedicos());
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println((i + 1) + " - " + medicos.get(i).getNome());
        }

        int opcao;

        do {
            opcao = getInt(mensagem.getInformeMedico());
        } while (opcao <= 0 || opcao > medicos.size());

        return medicos.get((opcao - 1));
    }

    public static void novoAtendimento() {

        Paciente paciente = new Paciente(getString(mensagem.getInformarDataNascimento()), getString(mensagem.getInformeNome()));

        ListaAntedimento.addLista(new Atendimento(paciente, getRespostas(mensagem.getPerguntasAtendimento())));
    }

    public static ArrayList<Boolean> getRespostas(ArrayList<String> perguntas) {
        ArrayList<Boolean> respostas = new ArrayList<Boolean>();

        for (String pergunta : perguntas) {
            respostas.add(getString(pergunta).equals(mensagem.getCaracterConfirmacao()));
        }

        return respostas;
    }

    public static int getInt(String mensagem) {
        System.out.print(mensagem);
        int resultado = entrada.nextInt();
        entrada.nextLine();
        return resultado;
    }

    public static String getString(String mensagem) {
        System.out.print(mensagem);
        return entrada.nextLine();
    }

    public static double getDouble(String mensagem) {
        System.out.print(mensagem);
        double resultado = entrada.nextDouble();
        entrada.nextLine();
        return resultado;
    }

    public static float getFloat(String mensagem) {
        System.out.print(mensagem);
        float resultado = entrada.nextFloat();
        entrada.nextLine();
        return resultado;
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void continuar() {
        getString(mensagem.continuar());
    }
}
