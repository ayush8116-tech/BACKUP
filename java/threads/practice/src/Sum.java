import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class Sum extends RecursiveTask<Integer> {
    private final ArrayList<Integer> nums;
    private final int start;
    private final int end;

    public Sum(ArrayList<Integer> nums) {
        this.nums = nums;
        this.start = 0;
        this.end = nums.size();
    }

    @Override
    protected Integer compute() {
        if (end - start < 2) {
            return 0;
        }

        int mid = (start + (end - 1)) / 2;

//        List<Integer> leftIntegers = nums.subList(start, mid).toArray();

//        List<Integer> left = new Sum((ArrayList<Integer>) leftIntegers);
        List<Integer> right = nums.subList(mid, end);

//        System.out.println(left);
        System.out.println(right);

        return 0;
    }
}
