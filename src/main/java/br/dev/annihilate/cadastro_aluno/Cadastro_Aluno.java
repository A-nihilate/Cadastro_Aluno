package br.dev.annihilate.cadastro_aluno;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sesi2dia
 */
public class Cadastro_Aluno {

    public static void main(String[] args) {

        Random randomizer = new Random();
        Scanner tecladoNumber = new Scanner(System.in);
        Scanner tecladoString = new Scanner(System.in);
        int[] id = new int[1];
        String[] nome = new String[10];
        long[] telefone = new long[10];
        int[] dia_nascimento = new int[10];
        int[] mes_nascimento = new int[10];
        int[] ano_nascimento = new int[10];
        int anoAtual = 2026;
        boolean active = true;

        for (int i = 0; i < id.length; i++) {

            id[i] = randomizer.nextInt(1, 999999999);

            System.out.printf("Nome: ");
            nome[i] = tecladoString.nextLine();

            System.out.printf("Telefone: ");
            telefone[i] = tecladoNumber.nextLong();
            while (active) {
                System.out.printf("Data de Nascimento, DIA: ");
                dia_nascimento[i] = tecladoNumber.nextInt();
                if (dia_nascimento[i] > 0 && dia_nascimento[i] < 32) {

                    active = false;
                } else {
                    System.out.println("Invalid day");
                }
            }
            active = true;
            while (active) {
                System.out.printf("Data de Nascimento, MES: ");
                mes_nascimento[i] = tecladoNumber.nextInt();
                if (mes_nascimento[i] > 0 && mes_nascimento[i] < 13) {

                    active = false;
                } else {
                    System.out.println("Invalid day");

                }
            }
            active = true;
            while (active) {
                System.out.printf("Data de Nascimento, ANO: ");
                ano_nascimento[i] = tecladoNumber.nextInt();
                if (ano_nascimento[i] < anoAtual && ano_nascimento[i] > 0) {
                    active = false;

                } else {
                    System.out.println("Invalid day");

                }
            }
            System.out.printf("\noutput %d %02d %s %d %02d %02d %04d %02d \n", i, id[i], nome[i], telefone[i], dia_nascimento[i], mes_nascimento[i], ano_nascimento[i], anoAtual - ano_nascimento[i]);
        }

//        output
//                            10           13               12            3       3   4      5
        System.out.println("|------------|---------------|--------------|-----|-----|------|-------|");
        System.out.println("| ID         | NOME          | Telefone     | dia | mes | ano  | idade |");
        System.out.println("|------------|---------------|--------------|-----|-----|------|-------|");
        for (int i = 0; i < id.length; i++) {
            System.out.printf("| %10d | %13s | %12d | %02d  | %02d  | %04d | %5d |\n", id[i], nome[i], telefone[i], dia_nascimento[i], mes_nascimento[i], ano_nascimento[i], anoAtual - ano_nascimento[i]);
            System.out.println("|------------|---------------|--------------|-----|-----|------|-------|");
        }
    }
}
