package me.ArchaneBot.devbot.commands;

import java.util.Scanner;

public class teste {
    public static void main(String[] args) {


        Scanner ent = new Scanner(System.in);


        System.out.println("Secretaria  = 1");
        System.out.println("Financeiro = 2");
        System.out.println("Atendimento geral = 3");
        System.out.println("Coordenacao = 4");


        System.out.println("\n\nEscolha sua senha");

        int cont = 0, cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0;

        while (cont < 5){
            cont+=1;
            System.out.print("\nSenha: ");
            int senha = ent.nextInt();

            if (senha == 1){
                cont1+=1;
            }
             if (senha == 2){
                cont2+=1;
            }
             if (senha == 3){
                cont3+=1;
            }
             if (senha == 4){
                cont4+=1;
            }

        }

        System.out.println("\n\nSecretaria  = " + cont1);
        System.out.println("Financeiro = " + cont2);
        System.out.println("Atendimento geral = " + cont3);
        System.out.println("Coordenacao = " + cont4);


    }
}
