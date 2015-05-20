class CaesarCipher
	
	def initialize(encoded)
		@encoded = encoded 	#instance variable stores the encoded result
	end
	
	
	#This method takes in a string and a shift value that adds
	#the shift value to the original string and produces a new
	#encoded string.   
	#E.g: - cipher("abc",3) = "def"
	 
	def cipher(str,shift)
	
		if str == '' or str.nil? or !str.is_a? String
			raise "Invalid Input"
		end 
		
		str.each_byte do |c|
		
			original_character = c.chr
			
			# encode the character by adding the shift value to it
			encoded_character = (c + shift).chr
			
			# Check if it is an uppercase character or Lowercase character
			# If its not either of them, then the character is not a letter and
			# and hence we just append them. My assumption is that if the
			# character is not a letter, then we don't encode them and just append
			# the original character
			
			if is_upper?(original_character)
				encodeCharacter(encoded_character,'Z')
			elsif is_lower?(original_character)
				encodeCharacter(encoded_character.chr,'z')
			else
				# use concat to conacatenate strings as it is much faster than
				# the + operator for conacatenation
				@encoded.concat(original_character)
			end
			
		end
		
		return @encoded
	end
	
	private
		
		# This function takes in an encoded character and the last character in
		# the english alphabet. It compares both of them to determine if there
		# is an overflow of a character. For Example, if originalcharacter is x and
		# we shift it by 3 times, the encoded character should be a. so If x + 3 > z,
		# we subtract 26 from it to get the wrapped around character. 
			
		def encodeCharacter(encoded_character, last_character)
			if (encoded_character > last_character)
				@encoded.concat((encoded_character.ord - 26).chr)
			else	
				@encoded.concat(encoded_character)
			end
		end

	private
		# determines if the character is lowercase.
		# Note that this function is needed as space is 
		# considered as an uppercase as well as a lowercase character
		# in ruby .upcase or .downcase api
		
		def is_lower?(c)
			return c >= 'a' && c <= 'z'
		end
			
	private
		
		# determines if the character is uppercase.
		# Note that this function is needed as space is 
		# considered as an uppercase as well as a lowercase character
		# in ruby if we use .upcase or .downcase api
		
		def is_upper?(c)
			return c >= 'A' && c <= 'Z'
		end
		
end


def main
	puts CaesarCipher.new('').cipher('xyz',3)
	puts CaesarCipher.new('').cipher('abc def',3)
end

main