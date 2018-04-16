package com.zdj.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.util.Random;

public class Main {
    public static final boolean logStep = false;
    static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random(10000);
        int size = 500000;
        int[] s;
        s = new int[size];
        for (int i = 0; i < size; i++) {
            s[i] = random.nextInt() % 100;
            if (s[i] < 0) {
                s[i] = -s[i];
            }
        }
        outputElements(s.clone());
        logger.info("==============================================");
        StopWatch stopWatch = new StopWatch();
        logger.info("====================bouble====================");
        stopWatch.start("bouble");
        bouble(s.clone());
        stopWatch.stop();
        logger.info("====================select====================");
        stopWatch.start("select");
        select(s.clone());
        stopWatch.stop();
        logger.info("====================insert====================");
        stopWatch.start("insert");
        insert(s.clone());
        stopWatch.stop();
        logger.info("====================merge=====================");
        stopWatch.start("merge");
        outputElements(merge(s.clone()));
        stopWatch.stop();
        logger.info("====================quick=====================");
        stopWatch.start("quick");
        outputElements(quick(s.clone()));
        stopWatch.stop();
        logger.info("=====================heap=====================");
        stopWatch.start("heap");
        outputElements(heap(s.clone()));
        stopWatch.stop();
        logger.info("====================Shell=====================");
        stopWatch.start("Shell");
        outputElements(shell(s.clone()));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    /**
     * https://raw.githubusercontent.com/ShaunSheep/BlogGifRes/9c8ec9b348958f17b0dbc9f7e64890dc01690f4c/BUBBLESORTGIF.gif
     * 冒泡：每一轮比较左右两个数
     * @param s 数组
     */
    private static void bouble(int[] s) {
        //i:比较的轮数
        int temp = 0;
        for (int i = 1; i < s.length; i++) {
            outputIJ(i, s.length - i);
            //j:i轮比较的次数
            for (int j = 0; j < s.length - i; j++) {
                if (s[j] > s[j + 1]) {
                    temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                }
            }
            outputElements(s);
        }
    }

    /**
     * https://raw.githubusercontent.com/ShaunSheep/BlogGifRes/f64328ec88bfc67b65856e703102ea43f94e60c7/selectSort%E6%8E%A9%E9%A5%B0.gif
     *
     * @param s
     */
    private static void select(int[] s) {
        //缓存最小值,坐标
        int point = 0, temp = 0;
        //i:比较的轮数
        for (int i = 1; i < s.length; i++) {
            //i:比较的轮数
            point = i - 1;
            for (int j = i; j < s.length; j++) {
                if (s[point] > s[j]) {
                    point = j;
                }
            }
            if (point != i - 1) {
                temp = s[i - 1];
                s[i - 1] = s[point];
                s[point] = temp;
            }
            outputElements(s);
        }
    }

    /**
     * https://raw.githubusercontent.com/ShaunSheep/BlogGifRes/983106dda6e5cfa195289b91e2c4c2bf45f09331/InsertSort%E5%BD%95%E5%88%B6.gif
     *
     * @param s 数组
     */
    private static void insert(int[] s) {
        for (int i = 1; i < s.length; i++) {
            //排序要经过i-1轮
            outputIJ(i, i - 1);
            //缓存当前轮最后一个元素
            int temp = s[i];
            for (int j = i; j > 0; j--) {
                if (s[j] < s[j - 1]) {
                    //后面元素比前面小，交换顺序
                    s[j] = s[j - 1];
                    s[j - 1] = temp;
                } else {
                    //全部排序已经完成
                    break;
                }
            }
            outputElements(s);
        }
    }

    /**
     * https://raw.githubusercontent.com/ShaunSheep/BlogGifRes/master/MerageSort%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F.gif
     *
     * @param s
     */
    private static int[] merge(int[] s) {
        int temp;
        if (s.length == 1) {
            //数组里有一个元素则返回
            outputElements(s);
            return s;
        } else if (s.length == 2) {
            //有两个元素则排序返回
            if (s[0] > s[1]) {
                temp = s[0];
                s[0] = s[1];
                s[1] = temp;
            }
            outputElements(s);
            return s;
        } else {
            //1.拆分数组成两个 2.按照该方法排序 3.归并
            //1.拆分
            int[] newArray1 = new int[s.length / 2];
            int[] newArray2 = new int[s.length - newArray1.length];
            for (int i = 0; i < newArray1.length; i++) {
                newArray1[i] = s[i];
            }
            for (int i = 0; i < newArray2.length; i++) {
                newArray2[i] = s[newArray1.length + i];
            }
            //2.按照该方法排序
            newArray1 = merge(newArray1);
            newArray2 = merge(newArray2);
            //3.归并
            int[] resultArray = new int[newArray1.length + newArray2.length];
            for (int i = 0, j = 0, k = 0; i < newArray1.length || j < newArray2.length; k++) {
                if (i == newArray1.length) {
                    //第一个数组迭代完，直接复制
                    resultArray[k] = newArray2[j];
                    j++;
                } else if (j == newArray2.length) {
                    //第二个数组迭代完，直接复制
                    resultArray[k] = newArray1[i];
                    i++;
                }//复制数组中的数据
                else if (newArray1[i] < newArray2[j]) {
                    resultArray[k] = newArray1[i];
                    i++;
                } else {
                    resultArray[k] = newArray2[j];
                    j++;
                }
            }
            outputElements(resultArray);
            return resultArray;
        }
    }

