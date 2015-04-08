package simuladorvendadeingressos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import simuladorvendadeingressos.listaencadeada.SinglyLinkedList;
import simuladorvendadeingressos.listaencadeada.UnderFlowException;

/**
 *
 * @author Gustavo Lazarotto Schroeder
 */
public class SimuladorVendaDeIngressos {

    public static void main(String[] args) {
        SinglyLinkedList<Dados> tipoA = new SinglyLinkedList<>();
        SinglyLinkedList<Dados> tipoB = new SinglyLinkedList<>();
        SinglyLinkedList<Dados> tipoC = new SinglyLinkedList<>();
        ReadDate rd = new ReadDate();

        while (true) {
            try {
                int option = rd.readInt("O que desejas fazer? \n 1 - Solicitar Reserva  "
                        + "2 - Sorteio  3 - Listar Ingressos por Cpf e 0 - Sair");
                if (option == 1) {
                    String nome = rd.readString("Nome do Comprador: ");
                    long cpf = rd.readInt("Cpf do Comprador: ");
                    String data = rd.readString("Data: (dd/mm/aaaa)");
                    String tipoIngr = rd.readString("Tipo do Ingresso: \n (A - Arquibancada Superior"
                            + " B - Arquibancada Inferior e C - Laterais");
                    if (tipoIngr.equalsIgnoreCase("A")) {
                        if (tipoA.isEmpty() == false) {
                            for (int i = 0; i < tipoA.numElements(); i++) {
                                if (cpf == tipoA.search(i).getCpf()) {
                                    throw new cpfAlreadyExistsException();
                                }
                            }
                        }
                        System.out.println("Processo Efetuado");
                        tipoA.insertHead(new Dados(nome, cpf, data, tipoIngr));
                        tipoA.getHead().getElement().toCsvPendentes();
                    } else if (tipoIngr.equalsIgnoreCase("B")) {
                        if (tipoB.isEmpty() == false) {
                            for (int i = 0; i < tipoB.numElements(); i++) {
                                if (cpf == tipoB.search(i).getCpf()) {
                                    throw new cpfAlreadyExistsException();
                                }
                            }
                        }
                        System.out.println("Processo Efetuado");
                        tipoB.insertHead(new Dados(nome, cpf, data, tipoIngr));
                        tipoB.getHead().getElement().toCsvPendentes();


                    } else if (tipoIngr.equalsIgnoreCase("C")) {
                        if (tipoC.isEmpty() == false) {
                            for (int i = 0; i < tipoC.numElements(); i++) {
                                if (cpf == tipoC.search(i).getCpf()) {
                                    throw new cpfAlreadyExistsException();
                                }
                            }
                        }
                        System.out.println("Processo Efetuado");
                        tipoC.insertHead(new Dados(nome, cpf, data, tipoIngr));
                        tipoC.getHead().getElement().toCsvPendentes();
                    }
                } else if (option == 2) {
                    if (tipoA.isEmpty() == false) {
                        for (int i = 0; i < 2; i++) {
                            int sorteio = (int)Math.floor(((Math.random()*tipoA.numElements())));
                            Dados element = (Dados) tipoA.getNode(sorteio).getElement();
                            element.setStatus("Confirmada");
                            element.toCsvConfirmados();
                            tipoA.removeAnyPos(sorteio);
                        }
                    }
                    else if (tipoB.isEmpty() == false) {
                        for (int i = 0; i < 2; i++) {
                            int sorteio = (int)Math.floor((Math.random()*tipoB.numElements()));
                            Dados element = (Dados) tipoB.getNode(sorteio).getElement();
                            element.setStatus("Confirmada");
                            tipoB.search(sorteio).toCsvConfirmados();
                            tipoB.removeAnyPos(sorteio);
                        }
                    }
                    else if (tipoC.isEmpty() == false) {
                        for (int i = 0; i < 3; i++) {
                            int sorteio = (int)Math.floor((Math.random()*tipoC.numElements()));
                            tipoC.search(sorteio).setStatus("Confirmada");
                            tipoC.search(sorteio).toCsvConfirmados();
                            tipoC.removeAnyPos(sorteio);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Não há nem um pedido Cadastrado!");
                    }
                } else if (option == 3) {
                    int cpfToCompare = rd.readInt("Informe o CPF: ");
                    int cont = 0; // contador para ver quantos ingressos tem
                    BufferedReader in;
                    FileReader fe;
                    fe = new FileReader("C:\\Temp\\SimuladorVendaDeIngressos\\src\\simuladorvendadeingressos\\IngressosSorteados.csv");
                    in = new BufferedReader(fe);
                    String[] split;
                    String line = null;
                    while ((line = in.readLine()) != null) {
                        split = line.split(";");
                        if (cpfToCompare == Long.parseLong(split[1])) {
                            System.out.println("Nome: " + split[0] + "Data da Solicitação: "
                                    + split[2] + "  Tipo do Ingresso: " + split[3]);
                            cont++;
                        }
                    }
                    if (cont == 0) {
                        JOptionPane.showMessageDialog(null, "Nem um item corresponde ao CPF");
                    }
                } else if (option == 0) {
                    JOptionPane.showMessageDialog(null, "Programa Finalizado!");
                    break;
                }
            } catch (cpfAlreadyExistsException ex) {
                ex.showMessage();
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao processar a data!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Processo de Gravação defeituoso");
            } catch (UnderFlowException ex) {
                ex.showMessage();
            }
        }
    }
}
