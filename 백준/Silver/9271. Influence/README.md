# [Silver I] Influence - 9271 

[문제 링크](https://www.acmicpc.net/problem/9271) 

### 성능 요약

메모리: 50488 KB, 시간: 512 ms

### 분류

그래프 이론, 그래프 탐색, 방향 비순환 그래프, 위상 정렬

### 제출 일자

2025년 11월 15일 14:21:23

### 문제 설명

<p>In any society there are social influence relations between individuals, where a person x can influence another person y. The same is true for Softopia, a special society where social influence relations are also transitive, meaning that if x can influence y and y can influence z, then x also influences z. Moreover, the rules of social influence guarantee that if x influences any other person y, then x cannot be influenced by y as well. Using these simple rules, if a person x from Softopia wants something, then all the nodes influenced by x also want the same thing.</p>

<p>Although, Softopia is almost a perfect society, there is a set of certain individuals, X, that would spread false demands through the social influence mechanism used by the society. And there is also an evil entity that would want to find out which of these people should be selected to spread a demand of their own. Because the society can only select one person from X, it would like to select one that is able to influence as many people as possible from Softopia. If there is more than a person that satisfies this request, you should pick the one with the lowest identifier.</p>

### 입력 

 <p>The input file starts with a line containing two integers separated by one space: n (n ≤ 5000) the number of individuals in the society, and k, the number of elements in set X. The next line contains the elements from X, thus k different integers from 1..n separated by one space. Then follow n lines and each line i, 1≤i≤n, contains first the identifier of the current person followed by the identifiers of the persons that can be directly influenced by person i, all of them separated by a space. The persons are labeled from 1 to n. The total number of influences in a society is less than 250000. Additional whitespaces in the input file should be skipped.</p>

### 출력 

 <p>The result, representing the identifier of the person that satisfies the conditions mentioned above, will be written on a single line.</p>

