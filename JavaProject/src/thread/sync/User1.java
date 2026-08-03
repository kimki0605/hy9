package thread.sync;

public class User1 extends Thread{
	private Calculator2 calculator;
	
	public void setCalculator(Calculator2 calculator) {
		this.setName("User1");
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(100);
	}
}
