### Composite Pattern

#### Composite Pattern 이란?

-클래스의 구조적 디자인 패턴으로 단일 객체와 복합 객체를 동일하게 컨트롤 할 수 있게 뜸 도와주는 패턴이다. 

+ 구조도

![image](https://raw.githubusercontent.com/Hongsomang/Design-Pattern/master/Structral%20Pattern/Composite_Pattern/image/Composite_Pattern.png)				

+ component

  -component는 composition(구성자)을 위한 인터페이스로 구성된다. 클라이언트 클래스에서는 component의 인터페이를 사용하여 작업하게 된다. 

+ leaf

  -component를 구현하는 클래스 요소로 이 클래스들을 쌓아올려 하나의 구성물을 만들게 된다. leaf클래스에서 component외에는 다른 컴포넌트는 섞지 않는다.

+ composite

  -다수의 leaf클래스를 컨트롤 할 수 있는 클래스로 인터페이스는 component부터 얻어 공통된 인터페이스로 작업을 할 수 있는 클래스이다.

#### 예제

-간단히  삼각형,원, 선의 객체 오브젝트를 생성하고 이 모든 객체를 빨강색으로 칠하는 작업을 컴포지트 패턴을 통해서 해보록 한다.

component

뼈대가 되는 클래스로 아래와 같이 draw메소드를 가지는 인터페이스로 구성된다. 

```
public interface Shape{
  public void draw(Stirng color);
}
```

leaf

leaf로 구성된 클래스를 이용하여 다수의 객체를 생성할 수 있다. 

```
// 삼각형
public class Triangle implements Shape {
    @Override
    public void draw(String color) {
        System.out.print("triangle color: " + color);
    }
}

// 원
public class Circle implements Shape {
    @Override
    public void draw(String color) {
        System.out.print("circle color: " + color);
    }
}

// 라인
public class Line implements Shape {
    @Override
    public void draw(String color) {
        System.out.print("line color: " + color);
    }
}
```

composite

composite클래스는 leaf의 객체 그룹을 컨트롤 하는 역할을 한다.

```
public class Drawing implements Shape {
    private List<Shape> shapes = new ArrayList<Shape>();

    @Override
    public void draw(String color) {
        for (Shape sh : shapes) {
            sh.draw(color);
        }
    }

    // 아래서부터는 헬퍼 성격의 메소드이다. 추가/제거/전체제거
    public void add (Shape s) {
        this.shapes.add(s);
    }

    public void remove (Shape s) {
        this.shapes.remove(s);
    }

    public void clear () {
        this.shapes.clear();
    }
}
```

test

```
public class Test {
    public static void main(String[] args) {
        Shape t1 = new Triangel();
        Shape t2 = new Triangel();
        Shape c1 = new Circle();
        Shape l1 = new Line();

        Drawing drawing = new Drawing();
        drawing.add(t1);
        drawing.add(t2);
        drawing.add(c1);
        drawing.add(l1);
        drawing.draw("red");

        drawing.clear();

        drawing.add(t2);
        drawing.add(c1);
        drawing.draw("blue");
    }
}
```

