package main.java.com.kangmin.algo.dfs;

public class BinaryTreeCamerasE {

    private final int NOT_MONITORED = 0;
    private final int MONITORED_NOCAM = 1;
    private final int MONITORED_WITHCAM = 2;
    private int cameras = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        int top = dfs(root);
        return cameras + (top == NOT_MONITORED ? 1 : 0);
    }

    private int dfs(TreeNode root) {
        if (root == null) return MONITORED_NOCAM;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == MONITORED_NOCAM && right == MONITORED_NOCAM) {
            return NOT_MONITORED;
        } else if (left == NOT_MONITORED || right == NOT_MONITORED) {
            cameras++;
            return MONITORED_WITHCAM;
        } else {
            return MONITORED_NOCAM;
        }
    }
}
