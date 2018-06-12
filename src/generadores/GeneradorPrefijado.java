package generadores;

public class GeneradorPrefijado implements Generador
{	
	// Indice al proximo booleano a retornar
	private int _indice;
	
	// Valor entero (siempre responde esto)
	private int[] _enteros;
	
	public GeneradorPrefijado(int[] enteros)
	{
		_indice = 0;
		_enteros = enteros;
	}

	@Override
	public int nextInt(int n)
	{
		return _enteros[_indice++];
	}
}