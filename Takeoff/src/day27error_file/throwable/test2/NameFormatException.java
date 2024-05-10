package day27error_file.throwable.test2;

public class NameFormatException extends RuntimeException{
    //技巧：
    //NameFormat：当前异常的名字，表示姓名格式化问题
    //Exception：表示当前类是一个异常类

//异常继承谁?
    //运行时异常：RuntimeException 核心 就表示由于参数错误而导致的问题
    //编译时异常：Exception 核心 提醒程序员检查本地信息


    public NameFormatException() {
    }

    public NameFormatException(String message) {
        super(message);
    }
}
