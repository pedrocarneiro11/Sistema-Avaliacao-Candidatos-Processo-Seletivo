import candidatura.ProcessoSeletivo;

public class Main {
    public static void main(String[] args) {
        ProcessoSeletivo processoSeletivo = new ProcessoSeletivo();
        String[] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
        processoSeletivo.imprimirSelecionados();

        for (String candidato: candidatos) {
            processoSeletivo.entrandoEmContato(candidato);
        }
    }
}