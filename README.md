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
