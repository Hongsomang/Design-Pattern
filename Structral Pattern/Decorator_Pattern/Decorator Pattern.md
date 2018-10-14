### Decorator Pattern

#### 1.Decorator Pattern이란?

-객체의 결합을 통해 기능을 동적으로 유연하게 확장 할 수 있게 해주는 패턴

 데코레이터 패턴은 기존의 코드를 건드리지 않고 확장하도록 한다.

+ 구조도

  ![image](https://github.com/Hongsomang/Design-Pattern/blob/master/Structral%20Pattern/Decorator_Pattern/image/decorator_Pattern.PNG?raw=true)

  + Component

    -추상 클래스로 데코레이터로 감싸져 사용될 수 있다.

  + ComcreateComponent

    -인터페이스를 동적으로 추가함

  + Decorator

    -Decorator안에 Component객체를 가짐. 자신이 장식할 구성요와 같은 인터페이스 또는 추상 클래스를 구현한다.

  + ConcreteDecorator

    -Decorator가 감싸고 있는 Component객체를 위한 인스턴트 변수가 있어 Component상태를 확장할 수 있음

    ​