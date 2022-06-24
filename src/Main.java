import espacoDeEstados.*;
import estrategiasDeBusca.cega.BuscaCega;
import estrategiasDeBusca.cega.BuscaEmLargura;
import estrategiasDeBusca.cega.BuscaEmProfundidade;
import estrategiasDeBusca.cega.BuscaEmProfundidadeLimitada;
import estrategiasDeBusca.heuristica.*;

import java.util.List;
import java.util.Scanner;


public class Main {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

//		char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
//		char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
//		char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
//		char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
//		char[] cfgFim = {'1','2','3','4','5','6','7','8',' '};
		//char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'}; // OutOfMemory



		Puzzle8 puzzleInicial = new Puzzle8();
		puzzleInicial.setCusto(0);
		puzzleInicial.setAvaliacao( puzzleInicial.heuristica(Puzzle8.TABULEIRO_ORGANIZADO) );

		Puzzle8 puzzleFinal = new Puzzle8();
		puzzleFinal.setCusto(0);
		puzzleFinal.setAvaliacao(0);

		Scanner s = new Scanner(System.in);

		System.out.println("Digite a busca desejada: ");

		System.out.println("1-Busca Informada");
		System.out.println("2-Busca em Largura");
		System.out.println("3-Busca em Profundidade");
		System.out.println("4-Busca em Profundidade Limitada");
		System.out.println("5-Busca BestFirst");
		System.out.println("5-Busca AStar");

		System.out.printf("Digite aqui: ");
		int contador = s.nextInt();

