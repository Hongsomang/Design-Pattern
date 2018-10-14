### Strategy Pattern

#### Strategy Pattern이란?

-Strategy는 전략을 의미한다. 

Strategy Pattern에서는 알고리즘을 정의하고 각각을 캡슐화하여 교환해서 사용할 수 있도록 만든다. 알고리즘을 빈틈없이 교체해서 같은 문제를 다른 방법으로도 쉽게 해결할 수 있도록 도와주는 패턴이 Strategy 패턴이다.



+ 구조도

  ![image](https://raw.githubusercontent.com/Hongsomang/Design-Pattern/master/Behavioral_Pattern/Strategy_Pattern/image/Strategy_Pattern.PNG)

  + Strategy:interface
  + ConcreteStategy(ImplementationOne, ImplementationTwo): Stategy의 인터페이스를 실제로 구현, 실제 알고리즘을 프로그래밍 한다.
  + Context:Context는 Strategy를 이용하여 역할, ConcreteStategy의 인스턴스를 가지고 있으며 그것을 이용

+ 장점

  + 코드중복을 줄일 수 있다.
  + 실행 시 행동을 바꿀 수 있다.
  + 신규 알고리즘 추가가 용이하다.(확장성)
  + 클라이언트와 독립적이기 때문에 알고리즘 변경에 용이하다.

### 예제



-이동수단으로 버스,자동차 택시가 있다. 각각 이동 비용이 다르다. 각각  pay메소드에 따라 다르기 때문에 WeaponBehavior인터페이스를 상속받는 각각의 객체에서 메소드를 구현한다. 

-Take 객체에서  WeaponBehavior객체를 갖고 탈것에 따라 다른 비용을 지불한다.

```
public class Transportation{
  private WeaponBehavior weaponBehavior;
  public Take(WeaponBehavior weaponBehavior){
    this.weaponBehavior=weaponBehavior;
  }
  public void Take(){
    weaponBehavior.pay();
  }
  pulbic void setWeapon(WeaponBehavior weaponBehavior){
    this.weaponBehavior=weaponBehavior;
  }
}
```

```
public interface WeaponBehavior{
  pulic void pay();
 
}
class Bus implements WeaponBehavior{
  @Override
  public void pay(){
    System.out.println("1200원");
  }
}
Class car implemnets WeaponBehavior{
  @Override
   public void pay(){
    System.out.println("0원");
  }
}
Class Taxi implemnets WeaponBehavior{
  @Override
   public void pay(){
    System.out.println("4000원");
  }
}

```

```
public class main{
  pulblic static void main(String[] args){
    Transportation transportation1=new Transportation(new Bus());
    transportation1.Take();
   
   Transportation transportation2=new Transportation(new car());
    transportation2.Take();
   
 	transportation2.setWeapon(new Taxi());
 	transportation2.Take();
  }
}
```

