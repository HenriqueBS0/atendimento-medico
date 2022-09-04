package app;
import java.util.ArrayList;

public class ListaAntedimento {
    static private ArrayList<Atendimento> atendimentos = new ArrayList<Atendimento>();

    public static void addLista(Atendimento novoAtendimento) {

        ArrayList<Atendimento> novosAtendimentos = new ArrayList<Atendimento>();

        boolean atendimentoInserido = false;

        for (Atendimento atendimento : atendimentos) {
            if(!atendimentoInserido && novoAtendimento.getPrioridade() > atendimento.getPrioridade()) {
                novosAtendimentos.add(novoAtendimento);
                atendimentoInserido = true;
            }

            novosAtendimentos.add(atendimento);
        }

        if(!atendimentoInserido) {
            novosAtendimentos.add(novoAtendimento);
        }

        atendimentos = novosAtendimentos;
    } 

    public static ArrayList<Atendimento> mostrarLista() {
        return atendimentos;
    }
}
