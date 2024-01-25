const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const [N, ...arr] = input;
const len = arr[0].length;

let ans = "";
for (let i = 0; i < len; i++) {
  const set = new Set(arr.map((elem) => elem[i]));
  if (set.size > 1) {
    ans += "?";
    continue;
  }
  ans += set.values().next().value;
}
console.log(ans);
