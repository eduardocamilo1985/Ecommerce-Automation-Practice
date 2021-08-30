package estrutura;

import com.github.javafaker.Faker;

public class Util {
  Faker faker = new Faker();

  public String email(){
   return faker.internet().emailAddress();
  }
}
