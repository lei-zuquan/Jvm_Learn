package com.java.z_exam.design_patterns.c00_priciple.c05_ocp.improve;

/**
 * @Author:
 * @Date: Created in 4:32 下午 2020/8/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Ocp {
    public static void main(String[] args) {
        //使用看看存在的问题
        GraphicEditor graphicEditor = new GraphicEditor();

        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
        graphicEditor.drawShape(new OtherGraphic());
    }
}

//这是一个用于绘图的类 [使用方]
class GraphicEditor {
    // 接收 Shape 对象，调成draw 方法
    public void drawShape(Shape s) {
        s.draw();
    }
}

//Shape 类，基类
abstract class Shape {
    int m_type;

    public abstract void draw(); // 抽象方法
}


class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制矩形 ");
    }
}


class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制圆形 ");
    }
}


//新增画三角形
class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制三角形 ");
    }
}

// 新增一个图形
class OtherGraphic extends Shape {

    OtherGraphic() {
        super.m_type = 4;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制其他图形 ");
    }
}
