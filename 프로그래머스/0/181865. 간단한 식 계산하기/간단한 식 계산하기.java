class Solution {
    public int solution(String binomial) {
        String[] parts = binomial.split(" "); //a, op, b
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[2]);
        char op = parts[1].charAt(0);
        int result =0;
        switch(op){
            case '+' :
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: "+op);
        }
        return result;
    }
}