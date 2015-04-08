package simuladorvendadeingressos.listaencadeada;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author gschroeder
 */
public class Pessoa implements Comparable {

    protected String nome;
    protected String cpf;
    protected Date dataNascimento;
    protected SimpleDateFormat sdf;

    public Pessoa(String nome, String cpf, String dataNascimento) throws ParseException {
        this.nome = nome;
        this.cpf = cpf;
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.dataNascimento = sdf.parse(dataNascimento);
    }

    @Override
    public int compareTo(Object t) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        if (nome.compareTo((String) t) == -1) {
            return BEFORE;
        } else if (nome.compareTo((String) t) == 0) {
            return EQUAL;
        } else {
            return AFTER;
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

}
