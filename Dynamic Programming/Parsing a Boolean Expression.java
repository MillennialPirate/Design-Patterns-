class Solution {
    public boolean evaluate(List<Boolean> operands, char operator)
    {
        boolean res = false; 
        if(operands.size() == 1)
        {
            if(operator == '!')
                return !operands.get(0); 
            else
                return operands.get(0);
        }
        else
        {
            res = operands.get(0);
            for(int i = 1; i < operands.size(); i++)
            {
                if(operator == '&')
                    res &= operands.get(i); 
                else
                    res |= operands.get(i); 
            }
            return res; 
        }
    }
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<Character>(); 
        List<Boolean> operands = new ArrayList<Boolean>(); 

        for(int i = 0; i < expression.length(); i++)
        {
            char ch = expression.charAt(i); 
            if(ch == ')')
            {
                while(!st.isEmpty() && st.peek() != '(')
                {
                    if(st.peek() == 'f' || st.peek() == 't')
                        operands.add(st.peek() == 't'); 
                    st.pop(); 
                }
                st.pop(); // popping the open bracket 
                char operator = st.pop(); // popping the operator 
                boolean res = evaluate(operands, operator); 
                operands = new ArrayList<Boolean>(); 
                if(res)
                    st.push('t'); 
                else
                    st.push('f'); 
            }
            else
                st.push(ch); 
        }
        return st.peek() == 't'; 
    }
}
