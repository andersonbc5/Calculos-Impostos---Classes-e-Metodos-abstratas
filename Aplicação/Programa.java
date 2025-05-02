package Aplicação;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company; 
import entities.Invividual; 
import entities.Taxpayes; 

public class Programa {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Lista para armazenar os contribuintes (pessoas físicas e jurídicas)
        List<Taxpayes> lista = new ArrayList<>();

        // Solicita ao usuário o número de contribuintes
        System.out.print("Insira o número de contribuintes: ");
        int n = sc.nextInt();

        // Loop para coletar os dados de cada contribuinte
        for (int i = 1; i <= n; i++) {
            System.out.print("Pessoa Fisica ou jurudica (f/j)? "); // Pergunta se é pessoa física ou jurídica
            char resp = sc.next().charAt(0); 

            System.out.print("Nome: "); 
            sc.nextLine(); // Consome a quebra de linha pendente
            String name = sc.nextLine();

            System.out.print("Renda anual: R$ ");
            double rendaAnual = sc.nextDouble(); 

            // Verifica se é pessoa física
            if (resp == 'f') {
                System.out.print("Gastos com saúde: R$ "); 
                double gastosSaude = sc.nextDouble(); 
                
                // Adiciona um novo objeto Invividual (pessoa física) à lista
                lista.add(new Invividual(name, rendaAnual, gastosSaude));
            } else {
                
                System.out.print("Número de funcionários: "); 
                int numeroFuncionarios = sc.nextInt(); 
                
                // Adiciona um novo objeto Company (empresa) à lista
                lista.add(new Company(name, rendaAnual, numeroFuncionarios));
            }
        }

        System.out.println();

        double soma = 0.0; 

        System.out.println("Impostos pagos: ");
        
        for (Taxpayes tp : lista) {
            double tax = tp.tax(); // Calcula o imposto usando o método abstrato implementado nas subclasses
            System.out.println(tp.getName() + " R$ " + String.format("%.2f", tax)); // Exibe o nome e o imposto
            soma += tax; // Soma o imposto ao total
        }

        System.out.println();

        // Exibe o total de impostos pagos
        System.out.println("Total impostos: R$ " + String.format("%.2f", soma));

        sc.close(); 
    }
}
