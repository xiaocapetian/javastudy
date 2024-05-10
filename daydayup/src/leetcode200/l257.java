package leetcode200;

import java.util.ArrayList;
import java.util.List;

public class l257 {
    //这是半抄了题解的,回溯又忘了啊啊啊啊啊,难难难
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        writepath(root,res,new ArrayList<>());
        return res;
    }
    public void writepath (TreeNode root,List<String> res,List<Integer> path){
        path.add(root.val);
        if(root.left==null&&root.right==null){
            //收获
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size()-1; i++) {
                sb.append(path.get(i)+"->");
            }
            sb.append(path.get(path.size()-1));
            res.add(sb.toString());
            return;
        }

        if(root.left!=null){
            writepath(root.left,res,path);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            writepath(root.right,res,path);
            path.remove(path.size()-1);
        }
    }
}
