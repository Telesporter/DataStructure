package DataStructure.DS06;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/14
 * Time: 14:19
 * Description: 仿写java.util.Iterator接口
 * 迭代器
 */
public interface MyIterator {
    boolean hasNext();

    Integer next();

    void remove();
}
