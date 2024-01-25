const fs = require("fs");
const input = fs.readFileSync("./input.txt").toString().split("\n").values();

const delta = [
  [0, 1],
  [0, -1],
  [1, 1],
  [1, 0],
  [1, -1],
  [-1, -1],
  [-1, 0],
  [-1, 1],
];

const bfs = (sr, sc, arr, visited) => {
  const R = arr.length;
  const C = arr[0].length;

  const queue = [[sr, sc]];

  while (queue.length) {
    const [r, c] = queue.shift();
    if (visited[r][c]) continue;
    visited[r][c] = true;

    for (let i = 0; i < 8; i++) {
      const [dr, dc] = delta[i];
      const nr = r + dr;
      const nc = c + dc;
      if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

      if (arr[nr][nc] === 1) {
        queue.push([nr, nc]);
      }
    }
  }
};

while (true) {
  const [C, R] = input.next().value.trim().split(" ");
  if (R == 0) {
    break;
  }

  const arr = [];
  for (let r = 0; r < R; r++) {
    arr[r] = input
      .next()
      .value.trim()
      .split(" ")
      .map((str) => +str);
  }
  // 입력 끝

  const visited = Array.from({ length: R }, () =>
    Array.from({ length: C }, () => false)
  );

  let ans = 0;
  for (let r = 0; r < R; r++) {
    for (let c = 0; c < C; c++) {
      if (arr[r][c] === 1 && !visited[r][c]) {
        bfs(r, c, arr, visited);
        ans++;
      }
    }
  }

  // 출력
  console.log(ans);
}
