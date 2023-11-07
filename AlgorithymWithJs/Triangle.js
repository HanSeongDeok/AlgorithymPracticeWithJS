function solution(triangle) {
    let prevRows = null;

    for(let rows of triangle){
        prevRows = maxValue(rows, prevRows);
    }

    return Math.max(...prevRows);
}

const maxValue = (rows, prevRows) => {
    if(prevRows == null) return rows;
    let temp = 0, prevIndex = 0; 
    
    for(let i = 0; i < rows.length; i++) {
        if(i>1) rows[i-1] = Math.max(rows[i-1], temp + prevRows[++prevIndex])
        temp = rows[i];
        rows[i] += prevRows[prevIndex];
    }
    return rows
}

console.log(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]));