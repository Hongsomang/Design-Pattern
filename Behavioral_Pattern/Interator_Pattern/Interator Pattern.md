### Interator Pattern

#### 1.Interator Patten이란?

- Interator Patten이란, 무엇인가 많이 모여있는 것들을 순서대로 지정하면서 전체를 검색하는 처리를 실행하기 위한 것이다.

  java 언어에서 for에서의 i를 하나씩 증가시키면서 배열의 arr의 요소를 검색한다. 여기서 사용하고 있는 변수 i의 기능을 추상화해서 일반화한 것을 디자인 패턴 Iterator 패턴이라고 한다.

#### Interator Patter의 등장인물

+ Interator(반복자)의 역할

  :요소를 순서대로 검색해가는 인터페이스를 결정한다.

  다음 요소가 존재하는지를 얻기 위한 hasNext메소드와 다음 요소를 얻기 위한  next 메소드를 결정한다.

+ Concretelterator(구체적인 반복자) 역할

  : Interator가 결정한 인터페이스를 실제로 구현한다.

    이 역할을 검색하기 위해 필요한 정보를 가지고 있어야 한다.

+ Aggregate(집합체)의 역할

  :Interator역할을 만들어내는 인터페이스를 결정한다.

  이 인터페이스는 '내가 가지고 있는 요소를 '내가 가지고 있는 요소를 순서대로 검색해 주는 사람'을 만들어내는 메소드이다.

+ ConcreteAggregate(구체적인 집합체)역할

  :Aggregate역할이 결정한 인터페이스를 실제로 구현하는 일을 한다.

   구체적인 Iterator 역할, 즉 Concretelterator역할의 인스턴스를 만들어 낸다.

