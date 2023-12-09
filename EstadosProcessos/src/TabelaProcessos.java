import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TabelaProcessos {
    private static final String NOME_ARQUIVO = "tabela_processos.txt";

    public static void gravarDados(Processo processo, String transicao) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
            writer.write("PID: " + processo.getPid() +
                    ", TP: " + processo.getTempoExecutado() +
                    ", CP: " + (processo.getTempoExecutado() + 1) +
                    ", EP: " + processo.getEstado() +
                    ", NES: " + processo.getNumOperacoesES() +
                    ", N_CPU: " + processo.getNumVezesCPU() +
                    ", Transição: " + transicao);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
