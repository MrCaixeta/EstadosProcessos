import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Processo> processos = new ArrayList<>();
        processos.add(new Processo(0, 10000));
        processos.add(new Processo(1, 5000));
        processos.add(new Processo(2, 7000));
        processos.add(new Processo(3, 3000));
        processos.add(new Processo(4, 3000));
        processos.add(new Processo(5, 8000));
        processos.add(new Processo(6, 2000));
        processos.add(new Processo(7, 5000));
        processos.add(new Processo(8, 4000));
        processos.add(new Processo(9, 10000));

        int quantum = 1000;

        SimuladorSistemaOperacional simulador = new SimuladorSistemaOperacional(processos, quantum);
        simulador.simularExecucao();
    }
}
