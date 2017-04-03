package com.fheebiy.service;

import com.fheebiy.common.LogUtil;
import com.fheebiy.domain.Gift;
import com.fheebiy.domain.KindChip;
import com.fheebiy.domain.UserChip;
import com.fheebiy.domain.Tree;
import com.fheebiy.repo.TreeRepo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by cm on 2017/3/30.
 */
@Service
public class TreeService {

    @Autowired
    private TreeRepo treeRepo;
/*
    @Autowired
    private GiftService giftService;*/

    @Autowired
    private KindChipService kindChipService;

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
    public List<UserChip> burstOutChip(long user_id, int type) {
        Tree tree = treeRepo.getTreeByUserIdAndType(user_id, type);
        List<UserChip> result = new ArrayList<UserChip>();
        if (tree != null && tree.getProgress() == tree.getTotalNum()) {
            //礼物碎片
            if (tree.getType() == Tree.TYPE_GIFT) {
                int level = tree.getLevel();
                List<KindChip> list = null;
                if (level > 0 && level < 7) {
                    list = kindChipService.getListByLevel(level);
                }
                /*List<Gift.BurstOutGroup> burstOutGroups = Gift.BurstOutGroup.getBList(level);
                List<List<UserChip>> lists = new LinkedList<List<UserChip>>();
                for(Gift.BurstOutGroup burstOutGroup : burstOutGroups) {
                    lists.add(new ArrayList<UserChip>());
                }

                for (KindChip kindChip : list) {
                    if
                }*/

                if (CollectionUtils.isNotEmpty(list)) {
                    switch (level) {
                        case 1:
                            List<KindChip> list1 = new ArrayList<KindChip>();
                            List<KindChip> list2 = new ArrayList<KindChip>();
                            List<KindChip> list3 = new ArrayList<KindChip>();
                            List<KindChip> list4 = new ArrayList<KindChip>();
                            List<KindChip> list5 = new ArrayList<KindChip>();

                            for (KindChip kindChip : list) {
                                int price = kindChip.getFullCount();
                                if (price >= 1 && price < 10) {
                                    list1.add(kindChip);
                                } else if (price >= 10 && price < 20) {
                                    list2.add(kindChip);
                                } else if (price >= 20 && price < 30) {
                                    list3.add(kindChip);
                                } else if (price >= 30 && price < 40) {
                                    list4.add(kindChip);
                                } else if (price >= 40 && price < 50) {
                                    list5.add(kindChip);
                                }
                            }
                            List<UserChip> userChipList1 = getUserChipByLevel(list1, 5, user_id);
                            List<UserChip> userChipList2 = getUserChipByLevel(list2, 20, user_id);
                            List<UserChip> userChipList3 = getUserChipByLevel(list3, 30, user_id);
                            List<UserChip> userChipList4 = getUserChipByLevel(list4, 15, user_id);
                            List<UserChip> userChipList5 = getUserChipByLevel(list5, 30, user_id);

                            result.addAll(userChipList1);
                            result.addAll(userChipList2);
                            result.addAll(userChipList3);
                            result.addAll(userChipList4);
                            result.addAll(userChipList5);
                            break;

                        case 2:
                            List<KindChip> list21 = new ArrayList<KindChip>();
                            List<KindChip> list22 = new ArrayList<KindChip>();
                            List<KindChip> list23 = new ArrayList<KindChip>();

                            for (KindChip kindChip : list) {
                                int price = kindChip.getFullCount();
                                if (price >= 50 && price < 80) {
                                    list21.add(kindChip);
                                } else if (price >= 80 && price < 150) {
                                    list22.add(kindChip);
                                } else if (price >= 150 && price < 300) {
                                    list23.add(kindChip);
                                }
                            }
                            List<UserChip> userChipList21 = getUserChipByLevel(list21, 60, user_id);
                            List<UserChip> userChipList22 = getUserChipByLevel(list22, 150, user_id);
                            List<UserChip> userChipList23 = getUserChipByLevel(list23, 90, user_id);

                            result.addAll(userChipList21);
                            result.addAll(userChipList22);
                            result.addAll(userChipList23);
                            break;

                        case 3:
                            List<KindChip> list31 = new ArrayList<KindChip>();
                            List<KindChip> list32 = new ArrayList<KindChip>();

                            for (KindChip kindChip : list) {
                                int price = kindChip.getFullCount();
                                if (price >= 300 && price < 400) {
                                    list31.add(kindChip);
                                } else if (price >= 400 && price < 500) {
                                    list32.add(kindChip);
                                }
                            }
                            List<UserChip> userChipList31 = getUserChipByLevel(list31, 300, user_id);
                            List<UserChip> userChipList32 = getUserChipByLevel(list32, 300, user_id);

                            result.addAll(userChipList31);
                            result.addAll(userChipList32);

                            break;


                        case 4:
                            List<KindChip> list41 = new ArrayList<KindChip>();
                            List<KindChip> list42 = new ArrayList<KindChip>();
                            List<KindChip> list43 = new ArrayList<KindChip>();

                            for (KindChip kindChip : list) {
                                int price = kindChip.getFullCount();
                                if (price >= 500 && price < 600) {
                                    list41.add(kindChip);
                                } else if (price >= 600 && price < 700) {
                                    list42.add(kindChip);
                                } else if (price >= 700 && price < 1000) {
                                    list43.add(kindChip);
                                }
                            }
                            List<UserChip> userChipList41 = getUserChipByLevel(list41, 350, user_id);
                            List<UserChip> userChipList42 = getUserChipByLevel(list42, 350, user_id);
                            List<UserChip> userChipList43 = getUserChipByLevel(list43, 300, user_id);

                            result.addAll(userChipList41);
                            result.addAll(userChipList42);
                            result.addAll(userChipList43);


                            break;


                        case 5:
                            List<KindChip> list51 = new ArrayList<KindChip>();
                            List<KindChip> list52 = new ArrayList<KindChip>();
                            List<KindChip> list53 = new ArrayList<KindChip>();
                            List<KindChip> list54 = new ArrayList<KindChip>();

                            for (KindChip kindChip : list) {
                                int price = kindChip.getFullCount();
                                if (price >= 1000 && price < 1200) {
                                    list51.add(kindChip);
                                } else if (price >= 1200 && price < 1500) {
                                    list52.add(kindChip);
                                } else if (price >= 1500 && price < 1700) {
                                    list53.add(kindChip);
                                } else if (price >= 1700 && price < 2000) {
                                    list54.add(kindChip);
                                }
                            }
                            List<UserChip> userChipList51 = getUserChipByLevel(list51, 225, user_id);
                            List<UserChip> userChipList52 = getUserChipByLevel(list51, 450, user_id);
                            List<UserChip> userChipList53 = getUserChipByLevel(list53, 450, user_id);
                            List<UserChip> userChipList54 = getUserChipByLevel(list54, 375, user_id);

                            result.addAll(userChipList51);
                            result.addAll(userChipList52);
                            result.addAll(userChipList53);
                            result.addAll(userChipList54);
                            break;

                        case 6:
                            List<KindChip> list61 = new ArrayList<KindChip>();
                            List<KindChip> list62 = new ArrayList<KindChip>();
                            List<KindChip> list63 = new ArrayList<KindChip>();
                            List<KindChip> list64 = new ArrayList<KindChip>();
                            List<KindChip> list65 = new ArrayList<KindChip>();
                            List<KindChip> list66 = new ArrayList<KindChip>();
                            List<KindChip> list67 = new ArrayList<KindChip>();

                            for (KindChip kindChip : list) {
                                int price = kindChip.getFullCount();
                                if (price >= 2000 && price < 2500) {
                                    list61.add(kindChip);
                                } else if (price >= 2500 && price < 2800) {
                                    list62.add(kindChip);
                                } else if (price >= 2800 && price < 3000) {
                                    list63.add(kindChip);
                                } else if (price >= 3000 && price < 3500) {
                                    list64.add(kindChip);
                                } else if (price >= 3500 && price < 4000) {
                                    list65.add(kindChip);
                                } else if (price >= 4000 && price < 4500) {
                                    list66.add(kindChip);
                                } else if (price >= 4500 && price < 3000000) {
                                    list67.add(kindChip);
                                }
                            }

                            List<UserChip> userChipList61 = getUserChipByLevel(list61, 800, user_id);
                            List<UserChip> userChipList62 = getUserChipByLevel(list62, 800, user_id);
                            List<UserChip> userChipList63 = getUserChipByLevel(list63, 800, user_id);
                            List<UserChip> userChipList64 = getUserChipByLevel(list64, 400, user_id);
                            List<UserChip> userChipList65 = getUserChipByLevel(list65, 600, user_id);
                            List<UserChip> userChipList66 = getUserChipByLevel(list66, 400, user_id);
                            List<UserChip> userChipList67 = getUserChipByLevel(list67, 200, user_id);

                            result.addAll(userChipList61);
                            result.addAll(userChipList62);
                            result.addAll(userChipList63);
                            result.addAll(userChipList64);
                            result.addAll(userChipList65);
                            result.addAll(userChipList66);
                            result.addAll(userChipList67);
                            break;
                    }
                }
            } else {    //愿望碎片

            }
        }

        return result;
    }

