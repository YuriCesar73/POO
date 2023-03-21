package application;

import entities.Coordenador;
import entities.Pesquisador;
import entities.Professor;
import entities.ProjetoDePesquisa;

public class Main {
	
	ProjetoDePesquisa projeto = new ProjetoDePesquisa();
	Pesquisador coordenador;
	Pesquisador professor;

}


/*EXERCICIO
 * Fa�a um programa orientado a objetos para cadastrar pessoas que se inscreveram em um Projeto de Pesquisa que tem como pesquisador maior a 
Sra. Mara Andrade. Os pesquisadores que trabalham neste Projeto de Pesquisa podem ser Coordenadores de Pesquisa que t�m pesquisadores e 
outros coordenadores de pesquisa sob sua supervis�o ou ent�o simples professores.

Uma classe Pesquisador deve ser criada para auxiliar a sua solu��o. Todo pesquisador deve ser capaz de informar quantos pesquisadores 
existem sobre sua supervis�o. Todo pesquisador possui um coordenador de pesquisa, que tamb�m � do tipo pesquisador.

A classe Projeto de Pesquisa deve ser constru�da para armazenar os pesquisadores cadastrados (m�todo inserirPesquisador), para retornar 
a quantidade de pesquisadores associados a um pesquisador (m�todo getQtdPesquisadores) e para retornar o valor a ser pago pelo pesquisador 
para se inscrever no Projeto (m�todo getValorPago).

Para calcular o valor a ser pago pelo pesquisador � preciso levar em considera��o que professores pagam R$ 220,00 mais 30% do que paga 
seu coordenador de pesquisa,enquanto que coordenadores de pesquisa pagam R$ 300,00 menos 2,5% por cada pesquisador que 
esteja vinculado a ele. 
*/


