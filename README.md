# algorithm-study
一直觉得算法是很重要的技能，之前学习了极客时间的算法面试通关视频，也练习了很多题目，只是做题，没有总结，感觉学习不牢靠。所以在这里总结下，有空就经常看自己总结的东西。

# 理论基础
## 优先队列（Priority Queue）
优先队列：正常进入、按照优先级出。  
实现机制  
1.Heap（Binary、Binomial、Fibonacci）  
2.Binary Search Tree  


Heap Wiki
https://en.wikipedia.org/wiki/Heap_(data_structure)  
各种堆的效率  
1.find-min的时间复杂度是o(1)  
2.Fibbonacci堆效率最好，处理del-min之外其他的效率都是o(1)  

练习：  
1. https://leetcode.com/problems/kth-largest-element-in-a-stream/  
解题思路  
1.用数组存储K各元素，每次对K个元素排序，最快的时间复杂度是o(KlogK),总共有N个元素，那么总的时间复杂度是NKlogK  
2.我们只需要最大或者最小元素，数组加排序有点大材小用，我们可以用Min Heap来存储这个元素，我们记得Fibbonacci堆的存储和find-min的效率是o（1）,n个元素，那么时间负责度即是o(N)  

编码实现：待续。。。

## 哈希表
Hash函数：取模是一种常见的hash函数。  
Hash碰撞：Hash表存储数据过程：首先利用hash函数计算存储在数组中的位置，不同的元素通过hash函数可能计算出来的位置是一样的，那么数组中的每一个位置就不能只存储一个元素，这个位置一般存储链表或者红黑树等数据结构。  

List：可以存储重复元素，插入o(1)，查找o(n)   
Map:
Set:实现方hash表或者数据，查找o(1)

HashMap vs TreeMap  
HashSet vs TreeSet  
查找时间复杂度：o(1)->o(logN)
treeMap有序。

练习：
见项目

## 树
相关概念：  
树：  
  层：距离Root节点的距离  
  ParentNode LeftNode RightNode Siblings 左子树 右子树  
二叉树：每一个节点最多有两个子节点。    
完全二叉树：所有的节点都有两个节点。
二叉搜索树：  
1. 左子树所有节点小于根节点的值
2. 右子树所有的节点大约根节点
依次递归。

## 二叉树遍历
# Pre-order  根左右
# in-order  左根右
# Post-order  左右根
