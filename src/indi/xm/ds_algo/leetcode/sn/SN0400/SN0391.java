package indi.xm.ds_algo.leetcode.sn.SN0400;


import org.junit.Test;

import java.util.HashSet;

/**
 * @ProjectName:    leetcode
 * @Package:        indi.xm.jy.leetcode.sn.SN0400
 * @ClassName:      SN0391
 * @Author:     albert.fang
 * @Description:  完美矩陣
 * @Date:    2021/11/16 18:28
 */
public class SN0391 {

    // 如果是完美矩阵，那么
    // （1）左下、左上、右上、右下四个点只出现一次，其他点都出现两次或者四次
    // （2）左下、左上、右上、右下四个点围成的面积等于所有小矩形的面积
    public boolean isRectangleCover(int[][] rectangles) {

        // 找到最边界的位置，上右下左
        int[] critical = new int[]{-100000,-100000,100000,100000};

        // 所有矩形总面积
        int res = 0;

        HashSet<String> set = new HashSet<>();

        for (int[] rectangle : rectangles) {
            setCriticalPoint(critical,rectangle);
            res += getArea(rectangle);
            String bottomLeftPoint = rectangle[0] + "" + rectangle[1];
            String topLeftPoint = rectangle[0] + "" + rectangle[3];
            String topRightPoint = rectangle[2] + "" + rectangle[3];
            String bottomRightPoint = rectangle[2] + "" + rectangle[1];
            // 左下角
            addOrRemovePoint(set, bottomLeftPoint);
            // 右上角
            addOrRemovePoint(set, topRightPoint);
            // 左上角
            addOrRemovePoint(set, topLeftPoint);
            // 右下角
            addOrRemovePoint(set, bottomRightPoint);
        }

        // 四个边界围城的矩形面积
        int pendingArea = getArea(critical);

        // 移除最边界的四个点
        // 右上角
        addOrRemovePoint(set,critical[1] + "" + critical[0]);
        // 右下
        addOrRemovePoint(set,critical[1] + "" + critical[2]);
        // 左下
        addOrRemovePoint(set,critical[3] + "" + critical[2]);
        // 左上
        addOrRemovePoint(set,critical[3] + "" + critical[0]);

        return res == pendingArea && set.size() == 0;
    }

    private void addOrRemovePoint(HashSet<String> set, String point) {
        if (set.contains(point)) {
            set.remove(point);
        } else {
            set.add(point);
        }
    }

    // 得到四个边界
    private void setCriticalPoint(int[] critical,int[] rectangle) {
        // 最高上边界
        critical[0] = Math.max(critical[0],rectangle[3]);
        // 最右边界
        critical[1] = Math.max(critical[1],rectangle[2]);
        // 最低下边界
        critical[2] = Math.min(critical[2],rectangle[1]);
        // 最左边界
        critical[3] = Math.min(critical[3],rectangle[0]);
    }

    private int getArea(int[] rectangle){
        return Math.abs(rectangle[0] - rectangle[2]) * Math.abs(rectangle[1] - rectangle[3]);
    }

    @Test
    public void test(){
//        System.out.println(getArea(new int[]{4, 4, 1, 1}));
//        System.out.println(isRectangleCover(new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {2, 2, 4, 4}}));
        System.out.println(isRectangleCover(new int[][]{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}}));
//        System.out.println(isRectangleCover(new int[][]{{0,0,1,1},{0,1,3,2},{1,0,2,2}}));
//        System.out.println(-1+"");
    }
}
