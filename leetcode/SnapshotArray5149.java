import java.util.HashMap;
import java.util.Objects;

/*
5149. 快照数组  显示英文描述
用户通过次数 142
用户尝试次数 328
通过次数 142
提交次数 962
题目难度 Medium
实现支持下列接口的「快照数组」- SnapshotArray5149：

SnapshotArray5149(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
void set(index, val) - 会将指定索引 index 处的元素设置为 val。
int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。


示例：

输入：["SnapshotArray5149","set","snap","set","get"]
     [[3],[0,5],[],[0,6],[0,0]]
输出：[null,null,0,null,5]
解释：
SnapshotArray5149 snapshotArr = new SnapshotArray5149(3); // 初始化一个长度为 3 的快照数组
snapshotArr.set(0,5);  // 令 array[0] = 5
snapshotArr.snap();  // 获取快照，返回 snap_id = 0
snapshotArr.set(0,6);
snapshotArr.get(0,0);  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5


提示：

1 <= length <= 50000
题目最多进行50000 次set，snap，和 get的调用 。
0 <= index < length
0 <= snap_id < 我们调用 snap() 的总次数
0 <= val <= 10^9
 */
class SnapshotArray5149 {
    public static void main(String[] args) {
        SnapshotArray5149 snapshotArr = new SnapshotArray5149(3); // 初始化一个长度为 3 的快照数组
        snapshotArr.set(0, 5);  // 令 array[0] = 5
        System.out.println(snapshotArr.snap());
        snapshotArr.set(0, 6);
        System.out.println(snapshotArr.get(0, 0));
    }

    int id;
    HashMap<Key,Integer> map;
    public static class Key{
        int id;
        int index;

        public Key(int id, int index) {
            this.id = id;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return id == key.id &&
                    index == key.index;
        }

        @Override
        public int hashCode() {

            return Objects.hash(id, index);
        }
    }
    public SnapshotArray5149(int length) {
        map = new HashMap<>();
        id = 0;
    }

    public void set(int index, int val) {
        map.put(new Key(id,index), val);
    }

    public int snap() {
        id++;
        return id-1;
    }

    public int get(int index, int snap_id) {
        while (snap_id >= 0 && !map.containsKey(new Key(snap_id,index))){
            snap_id--;
        }
        return map.containsKey(new Key(snap_id,index)) ? map.get(new Key(snap_id,index)):0;
    }
}

/**
 * Your SnapshotArray5149 object will be instantiated and called as such:
 * SnapshotArray5149 obj = new SnapshotArray5149(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */