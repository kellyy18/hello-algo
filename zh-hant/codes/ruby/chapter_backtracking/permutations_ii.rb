=begin
File: permutations_ii.rb
Created Time: 2024-05-22
Author: Xuan Khoa Tu Nguyen (ngxktuzkai2000@gmail.com)
=end

### 回溯演算法：全排列 II ###
def backtrack(state, choices, selected, res)
  # 當狀態長度等於元素數量時，記錄解
  if state.length == choices.length
    res << state.dup
    return
  end

  # 走訪所有選擇
  duplicated = Set.new
  choices.each_with_index do |choice, i|
    # 剪枝：不允許重複選擇元素 且 不允許重複選擇相等元素
    if !selected[i] && !duplicated.include?(choice)
      # 嘗試：做出選擇，更新狀態
      duplicated.add(choice)
      selected[i] = true
      state << choice
      # 進行下一輪選擇
      backtrack(state, choices, selected, res)
      # 回退：撤銷選擇，恢復到之前的狀態
      selected[i] = false
      state.pop
    end
  end
end

### 全排列 II ###
def permutations_ii(nums)
  res = []
  backtrack([], nums, Array.new(nums.length, false), res)
  res
end

### Driver Code ###
if __FILE__ == $0
  nums = [1, 2, 2]

  res = permutations_ii(nums)

  puts "輸入陣列 nums = #{nums}"
  puts "所有排列 res = #{res}"
end
