package generadores;

import java.util.Random;

public class GeneradorAleatorio implements Generador
{
	private Random _random;
	
	public GeneradorAleatorio()
	{
		_random = new Random();
	}

	public GeneradorAleatorio(int semilla)
	{
		_random = new Random(semilla);
	}

	@Override
	public int nextInt(int i) {
		return _random.nextInt(i);
	}
}
