### Prototype Pattern

#### 1.Prototype Pattern이란?

:원형이 되는 인스턴스, 모범이 되는 인스턴스를 기초로 새로운 인스턴스를 만드는 것이다. 이 패턴은 새로운 객처를 생성하기 위해 clone(복제)을 이용한다.

**사용하는 이유**

+ 종류가 너무 많아 클래스로 정리되지 않는 경우

+ 클래스로부터 인스턴스 생성이 어려운 경우

+ framework와 생성할 인스턴스를 분리하고 싶은 경우

  ​

#### 2.Prototype Pattern 등장인물

+ prototype(원형)의 역할

  + Cloneable 인터페이스를 상속한다.
    + clone메소드를 사용하여 자동적으로 복제를 할 수 있다.

+ ConcretePrototype(구체적인 원형)의 역할

  + createClone()메소드는 자기 자신을 복제하는 메소드 이다. 
  + java 언어의 Clone메소드는 자신의 클래스에서만 호출할 수 있기 때문에 다른 클래스의 요청으로 복제를 하는 경우에는 createClone과 같은 다른 메소드를 clone을 해서 기술할 필요가 있다.

+ Client(이용자)의 역할

  + 인스턴스의 복제를 실행하는 클래스
  + 구체적인 개개의 클래스 이름을 쓰지 않고 단지 Prototype라는 인터페이스 이름 만 사용하고 있다.이 인터페이스만 다른 클래스의 다리 역할을 한다.

  ![image](https://github.com/Hongsomang/Design-Pattern/blob/master/Creation_Pattern/Prototype_Pattern/Image/Prototype_Pattern.PNG?raw=true)

  ​