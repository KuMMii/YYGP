const fs = require("fs");
const arr = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((r) => r.trim());

for (let i = 0; i < arr.length; i++) {
  let k = i;
  for (let j = i + 1; j < arr.length; j++) {
    if (arr[j] < arr[i]) {
      k = j;
    }
  }

  [arr[i], arr[k]] = [arr[k], arr[i]];
}

arr.forEach((v) => {
  console.log(v);
});
