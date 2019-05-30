package framework.datapools;

import framework.exceptions.DatapoolException;

public interface IDatapool {
	
	/**
	 * Informa se há mais registros no datapool para uma nova iteração.
	*/
    boolean hasNext();

	/**
	 * Informa se há registros no datapool.
	*/
    boolean isEmpty();

	/**
	 * Reinicia a iteração novamente a partir do primeiro registro.
	*/
    void reset();

	/**
	 * Informa a quantidade de registros presentes no datapool.
	*/
    int getSize();

	/**
	 * Avança o ponteiro para o próximo registro.
	 * .
	 * @throws DatapoolException 
	*/
    IDatapool next() throws DatapoolException;

	/**
	 * Avança o ponteiro para o registro informado no parâmetro "line".
	 * .
	 * @param line índice do registro desejado, de 0 até tamanho - 1.
	 * @throws DatapoolException 
	*/
    IDatapool nextTo(int line) throws DatapoolException;

	/**
	 * Avança o ponteiro para um registro pseudo-aleatório.
	 * .
	 * @throws DatapoolException 
	*/
    IDatapool nextRandom() throws DatapoolException;

	/**
	 * Retorna o valor do campo informado referente ao registro atual.
	 * 
	 * @param field é o nome do campo.
	 * @throws DatapoolException 
	*/
    String getValue(String field) throws DatapoolException;

	/**
	 * Retorna o valor do campo relativo ao índice das colunas referente ao registro atual.
	 * 
	 * @param fieldIndex é o índice da coluna desejada, sendo um número de 0 até quantidade de registros - 1.
	 * @throws DatapoolException 
	*/
    String getValue(int fieldIndex) throws DatapoolException;

}