    public List<UserChip> getUserChipByLevel(List<KindChip> list, int count, long user_id) {
        List<UserChip> userChipList = new ArrayList<UserChip>();
        if (CollectionUtils.isEmpty(list)) {
            return userChipList;
        }

        int size = list.size();        //随机种类
        int totalCount = 0;
        HashMap<Long, Integer> map = new HashMap();
        while (totalCount < count) {
            int index = new Random().nextInt(size);
            KindChip kindChip = list.get(index);    //1到10元中的随机的一种
            long kc_id = kindChip.getKc_id();
            int countX = new Random().nextInt(5) + 1;
            int gapCount = 5 - totalCount;        //还差这个多个
            totalCount += countX;
            if (countX > gapCount) {    //如果随机多了，就
                countX = gapCount;
            }

            if (map.get(kc_id) > 0) {
                for (int i = 0; i < userChipList.size(); i++) {
                    UserChip userChip = userChipList.get(i);
                    if (userChip.getKc_id() == kc_id) {
                        userChip.setCount(userChip.getCount() + countX);
                        userChipList.remove(i);
                        userChipList.add(userChip);
                    }
                }
            } else {
                UserChip userChip = new UserChip();
                userChip.setKc_id(kc_id);
                userChip.setName(kindChip.getName());
                userChip.setCount(countX);
                userChip.setUser_id(user_id);
                userChipList.add(userChip);
                map.put(kc_id, countX);
            }
        }

        Set<Long> ids = new HashSet<Long>();
        Set<Long> sameIds = new HashSet<Long>();
        for (UserChip userChip : userChipList) {
            if (ids.contains(userChip.getKc_id())) {
                sameIds.add(userChip.getKc_id());
                LogUtil.d("爆礼物的时候，出现了重复id = " + userChip.getKc_id(), "");
            }
            ids.add(userChip.getKc_id());
        }
        return userChipList;
    }


}
