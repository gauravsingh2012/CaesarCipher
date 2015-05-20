require_relative "CaesarCipher"
require "test/unit"

class TestCaesarCipher < Test::Unit::TestCase 

	def test_simple
		assert_equal('def ghi', CaesarCipher.new('').cipher('abc def',3))
	end
	
	def test_with_character_overflow
		assert_equal('abc', CaesarCipher.new('').cipher('xyz',3))
	end
	
	def test_with_a_sentence
		assert_equal('WKH TXLFN EURZQ IRA MXPSV RYHU WKH ODCB GRJ',CaesarCipher.new('').cipher('THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG',3))
	end
	
	def test_when_shifted_26_times
		assert_equal('abc def', CaesarCipher.new('').cipher('abc def',26))
	end
	
	def test_with_characters_other_than_letters
		assert_equal('Dpdclqj!', CaesarCipher.new('').cipher('Amazing!',3))
	end
	
	def test_typecheck
		assert_raise( RuntimeError ) { CaesarCipher.new('').cipher(2,3) }
	end
	
	def test_nil
		assert_raise( RuntimeError ) { CaesarCipher.new('').cipher(nil,3) }
	end
	
	def test_empty_string
		assert_raise( RuntimeError ) { CaesarCipher.new('').cipher('',3) }
	end
	
end