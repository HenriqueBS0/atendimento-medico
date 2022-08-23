import java.util.ArrayList;

public class Medico extends Pessoa {
    private ArrayList<Especialidade> especialidades;
    
    public Medico(String dataNascimento, String nome) {
        super(dataNascimento, nome);
    }

    public void addEspecialidade(Especialidade especialidade) {
        this.especialidades.add(especialidade);
    }
}
