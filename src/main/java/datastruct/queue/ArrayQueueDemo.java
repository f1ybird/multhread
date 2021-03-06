package datastruct.queue;

import java.util.Scanner;

/**
 * @Description: 数组模拟队列
 * @Author: zhangkai
 * @Date: 2020/4/18 15:11
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean isLoop = true;
        //输出一个菜单
        while (isLoop) {
            System.out.print("s(show): 显示队列  ");
            System.out.print("e(exit): 退出程序  ");
            System.out.print("a(add): 添加数据到队列  ");
            System.out.print("g(get): 从队列取出数据  ");
            System.out.println("h(head): 查看队列头的数据  ");
            System.out.println("-----------------------------");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.peek();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    isLoop = false;
                    break;
                default:
                    break;
            }
        }
    }

}

/**
 * 数组模拟队列
 */
class ArrayQueue {

    /**
     * 数组最大容量
     */
    private int maxSize;

    /**
     * 队列头
     */
    private int front;

    /**
     * 队列尾
     */
    private int rear;

    /**
     * 模拟队列，存放数据
     */
    private int[] arr;

    /**
     * 构造器
     *
     * @param arrMaxSize
     */
    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    /**
     * 判定队列是否满
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判定队列是否空
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 添加元素
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        arr[++rear] = n;
    }

    /**
     * 获取元素
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[++front];
    }

    /**
     * 显示队列元素
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\t", i, arr[i]);
        }
        System.out.println();
    }

    /**
     * 显示队列头数据
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[++front];
    }

}
