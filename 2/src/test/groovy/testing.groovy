import spock.lang.Specification;

class testing extends Specification{

	Sys system
	ThirdPartyHelper thirdPartyHelper

	def setup(){
		system = new Sys()
		thirdPartyHelper = Mock()
		system.thirdPartyHelper = thirdPartyHelper
	}

	def "should return TRUE if age is 18 and above"(){
		given:
			def user = new User()
			user.name = "Dick"
			user.birthday = new Date(1,10,1996)
			//user.age = 18
			user.gender = Gender.MALE
			user.preference = [Gender.MALE, Gender.FEMALE]
			user.course = "BS Tourism"
			user.avatarUrl = "imgur.com/78456a"

			def sys = new Sys()

		when:
			def status = sys.register(user)

		then:
			status == true
	}

	def "should return FALSE if age is below 18"(){
		given:
			def user = new User()
			user.name = "Dick"
			user.birthday = new Date(1,10,2000)
			//user.age = 18
			user.gender = Gender.MALE
			user.preference = [Gender.MALE, Gender.FEMALE]
			user.course = "BS Tourism"
			user.avatarUrl = "imgur.com/78456a"

			def sys = new Sys()

		when:
			def status = sys.register(user)

		then:
			status == false
	}

	def "preference should have no duplicates"(){
		given:
			def user = new User()
			user.name = "Dick"
			user.birthday = new Date(1,10,2000)
			//user.age = 18
			user.gender = Gender.MALE
			user.preference = [Gender.MALE, Gender.FEMALE, Gender.MALE]
			user.course = "BS Tourism"
			user.avatarUrl = "imgur.com/78456a"

			def sys = new Sys()

		when:
			def status = sys.register(user)

		then:
			user.preference == [Gender.MALE, Gender.FEMALE]
	}

	enum Gender{
		MALE,
		FEMALE,
	}

	class Date{
		int day;
		int month;
		int year;

		public Date(int day, int month, int year){
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}
	
	class User{

		String name;
		Date birthday;
		//int age;
		Gender gender;
		List<Gender> preference;
		String course;
		String avatarUrl;
	}

	class Sys{
		def thirdPartyHelper

		def register(User user) {
			List<Gender> preference = new ArrayList<Gender>()

			if (user.preference.contains(Gender.MALE)) {
				preference.add(Gender.MALE)
			}

			if (user.preference.contains(Gender.FEMALE)) {
				preference.add(Gender.FEMALE)
			}

			user.preference = preference

			if(2016-user.birthday.year >= 18)
				return true

			return false
		}
	}

	class ThirdPartyHelper {
		def emailConfirmation(){

		}

		def 
	}
}