		switch (contador) {
			case 1: { //Busca informada
				BuscaInformada busca = new AStar();

				char[] cfgIni = {'2', '4', '3', '7', '1', '6', '5', ' ', '8'};
				char[] cfgFim = {'1', '2', '3', '4', '5', '6', '7', '8', ' '};
				puzzleInicial.setEstado(cfgIni);
				puzzleFinal.setEstado(cfgFim);

				busca.setInicio(puzzleInicial);
				busca.setObjetivo(puzzleFinal);
				busca.buscar();
				for (Estado e : busca.getCaminhoSolucao()) {
					System.out.println(e);
				}
				System.out.println("Estado Inicial e Final diferentes:");

				BuscaInformada busca1 = new AStar();

				char[] cfgIni2 = {' ', '2', '3', '1', '4', '6', '7', '5', '8'};
				char[] cfgFim2 = {'1', '2', '3', '4', '5', '6', '7', '8', ' '};
				puzzleInicial.setEstado(cfgIni2);
				puzzleFinal.setEstado(cfgFim2);

				busca1.setInicio(puzzleInicial);
				busca1.setObjetivo(puzzleFinal);
				busca1.buscar();
				for (Estado e : busca1.getCaminhoSolucao()) {
					System.out.println(e);
				}
				break;
			}

			case 2: {// Busca em Largura
				BuscaEmLargura buscaL = new BuscaEmLargura(puzzleInicial, puzzleFinal);

				char[] cfgIni = {'2', '4', '3', '7', '1', '6', '5', ' ', '8'};
				char[] cfgFim = {'1', '2', '3', '4', '5', '6', '7', '8', ' '};
				puzzleInicial.setEstado(cfgIni);
				puzzleFinal.setEstado(cfgFim);

				buscaL.setInicio(puzzleInicial);
				buscaL.setObjetivo(puzzleFinal);
				buscaL.buscar();
				for (Estado e : buscaL.getCaminhoSolucao()) {
					System.out.println(e);
				}
				System.out.println("Estado Inicial e Final diferentes:");
				BuscaEmLargura buscaL1 = new BuscaEmLargura(puzzleInicial, puzzleFinal);

				char[] cfgIni2 = {' ', '2', '3', '1', '4', '6', '7', '5', '8'};
				char[] cfgFim2 = {'1', '2', '3', '4', '5', '6', '7', '8', ' '};
				puzzleInicial.setEstado(cfgIni2);
				puzzleFinal.setEstado(cfgFim2);

				buscaL1.setInicio(puzzleInicial);
				buscaL1.setObjetivo(puzzleFinal);
				buscaL1.buscar();
				for (Estado e : buscaL1.getCaminhoSolucao()) {
					System.out.println(e);
				}
				break;
			}

			case 3: {//Busca em Profundidade
				BuscaEmProfundidade buscaP = new BuscaEmProfundidade();

				char[] cfgFim = {'2', '4', '3', '7', '1', '6', '5', ' ', '8'};
				char[] cfgIni = {'1', '2', '3', '4', '5', '6', '7', '8', ' '};
				puzzleInicial.setEstado(cfgIni);
				puzzleFinal.setEstado(cfgFim);

				buscaP.setInicio(puzzleInicial);
				buscaP.setObjetivo(puzzleFinal);
				buscaP.buscar();
				for (Estado e : buscaP.getCaminhoSolucao()) {
					System.out.println(e);
				}
				System.out.println("Estado Inicial e Final diferentes:");
				BuscaEmProfundidade buscaP1 = new BuscaEmProfundidade();

				char[] cfgIni2 = {' ', '2', '3', '1', '4', '6', '7', '5', '8'};
				char[] cfgFim2 = {'1', '2', '3', '4', '5', '6', '7', '8', ' '};
				puzzleInicial.setEstado(cfgIni2);
				puzzleFinal.setEstado(cfgFim2);

				buscaP1.setInicio(puzzleInicial);
				buscaP1.setObjetivo(puzzleFinal);
				buscaP1.buscar();
				for (Estado e : buscaP1.getCaminhoSolucao()) {
					System.out.println(e);
				}
				break;
			}


			case 4: {//Busca em Profundidade Limitada
				BuscaEmProfundidadeLimitada buscaPL = new BuscaEmProfundidadeLimitada();

				char[] cfgIni = {'2', '4', '3', '7', '1', '6', '5', ' ', '8'};
				char[] cfgFim = {'1', '2', '3', '4', '5', '6', '7', '8', ' '};
				puzzleInicial.setEstado(cfgIni);
				puzzleFinal.setEstado(cfgFim);

				buscaPL.setInicio(puzzleInicial);
				buscaPL.setObjetivo(puzzleFinal);
				buscaPL.setLimite(0);

				List<Estado<?>> check = null;

				while (check == null) {
					try {
						buscaPL.buscar();
						check = buscaPL.getCaminhoSolucao();
					} catch (Exception e) {

					}
					buscaPL.setLimite(buscaPL.getLimite() + 1);
				}
				for (Estado e : buscaPL.getCaminhoSolucao()) {
					System.out.println(e);
				}
				System.out.println("Estado Inicial e Final diferentes:");
				BuscaEmProfundidadeLimitada buscaPL1 = new BuscaEmProfundidadeLimitada();
				buscaPL1.setLimite(0);

				char[] cfgIni2 = {' ', '2', '3', '1', '4', '6', '7', '5', '8'};
				char[] cfgFim2 = {'1', '2', '3', '4', '5', '6', '7', '8', ' '};
				puzzleInicial.setEstado(cfgIni2);
				puzzleFinal.setEstado(cfgFim2);

				buscaPL1.setInicio(puzzleInicial);
				buscaPL1.setObjetivo(puzzleFinal);

				List<Estado<?>> check2 = null;

				while (check2 == null) {
					try {
						buscaPL1.buscar();
						check2 = buscaPL1.getCaminhoSolucao();
					} catch (Exception e) {

					}
					buscaPL1.setLimite(buscaPL1.getLimite() + 1);

				}
				for (Estado e : buscaPL1.getCaminhoSolucao()) {
					System.out.println(e);
				}
				break;
			}

			case 5: {//Busca BestFirst
				BuscaInformada buscaBme = new BestFirst();

				char[] cfgIni = {'2', '4', '3', '7', '1', '6', '5', ' ', '8'};
				char[] cfgFim = {'1', '2', '3', '4', '5', '6', '7', '8', ' '};
				puzzleInicial.setEstado(cfgIni);
				puzzleFinal.setEstado(cfgFim);

				buscaBme.setInicio(puzzleInicial);
				buscaBme.setObjetivo(puzzleFinal);
				buscaBme.buscar();

				for (Estado e : buscaBme.getCaminhoSolucao()) {
					System.out.println(e);
				}
				System.out.println("Estado Inicial e Final diferentes:");

				BuscaInformada buscaBme1 = new BestFirst();

				char[] cfgIni2 = {' ', '2', '3', '1', '4', '6', '7', '5', '8'};
				char[] cfgFim2 = {'1', '2', '3', '4', '5', '6', '7', '8', ' '};
				puzzleInicial.setEstado(cfgIni2);
				puzzleFinal.setEstado(cfgFim2);

				buscaBme1.setInicio(puzzleInicial);
				buscaBme1.setObjetivo(puzzleFinal);
				buscaBme1.buscar();

				for (Estado e : buscaBme1.getCaminhoSolucao()) {
					System.out.println(e);
				}
				break;
			}

			case 6: {//Busca AStar
				BuscaInformada buscaAS = new AStar();

				char[] cfgIni = {'2', '4', '3', '7', '1', '6', '5', ' ', '8'};
				char[] cfgFim = {'1', '2', '3', '4', '5', '6', '7', '8', ' '};
				puzzleInicial.setEstado(cfgIni);
				puzzleFinal.setEstado(cfgFim);

				buscaAS.setInicio(puzzleInicial);
				buscaAS.setObjetivo(puzzleFinal);
				buscaAS.buscar();

				for (Estado e : buscaAS.getCaminhoSolucao()) {
					System.out.println(e);
				}
				System.out.println("Estado Inicial e Final diferentes:");
				BuscaInformada buscaAS1 = new AStar();

				char[] cfgIni2 = {' ', '2', '3', '1', '4', '6', '7', '5', '8'};
				char[] cfgFim2 = {'1', '2', '3', '4', '5', '6', '7', '8', ' '};
				puzzleInicial.setEstado(cfgIni2);
				puzzleFinal.setEstado(cfgFim2);

				buscaAS1.setInicio(puzzleInicial);
				buscaAS1.setObjetivo(puzzleFinal);
				buscaAS1.buscar();

				for (Estado e : buscaAS1.getCaminhoSolucao()) {
					System.out.println(e);
				}
				break;
			}
			default:{
				System.out.println("Numero Inv�lido");
			}
		}
		System.exit(0);
	}

}