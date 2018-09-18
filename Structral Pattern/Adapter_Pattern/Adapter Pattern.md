### Adapter Pattern

#### 1. Adapter Pattern이란?

:한 클래스의 인터페이스를 클라이언트에서 사용하고자하는 다른 인터페이스로 변환한다. 어댑터를 이용하면 인터페이스 호환성 문제 때문에 같이 쓸 수 없는 클래스들을 연결하여 쓸 수 있다.

Adapter 패턴은 Wrapper 패턴으로 불린기도 한다.  무엇인가를 포장해서 다른 용도로 사용할 수 있게 교환 해주는 것이 Adapter 이다. Adapter pattern패턴에는 다음과 같이 두 가지 종류가 있다.

+  클래스에 의한 Adapter 패턴(상속을 사용한 Adapter 패턴)

   +  클래스 어댑터 패턴을 쓰려면 다숭 상속이 필요한데, 자바는 다중 상속이 불가능 하다. 그래서  어댑터를 만들 때 타겟과 어뎁티 모두 서브 클래스로 만든다.

      ![image](https://github.com/Hongsomang/Design-Pattern/blob/master/Structral%20Pattern/Adapter_Pattern/Image/Class_Adapter.PNG?raw=true)

   + 장점

     + Adapter 클래스에서 Adaptee의 기능이 필요한 경우 곧바로 Adaptee클래스의 멤버함수들을 Override할 수 있다
     + 별도의 Adaptee 객체를 보관할 필요가 없다.

   + 단점

     +  Adaptee클래스를 상속받는 것이기에, 그 하위단계에 있는 클래스들에 대해서는 상속 받지 못한다.

+ 인스턴스 의한 Adapter 패턴(위임을 사용한 Adapter 패턴, 객체 어뎁터)

  + 구성을 통해서 어댑티에 요청을 전달한다.

    ![image](https://github.com/Hongsomang/Design-Pattern/blob/master/Structral%20Pattern/Adapter_Pattern/Image/Object_Adapter.PNG?raw=true)

  +  장점

     +  Adaptee의 하위 클래스에 대해서도 소스코드 변경 없이 동작이 가능하다.

  +  단점

     +  Adaptee클래스의 멤버함수를 Override하려면 Adaptee 크래스를 상속한 하위클래스를 정의하고, 이를 다시 사용하는 형태가 되어야 한다.


#### 2.Adapter Pattern 등장인물

+ Target(대상)의 역할

+ Client(의뢰자) 역할

+ Adaptee(개조되는 쪽)의 역할

+ Adapter의 역할


#### 3. 클라이언트에서 어댑터를 사용하는 방법

1. 클라이어늩에서 타겟 인터페이스를 사용하여 메소드를 호출함으로 어댑터에 요청을 한다.
2. 어뎁터에서 어댑티 인터페이스를 사용하여 그 용청을 어댑티에 대한 하나 이상의 메소드를 호출로 변환한다.
3. 클라이언트에서는 호출 결과를 받긴 하지만 중간에 어뎁터가 껴 있는지는저혀 알지 못한다.