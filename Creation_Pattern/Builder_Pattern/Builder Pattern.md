###Builder Pattern

#### 1.Builder Pattern이란?

: Builder Pattern은 객체를 생성할 때 흔하게 사용하는 패턴이다. 객체 생성후 상태값을 변경할 수 없게 해준다. 상태를 변경할 수 있는 데이터와 변경할 수 있는 데이터가 있을 떄 사용한다.

장점

+ 인자의 의미를 파악하기 쉬워졌다.
+ 복잡한 여러 개의 생산자를 만들지 않아도 된다.

예시

-이름과 나이는 변경되지 않지만 좋아하는 컬러,동물,숫자는 변경 될 수 있다.

```
public static class Builder{
	private final String name;
	private final int age;
	private final String favoriteColor;
	private final String favoriteAnimal;
	private final int favoriteNumber;
	
}
```

