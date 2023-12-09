import java.util.List;

public class SimuladorSistemaOperacional {
    private List<Processo> processos;
    private int tempoTotalExecucao;
    private int quantum;

    public SimuladorSistemaOperacional(List<Processo> processos, int quantum) {
        this.processos = processos;
        this.tempoTotalExecucao = calcularTempoTotalExecucao(processos);
        this.quantum = quantum;
    }

    private int calcularTempoTotalExecucao(List<Processo> processos) {
        int tempoTotal = 0;
        for (Processo processo : processos) {
            tempoTotal += processo.getTempoExecucaoTotal();
        }
        return tempoTotal;
    }

    public void simularExecucao() {
        for (int tempoAtual = 0; tempoAtual < tempoTotalExecucao; tempoAtual += quantum) {
            for (Processo processo : processos) {
                if (processo.getEstado() == Estado.PRONTO) {
                    processo.executar();
                    TabelaProcessos.gravarDados(processo, "PRONTO >>> EXECUTANDO");
                } else if (processo.getEstado() == Estado.BLOQUEADO) {
                    if (Math.random() < 0.3) {
                        processo.desbloquear();
                        TabelaProcessos.gravarDados(processo, "BLOQUEADO >>> PRONTO");
                    }
                }

                processo.executarCiclo(quantum);

                if (processo.getEstado() == Estado.EXECUTANDO) {
                    processo.imprimirDados();
                    TabelaProcessos.gravarDados(processo, "EXECUTANDO >>> PRONTO");
                } else if (processo.getEstado() == Estado.CONCLUIDO) {
                    processo.imprimirDados();
                    TabelaProcessos.gravarDados(processo, "EXECUTANDO >>> CONCLUIDO");
                }
            }
        }
    }
}
