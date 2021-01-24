package Test;

// 父类
public class darwImplement {
    void doAnyTthing(){
    }

    public static void main(String[] args) {
        draw[] draws = {
                new Square(),
                new Parallelsibianxing()
        };
        for (int i = 0; i < draws.length; i++) {
            draws[i].draw();
        }
    }
}

//继承父类的方法类（忽略）
class Anything extends darwImplement {
    void doAnyTthing() {
        super.doAnyTthing();
    }
}

//正方形类 实现draw接口
class Square extends darwImplement implements draw{

    @Override
    public void draw() {
        System.out.println("子类正方形Square继承sibianxing父类实现接口draw的方法: draw()");
    }

    @Override
   void doAnyTthing() {
        super.doAnyTthing();
    }

}

//平行四边形类 实现draw接口
class Parallelsibianxing extends darwImplement implements draw{
    @Override
    public void  draw() {
        System.out.println("子类平行四边形Parallelsibianxing继承sibianxing父类实现接口draw的方法: draw()");
    }

    @Override
    void doAnyTthing() {
        super.doAnyTthing();
    }
}
