class Solution {
    public int solution(String myString, String pat) {
        // BAABB
        myString = myString.replace("A","b");
        myString = myString.replace("B","A");
        myString = myString.toUpperCase();
        System.out.println(myString);
        
        return myString.contains(pat) ? 1 : 0 ;
    }
}