### Abstract Factory Pattern

#### Abstract Factory Pattern이란?

-생산적인 디자인 패턴 중 하나로써 factory를 좀더 생산적으로 만들어 낼 수 있다는 점 외에는 factory pattern과 매우 비슷하다.

factory를 추상화하여 객체의 생성과정을 사용하는 측에서 결정할 수 있게한 패턴.  Stategy pattern과 결합된 형태라고 생각된다.

+ 구조도

![image](https://raw.githubusercontent.com/Hongsomang/Design-Pattern/master/Creation_Pattern/Abstract_Factory_Pattern/image/%EA%B5%AC%EC%A1%B0%EB%8F%84.PNG)

+ Product

  -AbstractFactory 역할에 의해 만들어지는 추상적인 부품이나 제품의 인터페이스를 결정한다. 

+ AbstractFactory

  -AbstractProduct 역할의 인스턴스를 만들어 내기위한 인터페이스를 결정한다.

+ Client

  -AbstractFactory와 product의 인터페이스만을 사용해서 주어진 역할을 실행한다. 

+ ConcreteFactory

  -AbstractFactory의 인터페이스를 구현합니다.

+ ConcreteFactory 

  -AbstractFactory의 인터페이스를 구현한다.

#### 예제

Skill.java

```
public interface Skill{
  public abstract void use();
}
```

MagicMissile.java

```
public class MagicMssile implements Skill{
  @Override
  public void use(){
 	 System.out.println("Cast Magic missile");
  }
}
```

FireBall.java

```
public class FireBall implements Skill{
  @Override
  public void use() {
  	System.out.println("Cast Fire ball");
  }
}
```

AbstractSkillFactory.java

```
public abstract class AbstractSkillFactory {

	public abstract Skill createSkill(String skillName);

}
```

MagicSkillFactory.java

```
public class MagicSkillFactory extends AbstractSkillFactory {
  @Override
  public Skill createSkill(String skillName) {

  Skill skill = null;
  skillName.toLowerCase();
  if(skillName.equals("magicmissile")){
 	 skill = new MagicMissile();
  }

  else if(skillName.equals("fireball")){
  	skill = new FireBall();
  }
  return skill;

  }

}
```

SwordSkillFactory.java

```
public class SwordSkillFactory extends AbstractSkillFactory {

@Override

public Skill createSkill(String skillName) {

  Skill skill = null;
  skillName.toLowerCase();
  if(skillName.equals("whirlwind")){
  	skill = new Whirlwind();
  }
  else if(skillName.equals("bash")){
  	skill = new Bash();

  }
  return skill;

}

}
```

Character.java

```
public class Character {

  private AbstractSkillFactory skillFactory;

  private Collection<Skill> skills = new Collection<Skill>();



  public void setSkillFactory(AbstractSkillFactory newSkillFactory){

      skillFactory = newSkillFactory;

  }



  //어떤 직업이건 스킬을 배우는입장은 변함없다.

  public void runSkill(String skillName){

      Skill skill = skillFactory.createSkill(skillName);

      // skill에 대한 세팅

      skills.add( skill );

  }



  public void useSkill(int index){

      skills.at(index).use();

      }

}




```

main.java

```
public static void main(String[] args){

  Character character = new Character();



  character.setSkillFactory(new MagicSkillFactory());

  character.runSkill("magicmissile");

  character.useSkill();



  //다른직업의 스킬을 배우자

  character.setSkillFactory(new SwordSkillFactory());

  character.runSkill("bash");

  character.useSkill();

 }



	
```