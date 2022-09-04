import java.util.ArrayList;
import java.util.Scanner;

import app.Atendimento;
import app.Atestado;
import app.Especialidade;
import app.ListaAntedimento;
import app.Medico;
import app.Paciente;
import app.UtilsDate;

public class App {

    private static Scanner entrada = new Scanner(System.in);

    private static ArrayList<Especialidade> especialidades = new ArrayList<Especialidade>();
    
    private static ArrayList<Medico> medicos = new ArrayList<Medico>();
    

    public static void main(String[] args) {

        cadastrarEspecialiades();
        cadastrarMedicos();
        menuInicial();

    }

    public static void cadastrarEspecialiades() {
        do {
            especialidades.add(new Especialidade(getString("Informe o nome da especialidade: ")));
        } while (getString("Continuar cadastrando (s/n): ").equals("s"));
    }

    public static void cadastrarMedicos() {
        do {

            Medico medico = new Medico(getString("Informe a data de Nascimento: "), getString("Informe o nome: "));
            
            for (Especialidade especialidade : getEspecialidades()) {
                medico.addEspecialidade(especialidade);
            }

            medicos.add(medico);
        } while (getString("Continuar cadastrando médicos (s/n): ").equals("s"));
    }


    public static ArrayList<Especialidade> getEspecialidades() {
        ArrayList<Especialidade> especialidades = new ArrayList<Especialidade>();

        do {
            especialidades.add(getEspecialidade());
        } while (getString("Continuar cadastrando (s/n): ").equals("s"));

        return especialidades;
    }

    public static Especialidade getEspecialidade() {
        System.out.println("-----{Especialidades}------");
        for (int i = 0; i < especialidades.size(); i++) {
            System.out.println((i + 1) + " - " + especialidades.get(i).getDescricao());
        }

        int opcao;

        do {
            opcao = getInt("Informe a Especialidade: ");
        } while (opcao < 0 && opcao > especialidades.size());

        return especialidades.get((opcao - 1));
    }

    public static void menuInicial() {
        
        int opcao;
        
        do {
            opcao = getInt("1 - Lista de Atendimento | 2 - Nova Consulta | 3 - Novo Antedimento | 4 - Finalizar: ");
        } while(opcao < 1 && opcao < 3);

        switch (opcao) {
            case 1:
               mostrarListaAtendimento();
                break;
            case 2:
                
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
        System.out.println("-----{Lista de Atendimentos}-------");
        for (Atendimento atendimento : ListaAntedimento.mostrarLista()) {
            System.out.println(String.format("Prioridade: %d | Situação: %s | Paciente: %s", atendimento.getPrioridade(), atendimento.getEstado(), atendimento.getPaciente().getNome()));
        }
    }

    public static void novaConsulta() {
        Atendimento atendimento = getAtendimentoEsperandoConsulta();
        
        if(atendimento == null) {
            System.out.println("Nenhum Atendimento esperando consulta");
            return;
        }

        atendimento.consulta(getMedico());
        
        System.out.println("----{Gerar Atestado}----");


        Atestado atestado = new Atestado(
            getInt("Informe o cid: "), 
            UtilsDate.stringToDate(getString("Informe a data Inicial: ")), 
            UtilsDate.stringToDate(getString("Informe a data Final: "))
        );

        System.out.println(atestado.emitir(atendimento));
    }

    public static Atendimento getAtendimentoEsperandoConsulta() {
        for (Atendimento atendimento : ListaAntedimento.mostrarLista()) {
            if(atendimento.getEstado().equals("Esperando Consulta")) {
                return atendimento;
            }
        }

        return null;
    }

    public static Medico getMedico() {
        System.out.println("-----{Médicos}------");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println((i + 1) + " - " + medicos.get(i).getNome());
        }

        int opcao;

        do {
            opcao = getInt("Informe o medico: ");
        } while (opcao < 0 && opcao > medicos.size());

        return medicos.get((opcao - 1));
    }

    public static void novoAtendimento() {

        Paciente paciente = new Paciente(getString("Informe a data de Nascimento: "), getString("Informe o nome: "));

        ListaAntedimento.addLista(new Atendimento(paciente, getRespostas(Atendimento.getPerguntas())));
    }

    public static ArrayList<Boolean> getRespostas(ArrayList<String> perguntas) {
        ArrayList<Boolean> respostas = new ArrayList<Boolean>();

        for (String pergunta : perguntas) {
            respostas.add(getString(pergunta).equals("S"));
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
        getString("Precione qualquer tecla para continuar\n");
    }
}
