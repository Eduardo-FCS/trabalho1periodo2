//Para dar velha
programa
{
	inclua biblioteca Util --> u
	cadeia tabuleiro[][] = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}}
	caracter jogadas
	funcao inicio(){
		efetuarJogada(1, 1, "X", tabuleiro)
		efetuarJogada(0, 0, "O", tabuleiro)
		efetuarJogada(0, 2, "X", tabuleiro)
		efetuarJogada(2, 0, "O", tabuleiro)
		efetuarJogada(1, 0, "X", tabuleiro)
        efetuarJogada(1, 2, "O", tabuleiro)
		efetuarJogada(0, 1, "X", tabuleiro)
		efetuarJogada(2, 1, "O", tabuleiro)
		efetuarJogada(2, 2, "X", tabuleiro)
	}
	funcao efetuarJogada(inteiro linha, inteiro coluna, cadeia jogador, cadeia tabuleiroVelha[][]){
	// jogador
		tabuleiroVelha[linha][coluna] = jogador
		imprimeTabuleiro(tabuleiroVelha)
		verificaVencedor(tabuleiro)
	}
	funcao verificaVencedor(cadeia tabuleiro[][]){
	    //Para i = linha e j = coluna
		logico jogador = falso
		//Linha
		para(inteiro i = 0; i < 3; i++){
			se((tabuleiro[i][0] == tabuleiro[i][1]) e (tabuleiro[i][0] == tabuleiro[i][2])){
				se(tabuleiro[i][0] == "X"){
					escreva("\n", "O jogador 'X' ganhou essa rodada! \n")
				}
				senao se(tabuleiro[i][0] == "O"){
					escreva("\n", "O jogador 'O' ganhou essa rodada! \n")
				}
				jogador = verdadeiro
			}
		}
		//Coluna
		para(inteiro j = 0; j < 3; j++){
			se((tabuleiro[0][j] == tabuleiro[1][j]) e (tabuleiro[0][j] == tabuleiro[2][j])){
				se(tabuleiro[0][j] == "X"){
					escreva("\n", "O jogador 'X' ganhou essa rodada! \n")
				}
				senao se(tabuleiro[0][j] == "O"){
					escreva("\n", "O jogador 'O' ganhou essa rodada! \n")
				}
				jogador = verdadeiro
			}
		}
        //Diagonal Principal
		se((tabuleiro[0][0] == tabuleiro[1][1]) e (tabuleiro[0][0] == tabuleiro[2][2])){
			se(tabuleiro[0][0] == "X"){
				escreva("\n", "O jogador 'X' ganhou essa rodada! \n")
			}
			senao se(tabuleiro[0][0] == "O"){
				escreva("\n", "O jogador 'O' ganhou essa rodada! \n") 
			}
			jogador = verdadeiro
		}
		//Diagonal Secundária
		se((tabuleiro[0][2] == tabuleiro[1][1]) e (tabuleiro[0][2] == tabuleiro[2][0])){
			se(tabuleiro[0][2] == "X"){
				escreva("\n", "O jogador 'X' ganhou essa rodada! \n")
			}
			senao se(tabuleiro[0][2] == "O"){
				escreva("\n", "O jogador 'O' ganhou essa rodada! \n")
			}
			jogador = verdadeiro
		}
		senao se (jogador == falso){
			escreva("\n", "Deu velha! \n")
		}
	}
	funcao imprimeTabuleiro(cadeia tabuleiro[][]){
	    // Para i = linha e j = coluna
		limpa()
		para(inteiro i = 0; i < 3; i++){
			para(inteiro j = 0; j < 3; j++){
				escreva(" ", tabuleiro[i][j], "  ")
			}
			escreva("\n")
		}
		Util.aguarde(1500)
	}
}
