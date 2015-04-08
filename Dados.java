package simuladorvendadeingressos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Unisinos
 */
public class Dados {

    private String nome;
    private long cpf;
    private Date dataSolicitacao;
    private SimpleDateFormat sdf;
    private String tipo;
    private String status;

    public Dados(String nome, long cpf, String data, String tipo) throws ParseException {
        this.nome = nome;
        this.cpf = cpf;
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.dataSolicitacao = sdf.parse(data);
        this.tipo = tipo;
        this.status = "pendente";
    }

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void toCsvPendentes() throws IOException {
        FileWriter fr = new FileWriter("C:\\Temp\\SimuladorVendaDeIngressos\\src\\simuladorvendadeingressos\\IngressosPendentes.csv", true);
        PrintWriter out = new PrintWriter(fr);
        out.println(getNome() + ";" + getCpf() + ";" + getDataSolicitacao()
                + ";" + getTipo() + ";" + getStatus());
        out.flush();
        out.close();
     }

    public void toCsvConfirmados() throws IOException {
        FileWriter fr = new FileWriter("C:\\Temp\\SimuladorVendaDeIngressos\\src\\simuladorvendadeingressos\\IngressosSorteados.csv", true);
        PrintWriter out = new PrintWriter(fr);
        out.println(getNome() + ";" + getCpf() + ";" + getDataSolicitacao()
                + ";" + getTipo() + ";" + getStatus());
        out.flush();
        out.close();
      }

    public void removeDataFromCsv() {
    }
}