    /**
     * https://images2017.cnblogs.com/blog/849589/201710/849589-20171015230936371-1413523412.gif
     *
     * @param s
     */
    private static int[] quick(int[] s) {
        if (s.length == 0 || s.length == 1) {
            outputElements(s);
            return s;
        }
        int index = 1, temp = 0;//标识的位置
        //将数字放在正确的位置上
        for (int i = 1; i < s.length; i++) {
            if (s[0] > s[i]) {
                temp = s[index];
                s[index] = s[i];
                s[i] = temp;
                index++;
            }
        }
        temp = s[index - 1];
        s[index - 1] = s[0];
        s[0] = temp;
        //切割数组
        int[] newArray1 = new int[index - 1];
        int[] newArray2 = new int[s.length - index];
        for (int i = 0; i < newArray1.length; i++) {
            newArray1[i] = s[i];
        }
        for (int i = 0; i < newArray2.length; i++) {
            newArray2[i] = s[newArray1.length + i + 1];
        }
        //执行排序
        newArray1 = quick(newArray1);
        newArray2 = quick(newArray2);
        //放回原数组
        for (int i = 0; i < newArray1.length; i++) {
            s[i] = newArray1[i];
        }
        //s[mark]=s[mark];
        for (int i = 0; i < newArray2.length; i++) {
            s[newArray1.length + 1 + i] = newArray2[i];
        }
        outputElements(s);
        return s;
    }


    /**
     * https://images2017.cnblogs.com/blog/849589/201710/849589-20171015231308699-356134237.gif
     * @param s
     * @return
     */
    private static int[] heap(int[] s) {
        int lastPoint = s.length;
        //1. 建堆
        for (int i = s.length / 2 - 1; i >= 0; i--) {
            buildHeap(s, lastPoint, i);
        }
        int temp = 0;
        logger.info("**堆建立好**");
        for (int i = 0; i < s.length; i++) {
            //2. 取元素，第一个和无序的最后一个对调
            temp = s[0];
            s[0] = s[lastPoint - 1];
            s[lastPoint - 1] = temp;
            //3. 移动指针
            lastPoint--;
            //4. 构建大堆顶
            s = buildHeap(s, lastPoint, 0);
        }
        return s;
    }

    /**
     * 假定节点i的左右子树已经是最大堆。那么维护堆时，先比较i节点的值与左右节点值的大小
     * 将三个数中的最大值交换到根节点的位置。假设根节点i与左子节点的值交换了，
     * 那么左子树就要再次调用buildHeap( s,  lenth, root左)，判断左子树还是不是最大堆
     * 如果是则结束，否则继续调用进行维护。
     *
     * @param s
     * @param lenth
     * @param root
     * @return
     */
    private static int[] buildHeap(int[] s, int lenth, int root) {
        //默认root是最大的节点
        int largest = root;
        //左节点
        int left = 2 * root + 1;
        int right = left + 1;
        if (left < lenth && s[largest] < s[left]) {
            largest = left;
        }
        if (right < lenth && s[largest] < s[right]) {
            largest = right;
        }
        if (largest != root) {
            int temp = s[largest];
            s[largest] = s[root];
            s[root] = temp;
            buildHeap(s, lenth, left);
            buildHeap(s, lenth, right);
        }
        outputElements(s);
        return s;
    }

    /**
     * https://images2015.cnblogs.com/blog/1024555/201611/1024555-20161128110416068-1421707828.png
     * @param s
     * @return
     */
    private static int[] shell(int[] s) {
        int temp=0;
        //gap:增量.为0时完成排序
        for (int gap=s.length/2;gap>0;gap/=2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i=gap;i<s.length;i++){
                //组内元素为0
                for (int j=i-gap;j>=0&&s[j]>s[j+gap];j-=gap){
                    temp=s[j];
                    s[j]=s[j+gap];
                    s[j+gap]=temp;
                }
            }
            outputElements(s);
        }
        return s;
    }

    private static void outputIJ(final int i, final int j) {
        if (logStep) {
            logger.info("i:" + i + "\t\t\tj:" + (j));
        }
    }

    private static void outputElements(final int[] s) {
        if (logStep) {
            StringBuffer str = new StringBuffer();
            for (int j = 0; j < s.length; j++) {
                str.append("," + s[j]);
            }
            logger.info(str.toString());
        }
    }

    private static void testElements(final int[] s) {
        StringBuffer str = new StringBuffer();
        for (int j = 0; j < s.length; j++) {
            str.append("," + s[j]);
        }
        logger.info(str.toString());
    }
}
