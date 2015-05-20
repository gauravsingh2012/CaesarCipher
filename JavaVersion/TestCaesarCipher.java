import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCaesarCipher {

	private CaesarCipher caesarCipher;

	@Before
	public void setup() {
		this.caesarCipher = new CaesarCipher();
	}

	@Test
	public void test() {

		String expectedEncodedString = "def ghi";
		Assert.assertEquals(expectedEncodedString,
				caesarCipher.cipher("abc def", 3));
	}

	@Test
	public void testCharacterShiftOverflow() {

		String expectedEncodedString = "abc";
		Assert.assertEquals(expectedEncodedString,
				caesarCipher.cipher("xyz", 3));
	}

	@Test
	public void testWithASentence() {
		String expectedEncodedString = "WKH TXLFN EURZQ IRA MXPSV RYHU WKH ODCB GRJ";
		Assert.assertEquals(expectedEncodedString, caesarCipher.cipher(
				"THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG", 3));
	}

	@Test
	public void testWithCharactersOtherThanLetters() {
		String expectedEncodedString = "Dpdclqj!";
		Assert.assertEquals(expectedEncodedString,
				caesarCipher.cipher("Amazing!", 3));
	}

	@Test
	public void testWhenShifted26Times() {
		String expectedEncodedString = "abc def";
		Assert.assertEquals(expectedEncodedString,
				caesarCipher.cipher("abc def", 26));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_null_input(){
		caesarCipher.cipher(null, 26);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_empty_string(){
		caesarCipher.cipher("", 26);
	}
}
