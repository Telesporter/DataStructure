package DataStructure.DS08;

import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/21
 * Time: 10:47
 * Description: No Description
 */
public interface MyQueue {
    //这组方法通过特殊的返回值，通知错误
    //true成功，false失败(例如容量满了)
    boolean offer(Integer e);

    //看队首元素，但不删除
    //返回null，表示队列为空
    Integer peek();

    //返回null，表示队列为空
    //看到并删除对首元素
    Integer poll();


    //这组方法通过抛出异常，通知错误
    //true成功，false失败(例如容量满了)
    default boolean add(Integer e){
        if (offer(e) == false){
            throw new IllegalStateException();
        }
        return true;
    }

    //看队首元素，但不删除
    default Integer element(){
        Integer e = peek();
        if (e == null){
            throw new NoSuchElementException();
        }
        return e;
    }

    //看到并删除对首元素
    default Integer remove(){
        Integer e = poll();
        if (e == null){
            throw new NoSuchElementException();
        }
        return e;
    }
}
