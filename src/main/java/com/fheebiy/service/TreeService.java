package com.fheebiy.service;

import com.fheebiy.domain.UserChip;
import com.fheebiy.domain.Tree;
import com.fheebiy.repo.TreeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by cm on 2017/3/30.
 */
@Service
public class TreeService {

    @Autowired
    private TreeRepo treeRepo;

    public void initSaveTwoTree(long user_id) {
        saveGiftTree(user_id);
        saveDesireTree(user_id);
    }

    public void saveGiftTree(long user_id) {
        Tree giftTree = new Tree();
        giftTree.setType(Tree.TYPE_GIFT);
        giftTree.setUser_id(user_id);
        giftTree.setTotalNum(Tree.GIFT_TREE_TOTAL_NUM);
        giftTree.setProgress(0);
        giftTree.setCreateTime(new Date());
        treeRepo.save(giftTree);
    }

    public void saveDesireTree(long user_id) {
        Tree giftTree = new Tree();
        giftTree.setType(Tree.TYPE_DESIRE);
        giftTree.setUser_id(user_id);
        giftTree.setTotalNum(Tree.DESIRE_TREE_TOTAL_NUM);
        giftTree.setProgress(0);
        giftTree.setCreateTime(new Date());
        treeRepo.save(giftTree);
    }

    /**
     * 给树浇水，增加成长值
     *
     * @param user_id     usr_id
     * @param type        type
     * @param addProgress 增加的progress
     * @return tree
     */
    public Tree updateTreeProgress(long user_id, int type, long addProgress) {
        Tree tree = treeRepo.getTreeByUserIdAndType(user_id, type);
        long currentProgress = tree.getProgress() + addProgress;
        if (currentProgress == tree.getTotalNum()) {        //满了， 可能不是这个流程
            //giveChips(tree.getType());  //
            //deleteTreeBecauseFull(tree.getTree_id());//
        }
        treeRepo.updateProgress(user_id, type, currentProgress);
        tree.setProgress(currentProgress);
        return tree;
    }

    /**
     * 成长值满了，根据树的类型来爆出不同碎片
     */
    public List<UserChip> giveChips(int type) {
        return null;
    }

    /**
     * 爆完碎片，把树给删除了，用户就没有这个树了
     */
    public void deleteTreeBecauseFull(long user_id, int type) {
        treeRepo.delete(user_id, type);
    }


    /**
     * 树成长值满了，爆出碎片
     *
     * @param user_id 用户id
     * @param type    树的种类
     */
    public void burstOutChip(long user_id, int type) {
        Tree tree = treeRepo.getTreeByUserIdAndType(user_id, type);
        if (tree != null && tree.getProgress() == tree.getTotalNum()) {

        }

    }


}
