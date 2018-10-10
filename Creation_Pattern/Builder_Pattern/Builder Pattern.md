###Builder Pattern

#### 1.Builder Pattern이란?

: Builder Pattern은 객체를 생성할 때 흔하게 사용하는 패턴이다. 객체 생성후 상태값을 변경할 수 없게 해준다. 상태를 변경할 수 있는 데이터와 변경할 수 있는 데이터가 있을 때사용한다.

장점

+ 인자의 의미를 파악하기 쉬워졌다.
+ 복잡한 여러 개의 생산자를 만들지 않아도 된다.

예시

-이름과 나이는 변경되지 않지만 좋아하는 컬러,동물,숫자는 변경 될 수 있다.

Effective Java 스타일

```
public static class Person{
	private final String name;
	private final int age;
	private final String favoriteColor;
	private final String favoriteAnimal;
	private final int favoriteNumber;
	
	public static class Builder{
		//필수 인자
		private final String name; 
		private final int age;
		//선택 인자
		private String favoriteColor="";
		private String favoriteAnimal="";
		private int favoriteNumber=0;
		public Builder(String name, int age){
          this.name=name;
          this.age=age;
		}
		public Builder favoriteColor(String val){
          favoriteColor=val;
          return this;
		}
		public Builder favoriteAnimal(String val){
          favoriteAnimal=val;
          return this;
		}
		public Builder favoriteNumber(int val){
          favoriteNumber=val;
          return this;
		}
		public Person build(){
          return new Person(this);
		}
		
	}
	private Person(Builder builder){
      name=builder.name;
      age=builder.age;
      favoriteColor=builder.favoriteColor;
      favoriteAnimal=builder.favoriteAnimal;
      favoriteNumber=builder.favoriteNumber;
	}
}
```

```
...
public static void main(String[] args) {
	
	//방법1
	Person.Builder builder=new Person.Builder("홍길동",20);
	builder.favoriteColor("노란색");
	builder.favoriteAnimal("웰시코기");
	builder.favoriteNumber(3);
	    
	//방법2
	Person person=new Person
	.Builder("홍길동",20)
	.favoriteColor("노란색")
	.favoriteAnimal("웰시코기")
	.favoriteNumber(3)
	.build();
		
}
```

