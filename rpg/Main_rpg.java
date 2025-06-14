package big_projects.rpg;

import java.util.Random;
import java.util.Scanner;

public class Main_rpg {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int playerHp = 200;
		int bossHp = 350;

		System.out.println("Bem-vindo ao RPG em java!");

		System.out.println("\nCuidado, boss avistado à frente! [HP - " + bossHp + "]");
		System.out.print("Deseja batalhar com ele? (y/n): ");
		String escolha = scanner.next();

		if (!escolha.equalsIgnoreCase("y")) {
			System.out.println("\nRPG encerrado..");
			scanner.close();
			return;
		}

		int playerUlt = 0;
		int bossUlt = 0;
		int playerAttack;
		int bossAttack;
		System.out.println("\nVocê entrou em batalha com o boss, cuidado com os ataques!\n");

		while (playerHp >= 0 || bossHp >= 0) {
			if (playerUlt == 3) {
				System.out.println("==== Sua rodada ====");
				System.out.println("==== ULTIMATE PRONTA! ====");
				System.out.print("1 - Ataque básico, 2 - Ataque pesado, 3 - Defesa, 4 - Ultimate: ");
				playerAttack = scanner.nextInt();
				if (playerAttack > 4) {
					System.out.println("\nAtaque inválido, -5 hp como penalidade");
					playerHp = playerHp - 5;
				}
			} else {
				System.out.println("==== Sua rodada ====");
				System.out.print("1 - Ataque básico, 2 - Ataque pesado, 3 - Defesa: ");
				playerAttack = scanner.nextInt();

				if (playerAttack <= 0 || playerAttack > 3) {
					System.out.println("\nAtaque inválido, -5 hp como penalidade");
					playerHp = playerHp - 5;
				}
			}

			if (bossUlt == 6) {
				bossAttack = random.nextInt(1, 4);
				if (bossUlt > 6) {
					bossUlt = bossUlt - 1;
				}
			} else {
				bossAttack = random.nextInt(1, 3);
			}
			
			if (bossAttack == 2) {
				bossUlt++;
			}
			
			if (playerAttack == 2) {
				playerUlt++;
				if (playerUlt > 3) {
					playerUlt = playerUlt - 1;
				}
			}

			if (playerAttack == 1 && bossAttack == 3 || playerAttack == 2 && bossAttack == 3) {
				System.out.println("\nSeu ataque foi defendido pelo boss!");
			} else if (playerAttack == 1 && bossAttack == 1 || playerAttack == 1 && bossAttack == 2 || playerAttack == 1 && bossAttack == 4) {
				bossHp = bossHp - 25;
				System.out.println("\nSeu ataque surgiu efeito no boss! ==  Boss HP - " + bossHp);
			} else if (playerAttack == 2 && bossAttack == 2 || playerAttack == 2 && bossAttack == 1 || playerAttack == 1 && bossAttack == 4) {
				bossHp = bossHp - 40;
				System.out.println("\nSeu ataque pesado surgiu efeito no boss! ==  Boss HP - " + bossHp);
			} else if (playerAttack == 4 && bossAttack == 1 || playerAttack == 4 && bossAttack == 2 || playerAttack == 4 && bossAttack == 3 || playerAttack == 4 && bossAttack == 4) {
				bossHp = bossHp - 90;
				System.out.println("\nSua ultimate surgiu um dano MASSIVO no boss! ==  Boss HP - " + bossHp);
				playerUlt = playerUlt - playerUlt;
			}
			
			if (bossAttack == 1 && playerAttack == 3 || bossAttack == 2 && playerAttack == 3) {
				System.out.println("\nVocê defendeu o ataque do boss!\n");
			} else if (bossAttack == 1 && playerAttack == 1 || bossAttack == 1 && playerAttack == 2 || bossAttack == 1 && playerAttack == 4) {
				playerHp = playerHp - 20;
				System.out.println("\nVocê sofreu um ataque do boss! ==  Player HP - " + playerHp + "\n");
			} else if (bossAttack == 2 && playerAttack == 1 || bossAttack == 2 && playerAttack == 2 || bossAttack == 2 && playerAttack == 4) {
				playerHp = playerHp - 35;
				System.out.println("\nVocê sofreu um ataque pesado do boss! ==  Player HP - " + playerHp + "\n");
			} else if (bossAttack == 4 && playerAttack == 1 || bossAttack == 4 && playerAttack == 2 || bossAttack == 4 && playerAttack == 3 || bossAttack == 4 && playerAttack == 4) {
				playerHp = playerHp - 65;
				System.out.println("\nVocê sofreu um dano MASSIVO da ultimate do boss! ==  Player HP - " + playerHp + "\n");
				bossUlt = bossUlt - bossUlt;
			}
			
		}
		
		System.out.println(" ");
		if (bossHp < playerHp) {
			System.out.println("===== BATALHA ENCERRADA =====");
			System.out.println("Parabéns, você derrotou o boss!");
		} else if (playerHp < bossHp) {
			System.out.println("==== YOU DIED ====");
			System.out.println("Você foi derrotado");
		}
		
		scanner.close();
	}

}
