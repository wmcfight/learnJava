package baseKnowledge;

/**
 * Created by weimingchuan on 16/3/28.
 *
 * 1）一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。

 2）transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。变量如果是用户自定义类变量，则该类需要实现Serializable接口。

 3）被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。

 对象的序列化可以通过实现两种接口来实现，若实现的是Serializable接口，则所有的序列化将会自动进行，
 若实现的是Externalizable接口，则没有任何东西可以自动序列化，
 需要在writeExternal方法中进行手工指定所要序列化的变量，
 这与是否被transient修饰无关。因此第二个例子输出的是变量content初始化的内容，而不是null。
 */
public class KeyTransient {
}
