function solution(operations) {
    let maxQueue = [];
    let minQueue = [];

    for(let oper of operations) {
        const [tag, value] = oper.split(' ');
        if(tag == "I") {
            maxQueue.push(parseInt(value));
            maxQueue.sort((o1,o2)=>o2-o1);
            minQueue.push(parseInt(value));
            minQueue.sort((o1,o2)=>o1-o2);
        }
        if(tag == "D" && value == 1) minQueue.splice(maxQueue.shift(),1);
        if(tag == "D" && value == -1) maxQueue.splice(minQueue.shift(),1);
    }

    if(maxQueue.length==0 || minQueue.length==0) return [0,0];  
    return [maxQueue[0],minQueue[0]];
}

console.log(solution(["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]));