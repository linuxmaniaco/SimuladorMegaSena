import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		//instância um objeto da classe Random usando o construtor padrão
		Random random = new Random();
	
	    Set<Integer> sorteio = new HashSet<>(); 					// Lista de numeros sorteados sem repetição ao usar o HashSet.
        ArrayList<Integer> aposta = new ArrayList<>(); 				// Lista de numeros para uma aposta.
        
        
        //Adicionando a lista aposta 6 números 
        System.out.println("Adicione 6 números de 1 a 60");
        for (int i=0; i<=5; i++) {
        	aposta.add(sc.nextInt());
        }
        
        int acertos = 0; 											// Quantidade de acertos
        int cont = 1; 
        int quadra = 0;
        int quina = 0;
        int sena = 0;
        
        
		while (acertos != 6) { 										//O programa roda ate acertar 6 números
			try {
					acertos = 0; 									// inicia a variavel com zero a cada novo laço para um novo sorteio
				int numero = 0; 									//inicia a variavel com zero para cada novo laço para un novo sorteio
				System.out.println("SORTEIO " + cont +"\n"); 		// Imprime a quantidade de sorteios até o momento
				
				// SORTEANDO NÚMEROS SEM REPETIÇÕES
				while(numero != 6) { 								//Sorteia 1 números até atingir 6 números
					for(int i = 0; i <= 5; i++) { 					// sorteia 6 números
						int sorteado = random.nextInt(59)+1; 		// sorteia 1 número aleatório entre 1 e 60.
						sorteio.add(sorteado);						// adiciona numero aleatório na lista sorteio
					}
					numero = sorteio.size(); 						//Verifica o tamanho da lista sorteio, ja que o hashset exclui o numero sorteado repetido, caso tenha menos de 6 numero, o sorteio é feito novamente.
//					System.out.println("Numeros sorteados: " + numero);
					if(numero != 6) { 								// condicional que verifica se a lista tem 6 numero
						sorteio.clear(); 							// limpa a lista para um novo sorteio
					}
				}
				
					//EXIBE OS NÚMEROS SORTEADOS DO JOGO
					System.out.println("NUMEROS SORTEADOS");		// imprime os numeros sorteados
				    for (Integer jogo : sorteio) {					
				    	System.out.println(jogo.toString());
//				    	Thread.sleep(100);							// sleep caso queira exibir os sorteios mais lentamente
				    }
				    
				    // VERIFICA OS NÚMEROS SORTEADOS 
				    for (Integer result : sorteio) { 				// lista de numeros do sorteio
				    	if(aposta.contains(result)) {				// verifica se a aposta contem os números sorteados
				    		System.out.println("Acertou o nº: " + result.toString());	// Imprime os numeros que acertou
				    		acertos++;								// conta quantos numeros acertou
				    	}
				    }
				    
				    if(acertos == 4) { 								// ferifica se teve 4 acertos para somar a quantidade de quadras que deu
				    	quadra++;
				    } else if(acertos == 5) {						// ferifica se teve 5 acertos para somar a quantidade de quinas que deu
				    	quina++;
				    } else if(acertos == 6) {						// ferifica se teve 6 acertos para atribuir o valor 1 na variável sena para que o programa possa encerrar, pois nesse caso encerra com 1 ganhador
				    	sena++;
				    }
				    
				    System.out.println("contem: "+acertos);			// imprime q quantidade de acertos
				    System.out.println("\n \n");
				
				Thread.sleep(000);									// Caso queira exibir o programa mais lentamente.
				cont++; 											// Soma quantos sorteios foram feitos
				sorteio = new HashSet<>();							// zera a lista sorteio para começar um novo
					
					
					
				
	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} //FIM WHILE PRINCIPAL
		
		//EXIBE RELATORIO FINAL		
		System.out.println("RESULTADO FINAL");
		System.out.println("Acertou "+ quadra + " Quadra"); 		// imprime quant de quadra
		System.out.println("Acertou "+ quina + " Quina");			// imprime quant de quina
		System.out.println("Acertou "+ sena + " Sena");				// imprime quant de sena
		System.out.println("FEZ "+ cont + " JOGOS");				// imprime quant de sorteios 
	}	
}


