package com.java.z_exam.design_patterns.c00_priciple.c03_inversion.improve;

/**
 * @Author:
 * @Date: Created in 3:46 下午 2020/8/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class DependencyPass {

    public static void main(String[] args) {
// TODO Auto-generated method stub
    ChangHong changHong = new ChangHong();
//	OpenAndClose openAndClose = new OpenAndClose();
//	openAndClose.open(changHong);

//通过构造器进行依赖传递
//	OpenAndClose openAndClose = new OpenAndClose(changHong);
//	openAndClose.open();
//通过 setter 方法进行依赖传递
        OpenAndClose openAndClose = new OpenAndClose(); openAndClose.setTv(changHong); openAndClose.open();

    }

}

// 方式 1： 通过接口传递实现依赖
// 开关的接口


// interface IOpenAndClose {
// public void open(ITV tv); //抽象方法,接收接口
// }
//
// interface ITV { //ITV 接口
// public void play();
// }
//
// class ChangHong implements ITV {
//
//	@Override
//	public void play() {
//	// TODO Auto-generated method stub
//	System.out.println("长虹电视机，打开");
//	}
//
// }
//// 实现接口
// class OpenAndClose implements IOpenAndClose{
// public void open(ITV tv){
// tv.play();
// }
// }

// 方式 2: 通过构造方法依赖传递
// interface IOpenAndClose {


// public void open(); //抽象方法
// }
// interface ITV { //ITV 接口
// public void play();
// }
// class OpenAndClose implements IOpenAndClose{
// public ITV tv; //成员
// public OpenAndClose(ITV tv){ //构造器
// this.tv = tv;
// }
// public void open(){
// this.tv.play();
// }
// }



// 方式 3 ,  通过 setter 方法传递
interface IOpenAndClose {
    public void open(); // 抽象方法


    public void setTv(ITV tv);
}

interface ITV { // ITV 接口
    public void play();
}




class OpenAndClose implements IOpenAndClose { private ITV tv;

    public void setTv(ITV tv) { this.tv = tv;
    }


    public void open() { this.tv.play();
    }
}


class ChangHong implements ITV {


    @Override
    public void play() {
// TODO Auto-generated method stub
        System.out.println("长虹电视机，打开");
    }


}