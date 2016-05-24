import spock.lang.Specification

class FooTest extends Specification {

	def "simple addition test"() {
		given:
			def math = new Math()

		when:
			def sum = math.add(3,4)

		then:
			sum == 7
	}

	def "simple subtraction test"() {
		given:
			def math = new Math()

		when:
			def difference = math.subtract(5,2)

		then:
			difference == 3
	}

	def "simple division test"() {
		given:
			def math = new Math()

		when:
			def quotient = math.divide(10,2)

		then:
			quotient == 5
	}

	def "simple multiplication test"() {
		given:
			def math = new Math()

		when:
			def product = math.multiply(2,3)

		then:
			product == 6
			//ex = thrown()
	}

	class Math {
		
		def add(a,b) {
			return a + b
		}

		def subtract(a, b) {
			return a - b
		}

		def divide(a, b){
			return a / b
		}

		def multiply(a, b){
			return a * b
		}
	}
}