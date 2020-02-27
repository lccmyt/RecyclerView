package com.bawei.demo_022501.base;

/**
 * @ProjectName: Demo_022501
 * @Package: com.bawei.demo_022501.base
 * @ClassName: IBaseView
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/2/25 17:16
 */
/**
 * 这里是一个空接口
 * 在我们每一个页面的契约类里，V层的接口是不一样的
 * 正因为他们不一样，才会导致在BasePresenter中，无法统一使用
 * 为了实现无论哪一个契约类中的V层，都能传入到BasePresenter中
 * 所以定义了一个空的接口，由每一个契约类的V层接口来继承他
 * 继承过后，IBaseView就是我们每一个契约类中V层接口的父类
 * 方便我们在BasePresenter添加泛型的限制
 *
 *
 * 2.写一个v层的基类，这是一个接口，用来作为所有V层接口的父类，以方便BasePresenter使用
 * 这个接口里面可以是空的啥都没有
 */
public interface IBaseView {
}
