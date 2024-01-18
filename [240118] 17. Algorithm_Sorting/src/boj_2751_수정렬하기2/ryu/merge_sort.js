const fs = require("fs");
const arr = fs
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((r) => r.trim());

function merge(s1, s2, s0) {
  let i, j;
  i = 0;
  j = 0;

  while (i + j < s0.length) {
    if (j >= s2.length || s1[i] < s2[j]) {
      s0[i + j] = s1[i];
      i++;
    } else {
      s0[i + j] = s2[j];
      j++;
    }
  }
}

function merge_sort(s0) {
  if (s0.length < 2) return;
  let mid = s0.length / 2;

  const s1 = s0.slice(0, mid);
  const s2 = s0.slice(mid);

  merge_sort(s1);
  merge_sort(s2);

  merge(s1, s2, s0);
}

merge_sort(arr);

arr.forEach((v) => {
  console.log(v);
});
