package array._1146SnapshotArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SnapshotArray {
    List<Map<Integer, Integer>> list;

    // tạo ra List với kiểu dữ liệu là Map
    public SnapshotArray(int length) {
        list = new ArrayList<>();
        list.add(new HashMap());
    }

    // add thêm giá trị vào chỉ mục của Map
    public void set(int index, int val) {
        int snapId = list.size() - 1;
        list.get(snapId).put(index, val);
    }

    public int snap() {
        list.add(new HashMap());
        return list.size() - 2;
    }

    public int get(int index, int snap_id) {
        for (int snap = snap_id; snap >= 0; snap--) {
            if (list.get(snap).containsKey(index)) {
                return list.get(snap).get(index);
            }
        }
        return 0;
    }
}

public class _1146SnapshotArray {
    public static void main(String[] args) {
        SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
        snapshotArr.set(0, 5);  // Set array[0] = 5
        snapshotArr.snap();  // Take a snapshot, return snap_id = 0
        snapshotArr.set(0, 6);
        snapshotArr.get(0, 0);  // Get the value of array[0] with snap_id = 0, return 5
    }
}