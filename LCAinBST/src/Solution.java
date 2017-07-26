/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
		TreeNode current = root;
		while (true) {
			if ((current.val > p.val) && (current.val > q.val)) {
				current = current.left;
			} else if ((current.val < p.val) && (current.val < q.val)) {
				current = current.right;
			} else {
				break;
			}
		}
		return current;

	}
}