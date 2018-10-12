### Bridge Pattern

  #### 1.Bridge Pattern이란?

-구현부에서 추상층을 분리하여 각자 독립적으로 변형할 수 있게 하는 패턴이다. 즉,'기능의 클래스 계층'와 '구현의 클래스 계층'를 연결해주는 역할이다.

전형적인 상속을 이용한 패턴으로 확장 설계에 용이하다.

+ 클래스 계층의 두 가지 역할
  + 새로운 '기능'을 추가하고 싶은 경우

    -Something이라는 클래스가 있다. 여기에 새로운 기능 추가하고 싶을 때 하위클래스로 SomethingGood 클래스를 만든다. 기능을 추가하기 위해서 만들어진 이 클래스의 계층을 '기능의 클래스 계층'이라고 한다.

    *일반적으로 클래스 계층은 너무 깊게 하지 않는 편이 좋다.

  + 새로운 '구현'추가하고 싶은 경우

    최상위 클래스가 인터페이스이고 이 인터페이스는 자식 클래스들에서  구체화될 때 메소드들이 정의되어있다.

    자식클래스에서 부모 인터페이스를 구현하여 사용한다.

    A라는 인터페이스를 구현한 B라는 객체가 있을 때 이것을 '구현의 클래스 계층'이라고 한다.

+ 클래스 계층의 혼재와 클래스 계층의 분리


  -클래스 계층이 하나라면 기능의 크래스 계층과 구현의 클래스 계층과 기능클래스 계층이 하나의 계층구조 안에 혼재하게 된다. 이것은 클래스 계층을 어렵게 한다. 

  그래서 '기능의 클래스 계층'과 '구현의 클래스 계층'을 두 개의 독립된 클래스 계층로 분리 한다. 단순히 분리만 하면 흩어져버리기 떄문에 두 개의 클래스 계층 사이에 다리를 놓는 일이 필요하다. 

  #### 예제

  -각 '동물'이라는 클래스와 이 동물 클래스가 가질 수 있는 '사냥방법'을 Bridge 패턴을 적용하여 각각 분리하여 설계

  ![image](https://raw.githubusercontent.com/Hongsomang/Design-Pattern/master/Structral%20Pattern/Bridge_Pattern/Image/%ED%81%B4%EB%9E%98%EC%8A%A4%20%EA%B5%AC%EC%A1%B0%EB%8F%84.PNG)

  ​

+ Animal ->기능 계층의 최상위 클래스. 구현 부분에 해당하는 클래스의 인스턴스를 가지고 해당 인스턴스를 통해 구현부분의 메서드를 호출
+ Bird,Tiger->기능 계층에서 새로운 부분을 확장한 클래스
+ Hunting_Handler-> Animal의 기능을 구현하기 위한 인터페이스 정의
+ Hunting_Method1,Hunting_Method2-> 실제 기능 구현

```
public interface Hunting_Handler{
  public void Find_Quarry();
  public void Detected_Quarry();
  public void attack();
}
```

동물이 가질 수 있는 '사냥 방식'들이 가져야 할 공통 인터페이스를  정의하고 있다.

```
public class Hunting_Method1 implements Hunting_Handler{
  public void Find_Quarry(){
    System.out.println("물 위에서 찾는다");
  }
  public void Detected_Quarry(){
  	System.out.println("물고기 발견");
  }
  public void attack(){
    System.out.println("낚아챈다.");
  }
}
```

```
public class Hunting_Method2 implemets Hunting_Handler{
  public void Find_Quarry(){
    System.out.pirintln("지상에서 찾는다.");
  }
  public void Detected_Quarry(){
	System.out.println("노루 발견");
  }
  public void attack(){
    System.out.println("물어뜯는다");
  }
}
```

Hunting_Handler인터페이스를 상속받아 실제 기능에 해당하는 부문을 구현합니다.

```
public class Animal{
  private Hunting_Handlr hunting;
  public Animal(Huntin_Handler hunting){
    this.hunting=hunting;
  }
  public void Find_Quarry(){
    hunting.Find_Quarry();
  }
  public void Detected_Quarry(){
    hunting.Detected_Quarry();
  }
  
  public void attack(){
	hunting.attack();
  }
  public void hunt(){
    Find_Quarry();
    Detected_Quarry();
    attack();
  }
}
```

기능 부문에 해당되는 최상위 클래스이다. Hunting_Handler의 인스턴스를 가지고 각각의 Hunting_Handler를 상속받아 구현하고 있는 메서드를 호출하고 있다.

```
public class Tiger extends Animal{
  pulblic Tiger(Hunting_Handler hunting){
    super(hunting);
  }
  public void hunt(){
    System.out.println("호랑이의 사냥방식");
    Find_Quarry();
    Detected_Quarry();
    attack();
  }
}
```

```
public class Bird extends Animal{
  public Bird(Hunting_Handler hunting){
    super(hunting);
  }
  pulbilc void hunting(){
    System.out.println("새의 사냥방식");
    Find_Quarry();
    Detected_Quarry();
    attack();
  }
}
```

Animal를 확장한 클래스이다. 

```
public class Main{
  public static void main(String argsp[]){
    Animal tiger=new Tiger(new Hunting_Method2());
    Animal bird=new Bird(new Hunting_Method1());
    tiger.hunt();
    System.out.println("================");
    bird.hunt();
  }
}
```

실제 메인에서 동물 클래스를 생성하고 각각 다른 사냥 방식을 채택하는 모습이다.



