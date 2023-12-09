import java.util.Random;

enum Estado {
    PRONTO,
    EXECUTANDO,
    BLOQUEADO,
    CONCLUIDO
}

public class Processo {
    private int pid;
    private int tempoExecucaoTotal;
    private int tempoExecutado;
    private Estado estado;
    private int numOperacoesES;
    private int numVezesCPU;

    public Processo(int pid, int tempoExecucaoTotal) {
        this.pid = pid;
        this.tempoExecucaoTotal = tempoExecucaoTotal;
        this.tempoExecutado = 0;
        this.estado = Estado.PRONTO;
        this.numOperacoesES = 0;
        this.numVezesCPU = 0;
    }

    public int getPid() {
        return pid;
    }

    public int getTempoExecucaoTotal() {
        return tempoExecucaoTotal;
    }

    public int getTempoExecutado() {
        return tempoExecutado;
    }

    public Estado getEstado() {
        return estado;
    }

    public int getNumOperacoesES() {
        return numOperacoesES;
    }

    public int getNumVezesCPU() {
        return numVezesCPU;
    }

    public void executarCiclo(int quantum) {
        if (estado == Estado.EXECUTANDO) {
            if (new Random().nextInt(100) < 5) {
                bloquear();
            } else {
                int ciclosExecutados = Math.min(quantum, tempoExecucaoTotal - tempoExecutado);
                tempoExecutado += ciclosExecutados;
                numVezesCPU++;

                if (tempoExecutado == tempoExecucaoTotal) {
                    concluir();
                }
            }
        }
    }

    public void bloquear() {
        estado = Estado.BLOQUEADO;
        numOperacoesES++;
    }

    public void desbloquear() {
        estado = Estado.PRONTO;
    }

    public void executar() {
        estado = Estado.EXECUTANDO;
    }

    public void concluir() {
        estado = Estado.CONCLUIDO;
    }

    public void imprimirDados() {
        System.out.println("PID: " + pid +
                ", TP: " + tempoExecutado +
                ", CP: " + (tempoExecutado + 1) +
                ", EP: " + estado +
                ", NES: " + numOperacoesES +
                ", N_CPU: " + numVezesCPU);
    }
}
