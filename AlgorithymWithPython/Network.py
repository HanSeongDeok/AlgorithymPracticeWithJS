def solution(n, works):
    count = 0
    checked = [False] * n
    for i in range(n):
        if not checked[i]:
            count = dfs_check_with_stack(i, works, checked, count)

    return count

def dfs_check(i, works, checked, count):
    checked[i] = True
    for index in range(len(works)):
        if not checked[index] and works[i][index] == 1:
            dfs_check(index, works, checked, count)
    
    count += 1
    return count 

def dfs_check_with_stack(i, works, checked, count):
    stack = [i]
    while stack: 
        index = stack.pop()
        checked[index] = True
        for j in range(len(works)):
            if not checked[j] and works[index][j] == 1:
                stack.append(j)
    
    count += 1       
    return count

print (solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))