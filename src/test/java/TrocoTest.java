import static org.junit.Assert.*;
import org.junit.Test;

public class TrocoTest {
	@Test
	public void shouldTrocoNothing() {
		assertEquals("", new Troco().calculate(100.0,100.0));
	}
	
	@Test
	public void shouldTrocoOne50note() {
		assertEquals("[R$ 50,00]", new Troco().calculate(100.0,50.0));
	}
	
	@Test
	public void shouldTrocoOne5note() {
		assertEquals("[R$ 5,00]", new Troco().calculate(50.0,45.0));
	}
	
	@Test
	public void shouldTrocoOtherValues() {
		assertEquals("[R$ 20,00][R$ 5,00]", new Troco().calculate(100.0,75.0));
		assertEquals("[R$ 2,00][R$ 0,50]", new Troco().calculate(5.0,2.50));
		assertEquals("[R$ 2,00][R$ 0,50][R$ 0,01][R$ 0,01]", new Troco().calculate(5.0,2.48));
		assertEquals("[R$ 1,00][R$ 0,50][R$ 0,25]", new Troco().calculate(2.0,0.25));
	}

}
