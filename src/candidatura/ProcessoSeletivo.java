package candidatura;


import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso!");
            }
        } while (continuarTentando==true && tentativasRealizadas < 3);
        if(atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " apos " + tentativasRealizadas + " tentativas");
        } else {
            System.out.println("Nao conseguimos contato com " + candidato + ", Numero maximo de tentativas alcancado: " + tentativasRealizadas);
        }
    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
        // sera gerado um valor randomico acima(entre 1 e 3), e caso o valor for igual a 1 o metodo
        // ira retornar "true", se retornar "true" o candidato tera atendido
    }

    public static void imprimirSelecionados() {
        String[] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento: ");
        for(int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de nº " + (indice+1) + " é " + candidatos[indice]);
        }

        System.out.println("Forma abreviada de interacao for each");

        for(String candidato: candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }

    }

    static void selecaoCandidatos() {
        String[] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JORGE"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        DecimalFormat df = new DecimalFormat("###.##"); // Arredondar o valor para duas casas decimais
        while(candidatosSelecionados<5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou um salario de R$ " + df.format(salarioPretendido));
            if(salarioBase >= salarioPretendido) {
                System.out.println("O candidato "+ candidato +" foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.00;
        if(salarioBase>salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        } else {
            System.out.println("Aguardar o resultado dos demais candidatos");
        }
    }
}
