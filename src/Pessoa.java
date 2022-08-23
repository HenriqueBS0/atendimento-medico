import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Pessoa
 */
abstract public class Pessoa {

    private Date dataNascimento;
    private String nome; 

    public Pessoa(String dataNascimento, String nome) {
        this.dataNascimento = UtilsDate.stringToDate(dataNascimento + " 00:00 ");
        this.nome = nome;
    }

    public int calcularIdade() {
        Calendar dataNascimento = new GregorianCalendar();
        dataNascimento.setTime(this.dataNascimento);
        
        Calendar dataAtual = Calendar.getInstance();
        
        int idadeAtual = dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
        
        dataNascimento.add(Calendar.YEAR, idadeAtual);
        
        if (dataAtual.before(dataNascimento)) {
            idadeAtual--;
        }
        
        return idadeAtual;
    }

    public String getNome() {
        return nome;
    }
}