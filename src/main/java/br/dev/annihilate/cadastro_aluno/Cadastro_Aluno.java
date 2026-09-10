package br.dev.annihilate.cadastro_aluno;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sesi2dia
 */
public class Cadastro_Aluno {

    public static int MAX = 2;

    public static void main(String[] args) {

        Random randomizer = new Random();
        Scanner tecladoNumber = new Scanner(System.in);
        Scanner tecladoString = new Scanner(System.in);
        int[] id = new int[MAX];
        int qtdAluno = 0;
        String[] nome = new String[MAX];
        long[] telefone = new long[MAX];
        int[] dia_nascimento = new int[MAX];
        int[] mes_nascimento = new int[MAX];
        int[] ano_nascimento = new int[MAX];
        int anoAtual = 2026;
        boolean invalidValue = true;
        boolean active = true;
        boolean ignoreOveride = false;
        int state = -1;
        int ativeRecords = 0;

//        TEST CONFIGS
        boolean Config = true;
        int mode = 1;
        System.out.println("\n------------------------------------------\nWelcome\n------------------------------------------\n");

        if (Config == true) {
            System.out.println("config mode on, use numbers to select options");
            
            
            while (true) {
                System.out.println("ID input: (1) = Random (2) = Manual");
                int input = tecladoNumber.nextInt();
                
                if (input == 1){
                    System.out.println("Random Selected");
                    mode = 1;
                    break;
                } else if(input==2){
                    System.out.println("Manual Selected");
                    mode = 2;
                    break;
                }
            }
        }

        while (active) {

            System.out.println("Menu Options:");
            System.out.println("1) Cadastro   2) Listar");
            System.out.println("0) Sair");

            state = tecladoNumber.nextInt();
            if (state > 2 || state < 0) {
                System.out.println("\ninvalid State.");
            }
            switch (state) {
                case 1:
                    if (ativeRecords >= MAX) {
                        while (true || ignoreOveride == false) {
                            System.out.printf("\n----\nWaring, max amount reached, do you wish to start overiding?\n---\nBy selecting Y, You will start Overiding the Registers beggining on Register 0\n(Y) (N)");
                            String tempValue = tecladoString.nextLine();
                            if (tempValue == "Y") {
                                ativeRecords = 0;
                                break;
                            } else if (tempValue == "N") {
                                ignoreOveride = true;
                                break;
                            }
                        }
                    }

                    System.out.println("Quantos Alunos serao cadastrados?");
                    qtdAluno = tecladoNumber.nextInt();

                    if (qtdAluno > MAX || qtdAluno < 1 || ativeRecords + qtdAluno > MAX) {
                        System.out.printf("\n---\nInvalid Amount, try again. Avaliable registers: %d\n---\n", (MAX - ativeRecords));
                        break;
                    } else {
                        System.out.printf("Cadastro de %d Aluno(s), Porfavor preencha as Informacoes requisitadas\n", qtdAluno);
                        for (int i = ativeRecords; i < qtdAluno; i++) {

                            if (mode == 1) {
                                id[i] = randomizer.nextInt(1, 999999999);
                            } else if (mode == 2) {
                                System.out.printf("0 for Exit\nID: ");
                                id[i] = tecladoNumber.nextInt();
                                if (id[i]==0){break;}
                            }
                            System.out.printf("Nome: ");
                            nome[i] = tecladoString.nextLine();

                            System.out.printf("Telefone: ");
                            telefone[i] = tecladoNumber.nextLong();
                            while (invalidValue) {
                                System.out.printf("Data de Nascimento, DIA: ");
                                dia_nascimento[i] = tecladoNumber.nextInt();
                                if (dia_nascimento[i] > 0 && dia_nascimento[i] < 32) {

                                    invalidValue = false;
                                } else {
                                    System.out.println("Invalid day");
                                }
                            }
                            invalidValue = true;
                            while (invalidValue) {
                                System.out.printf("Data de Nascimento, MES: ");
                                mes_nascimento[i] = tecladoNumber.nextInt();
                                if (mes_nascimento[i] > 0 && mes_nascimento[i] < 13) {

                                    invalidValue = false;
                                } else {
                                    System.out.println("Invalid Month");

                                }
                            }
                            invalidValue = true;
                            while (invalidValue) {
                                System.out.printf("Data de Nascimento, ANO: ");
                                ano_nascimento[i] = tecladoNumber.nextInt();
                                if (ano_nascimento[i] <= anoAtual && ano_nascimento[i] > 0) {
                                    invalidValue = false;

                                } else {
                                    System.out.println("Invalid Year");

                                }
                            }
                            System.out.printf("\noutput %d %02d %s %d %02d %02d %04d %02d \n", i, id[i], nome[i], telefone[i], dia_nascimento[i], mes_nascimento[i], ano_nascimento[i], anoAtual - ano_nascimento[i]);
                        }
                        ativeRecords = +qtdAluno;
                    }
                    break;
//        output
//                                         10           20                     12             3    3   4      5
                case 2:

                    if (id[0] == 0) {
                        System.out.printf("\n---\nRegisters are Empty.\n---\n\n");
                        break;
                    }

                    System.out.println("|------------|----------------------|--------------|-------------|-------|");
                    System.out.println("| ID         | NOME                 | Telefone     | dia/mes/ano | idade |");
                    System.out.println("|------------|----------------------|--------------|-------------|-------|");
                    for (int i = 0; i < id.length; i++) {
                        if (id[i] == 0) {
                            break;
                        }
                        System.out.printf("| %10d | %20s | %12d |  %02d/%02d/%04d | %5d |\n", id[i], nome[i], telefone[i], dia_nascimento[i], mes_nascimento[i], ano_nascimento[i], anoAtual - ano_nascimento[i]);
                        System.out.println("|------------|----------------------|--------------|-------------|-------|");

                    }
                    break;
                case 0:
                    active = false;
                    System.out.println("GoodBye :3");
                    break;
            }
        }
    }
}
    
