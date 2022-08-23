import java.util.ArrayList;

public class ListaAntedimento {
    static private ArrayList<Atendimento> atendimentos = new ArrayList<Atendimento>();

    public static void addLista(Atendimento atendimento) {
        atendimentos.add(atendimento);
    } 

    public static ArrayList<Atendimento> mostrarLista() {
        return atendimentos;
    }
}
