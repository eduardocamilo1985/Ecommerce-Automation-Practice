package estrutura;

import com.github.javafaker.Faker;

public class Util {
  Faker faker = new Faker();

  public String email(){
   return faker.internet().emailAddress();
  }
    public String name(){
        return faker.funnyName().name();
    }
    public String lastName(){
        return faker.name().lastName();
    }
    public String company(){
        return faker.company().name();
    }

    public String address(){
        return faker.address().streetName();
    }
    public String inf(){
        return faker.chuckNorris().fact();
    }
    public String phone(){
        return faker.phoneNumber().cellPhone();
    }
    public String city(){
        return faker.address().city();
    }
    public String zipCode(){
        return faker.number().digits(5);
    }

}
