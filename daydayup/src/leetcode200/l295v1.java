package leetcode200;

import java.util.TreeMap;

public class l295v1 {
    //TODO 这个真难啊我真看不懂
    class MedianFinder {
        TreeMap<Integer, Integer> treeMap;
        int size;
        int[] left;
        int[] right;
/*left[0]和right[0]表示当前的中位数。当数据流中元素个数为 奇数，left[0]和right[0]将表示同一个元素，即中位数。
当数据流中元素个数为 偶数，left[0]表示中位数的左边界，right[0]表示中位数的右边界。*/
        public MedianFinder() {
            treeMap = new TreeMap<Integer, Integer>();
            size = 0;
            left = new int[2];
            right = new int[2];
        }

        public void addNum(int num) {
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
            if (size == 0) {//没有数据时
                left[0] = right[0] = num;
                left[1] = right[1] = 1;
            } else if ((size & 1) != 0) {//位与运算,若为奇数
                if (num < left[0]) {
                    decrease(left);
                } else {
                    increase(right);
                }
            } else {//若为偶数
                if (num > left[0] && num < right[0]) {
                    increase(left);
                    decrease(right);
                } else if (num >= right[0]) {
                    increase(left);
                } else {
                    decrease(right);
                    System.arraycopy(right, 0, left, 0, 2);
                }
            }
            size++;
        }

        public double findMedian() {
            return (left[0] + right[0]) / 2.0;
        }

        private void increase(int[] iterator) {
            iterator[1]++;
            if (iterator[1] > treeMap.get(iterator[0])) {//检查增加后的计数器是否大于该值在 treeMap 中的计数器。
                //如果是>，则说明迭代器指向的值已经超出了当前最大的计数器值，需要更新迭代器指向的值。
                iterator[0] = treeMap.ceilingKey(iterator[0] + 1);
                /*用于返回大于或等于给定键的最小键，如果不存在这样的键，则返回 null*/

                iterator[1] = 1;
            }
        }

        private void decrease(int[] iterator) {
            iterator[1]--;//减少计数器，表示将当前数字的频率减少1。
            if (iterator[1] == 0) {//减少后计数器的值等于0，表示当前数字已经没有了，需要从 TreeMap 中移除。
                iterator[0] = treeMap.floorKey(iterator[0] - 1);//将 iterator[0] 更新为当前数字的前一个数字，即向左移动一个位置。
                /*treeMap.floorKey() 是 TreeMap 类中的一个方法，返回<=给定 键 的最大 键 ，如果不存在则返回 null*/
                iterator[1] = treeMap.get(iterator[0]);
            }
        }
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/find-median-from-data-stream/solutions/961062/shu-ju-liu-de-zhong-wei-shu-by-leetcode-ktkst/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
