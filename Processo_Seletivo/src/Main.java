import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        List<String> selecionados = selecaoCandidatos();
        imprimirSelecionados(selecionados);

        System.out.println("\nIniciando tentativas de contato com os candidatos selecionados...\n");
        for (String candidato : selecionados) {
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        System.out.println("====================================");
        int tentativasRealizadas = 0;
        boolean atendeu = false;

        while(tentativasRealizadas < 3 && !atendeu){
            atendeu = atender();  // simulação
            tentativasRealizadas++;
        }

        if (atendeu) {
            System.out.println("Contato realizado com sucesso.");
            System.out.printf("Conseguimos contato com %s na %d tentativa.\n", candidato, tentativasRealizadas);
        } else {
            System.out.printf("Não conseguimos contato com %s após %d tentativas.\n", candidato, tentativasRealizadas);
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1; // 1 em 3 chances de atender
    }

    static void imprimirSelecionados(List<String> candidatos){
        System.out.println("====================================");
        System.out.println("Imprimindo a lista de candidatos informando o índice do elemento");

        for (int indice=0;indice < candidatos.toArray().length;indice++){
            System.out.printf("O candidato de número %s é %s.\n", indice+1, candidatos.get(indice));
        }
    }

    static List<String> selecaoCandidatos(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA",
                "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        List<String> selecionados = new ArrayList<>();

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("====================================");
            System.out.printf("O candidato %s solicitou este valor de salário: R$%.2f\n", candidato, salarioPretendido);

            if(salarioBase >= salarioPretendido){
                System.out.printf("O candidato %s, foi selecionado para vaga.\n", candidato);
                candidatosSelecionados++;
                selecionados.add(candidato);
            }else{
                System.out.printf("O candidato %s, NÃO foi selecionado para vaga.\n", candidato);
            }
            candidatosAtual++;
        }
        return selecionados;
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        var salarioBase = 2000;
        System.out.printf("O salário pretendido é de: R$ %.2f\n", salarioPretendido);
        if(salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO.");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA.");
        }else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}


