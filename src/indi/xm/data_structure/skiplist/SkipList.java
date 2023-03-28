package indi.xm.data_structure.skiplist;

import java.util.Iterator;
import java.util.Random;

/**
 * 看完这个，我觉得再看ConcurrentSkipListMap 源码，会有很大收获
 * Author：ldb
 */
public class SkipList {

    // 每个节点索引最大层级
    private static final int MAX_LEVEL = 16;

    // 记录当前跳表节点最大的索引层数
    private int levelCount = 1;

    /**
     * 带头链表
     */
    private Node head = new Node(MAX_LEVEL);

    // 随机整数: 0，1
    private Random r = new Random();

    public Node find(int value) {
        Node p = head;
        // 从最大层开始查找，找到前一节点，通过--i，移动到下层再开始查找
        // 最终的 p 为 第0层略微比 value大的节点
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                // 找到前一节点
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    /**
     * 插入
     *
     * @param value 值
     */
    public void insert(int value) {

        // 头结点的第0层的下一个节点 如果是null，层级 = 1，不为null，则生成随机level
        int level = head.forwards[0] == null ? 1 : randomLevel();

        // 如果你随机生成的层数比我当前跳表里最大的层级还要大，那么不管大多少，我只让你大一个
        // 防止过分离谱 ==》 第一个节点2层索引，第二个节点3个索引，第三个节点5个索引，第四个节点来个16级索引
        // 有了它之后，第四个索引最大就只能是6层索引
        if (level > levelCount) {
            level = ++levelCount;
        }

        // 生成新节点
        Node newNode = new Node(level);

        // 新节点的值
        newNode.data = value;

        // 记录每层比 插入节点值 略小的那个节点
        Node update[] = new Node[level];
        for (int i = 0; i < level; ++i) {
            update[i] = head;
        }

        // 注意，这里的 p 放外面，通过 --i 控制down方向
        Node p = head;

        // 从最大层开始查找，找到下一节点，通过--i，移动到下层再开始查找
        // 找到每层比当前待插入的节点值略小的那个
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                // 找到下一节点
                p = p.forwards[i];
            }
            // 因为当前节点的level肯定是小于等于 levelCount的
            // 这里从 i = levelCount - 1 开始，所以，i < level 即可
            if (i < level){
                update[i] = p;
            }

        }
        // 更新每层的索引
        // 更新分两步：新节点的后指向、新节点的前指向
        for (int i = 0; i < level; ++i) {
            // 新节点的第i层指向 之前略小于插入值的下一个
            // 新节点的后指向
            newNode.forwards[i] = update[i].forwards[i];
            // 新节点的前指向
            update[i].forwards[i] = newNode;
        }

    }

    public void delete(int value) {
        // 存储每一层比 指定值 略小的那个
        Node[] update = new Node[levelCount];
        Node p = head;
        // 从上往下逐层找 比指定值 略小的那个
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }
        // 此时 p 应该在第 0 层，如果 p的 next 值等于value，才可以删除
        // 其实这层可以不要，直接走里面的
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            // 每层进行删除
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    // 跳过被删除节点 update[i].forwards[i] 指向
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
    }

    /**
     * 随机 level 次，如果是奇数层数 +1，防止伪随机
     *
     * @return
     */
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }

    /**
     * 打印所有数据
     */
    public void printAll_beautiful() {
        Node p = head;
        Node[] c = p.forwards;
        Node[] d = c;
        int maxLevel = c.length;
        for (int i = maxLevel - 1; i >= 0; i--) {
            do {
                System.out.print("（数据 " + (d[i] != null ? d[i].data : null) + "  :  当前第 " + i + " 层） -------");
            } while (d[i] != null && (d = d[i].forwards)[i] != null);
            System.out.println();
            d = c;
        }
    }


    /**
     * 跳表的节点，每个节点记录了当前节点数据和所在层数数据
     */
    public class Node {
        private int data = -1;
        /**
         * 表示当前节点位置的下一个节点所有层的数据，从上层切换到下层，就是数组下标-1，
         * forwards[3]表示当前节点在第三层的下一个节点。
         * 是next
         */
        private Node forwards[];

        public Node(int level) {
            forwards = new Node[level];
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append(" }");
            return builder.toString();
        }
    }

    // 以下是为迭代器新增内容


    class SkipListIterator<T> implements Iterator<T> {

        Node p = head.forwards[0];

         @Override
         public boolean hasNext() {
             return p != null;
         }

         @Override
         public T next() {
             Integer tmp = p.data;
             p = p.forwards[0];
             return (T)tmp;
         }
    }

    public Iterator iterator(){
        return new SkipListIterator();
    }

}
